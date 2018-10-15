import java.io.*;


public class StringBuilderTest {
 
	public static void main(String[] args)
	{
		SbTest1();
		//SbTest2();
		
	}

	public static void SbTest2()
	{
		String a = "\uD835\uDD6B";
		String b = new String(a.codePoints().toArray(),0,1);
		System.out.println(a.length());	
		System.out.println(a.codePointCount(0, 1));
		System.out.println(a.codePointAt(0));
		System.out.println(a);
	}
	
	public static void SbTest1()
	{
		//在1.5中，这个类的前身是StringBuffer，这个类适用于从键盘多次敲击字符数据获取输入。
		//相当于一个BUFFER，最后通过TOSTRING方法一次性写入一个新构建的STRING对形象中。
		//入股采用传统的STRING连接（+）方式，+的过程中会构建多个STRING对象，效率低下
		StringBuilder sb = new StringBuilder();
		//sb.append("\uD835\uDD6B");
		sb.append("12");
		//返回sb缓冲区字符数量code units,非code point
		System.out.println(sb.length()); 
		
		//unicode 97表示的是a，这里增加a
		sb.appendCodePoint(97);
		System.out.println(sb.toString());
		
		//在第N个code unit位置插入字符，其余字符向后移
		sb.insert(3, "c");
		System.out.println(sb.toString());
		
		
	
		
	}
}
