package ThreadPool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

//RecursiveAction
//�޽�������������FJPoolʹ��
//����û�з���ֵ���Ҳ²�Ӧ��û��JOIN�Ĺ��̣�ʵ����RecursiveAction���������JOIN���̻ᱻ���ã�ֻ��������ΪNULL
//����RecursiveAction���������࣬����ֵΪNULL����˿��Բ�����JOIN����
//����RecursiveTask���������࣬������Ҫ��÷���ֵ����˱������join����

//��compute��д���������÷ָ�����������ޣ����ڷָ���в�mid�����ظ��������䣩����˹��캯����hi������Ҫ+1��������array.length���
//��compute��ʹ��invokeAll���������Ա�������fork join
//���̳߳�Ҳ����ִ��һ���Runnable��Callable������ʹ��apool.submit�ύ���ύ���������submissions�м���



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
		 
		 //��ARRAY��2�������������������ϲ�
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
			   //��ʹ��compute��û��fork�ˣ�ʵ���ǵ��߳�ִ��
			   //s2.compute();
			   //s1.compute();
			   
			   //s2ʹ�ñ����̣߳�s1 fork ʹ�������̣߳�
			   //����д����ϸ��Ҫ��ܸߣ���Ҫ��fork��ǰ��invoke�ں������ſ��Բ���
			   s1.fork();
			   s2.invoke(); //s2.compute;
		       
		       
			   //invokeAll��һ�ֱȽϼ����÷����ڲ�ʹ�õ���fork join����
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
