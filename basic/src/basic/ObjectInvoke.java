package basic;
import java.util.*;
import java.io.*;

public class ObjectInvoke {
	
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
	}
}
