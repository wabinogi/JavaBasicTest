package ThreadPool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

//RecursiveAction
//无结果返回任务，配合FJPool使用
//由于没有返回值，我猜测应该没有JOIN的过程，实际上RecursiveAction派生子类的JOIN过程会被调用，只不过返回为NULL
//对于RecursiveAction的派生子类，返回值为NULL，因此可以不调用JOIN方法
//对于RecursiveTask的派生子类，由于需要获得返回值，因此必须调用join方法

//在compute重写方法中设置分割任务的上下限，由于分割的中部mid会有重复（闭区间），因此构造函数中hi上限需要+1，可以用array.length替代
//在compute中使用invokeAll方法，可以避免多余的fork join
//该线程池也可以执行一般的Runnable和Callable方法，使用apool.submit提交，提交的任务会在submissions中计数



public class RecusiveActionTest  {

	public static void main(String[] args) throws InterruptedException 
	{
		RecusiveActionTest rat = new RecusiveActionTest();
		long[] array = {6,3,2,1,5,7,8,9,0,2,
				        3,4,3,4,5,11,35,-1,-5,2,
				        4,5,9,4,-3,2,4,100,32,4};
		System.out.println(Arrays.toString(array));
		
		SortTask st = rat.new SortTask(array,0,array.length);
		RunnableTask rt = rat.new RunnableTask();
		
		ForkJoinPool apool = ForkJoinPool.commonPool();
		
		apool.submit(rt);
	
		apool.invoke(st);
		System.out.println(apool.toString());
		System.out.println(Arrays.toString(array));
		
		
		/*
		long[] array1 = {6,7,8,9,10,1,2,3,4,5};
		SortTask st1 = rat.new SortTask(array1,0,10);
		st1.merge(0, 5, 10);
		System.out.println(Arrays.toString(array1));
		*/
		RecursiveTask rtt;
	}
	
	class SortTask extends RecursiveAction
	{
		 final long[] array;
		 final int lo, hi;
		 static final int THRESHOLD = 16;
		 
		 SortTask(long[] array, int lo, int hi) 
		 {
		    this.array = array; 
		    this.lo = lo;
	        this.hi = hi;
		 }
		 
		 SortTask(long[] array) 
		 { 
			 this(array, 0, array.length); 
		 }
 
		 void sortSequentially(int lo, int hi)
		 {
			 Arrays.sort(array, lo, hi);
		 }
		 
		 //将ARRAY中2个部分连续有序的数组合并
		 void merge(int lo, int mid, int hi) 
		 {
			 long[] buf = Arrays.copyOfRange(array, lo, mid);
			 for (int i = 0, j = lo, k = mid; i < buf.length; j++)
				 
				 if((k == hi || buf[i] < array[k]) )
				 {
					 array[j] = buf[i++];
				 }
				 else
				 {
					 array[j] = array[k++];
				 }
		 }
		 
		@Override
		protected void compute() 
		{
			
			if (hi - lo < THRESHOLD)
			{
				sortSequentially(lo, hi);
				
			}
			else 
			{
				
		        int mid = (lo + hi) >>>1;
			   System.out.println(mid);
			   
			   
			   SortTask s1 = new SortTask(array, lo, mid);
			   SortTask s2 = new SortTask(array, mid, hi);
			   //都使用compute就没有fork了，实际是单线程执行
			   //s2.compute();
			   //s1.compute();
			   
			   //s2使用本地线程，s1 fork 使用其他线程？
			   //这种写法对细节要求很高，需要先fork在前，invoke在后，这样才可以并行
			   s1.fork();
			   s2.invoke(); //s2.compute;
		       
		       
			   //invokeAll是一种比较简便的用法，内部使用的是fork join方法
			   /*invokeAll(new SortTask(array, lo, mid),
		                  new SortTask(array, mid, hi));*/
		        
		        System.out.println("before merge !");
		        merge(lo, mid, hi);
			}
			
		}
	}

	class RunnableTask implements Runnable
	{

		@Override
		public void run() 
		{
			
			System.out.println("RunnableTask is run !");
		}
		
	}
}
