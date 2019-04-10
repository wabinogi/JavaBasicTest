import java.util.concurrent.CountDownLatch;

//允许一个或多个线程一致等待，直到其他线程操作执行完后再执行
public class CountDownLatchNote implements Runnable{

	//数字需要与实际线程数匹配，数字过大会造成其他线程永远在等待
	static CountDownLatch cdl = new CountDownLatch(4);
	public static void main(String[] args) throws InterruptedException 
	{
		CountDownLatchNote cdln = new CountDownLatchNote();
		for(int i = 0; i <= 3; i++)
		{
			Thread t = new Thread(cdln);
			t.start();
			
		}
		//其他线程完成后，执行等待操作
		cdl.await();
		System.out.println("Main");
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName());		
		//该线程执行完成后，计数器减1
		cdl.countDown();

	}

}
