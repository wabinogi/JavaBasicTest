import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;
//StampedLock的锁和重入锁的比较大的区别之一是，可以跨线程使用！第一个线程上锁，生成STAMP，其他线程可通过STAMP解锁
//重入锁在进入CLH队列等待前，几乎没有自旋，StampedLock在进入CLH队列前会SPIN一定的时间.SPIN使用了一定算法，改变SPIN次数
//SPIN后没有获取到锁，则使用UNSAFE的PARK，将线程挂起
//sl.readLock读锁是可重入（共享）的，多次调用sl.readLock，而不解锁，不会阻塞，只会使得锁的数量+1，RFULL是126
//readLock是可以共享的，既多个对象可以同时获得readLock，此时多对象是并发的
//writelock是独占的，必须一个线程释放后，另一个线程才能获取
//writelock在独占后，不释放不可以直接调用readlock，会阻塞
//StampedLock有三种模式，独占锁（写锁），共享锁（读锁），乐观读（无锁）
//三种锁模式可以互相转化（锁升级、降级）
//乐观读通过位运算判断数据一致性，该方法十分高效！如果乐观读之前发生了其他线程获取写锁（独占）的情况，则位标识改变，validate方法返回0
//如果线程在获取锁前可能被Interrupt,则使用readLockInterruptibly()方法以抛出中断异常
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
	
	/* 主要方法备注
	 * 解锁方法
	 *  public void unlock(long stamp) {
        long a = stamp & ABITS, m, s; WNode h;
       //当前线程持有的stamp是否是锁定时产生的STAMP，如果是，说明当前线程可解锁
        while (((s = state) & SBITS) == (stamp & SBITS)) {
            if ((m = s & ABITS) == 0L)
                break;
           //m = s & ABITS后还原出锁持有的锁，判断持有的是否是WRITE锁
            else if (m == WBIT) {
                if (a != m)
                    break;
                
                   //STATE状态归位
                 //归位的值，要么是ORIGIN（256）        1 0000 0000
                //要么是 s+WBIT (384+128)=512 10 0000 0000
                state = (s += WBIT) == 0L ? ORIGIN : s;
                
                //如果只有一个锁（没有锁队列），则直接RETURN,如果有锁队列，则需要RELEASE(h)
                if ((h = whead) != null && h.status != 0)
                    release(h);
                return;
            }
            else if (a == 0L || a >= WBIT)
                break;
            
            //如果是读锁
            else if (m < RFULL) {
            //锁的数量减1，更新STATE
                if (U.compareAndSwapLong(this, STATE, s, s - RUNIT)) {
                    if (m == RUNIT && (h = whead) != null && h.status != 0)
                        release(h);
                    return;
                }
            }
            else if (tryDecReaderOverflow(s) != 0L)
                return;
        }
        //如果当前线程持有的STAMP不能解锁，则抛异常，在ReentranceLOCK中，抛该异常一般是由于当前线程不是锁定的那个线程，既当前线程不能解锁其他线程所持有的锁
        throw new IllegalMonitorStateException();
    }
    
      //如果不能取得锁，则进入再尝试一次的方法
	 *  private long acquireWrite(boolean interruptible, long deadline) {
        WNode node = null, p;
        for (int spins = -1;;) { // spin while enqueuing
            long m, s, ns;
            
            //S=512，m = 512 & 255 = 0L,通过BIT位查看锁是否释放
            if ((m = (s = state) & ABITS) == 0L) {
            
            //如果释放，则尝试获取写锁，设置标识位ns
                if (U.compareAndSwapLong(this, STATE, s, ns = s + WBIT))
                    return ns;
            }
            //开始时spins为-1，因此自旋一定次数（64）
            else if (spins < 0)
                spins = (m == WBIT && wtail == whead) ? SPINS : 0;
               
            //自旋过程中做一些操作，例如调用nextSecondarySeed()方法生成随机数？，如果成果则自旋数减1
            else if (spins > 0) {
                if (LockSupport.nextSecondarySeed() >= 0)
                    --spins;
            }
            //通过判断尾节点是否为空判断CLH队列是否为空？
            else if ((p = wtail) == null) { // initialize queue
                //初始化CLH队列，初始化CLH尾节点
                WNode hd = new WNode(WMODE, null);
                //更新头结点地址为尾节点地址
                if (U.compareAndSwapObject(this, WHEAD, null, hd))
                    wtail = hd;
            }
            //当前NODE节点是否为空?
            else if (node == null)
            //初始化当前节点，且当前节点的前一个节点设为尾节点，既当前NODE节点为最后一个节点
                node = new WNode(WMODE, p);
            else if (node.prev != p)
                node.prev = p;
              //更新尾节点地址为NODE的地址，且为节点P的NEXT指针指向NODE
            else if (U.compareAndSwapObject(this, WTAIL, p, node)) {
                p.next = node;
                break;
            }
        }

        for (int spins = -1;;) {
            WNode h, np, pp; int ps;
            //头尾节点指针是否指向同一地址？
            if ((h = whead) == p) {
                if (spins < 0)
                //HEAD_SPINS 1024
                    spins = HEAD_SPINS;
                    
                 //MAX_HEAD_SPINS 65536 1<<16
                else if (spins < MAX_HEAD_SPINS)
                    spins <<= 1;
                for (int k = spins;;) { // spin at head
                    long s, ns;
                    //判断是否释放锁？
                    if (((s = state) & ABITS) == 0L) {
                    //如果释放了，则获取写锁，设置STATE的BIT位
                        if (U.compareAndSwapLong(this, STATE, s,
                                                 ns = s + WBIT)) {
                            whead = node;
                            node.prev = null;
                            return ns;
                        }
                    }
                    //未释放则 执行一次自旋
                    else if (LockSupport.nextSecondarySeed() >= 0 &&
                             --k <= 0)
                             //直到K次自旋结束后，BREAK
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
