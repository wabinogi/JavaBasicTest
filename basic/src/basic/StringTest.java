package basic;
import java.io.*;

  
public class StringTest {

	public static void main(String[] args)
	{
		String a = "abcde";
		String b ="abc";
		String c = "cde";
		String e = b.substring(0,3) + c.substring(1,3);
		String f = "abcde";
		//字符串判断是否相等一定要用Equal
		//字符串String的值一旦分配是不可改变的，不同的String变量赋值的只是引用，而不是重新分配新的内存地址
		//对于大量输入的，不可共享的字符串内容，有专门的类去处理
		if(a.equals("abcde"))
			System.out.println("相等");
		else
			System.out.println("不相等");
		
		//切记:不能用“==”判断连个字符串是否相等，因为“==”判断的是地址！
		System.out.println(a.substring(0,3));
		System.out.println(e);
		if(a.substring(0,3) == "abcde")
			System.out.println("符号：相等");
		else
			System.out.println("符号：不相等");

		
		//UNICODE由32位，4个BYTE组成，一般的地址范围在0x10FFFF以内，即，用到6*4=24位
		//JAVA中CHAR类型采用UTF-16，最多只能表示到FFFF，对于大于此编码地址的字符，使用两个CHAR表示一个码点
		//每个码点相当于一个ID，是固定的
	   // String s1 = "\uD835\uDD69";
		String s1 = "\uD83D\uDE03";
		
	    int is1 = s1.codePointCount(0, s1.length());//按UTF-16编码中实际码点（可能是16位或32位），计算有多少个字符
	    int is2 = s1.length();//按UTF-16编码中16位为一个字符单元，计算有多少个字符
	    int[] is3 = s1.codePoints().toArray();
	    System.out.println(s1);
	    System.out.println(is1);
	    System.out.println(is2);
	    System.out.println(is3[0]);
	    //String cs = new String(is3,0,1);
	    
	    //如果文本中有特殊字符，则length的值为2！此时应该用codePointCount方法！
	    //对于大于FFFF的UTF-16字符，charAt不好使！需要获得码点
	    String s2 = "😃";
	    System.out.println(s2.codePointCount(0,s1.length()));
	    System.out.println(s2.charAt(1));
	    
	    //compareTo返回0，表示两个字符串相等！如果S3在前返回负数，在后返回正数
	    String s3 = "aabbcc";
	    System.out.println(s3.compareTo("saabbcc"));
	  
	}
	
	
}
