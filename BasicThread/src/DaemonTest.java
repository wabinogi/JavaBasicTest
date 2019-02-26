//主线程st2执行完毕后，守护线程就会结束
//守护线程依赖主线程而生存
public class DaemonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaemonTest dt = new DaemonTest();
		subTest1 st1 = dt.new subTest1();
		subTest2 st2 = dt.new subTest2();
		st1.setDaemon(true);
		st1.start();
		st2.start();
		
	}

	
	public class subTest1 extends Thread
	{
		public void run()
		{
			while(true)
			{
				long time =  System.currentTimeMillis();
				
				while(System.currentTimeMillis() - time <= 1000)
				{
					
				}
				
				System.out.println("Thread 1");
			}
		}
		
	}
	
	public class subTest2 extends Thread
	{
		public void run()
		{
			int i = 1;
			while(i <=5)
			{
				long time =  System.currentTimeMillis();
				
				while(System.currentTimeMillis() - time <= 1000)
				{
					
				}
				
				System.out.println("Thread 2");
				++i;
			}
		}
	}
	
}
