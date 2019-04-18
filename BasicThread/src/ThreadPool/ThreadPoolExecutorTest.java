package ThreadPool;

//ThreadPoolExecutor�����Ҫ��
//ThreadPoolExecutor�е�״̬λ���Ϳ���λ���ô�����λ�����������״̬����
//���̳߳�����߳�����С��corePoolSizeʱ��ͨ��addWorker�������� �̳߳���Ĵ�ִ��������߳�
//addWorker�лᴴ��һ��Worker���󣬸ö���ʹ��Executors�๹��һ���µ�Thread�����Һ��д�ִ������Ķ���
//���б�������Worker���󶼻ᱻд��HashSet�У����������̳߳ش�С��������HashSetʱ���Ǽ����������ģ�MainLock��
//����addWorker��start�������̳߳��е�ĳһ���߳̿�ʼִ�С�start�����runWorker(this)��
//runWorker(this)���ṩ���ط�����beforeExecute��afterExecute���ڵ���������ǰ��Ĵ��������
//���߳̿�ʼִ�ж����е�Runnable����ǰ��ʹ��Work�е�Lock����������ʹ�ø��̴߳���ִ�У���
//���߳�ִ�����һ�������Runnable������ʹ��getTask������ѭ����BlockingQue��ȡ�µĶ���
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorTest implements Runnable {

	 private static  long ii = 0;
	 private static final int COUNT_BITS = Integer.SIZE - 3;
	 private static final int CAPACITY   = (1 << COUNT_BITS) - 1;
	 public final AtomicInteger ctl = new AtomicInteger(ctlOf(-1 << COUNT_BITS, 0));
	 private static int ctlOf(int rs, int wc) { return rs | wc; }
	 private static int runStateOf(int c)     { return c & ~CAPACITY; }
	 private static int workerCountOf(int c)  { return c & CAPACITY; }
	 
	public static void main(String[] args) {
		
	
		
		//RUNNING
		System.out.println("RUNNING:" + (-1 << (Integer.SIZE - 3)));
		//SHUTDOWN
		System.out.println("SHUTDOWN:" + (0 << (Integer.SIZE - 3)));
		//STOP
		System.out.println("STOP:" + (1 << (Integer.SIZE - 3)));
		//TIDYING
		System.out.println("TIDYING:" + (2 << (Integer.SIZE - 3)));
		//TERMINATED
		System.out.println("TERMINATED:" + (3 << (Integer.SIZE - 3)));
		//CAPACITY
		System.out.println(((1 << (Integer.SIZE - 3)) - 1));
		//ctl
		System.out.println(ctlOf(-1 << COUNT_BITS, 0));
		ThreadPoolExecutor te;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		
	}



}
