import java.io.*;
import java.math.*;
import java.util.Arrays;


public class BigNumberTest {

	public static void main(String[] args)
	{
		//返回一个大实数，大浮点数
		BigInteger bi = BigInteger.valueOf(1000);
		BigDecimal bd = BigDecimal.valueOf(1000);
		
		bi =  bi.add(BigInteger.valueOf(1111));
		bd =  bd.add(BigDecimal.valueOf(1111.1111));
		
		System.out.println(bi);
		System.out.println(bd);
		
		String[] sa = new String[10];
		int i;
		for(i = 0; i < 10; i++)
		{
			sa[i] = String.valueOf(i);
		}
		
		System.out.println(Arrays.toString(sa));
		
	    //JAVA中for each的写法
		for(String a:sa)
		{
			System.out.println(a);
		}
		    
		
	}
}
