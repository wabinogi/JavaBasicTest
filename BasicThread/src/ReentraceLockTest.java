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
//重入锁可以使用TRYLOCK方法
public class ReentraceLockTest {

     static Lock alock = new ReentrantLock();
     static Condition acond = alock.newCondition();
     static Thread t;
	 static int j;
	public static void  main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		ReentraceLockTest rlt = new ReentraceLockTest();
		Thread maint = Thread.currentThread();
		maint.setName("Main THREAD");
		SecondThread st = rlt.new SecondThread();
	    t = new Thread(st);
		t.setName("SECOND THREAD");
		t.start();
		
		System.out.println(maint.getName());
		
		//ReentraceLockTest.alock.lock();
	    //尝试获取锁对象，如果没获取成功，可以先干别的
		while(ReentraceLockTest.alock.tryLock() == false)
		{
			 System.out.println("Main Waiting ");
			 Thread.sleep(100);
		}
		
		rlt.method();
	  
	}
	
	public void method()
	{
		if(ReentraceLockTest.alock.tryLock())
		{
			try
			{
			  for( j = 0; j <= 9; j ++){
				
				  System.out.println("Main : " + j);
			   }
			}
			finally
			{
				//主线程执行完毕后，使用signalAll，使得所有线程重新进入竞争
				//acond.signalAll();
				ReentraceLockTest.alock.unlock();
			}
		}
	}
	
	
	public class SecondThread implements Runnable
	{   
		public void run() 
		{
		   Thread tt = Thread.currentThread();
		   System.out.println(tt.getName());
		   if(ReentraceLockTest.alock.tryLock())
			{
		   try{
		   for( j = 0; j <= 9; j ++){
			   
			   //满足某个条件的时候该线程进入等待！
			   //while(j == 3) acond.await();
			   System.out.println("S : " + j);
			
			} 
		   }
		   finally
		   {
			   ReentraceLockTest.alock.unlock();
			  
		   }
		   
			}
		   else
		   {
			   System.out.println("SEC Waiting ");
		   }
		   
		}	
	}

}
