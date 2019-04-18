package ThreadPool;

//ThreadPoolExecutor类解析要点
//ThreadPoolExecutor中的状态位，和控制位采用大量的位运算操作进行状态更新
//当线程池里的线程数量小于corePoolSize时，通过addWorker方法创建 线程池里的待执行任务的线程
//addWorker中会创建一个Worker对象，该对象使用Executors类构造一个新的Thread对象且含有待执行任务的对象。
//所有被创建的Worker对象都会被写入HashSet中，用来管理线程池大小，当更新HashSet时，是加了重入锁的（MainLock）
//调用addWorker的start方法，线程池中的某一个线程开始执行。start会调用runWorker(this)。
//runWorker(this)中提供重载方法，beforeExecute和afterExecute用于调用主方法前后的处理操作。
//当线程开始执行对象中的Runnable方法前，使用Work中的Lock进行锁定，使得该线程串行执行？？
//该线程执行完第一个对象的Runnable方法后，使用getTask方法，循环从BlockingQue中取新的对象
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
