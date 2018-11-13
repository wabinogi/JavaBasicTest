package basic;

public class InnerClTest {

	private int outeri = 0;
		
	public void InnerCl1()
	{
		//内部类实例化this.new 
		Inner1 i1 = this.new Inner1();
		System.out.println(i1.in);
		
	}
	
	public static void main(String[] args)
	{
		new InnerClTest().InnerCl1();
	}
	
	public static void print()
	{
		
	}
	//内部类可以用private修饰，来保证对外不可见
	private  class Inner1
	{
		int in = InnerClTest.this.outeri;
	
		Inner1()
		{
			
		}
		
		//内部类可以访问主类全局变量
	     void Inner11()
		{
	    	 InnerClTest.this.outeri = 1;
		}
	}
	
	//只有内部类可以为静态类，其他类不能用static修饰
	//静态内部类中不能使用外部类对象或变量引用
	public static class Inner2
	{
		//构造方法虽然没有static修饰，但是是静态的
		public Inner2()
		{
			
		}
		//内部类中所有静态域都是final
		int i = 0;
		
		//要定义成静态方法，则类必须为静态类
	    static void Inner22()
		{
			
		}
	}
	
}
