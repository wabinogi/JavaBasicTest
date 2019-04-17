package ThreadPool;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


//线程池执行
//FixedThreadPool 采用LinkedBlockingQueue
//CachedThreadPool 采用SynchronousQue
//SingleThreadPool  采用LinkedBlockingQueue
//如果单线程意外终止，则创建一个新的线程继续执行？
public class ThreadPoolTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

		CallableTest ct = new CallableTest();
		
		//Create new Thread,remaining 60s
		//ExecutorService es = Executors.newCachedThreadPool();
		//Create 5 thread,remaining all the time
		ExecutorService es = Executors.newFixedThreadPool(5);
		
		//延时作业使用下面方法
		//ScheduledExecutorService = Executors.newScheduledThreadPool
		//ScheduledFuture sf = ...
		
		//submit!
		Future ft = es.submit(ct); 
		
		while(!ft.isDone())
		{
			Thread.sleep(200);
			System.out.println("Computing !");
		}
		System.out.println(ft.get().toString());
		//Close
		es.shutdown();
	}

	
}
