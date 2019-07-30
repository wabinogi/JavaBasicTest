import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock要点！
//new ReentrantLock()一般作为全局变量，可以是静态的
//每当一个线程要执行时，首先需要获取到 Lock对象，才能执行（进入）LOCK的代码段！
//ReentrantLock是在JDK层面实现的
//有公平锁和非公平锁两种模式
//重入锁具有条件锁特性
//进入等待的使用后面的形式：while(j == 3) acond.await();
//充入锁的结构具有一定的特殊性，只有不能不用的时候才用！
//该锁有大量用到UNSAFE类中CAS方法的，具备自旋的特性。如：在FOR循环中，进行CAS，直到成功。
//补充：该锁特殊性是由于，多个线程尝试获取锁资源时，会在AQS的队列中排队，且等待（阻塞）中的线程，
//使用的是PARK和UNPARK原语方法，这种方法可能会有上下文开销，优化方法是可以先自旋一小段时间，再PARK
//该锁用的是AQS的非公平锁，因此性能比公平锁要好！公平锁是严格按照AQS队列的顺序，从头结点出队执行的!
//重入锁可以使用TRYLOCK方法
public class ReentraceLockTest {

	//因为要让多个ReentraceLockTest对象使用一个ReentrantLock，因此使用静态变量
	//多个不同的对象，使用一个Reentrantlock实例，即可实现多个对象所在线程的同步
    public static Lock Reentrantlock = new ReentrantLock();
    //使用Reentrantlock实例，初始化condition对象
    public static Condition condition = Reentrantlock.newCondition();
 
	public static void  main(String[] args) throws InterruptedException 
	{
		ReentraceLockTest threadA = new ReentraceLockTest();
		SecondThread threadS = new SecondThread();
		Thread t = new Thread(threadS);
		
		//线程B方法启动
		//该方法必须先执行，因为如果先执行method方法，其中的await方法会使主线程阻塞，从而无法启动threadB
	    t.start();
		
		//线程A方法启动
		threadA.method();
		
		
	}
	
	//Reentrantlock的典型用法if()... try... finally...
	public void method() throws InterruptedException
	{
	   if(Reentrantlock.tryLock())
	   {
		   try
		   {
			   for(int i = 0;i< 10;i++)
			   {
				   //await在调用前，必须确保该线程已经取得Reentrantlock，否则额会报错
				   if(i==6) condition.await();
				   System.out.println("AThread : " + i );
			   }
		   }
		   finally
		   {
		      Reentrantlock.unlock();
		   }
	   }		
	}
	
	
    class ThreadB implements Runnable
    {

		@Override
		public void run() 
		{
		   while(true)
		   {
			   if(Reentrantlock.tryLock())
			   {
				   try
				   {
					   for(int i = 0;i< 10;i++)
					   {
						   System.out.println("BThread : " + i );
					   }
				   }
				   finally
				   {
					   //signal在通知其他线程从await中唤醒前，必须确保在本线程的重入锁中！
					   condition.signal();
					   Reentrantlock.unlock();
					   break;
				   }
			   }
			   else
			   {
				   try 
				   {
					  Thread.currentThread().sleep(200);
				   } 
				   catch (InterruptedException e) 
				   {
					e.printStackTrace();
				   }
				   System.out.println("BThread :  waiting !"  );
			   }
			}
		}
    }

}
