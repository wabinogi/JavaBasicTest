
public class InnerStaticTest implements Runnable {
	
	Object1 o1 = new Object1();
	
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
		
		if(td.getName().equals("Thread 1"))
		{
			InnerStatic is1 =  new InnerStatic();
			is1.o = o1;
			while(true)
			{
				long time = System.currentTimeMillis();
				while( System.currentTimeMillis() - time <=500 )
				{
					
				}		

			((Object1)is1.o).ii = ((Object1)is1.o).ii + 1;
			System.out.println(td.getName() + " ii : " + ((Object1)is1.o).ii);
		   } 
		}
		if(td.getName().equals("Thread 2"))
		{
			InnerStatic is2 =  new InnerStatic();
			is2.o = o1;
			while(true)
			{
				long time = System.currentTimeMillis();
				while( System.currentTimeMillis() - time <=500 )
				{
					
				}		

			((Object1)is2.o).ii = ((Object1)is2.o).ii + 1;
			System.out.println(td.getName() + " ii : " + ((Object1)is2.o).ii);
		   } 
		}
		if(td.getName().equals("Thread 3"))
		{
			InnerStatic is3 =  new InnerStatic();
			is3.o = o1;
			while(true)
			{
				long time = System.currentTimeMillis();
				while( System.currentTimeMillis() - time <=500 )
				{
					
				}		

			((Object1)is3.o).ii = ((Object1)is3.o).ii + 1;
			System.out.println(td.getName() + " ii : " + ((Object1)is3.o).ii);
		   } 
		} 
		if(td.getName().equals("Thread 4"))
		{
			InnerStatic is4 =  new InnerStatic();
			is4.o = o1;
			while(true)
			{
				long time = System.currentTimeMillis();
				while( System.currentTimeMillis() - time <=500 )
				{
					
				}		

			((Object1)is4.o).ii = ((Object1)is4.o).ii + 1;
			System.out.println(td.getName() + " ii : " + ((Object1)is4.o).ii);
		} 
	
			
			
	
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
		Object o;
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
