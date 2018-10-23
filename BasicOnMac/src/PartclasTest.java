import java.util.ArrayList;

public class PartclasTest {
	
	
	public static void main(String... args)
	{ 
		int[] ii = new int[]{1}; 
		new PartclasTest().Test1(ii);
		new PartclasTest().Test2();
		new PartclasTest().Test3();
		//匿名类使用方式1，采用父类和子类
		ParentClass ps = new ChildClass()
				{
			//子类重写父类方法Child
			 public void Child()
			 {
				 ////注意！匿名子类中getClass和父类比较会不等！
				System.out.println(getClass().toString());
	    	    System.out.println("New Child!");
			 }
				};
				//匿名类外部调用刚刚重写的方法
				((ChildClass)ps).Child();
	
	
	}
	//匿名内部类
	public void Test3()
	{
		//匿名类使用方法2，和1大同小异
		WabinogiIN aa = new WabinogiIN()
		{
			//实现接口类方法
			//实现的default，用public修饰
			 public String GetName()
			{
				return "wangxing";
			}
			
			//初始化块
				{
					  System.out.println("初始化块的方法");
				}
			
		};
	}
	public void Test2()
	{
		//匿名内部类
		//产生一个实现了WabinogiIN的匿名内部类对象acn
		WabinogiIN acn = new WabinogiIN()
	    {
			 public void GetWife()
			 {
	    	    System.out.println("匿名内部类");
			 }
	    };
	    acn.GetWife();
	    
	}
	
	//内部类
	public void Test1(int[] ii)
	{
		//局部类作用域只能在该方法内部
		//对外隐藏，不能用public和private关键字
		ii[0] = 2;
	    class SubPartClass
		{
		     void Pprint()
			{
		        //变量s在局部类中为final，不能改变
		    	 //stringbuilder和int[]等数组例外
				System.out.println(ii[0]);
			}
		}
	    SubPartClass spc = new SubPartClass();
	    System.out.println("get ready!");
	    spc.Pprint();
	    
	}

}
