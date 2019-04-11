import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//用于多线程分组
//每个线程都互相等待其他线程，达到"上车"标准，发车
//可以理解为“人满发车”
//采用重入锁实现
public class CyclicBarrierNote implements Runnable {

	static DelayQueNote sn = new DelayQueNote();
	//车有2个座位，每当2个座位被2个线程占据后，将发车（执行）后续sn中Runnable接口中定义的方法
	//如果2个座位没有被占满，则阻塞所有线程，等待后续其他线程上车
	static CyclicBarrier cb = new CyclicBarrier(2,sn);
	public static void main(String[] args) {
		
		CyclicBarrierNote sbn = new CyclicBarrierNote();
		for(int i = 1 ; i <=2; i ++)
		{
			
			Thread t = new Thread(sbn);
			t.start();
		}
	}

	@Override
	public void run() {
	
		System.out.println(Thread.currentThread().getName());
		
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
