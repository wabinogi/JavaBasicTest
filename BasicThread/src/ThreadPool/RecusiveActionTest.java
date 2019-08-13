package ThreadPool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

//�޽�������������FJPoolʹ��
//����û�з���ֵ���Ҳ²�Ӧ��û��JOIN�Ĺ��̣�ʵ����JOIN���̻ᱻ���ã�ֻ��������ΪNULL
//�ָ�����������ޣ����ڷָ���в�mid�����ظ��������䣩�����hi������Ҫ+1

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
