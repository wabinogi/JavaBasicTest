import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

//底层实现采用重入锁，且是2把锁，一把存，一把取，可同时进出队列
//如果初始化队列时不指定容量大小，默认是无限的队列，因此，取得速度太慢，会导致队列太大撑爆内存
public class LinkedBlockingQueNote extends AbstractQueuedSynchronizer implements Runnable {

	public static void main(String[] args) throws InterruptedException {
	
		
		LinkedBlockingQueNote lbqn = new LinkedBlockingQueNote();
		LinkedBlockingQueue<Runnable> lbq = new LinkedBlockingQueue<Runnable>();
		
		lbq.offer(lbqn);
	
		lbq.offer(lbqn);
	
		//lbq.poll();
		
		
		//带阻塞的双端队列
		//采用一个全局重入锁实现，所有的头尾进出队列操作，均使用了LOCK方法独占
		//感觉不存在什么多线程从双端同时进队的情况，因为只有释放锁才能操作
		LinkedBlockingDeque lbd;
	}

	LinkedBlockingQueNote()
	{
		setState(-1);
	}
	@Override
	public void run() {
		
		System.out.println("is run !");
	}

}
