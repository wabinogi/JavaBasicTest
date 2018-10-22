package basic;

import static java.lang.System.out;

import java.util.Objects;

public class ObjectCateTest {

	/*判断两个对象是否相同的步骤cc
	 * 1.判断引用相同？相同返回1，否则继续
	 * 2.判断是否为null？为空返回0，否则继续
	 * 3.判断对象类型，可以根据情况使用instanceof和getclass方法
	 * 4.判断域值
	 */
	public static void main(String[] args)
	{	
		
		
		
		ObjectTest ot = new ObjectTest(1);

		
		//use instanceof checking object type 
		if(ot instanceof ObjectTest)
		{
			 out.println(ot.getA());
		}
		else
		{
			out.println("Can not cast");
		}
		
		
		 equaltest4();
		
	}
	
	public static void equaltest4()
	{
		ObjectSubTest ost = new ObjectSubTest(1);
		ObjectTest ot =  new ObjectTest(1);
		
		//ot1.getClass() show the real object class
		ObjectTest ot1 =  new ObjectSubTest(1);
		out.println(ot1.getClass());
		
		//ost is a child class,but instanceof ObjectTest
		if(ost instanceof ObjectTest)
			{
			out.println("true");
	
		    }
		else
		{
			out.println("false");
		
		}
		
		//ot is father class,not instanceof ObjectSubTest
		//if equal method using instanceof implementation,it breaks the java lang rule
		if(ot instanceof ObjectSubTest)
		{
			out.println("true");
	
		}
		else
		{
			out.println("false");

		}
		
		
	}
	
	public static void equaltest1()
	{
		String a = "aaa";
		StringBuilder sb = new StringBuilder("aaa");
		String c = sb.toString();
		
	    //String类型的equals方法，1.先看是否为同引用?如果为同引用则返回true。2.如果不为同引用则比较字符值
		// as to String Type,the equals method has a special implementation.compare every char
		// in the String Array
		//as to Other Objects, == is the same as equal method
	    if(a.equals(c))
	    		{
	    	out.println("equal1");
	    		}
	    else
	    {
	    	out.println("not equal1");
	    }
	    
	    
	    if(a == c)
		{
	      out.println("equal2");
		}
	    else
	    {
	    	out.println("not equal2");
	    }
	}
	
	public static void equaltest3()
	{
		StringBuilder sb1 = null;
		StringBuilder sb2 = null;
		
		//if sb1 or sb2 may be null,using Objects.equals avoiding exception
		if(Objects.equals(sb1,sb2)) out.println("Using Objects.equals method: nullsb1 e nullsb2");
		else out.println("nullsb1 ne nullsb2");
		
		try
		{
		  if(sb1.equals(sb2)) out.println("nullsb1 e nullsb2");
		  else out.println("nullsb1 ne nullsb2");
		}
		catch(Exception e)
		{
			out.println("Ex found!");
		}
		
	}
	public static void equaltest2()
	{
		StringBuilder sb1 = new StringBuilder("aaa");
		StringBuilder sb2 = new StringBuilder("aaa");
	
		//not equal,as the reference is not equal
	    if(sb1.equals(sb2))
	    {
	    	out.println("sb1 equal sb2");
	    }
	    else
	    {
	    	out.println("sb1 not e sb2");
	    }
	    
	    // equal,as the string value is equal
	    if(sb1.toString().equals(sb2.toString()))
	    {
	    	out.println("sb1string equal sb2string");
	    }
	    else
	    {
	    	out.println("sb1 not e sb2");
	    }
	    

	}
}
