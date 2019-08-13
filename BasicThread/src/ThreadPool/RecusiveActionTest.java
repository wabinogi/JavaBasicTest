package ThreadPool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

//无结果返回任务，配合FJPool使用
//由于没有返回值，我猜测应该没有JOIN的过程，实际上JOIN过程会被调用，只不过返回为NULL
//分割任务的上下限，由于分割的中部mid会有重复（闭区间），因此hi上限需要+1

public class RecusiveActionTest  {

	public static void main(String[] args) 
	{
		RecusiveActionTest rat = new RecusiveActionTest();
		long[] array = {6,3,2,1,5,7,8,9,0,2,
				        3,4,3,4,5,11,35,-1,-5,2,
				        4,5,9,4,-3,2,4,100,32,4};
		System.out.println(Arrays.toString(array));

		SortTask st = rat.new SortTask(array,0,30);
		ForkJoinPool.commonPool().invoke(st);
		System.out.println(Arrays.toString(array));
		
		long[] array1 = {6,7,8,9,10,1,2,3,4,5};
		SortTask st1 = rat.new SortTask(array1,0,10);
		st1.merge(0, 5, 11);
		System.out.println(Arrays.toString(array1));
	}
	
	class SortTask extends RecursiveAction
	{
		 final long[] array;
		 final int lo, hi;
		 static final int THRESHOLD = 18;
		 
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
				sortSequentially(lo, hi);
			else 
			{
		        int mid = (lo + hi) >>> 1;
			   System.out.println(mid);
		        invokeAll(new SortTask(array, lo, mid),
		                  new SortTask(array, mid, hi));
		        merge(lo, mid, hi);
			}
			
		}
	}

}
