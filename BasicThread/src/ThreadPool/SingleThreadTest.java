package ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

//���̵߳��̳߳�
//�ײ����1����С��LinkedBlockingQueue
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
