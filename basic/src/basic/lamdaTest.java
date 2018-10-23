package basic;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.print.attribute.IntegerSyntax;

public class lamdaTest {
	
	public static void main(String[] args)
	{
		ObjectTest ob = new ObjectTest(1);
		
		//函数式接口，lamda表达式写法1
		//定义一个只有一个虚方法的接口
		//使用接口的类的方法ObjectInterfaceTest中必须包含接口对象参数，且接口方法可参与运算
	    double re = ob.ObjectInterfaceTest(1,1, (a,b)-> a+b);
		System.out.println(re);
	    
		//lamda表达式写法2  obj::method,class:staticmethod,super::method
	    re = ob.ObjectInterfaceTest(2,2, Math::pow);
		System.out.println(re);
			
		//lamda表达式写法3
		re =  ob.ObjectInterfaceTest(1,1, 
				 (int a,int b)-> { 
					 if(a == b) 
					 {return a*b;} 
					 else 
					 {
						 return a-b;}
					 }
				 );
		System.out.println(re);
		/*
		String[] ss = new String[]{"1","22"};
		Arrays.sort(ss,(first1,second)->first1.length() - second.length());
		*/
	String s = "wabinogi1";
	 s = "wabinogi";
		lamda1(s);
		
		
		repeat(5,()->System.out.println("good job!"));
	}
	
	//函数式接口
	public static void repeat(int i , Runnable action)
	{
		for(int j = 1; j <=i; j++)
			action.run();
	}
	
	public static void lamda1(String s)
	{
		//恶心的lamda表达式4
		BasicInterface bi = Math::pow;

		//一旦局部变量s传入lamda表达式，值就不可改变，成了final,但是StringBuilder特别
		//s在lamda内部域范围，或者外部局部方法范围都不可改变
		BasicInterface bi1 = (a,b) -> {System.out.printf(s); 
		return (a+b);};
		
		ObjectTest ot = new ObjectTest(1);
		
		System.out.println(ot.ObjectInterfaceTest(3,3, bi1));
		
	}
	

}
