import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//继承抽象类RecursiveTask，如果不返回参数，继承RecursiveAction
//fork join框架采用窃取算法平衡队列任务
//有待进一步研究
public class ForkJoinTest extends RecursiveTask<String>{

	//门槛值，任务大于此，则启动多个线程
	private static int threshold = 2;
    private  int start;
    private  int end;
	
	ForkJoinTest(int start,int end)
	{  
		this.start = start;
		this.end = end;
	}

	
	public static void main(String[] args) {
	
		
		ForkJoinPool apool = new ForkJoinPool();
		//end-start个任务
		ForkJoinTest ob = new ForkJoinTest(0,10);
		apool.invoke(ob);
		//join调用compute()，返回单位线程的返回值
        System.out.println(ob.join());
	}

	public String method()
	{
		return Thread.currentThread().getName();
	}
	
	@Override
	protected String compute() {
		// TODO Auto-generated method stub
		//门槛值，任务小于此，则使用单线程
		if(end - start <= threshold )
		{
			String tmp = "";
			for(int i = start; i< end; i ++)
			{
				tmp = tmp + method() + "\r";
			}
			return tmp;
		}
		//门槛值，任务大于此，则启动多个线程
		else
		{
			int mid =  (end+start)/2;
			//分解为2个线程，之后递归调用！
			ForkJoinTest part1 = new ForkJoinTest(start,mid);
			ForkJoinTest part2 = new ForkJoinTest(mid,end);
			//同时调用
			invokeAll(part1,part2);
			return part1.join() +  part2.join();
		}
	}

	
}
