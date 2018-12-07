import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
//FIFO，且每次添加、删除都会使用重入锁，反复使用添加、删除，会频繁触发锁资源申请和释放，估计效率不高
//每次添加使用可以抛出InterruptedException的方法，例如PUT和TAKE，这两个方法都会AWAIT
//POLL和OFFER在遇到队列空或者满了会返回NULL
//DRAINTO是把ArrayBlockingQueue拷贝到目标队列中
//如果要把多个原子操作一次加入队列，则先加入一个AL中，然后该AL对象PUT入队列

public class ArrayBlockingQueTest implements Runnable {

	int i = 1;
	static ArrayBlockingQueue<ArrayList> abq = new ArrayBlockingQueue<ArrayList>(5);
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ArrayBlockingQueTest ot1 = new ArrayBlockingQueTest();
		ArrayBlockingQueTest ot2 = new ArrayBlockingQueTest();

        //Thread ，2个生产者
		 Thread t = new Thread(ot1);
		 Thread t2 = new Thread(ot2);
		 t2.start();
		 t.start();

		 //一个消费者
		 System.out.println("Consumer: ");
		 ot1.consumer();
		
		
	}
    
	public void input1() throws InterruptedException 
	{
		 String ThreadName = Thread.currentThread().getName();
		 
		 int j = 10;
		 ArrayList<String> al = new ArrayList<String>(10);
		 String PrintOb;
		 while(j >=1)
		 {
			 j--;
			 PrintOb = ThreadName + ": " + i; 
			 i = i + 1;
			 //多个原子动作封入一个AL中
			 al.add(PrintOb);
		 }
		 System.out.println(ThreadName + " Start !");
		 abq.put(al);
	}
	
	public void consumer() throws InterruptedException
	{
		while(true)
		{
		   Thread.sleep(50);
		   ArrayList al = abq.take();
		   Iterator<String> it = al.iterator();
		   while(it.hasNext())
		   {
			  
			   System.out.println(it.next());
		   }
		}	
	}
	
	@Override
	public void run() {
		
		try {
			input1();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    
	
	
	
	
	
	

	
}
