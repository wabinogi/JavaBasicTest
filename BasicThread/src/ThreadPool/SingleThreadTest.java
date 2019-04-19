package ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

//单线程的线程池
//底层采用1个大小的LinkedBlockingQueue
public class SingleThreadTest implements Runnable{

	public static void main(String[] args) {

	
         ExecutorService executor = Executors.newSingleThreadExecutor();
         
         ScheduledExecutorService ses;
         ThreadPoolExecutorTest tpet = new ThreadPoolExecutorTest();
         SingleThreadTest stt  = new SingleThreadTest();
     
         executor.execute(stt); 
         executor.execute(stt); 
         
      
         
         executor.shutdown();
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName());

	
	}

}
