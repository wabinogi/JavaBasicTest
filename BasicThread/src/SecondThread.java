
public class SecondThread implements Runnable
{

	@Override
	public void run()
	{
		
		ReentraceLockTest.Reentrantlock.lock();
	
			try
			{
				for(int i =0; i< 10; i++)
				{
					System.out.println("SecondThread : " + i);
				}	
			}
			finally
			{
				ReentraceLockTest.condition.signal();
				ReentraceLockTest.Reentrantlock.unlock();
				
		    }
		
	}
	

}
