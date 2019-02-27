
public class ThreadLocalTest1  implements Runnable{

	//可以将每个线程的独立副本数据sg，放在ThreadLocal的initialValue中。
	//在Thread的run方法中，调用threadlocal实例的get方法，即可取得该线程中的副本数据。
	//如果ThreadLocal中封装的是sg是单例模式，那么副本机制将失效！
	/*
	Singleton sg = Singleton.getInstant(0);
    ThreadLocal<Singleton> threadlocal = new ThreadLocal<Singleton>()
     {
		 @Override
         protected Singleton initialValue()
         {
        	 return sg;
         }
   	  };*/
	
	Object1 sg = new Object1();
    ThreadLocal<Object1> threadlocal = new ThreadLocal<Object1>()
     {
		 @Override
         protected Object1 initialValue()
         {
        	 return sg;
         }
   	  };
	
    
	@Override
	public void run()
	{
		while(true)
		{
			long t1 = System.currentTimeMillis();
			while(System.currentTimeMillis() - t1 <=200)
			{
				
			}
			
			//threadlocal.set(threadlocal.get() + 1);
		//threadlocal.set(no);
	    System.out.println(Thread.currentThread().getName() + " Hash : " + threadlocal.get().hashCode() );	
		}
	}
	
	public static void main(String[] args) {

		ThreadLocalTest1 test1 = new ThreadLocalTest1();
	
		for(int i = 1; i <= 4; i++)
		{
			Thread t = new Thread(test1);
			t.setName("Thread " + i);
			if(t.getName().equals("Thread 4"))
			{
				System.out.println("Debug");
			}
			t.start();
		}
		
	}

}
