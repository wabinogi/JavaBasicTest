import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class NormalTest {

	public static void main(String[] args)
	{ 
		//初始化方法12
		int[] ii = {1,2,3,4,5};
		//初始化方法2，默认赋值为0
		int[] kk = new int[5];
		
		int[] jj = ii;
		//修改jj也会修改ii的值
		jj[4] = 10;
		
		//Arrays.copyOf可用来赋值数组，如果大于原数组长度，多余的为0；小于的话会被丢弃
		int[] zz = Arrays.copyOf(ii, 10);
		
		//可用Arrays.toString()方法输出
		System.out.println(Arrays.toString(ii));
		System.out.println(Arrays.toString(jj));
		System.out.println(Arrays.toString(kk));
		System.out.println(Arrays.toString(zz));
		
		//用于接受入口点主函数参数的数组args
		System.out.println(Arrays.toString(args));
		
		int[] aa = {7,6,5,4,3,2,1};
		System.out.println(Arrays.toString(aa));
		//优化快速排序算法对数组进行排序
		Arrays.sort(aa);
		System.out.println(Arrays.toString(aa));
		
		//用二分法查找，返回索引值
		System.out.println(Arrays.binarySearch(aa, 3));
	}
}
