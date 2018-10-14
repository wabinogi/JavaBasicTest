package basic;

import java.io.*;


public class OperatorTest {

	
	public static void main(String[] args)
	{
		//左移后，原来的位置由0填充
		//0001左移后，为0
		//负数的二进制是用补码表示的，补码=反码+1
		//负数最高位，INT型，第32位是符号位
		//>>> 用移完的最高位补0
		//a += b, a^=b, a >>= b,三元运算符,一元运算符（++ --）是从右向左，剩下都是左向右，
		byte a = 1;
		
	    int b = 4;
	    
		System.out.println(a>>1);
		System.out.println(a>>>1);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.toBinaryString(a));
		System.out.println(Integer.toBinaryString(a>>1));
		System.out.println(Integer.toBinaryString(a>>>1));
		System.out.println(Integer.toBinaryString(b));
		//11111111111111111111111111111110
		//01111111111111111111111111111110
		//2147483647
		
	}
}
