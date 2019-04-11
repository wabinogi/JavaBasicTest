import java.util.concurrent.Semaphore;

public class SemaphoreNote implements Runnable{

	//一次只能允许2个线程进来执行
	static Semaphore sp = new Semaphore(2);
	public static void main(String[] args) {
		SemaphoreNote sn = new SemaphoreNote();
		
		for(int i = 0;i<=4;i++)
		{
			Thread t = new Thread(sn);
			t.start();
		}
	}

	@Override
	public void run() {
		//因为Semaphore(2)的缘故，因此最多只有2个标志
		try {
			//获取进入标志
			//底层扩展自AQS，
			//当标示位富裕的时候，acquire只更新计数器状态，什么都不做
			//当标示位用完时，会通过AQS的方法挂起后续线程
			sp.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());	
		//释放该标志
		//release方法更新计数器，如果后续有阻塞线程，则唤醒
		sp.release();
		
	}

}
