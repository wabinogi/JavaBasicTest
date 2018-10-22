import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import basic.*;


public class ArraylistTest {

	public static void main(String[] args)
	{ 
		 Atest1();
		 Btest1();
	}
	
	public static void Atest1()
	{
		String[] ss = new String[]{"a","b","c"};
		Object[] oo = new Object[3];
		//将ss拷贝到oo中
		System.arraycopy(ss, 0, oo, 0, Math.min(ss.length, oo.length));
		
		System.out.println(Arrays.toString(ss));
		System.out.println(Arrays.toString(oo));
	}
	
	public static void Btest1()
	{
		Object[] o = (Object[]) Array.newInstance(ObjectTest.class, 5);
		//将ss拷贝到oo中
		System.out.println(Arrays.toString(o));
	}
}
