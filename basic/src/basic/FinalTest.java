package basic;
import java.io.*;

public class FinalTest {
	
	//静态常量比较多用
	//静态常量由于是final，一旦赋值无法被更改，所以public关键字不会破坏其封装性。
	//*本地方法可以绕过JAVA语言访问控制机制
	public static final int ii = 123;
	public int jj = 3;
	public static void main(String[] args)
	{
	    //final关键字标识类引用（指针）的地址不会再指向其他对象的地址；下载这个例子是个特例！
		final StringBuilder sb = new StringBuilder();
		sb.append("1");
		sb.append("2");
		sb.append("3");
		System.out.println(sb.toString());
		
		
	}
	

}
