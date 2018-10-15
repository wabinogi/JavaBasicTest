package basic;
import java.util.*;
import java.io.*;

public class ObjectInvoke {
	
	private int k;
	
	private static ObjectInvoke oi1;
	private static ObjectInvoke oi2;
	
	public ObjectInvoke(int k)
	{
		this.k = k;
	}
	
	
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
		
		ObjectInvoke oii = new ObjectInvoke(10);
		//方法得到的是“对象引用”（指针地址）的拷贝。
		//当调用triple时，oii传的是一个（指针地址）的拷贝，该拷贝和oii地址同时指向一个对象。
		triple(oii);
		System.out.println(oii.k);
		
		//方法得到的是“对象引用”（指针地址）的拷贝。
		//swap方法中ooi1和ooi2交换了值，但是swap调用结束后，局部变量ooi1和ooi2注销，没有成功交换
		oi1 = new ObjectInvoke(1);
		oi2 = new ObjectInvoke(2);
		swap(oi1,oi2);
		System.out.println("oi1:" + oi1.k);
		System.out.println("oi2:" + oi2.k);
	}
	
	public static void triple(int x)
	{
	   x = x*x*x;
	}
	
	public static void triple(ObjectInvoke oi)
	{
		oi.k = oi.k * 10 ;
	}
	
	public static void swap (ObjectInvoke ooi1,ObjectInvoke ooi2)
	{
		ObjectInvoke ooi3 = ooi1;
		ooi1 = ooi2;
		ooi2 = ooi3;
		
		//将ooi1和ooi2指针指向的对象交给oi1，oi2；实现交换！！
		//oi1 = ooi1;
		//oi2 = ooi2;
	}

}
