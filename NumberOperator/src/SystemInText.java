import java.io.*;
import java.util.*;



public class SystemInText {

	public static void main(String[] args)
	{
	
		double db = 10000.0/3.0;
		String a = "231";
		System.out.printf("%,.2f\r",db); // %f
		System.out.printf("%5d\r",30); //%d
		System.out.printf("%5s\r","sbcs");//%s ����ת���������
		System.out.printf("%10x\r",0x9f);//%x 
		System.out.printf("%c\r",'A'); //%c
		System.out.printf("%b\r",true); //%b
		System.out.printf("%h\r",args.hashCode()); //%h
		System.out.printf("%5o\r",013); //%o
		System.out.printf("%+010d,%<#x",12345);//%+ %0 %10d %#x 
		System.out.printf("%(d,%<#x",-12345);//%<x %(d
		
		System.out.printf("\r");
		//ʱ��
		System.out.println(new Date());
		System.out.printf("%tF\r",new Date()); //2018-10-11
		System.out.printf("%tD\r",new Date());
		System.out.printf("%tT\r",new Date()); //14:05:18
		System.out.printf("%tr\r",new Date()); //02:05:18 ����
		System.out.printf("%ts\r",new Date()); //timestamp 10
		System.out.printf("%tQ\r",new Date()); //timestamp 13
		System.out.printf("%tY\r",new Date());//2018
		System.out.printf("%tB\r",new Date()); //ʮ��
		System.out.printf("%tA\r",new Date()); //������
		System.out.printf("%tj\r",new Date()); //284
		System.out.printf("%tB %<te %<tY\r",new Date()); //%< ͬһ����������ʹ��
		System.out.printf("%1$s %2$s %3$te %3$tY","Date is"," format",new Date()); //%1$s ����Ĳ��������� 
		//String.format(XXXX)����Ҳ����ʹ�ø�ʽ������
	}
	public static void test1()
	{
		//sc.next()���Զ����οո���������
		Scanner sc = new Scanner(System.in);
		System.out.println("Pl INPUT 1!");
		String a = sc.next();
		System.out.println(a);
	
		//sc.nextLine()���ж������԰����ո���������
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Pl INPUT 2!");
		String b = sc2.nextLine();
		System.out.println(b);
		
		//Console���е�readPassword���ڶ������룬�ڿ���̨����ʾ���÷���������IDE�д�
		System.out.println("PS INPUT !");
		Console c1 = System.console();
		String ps = new String(c1.readPassword());
		//char[] cs = c1.readPassword();
		//System.out.println(ps);
		System.out.println(ps);
	
	}
	
	
	
}
