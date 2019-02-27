
public class InnerStaticTest implements Runnable {
	Integer ii = new Integer(0);
	public static void main(String[] args) {
		
		
	    InnerStaticTest it1 = new InnerStaticTest();
		for(int k = 1; k<5; k++)
		{
			Thread td = new Thread(it1);
			td.setName("Thread " + k);
			td.start();
		}
	}
	
	@Override
	public void run()
	{
		Thread td = Thread.currentThread();
		InnerStatic is1 =  new InnerStatic();
		is1.o = ii;
	
		
		while(true)
		{
			if(td.getName().equals("Thread 1"))
			{
				is1.o = (Integer)is1.o + 1;
			}
			
			long time = System.currentTimeMillis();
			while( System.currentTimeMillis() - time <=500 )
			{
				
			}		

		System.out.println(td.getName() + " Integer : " + is1.o);
		}
		
	}
	


	
	//内部静态类可以简单理解为被共享的内存区域
	//被外部类不同实例共享
	 public class InnerStatic
	{
		//InnerStatic为内部静态类
		//i为静态变量
		//InnerStatic new了两个独立的对象
		//两个对象共享i的值，可被两个对象读写（实际是一个对象，两个引用）
		//但是，如果存在非静态域z,则两个对象的z值实际是不同的！
		 private int i = 0;
		Object o = null;
		private int z = 0;
		public void SetZ(int si)
		{
			z = si;
		}
		
		public int GetZ()
		{
			return z;
		}
		
		
	}

}
