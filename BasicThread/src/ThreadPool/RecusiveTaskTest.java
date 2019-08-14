package ThreadPool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

//需要返回结果值得分解任务要继承自RecursiveTask，RecursiveTask为泛型，可定义为RecursiveTask<Object>
//pool.invoke(st)执行完毕后，可以使用st.join取得返回结果
//可以使用st.isCompleteAbnomally和st.getException方法获得任务是否异常
//mid为边界值，可能会被重复处理

public class RecusiveTaskTest {

	public static void main(String[] args) 
	{
		Integer[] array = {1,2,3,4,5,6,7,8,9,10};	
		RecusiveTaskTest rtt = new RecusiveTaskTest();
		SubTask st = rtt.new SubTask(0,array.length,array);
		ForkJoinPool pool = ForkJoinPool.commonPool();
		pool.invoke(st);
		System.out.println(st.join());
	}

	class SubTask extends RecursiveTask<Object>
	{
		Integer[] array;
        int start;
        int end;
        int THRESHOLD = 6;
        
        SubTask(int st,int ed,Integer[] ary)
        {
        	this.start = st;
            this.end = ed;
            this.array = ary;
        }
		
		@Override
		protected Object compute() 
		{
			System.out.println(Thread.currentThread().getName());
			int mid;
			int sum = 0;
			if(end - start < THRESHOLD )
			{
				for(int i = start; i<end; i ++)
				{
					sum = sum + array[i];
				}
				return sum;
			}
			else
			{
				mid = (start + end) >>> 1; 
				SubTask leftTask = new SubTask(start,mid,this.array);
				SubTask rightTask = new SubTask(mid,end,this.array);
				this.invokeAll(leftTask,rightTask);
				
				return (((int)leftTask.join()) + ((int)rightTask.join()));
			}

		}
		
	}
}
