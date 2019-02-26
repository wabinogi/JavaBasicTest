
public class BasicThread1 implements Runnable{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		BasicThread1 eThread = new BasicThread1();
		Thread th = new Thread(eThread);
		th.start();
		System.out.println("Thread Main");
		System.out.println("Is IRT ? " + th.isInterrupted());
	
		//interupt设置中断表示位置，但需要在th线程方法中做实际处理
		//当th在sleep或wait时，调用interupt方法会抛异常，且不会设置中断标志位，该情况需要在异常段儿中做处理
        th.interrupt();

	}
	
	//run方式不能抛出受查异常，因此需要catch处理
	//InterruptException是受查异常
	@Override
	public void run()
	{
		boolean flag = false;
		
		try{
		
			Thread.currentThread().sleep(1000);
		
		while(!flag)
		{
			
		   long time = System.currentTimeMillis();
		   while(System.currentTimeMillis() - time < 1000)
		   {
			   
		   }
	
		   //一个interrupted只能用一次，用完后设置为中断位为false
		   if(Thread.currentThread().interrupted())
		   {
			   System.out.println("Thread break");
			   break;
		   }
		   
		   System.out.println("Thread B");
		}
		}
		catch(Exception ex)
		{
			//RUN方法不能抛出受查异常，因此异常处理一定要有！
			System.out.println("Interputed Ex !");
			System.out.println("Is IRT ? " + Thread.currentThread().isInterrupted());
		}
		
		 System.out.println("End");
	}

}
