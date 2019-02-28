import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

public class ArraylistTest {
	
	public static void main(String[] args)
	{ 
		//ARRAYLIST效率比链表低，删除一个元素，所有后面的元素会前移
		arrayListT1();
		arrayListT2();
		arrayListT3();
		arrayListT4();
	}
	
	public static void arrayListT4()
	{
		System.out.println("__________________T4");
		//产生5个数组
		Wabinogi[] wi = new Wabinogi[5];
		//由于是引用类型，所以为空
		//System.out.println(wi[0].money);
		
		//cl.getComponentType()用来确定数组的类型
		System.out.println(wi.getClass().getComponentType());
		//类型带入Array.newInstance进行初始化,如果getComponentType返回的是引用类型，则初始化数组只有引用，值为null
		Object ob = Array.newInstance(wi.getClass().getComponentType(), 5);
		//使用基本类型int.class，数组中返回的值为0！记住integer为int的包装类
		Object ib = Array.newInstance(int.class, 5);
		System.out.println(((int[])ib)[1]);
	
	}
	
	public static void arrayListT3()
	{
		System.out.println("__________________T3");
		String[] ss = new String[3];
		ArrayList<String> al = new ArrayList();
		al.add("a");al.add("b");
		//ArrayList转化String[]
		al.toArray(ss);
		System.out.println(Arrays.toString(ss));
	}
	public static void arrayListT2()
	{
	    String[] ss  = new String[40];
	    //已经有个40个单位
	    System.out.println(ss.length);
	    
		//具有容纳100个单位的潜力！
		ArrayList<String> as = new ArrayList<>(100);
		//ArrayList是边长的，初始值是10个大小
		//不指定ensureCapacity时，每次插入数组，可能会导致数组频繁的扩容、COPY，导致性能下降
		//ensureCapacity（20），表示在创建数组后，每次追加20个单位
		as.ensureCapacity(1);
        
	}
	
	public static void arrayListT1()
	{
		//ArrayList初始化两种方法
		ArrayList<String> as = new ArrayList<>();
		ArrayList<String> as1 = new ArrayList<>(5);
		ArrayList<HashcodeTest> aht = new ArrayList<>();
		
		//as1初始化5个单位但是实际sIZE是0
		System.out.println(as1.size());
		as1.add("a");
		//replace index 0 content
		as1.set(0, "b");
		
		//索引从0开始
		aht.add(0,new HashcodeTest());
		
		System.out.println(as.size());
		//增加后，为1
		System.out.println(as1.size() + ": "+as1.toString());
		
		System.out.println(aht.size() + ": "+aht.toString());
		
	}
}
