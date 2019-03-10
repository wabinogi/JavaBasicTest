
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
	
<<<<<<< HEAD
	Integer sg = new Integer(1);
=======
	Integer sg = new Integer(0);
>>>>>>> branch 'master' of https://github.com/wabinogi/JavaBasicTest.git
    ThreadLocal<Integer> threadlocal = new ThreadLocal<Integer>()
     {
		 @Override
         protected Integer initialValue()
         {
        	 return sg;
         }
   	  };
	
    
	@Override
	public void run()
	{
		Thread th = Thread.currentThread();
		if(th.getName().equals("Thread 2"))
		{

		}
		if(th.getName().equals("Thread 1"))
		{
			try {
				th.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 sg = 6;
		 
		}
		while(true)
		{
			long t1 = System.currentTimeMillis();
			while(System.currentTimeMillis() - t1 <=200)
			{
				
			}
			if(Thread.currentThread().getName().equals("Thread 1"))
			{
				threadlocal.set(threadlocal.get() + 1);
			}
			
		//threadlocal.set(threadlocal.get().ii + 1);
		//threadlocal.set(no);
<<<<<<< HEAD
	    System.out.println(Thread.currentThread().getName() + " ii : " + threadlocal.get().hashCode());	
=======
	    System.out.println(Thread.currentThread().getName() + " No : " + threadlocal.get());	
>>>>>>> branch 'master' of https://github.com/wabinogi/JavaBasicTest.git
		}
	}
	
	public static void main(String[] args) {

		ThreadLocalTest1 test1 = new ThreadLocalTest1();
	
		for(int i = 1; i <= 2; i++)
		{
			Thread t = new Thread(test1);
			t.setName("Thread " + i);
<<<<<<< HEAD
		
=======
>>>>>>> branch 'master' of https://github.com/wabinogi/JavaBasicTest.git
			t.start();
		}
		
	}

	//几点心得
	//1、在initialValue方法中，需要在方法体内部NEW对象，保证每个线程调用initialValue时，对象是只属于该线程！在外部new则线程将共享对象！
	//2、对于上一步操作中有几个例外现象，如果在initialValue外部NEW一个数字包装器类型，例如Integer,每个线程
	//看似共享一个Integer对象，实则不然。原因如下：
	//虽然只New了一个Integer，但是在调用threadlocal.set(4)时。4是一个新的Integer对象。即为当前线程开辟了的新的副本内存空间
	//哪怕对threadlocal包装的副本对象Integer的对象sg单独赋值，线程1中sg = 33;线程2中sg = 44;也任然不会共享，因为1线程中的33和2线程中的44，都保存在各自线程中ThreadLocalMap中各自的Entry实例中了！ 
}
