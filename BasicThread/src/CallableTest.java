import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//implements Callable<String>，返回值为STRING

public class CallableTest implements Callable<String>{

	public static void main(String...args) throws InterruptedException, ExecutionException
	{
		CallableTest ct = new CallableTest();
		//Future类
		//中断任务
		//查询任务状态
		//获取任务结果
		//通过FutureTask包装器取得返回值，FutureTask实现了Future、Runnable接口
		FutureTask<String> ft = new FutureTask<String>(ct);
		//FutureTask加入到THREAD线程中
		Thread t  = new Thread(ft);
		t.start();
		
		

		//通过get()取得返回参数
		//如果计算没结束，则被阻塞，直到完成
		//如果计算没结束，T2线程被终端，会返回InterruptedException
		//isDone为TRUE表示计算完成
		while(!ft.isDone())
		{
			Thread.sleep(200);
			 System.out.println("Computing");
		}
		
		 System.out.println(ft.get());
	}

	public static String method1() throws InterruptedException
	{
		Thread.sleep(1000);
		return Thread.currentThread() + "Finished !";	
	}
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		
		return method1();
	}
}
