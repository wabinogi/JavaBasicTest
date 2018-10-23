package basic;

public class InnerClTest {

	private int i = 0;
		
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
		int in = 1;
	
		Inner1()
		{
			
		}
		
		//内部类可以访问主类全局变量
	     void Inner11()
		{
	    	 InnerClTest.this.i = 1;
		}
	}
	
	//内部类可以为静态类，
	public static class Inner2
	{
		//内部类中所有静态域都是final
		int i = 0;
		
		//内部类要定义成静态方法，则类必须为静态类
		//但是JAVA语言规范没有限制，不建议这么做
	    static void Inner22()
		{
			
		}
	}
	
}
