import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;
//StampedLock�������������ıȽϴ������֮һ�ǣ����Կ��߳�ʹ�ã���һ���߳�����������STAMP�������߳̿�ͨ��STAMP����
//�������ڽ���CLH���еȴ�ǰ������û��������StampedLock�ڽ���CLH����ǰ��SPINһ����ʱ��.SPINʹ����һ���㷨���ı�SPIN����
//SPIN��û�л�ȡ��������ʹ��UNSAFE��PARK�����̹߳���
//sl.readLock�����ǿ����루�����ģ���ε���sl.readLock����������������������ֻ��ʹ����������+1��RFULL��126
//readLock�ǿ��Թ���ģ��ȶ���������ͬʱ���readLock����ʱ������ǲ�����
//writelock�Ƕ�ռ�ģ�����һ���߳��ͷź���һ���̲߳��ܻ�ȡ
//writelock�ڶ�ռ�󣬲��ͷŲ�����ֱ�ӵ���readlock��������
//StampedLock������ģʽ����ռ����д�����������������������ֹ۶���������
//������ģʽ���Ի���ת������������������
//�ֹ۶�ͨ��λ�����ж�����һ���ԣ��÷���ʮ�ָ�Ч������ֹ۶�֮ǰ�����������̻߳�ȡд������ռ�����������λ��ʶ�ı䣬validate��������0
//����߳��ڻ�ȡ��ǰ���ܱ�Interrupt,��ʹ��readLockInterruptibly()�������׳��ж��쳣
public class StampedLockTest implements Runnable{

	static StampedLock sl = new StampedLock();
	static ReentrantLock rl = new ReentrantLock();
	static long stamp;
	public static void main(String[] args) throws InterruptedException {
	
		//128+256 = 384
		// 1000 0000 128 wbit
		//10000 0000 256
		
		//01111 1111 255 await
		//11000 0000 384
		//11000 0000  SBITS -128 
	  // 100000 0000 384+128
	  //  10000 0000 ORIGIN 256
		
		StampedLockTest slt = new StampedLockTest();
		
		
		
		sl.readLockInterruptibly();
		

	
		 //sl.unlockRead(stamp);
		for(int i =0; i< 10;i++)
		{
		   Thread t = new Thread(slt);
		   t.start();
		}
	
		//ORIGIN 256 1 0000 0000
		
		//ABITS 255  011111111
		//WBIT 128   010000000
		//SBITS -128 110000000
		//RBITS 127  001111111
		//RFULL 126  001111110
		//s+WBIT     110000000
	

		//System.out.println(Integer.toBinaryString(-128) );
	}
	
	



	@Override
	public void run() {
		
	
		System.out.println(Thread.currentThread().getName());
		
	}
	
	/* ��Ҫ������ע
	 * ��������
	 *  public void unlock(long stamp) {
        long a = stamp & ABITS, m, s; WNode h;
       //��ǰ�̳߳��е�stamp�Ƿ�������ʱ������STAMP������ǣ�˵����ǰ�߳̿ɽ���
        while (((s = state) & SBITS) == (stamp & SBITS)) {
            if ((m = s & ABITS) == 0L)
                break;
           //m = s & ABITS��ԭ�������е������жϳ��е��Ƿ���WRITE��
            else if (m == WBIT) {
                if (a != m)
                    break;
                
                   //STATE״̬��λ
                 //��λ��ֵ��Ҫô��ORIGIN��256��        1 0000 0000
                //Ҫô�� s+WBIT (384+128)=512 10 0000 0000
                state = (s += WBIT) == 0L ? ORIGIN : s;
                
                //���ֻ��һ������û�������У�����ֱ��RETURN,����������У�����ҪRELEASE(h)
                if ((h = whead) != null && h.status != 0)
                    release(h);
                return;
            }
            else if (a == 0L || a >= WBIT)
                break;
            
            //����Ƕ���
            else if (m < RFULL) {
            //����������1������STATE
                if (U.compareAndSwapLong(this, STATE, s, s - RUNIT)) {
                    if (m == RUNIT && (h = whead) != null && h.status != 0)
                        release(h);
                    return;
                }
            }
            else if (tryDecReaderOverflow(s) != 0L)
                return;
        }
        //�����ǰ�̳߳��е�STAMP���ܽ����������쳣����ReentranceLOCK�У��׸��쳣һ�������ڵ�ǰ�̲߳����������Ǹ��̣߳��ȵ�ǰ�̲߳��ܽ��������߳������е���
        throw new IllegalMonitorStateException();
    }
    
      //�������ȡ������������ٳ���һ�εķ���
	 *  private long acquireWrite(boolean interruptible, long deadline) {
        WNode node = null, p;
        for (int spins = -1;;) { // spin while enqueuing
            long m, s, ns;
            
            //S=512��m = 512 & 255 = 0L,ͨ��BITλ�鿴���Ƿ��ͷ�
            if ((m = (s = state) & ABITS) == 0L) {
            
            //����ͷţ����Ի�ȡд�������ñ�ʶλns
                if (U.compareAndSwapLong(this, STATE, s, ns = s + WBIT))
                    return ns;
            }
            //��ʼʱspinsΪ-1���������һ��������64��
            else if (spins < 0)
                spins = (m == WBIT && wtail == whead) ? SPINS : 0;
               
            //������������һЩ�������������nextSecondarySeed()���������������������ɹ�����������1
            else if (spins > 0) {
                if (LockSupport.nextSecondarySeed() >= 0)
                    --spins;
            }
            //ͨ���ж�β�ڵ��Ƿ�Ϊ���ж�CLH�����Ƿ�Ϊ�գ�
            else if ((p = wtail) == null) { // initialize queue
                //��ʼ��CLH���У���ʼ��CLHβ�ڵ�
                WNode hd = new WNode(WMODE, null);
                //����ͷ����ַΪβ�ڵ��ַ
                if (U.compareAndSwapObject(this, WHEAD, null, hd))
                    wtail = hd;
            }
            //��ǰNODE�ڵ��Ƿ�Ϊ��?
            else if (node == null)
            //��ʼ����ǰ�ڵ㣬�ҵ�ǰ�ڵ��ǰһ���ڵ���Ϊβ�ڵ㣬�ȵ�ǰNODE�ڵ�Ϊ���һ���ڵ�
                node = new WNode(WMODE, p);
            else if (node.prev != p)
                node.prev = p;
              //����β�ڵ��ַΪNODE�ĵ�ַ����Ϊ�ڵ�P��NEXTָ��ָ��NODE
            else if (U.compareAndSwapObject(this, WTAIL, p, node)) {
                p.next = node;
                break;
            }
        }

        for (int spins = -1;;) {
            WNode h, np, pp; int ps;
            //ͷβ�ڵ�ָ���Ƿ�ָ��ͬһ��ַ��
            if ((h = whead) == p) {
                if (spins < 0)
                //HEAD_SPINS 1024
                    spins = HEAD_SPINS;
                    
                 //MAX_HEAD_SPINS 65536 1<<16
                else if (spins < MAX_HEAD_SPINS)
                    spins <<= 1;
                for (int k = spins;;) { // spin at head
                    long s, ns;
                    //�ж��Ƿ��ͷ�����
                    if (((s = state) & ABITS) == 0L) {
                    //����ͷ��ˣ����ȡд��������STATE��BITλ
                        if (U.compareAndSwapLong(this, STATE, s,
                                                 ns = s + WBIT)) {
                            whead = node;
                            node.prev = null;
                            return ns;
                        }
                    }
                    //δ�ͷ��� ִ��һ������
                    else if (LockSupport.nextSecondarySeed() >= 0 &&
                             --k <= 0)
                             //ֱ��K������������BREAK
                        break;
                }
            }
            else if (h != null) { // help release stale waiters
                WNode c; Thread w;
                while ((c = h.cowait) != null) {
                    if (U.compareAndSwapObject(h, WCOWAIT, c, c.cowait) &&
                        (w = c.thread) != null)
                        U.unpark(w);
                }
            }
            if (whead == h) {
                if ((np = node.prev) != p) {
                    if (np != null)
                        (p = np).next = node;   // stale
                }
                else if ((ps = p.status) == 0)
                    U.compareAndSwapInt(p, WSTATUS, 0, WAITING);
                else if (ps == CANCELLED) {
                    if ((pp = p.prev) != null) {
                        node.prev = pp;
                        pp.next = node;
                    }
                }
                else {
                    long time; // 0 argument to park means no timeout
                    if (deadline == 0L)
                        time = 0L;
                    else if ((time = deadline - System.nanoTime()) <= 0L)
                        return cancelWaiter(node, node, false);
                    Thread wt = Thread.currentThread();
                    U.putObject(wt, PARKBLOCKER, this);
                    node.thread = wt;
                    if (p.status < 0 && (p != h || (state & ABITS) != 0L) &&
                        whead == h && node.prev == p)
                        U.park(false, time);  // emulate LockSupport.park
                    node.thread = null;
                    U.putObject(wt, PARKBLOCKER, null);
                    if (interruptible && Thread.interrupted())
                        return cancelWaiter(node, node, true);
                }
            }
        }
    }

	 
	 */

}
