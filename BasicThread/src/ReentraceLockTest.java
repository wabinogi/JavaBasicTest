import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock要点！
//1.static Lock alock = new ReentrantLock()在每个类中作为静态共有对象
//
public class ReentraceLockTest {

     Integer i = new Integer(0);
	static Lock alock = new ReentrantLock();
	
	
	public static void  main(String[] args) throws InterruptedException, FileNotFoundException {
		// TODO Auto-generated method stub
		
		ReentraceLockTest rlt = new ReentraceLockTest();
		Thread maint = Thread.currentThread();
		maint.setName("Main THREAD");
		SecondThread st = rlt.new SecondThread();
		Thread t = new Thread(st);
		t.setName("SECOND THREAD");
		t.start();
		
		System.out.println(maint.getName());	
		ReentraceLockTest.alock.lock();
		try
		{
		  PrintStream ps2 =  new PrintStream("E:\\log.txt");
		  for(int j = 0; j <= 9; j ++){
		   
			
			  ps2.append("Main :1");
  
		   }
		  ps2.flush();
		  ps2.close();
		}
		finally
		{
			ReentraceLockTest.alock.unlock();
		}
		
	}
	
	
	public class SecondThread implements Runnable
	{   
		PrintStream ps;
		public void run() 
		{
			
		   Thread tt = Thread.currentThread();
		   System.out.println(tt.getName());
		   ReentraceLockTest.alock.lock();
		   try{
			   
			   ps = new PrintStream("E:\\log.txt");
		   for(int j = 0; j <= 9; j ++){
			   
			   ps.append("SECOND");
			  // System.out.println("SECOND : 2");	   
			
			} 
		   } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   finally
		   {
			  
			   ReentraceLockTest.alock.unlock();
			   ps.flush();
			   ps.close();
		   }
		   
		}	
	}

}
