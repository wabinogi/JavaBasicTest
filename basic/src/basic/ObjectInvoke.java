package basic;
import java.util.*;
import java.io.*;

public class ObjectInvoke {
	
	private int k = 10;
	
	public static void main(String[] args)
	{		
		//普通对象可以使用数组初始化
		ObjectTest[] ot1 = new ObjectTest[3];
		ot1[0] = new ObjectTest(2);
		ot1[1] = new ObjectTest(3);
		ot1[2] = new ObjectTest(4);
		
		//支持for的快速存取形式
		for(ObjectTest oo:ot1 )
		{
			System.out.println(oo.getA());
		}
		
		int ii = 22;
		//当调用triple时，ii传递的是一番副本（其他地址）拷贝！triple方法执行结束后，副本值不再使用
		triple(ii);
		System.out.println(ii);
		
		ObjectInvoke oii = new ObjectInvoke();
		//方法得到的是“对象引用”（指针地址）的拷贝。
		//当调用triple时，oii传的是一个（指针地址）的拷贝，该拷贝和oii地址同时指向一个对象。
		triple(oii);
		System.out.println(oii.k);
	}
	
	public static void triple(int x)
	{
	   x = x*x*x;
	}
	
	public static void triple(ObjectInvoke oi)
	{
		oi.k = oi.k * 10 ;
	}
	

}
