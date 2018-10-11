import java.io.*;
import java.util.*;



public class SystemInText {

	public static void main(String[] args)
	{
		//sc.next()会自动屏蔽空格后面的输入
		Scanner sc = new Scanner(System.in);
		System.out.println("Pl INPUT 1!");
		String a = sc.next();
		System.out.println(a);
	
		//sc.nextLine()按行读，可以包含空格后面的输入
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Pl INPUT 2!");
		String b = sc2.nextLine();
		System.out.println(b);
		
		//Console类中的readPassword用于读入密码，在控制台不显示，该方法不能再IDE中打开
		System.out.println("PS INPUT !");
		Console c1 = System.console();
		//String ps = new String(c1.readPassword());
		char[] cs = c1.readPassword();
		//System.out.println(ps);
		System.out.println(cs[0]);
		System.out.println(cs[1]);
		System.out.println(cs[2]);
		System.out.println(cs[3]);
	}
	
	
}
