import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorCompletionServiceTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub

	ExecutorService poolExector = Executors.newCachedThreadPool();
	
	//执行任务结束的管理服务
	//将线程池执行器加入
	ExecutorCompletionService ecs =  new ExecutorCompletionService(poolExector);	
	
	for(int i = 1; i <=5; i++)
	{
		CallableTest ct = new CallableTest();
		//执行对象加入服务管理器
		ecs.submit(ct);
		
	}
	
	int j = 5;
	while( j >=1)
	{
		j = j - 1;
		//管理器取出执行结束的线程的返回值
		//如果循环次数多于生产者线程，则会空转！直到有结果返回
	 System.out.println(ecs.take().get().toString());
	}
	
	poolExector.shutdown();
	}
	
	
	

}
