package ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

//单线程的线程池
//底层采用1个大小的LinkedBlockingQueue
public class SingleThreadTest implements Runnable{

	public static void main(String[] args) throws Exception {

	
         ExecutorService executor = Executors.newSingleThreadExecutor();
         ScheduledExecutorService ses;
   
         for (int i = 1 ; i <= 5000 ; i++)
         {
        	 doWork();
        	 if(i % 100 == 0)
        	 {
        		 System.out.println(i + " done");
        		 executor.execute(new SingleThreadTest()); 
        	 }
         }
         
         executor.shutdown();
	}
	public static void doWork() throws Exception
	{
		Thread.currentThread().sleep(1);
	}

	@Override
	public void run() {
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread work done !");
		
	}

}
