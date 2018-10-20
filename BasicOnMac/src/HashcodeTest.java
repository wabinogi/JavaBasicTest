import java.util.Objects;

public class HashcodeTest {
	
	static HashcodeTest ht = new HashcodeTest();
	
	public static void main(String[] args)
	{ 
		hashcodeT1();	
		//JAVA中重写方法没有override关键字
		System.out.println(ht.toString());
		//重载方法
		System.out.println(ht.toString(1));
		//对象ht遇到+运算，自动调用tostring方法
		System.out.println("auto plus " + ht);
	}
	
	public static void hashcodeT1()
	{
	   int a = 1;
	   String s = "a";
	   //返回联合hash值
	   //两个相等的对象要返回相等的HASH值，但是相等的HASH不一定对象相等
	   System.out.println(Objects.hash(a,s));
	   //取得类名方法
	   System.out.println(s.getClass().getName());
	   
	}
	
	//重写方法，三一致
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	//overload重写方法，1一致
	public int toString(int i)
	{
		return i;
	}
	
}
