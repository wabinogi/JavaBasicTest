package basic;
import static java.lang.System.out;

import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.IntFunction;
import java.util.function.Supplier;

//类GenericTest 泛型符号T,可以限定
//如果多个限定，顺序痕重要！因为列表最后的接口方法，可能不会再IDE中出现
public class GenericTest<T> {

	
	private T t = null;
	
	
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException
	{
		GenericTest<String> GnS = new GenericTest<>();
		GenericTest<String> GnS1 = new GenericTest<>("1");
	
	    out.println(GnS1.getObject());
	
	    
	    //三参数关联，1，3参数需要一致
	    out.println( GenericTest.<Double>GetGnsObject1(1d));	
	    
	    //1,2关联，没啥意义
	    GenericTest.<Integer>GetGnsObject2("asd"); 
	    
	    //1,3关联，输入要一致！有一定意义
	    GenericTest.<String>GetGnsObject3("a"); 
	    
	    Integer[] ii = new Integer[]{1,2,3};
	    out.println(GenericTest.<Integer>GetGnsObject4(ii));
	    
	    //调用接口方法
	    GenericTest.<String>GetGnsObject5("a");
	    
	    //lambda表达式，实现接口对象st
	    Supplier<String> st = () -> {return "abcd";};
	    out.println(GenericTest.GetNewInstance(st).getObject());
	    
	    //利用Class<T> ct初始化，Integer.class是Class<T>的实例
	    Class<String> ct = String.class;
	    GenericTest<String> gs =  GenericTest.GetNewInstance1(ct);
	    gs.setObject("123");
	    out.println(gs.getObject());
	    
	    //。。。
	    GenericTest.GetArray("1","2");
	    //函数式接口调用
	    GenericTest.GetArray1((int i)->{ return new String[i];},"1","2");
	}
	//采用函数式接口赋参数值
	public static <T extends Comparable> T[] GetArray1(IntFunction<T[]> it,T...t)
	{
		T[]  tt =  it.apply(2);
		tt[0] = t[0];
		tt[1] = t[1];
		return tt;
	}
	//返回
	public static <T extends Comparable> T[] GetArray(T... t)
	{
		//如果Comparable为Object，则报错
		Comparable[] oo = new Comparable[2];
        oo[0] = t[0];
        oo[1] = t[1];
		return (T[])oo;
	}
	
	
	//利用Class<T>的实例化方法，
	public static <T> GenericTest<T> GetNewInstance1(Class<T> ct) throws InstantiationException, IllegalAccessException
	{
		//ct如果是Integer.class会报错！貌似JAVA八中基本型都不行！
		return new GenericTest<>(ct.newInstance()); 
	}
	
	//返回GenericTest<T>,Supplier<T>返回某对象
	public static <T> GenericTest<T> GetNewInstance(Supplier<T> st)
	{
		//将某对象输入GenericTest构造函数初始化
		return new GenericTest<>(st.get()); 
	}
	
	
	//调用方法泛型输入必须支持接口类型，否则报错
	//语法关键字用extends进行绑定；可以是类和接口
	//可以同时绑定多个
	//如果是类，必须出现的&后第一个位置
	public static <T extends Comparable & Serializable>void GetGnsObject5(T t1)
	{
		 out.println(t1.compareTo("a"));
	}
	
	//定义方法
	//<A>为调用输入类型参数；调用时可不写，可为任意？
	//A为返回类型；A可为固定类型String，数组类型String[]，泛型类型 MyObject<M>
	//A a为输入参数；可为A[],A..., MyObject<M>...
	public static <A>A GetGnsObject1(A a)
	{
		return a;
	}
	
	//1,2
	public static <A>A GetGnsObject2(String s)
	{
		out.println(s + " 方法2: 暂时认定无意义!");
		return (A)s;
	}
	
	//1,3
	public static <A>void GetGnsObject3(A a)
	{
		out.println(a.getClass().getName() + " 方法3: 有一定意义!");
	}
	

	//输入参数为数组
	public static <T>T GetGnsObject4(T[] t)
	{
		  return t[t.length/2];
	}
	
	
	//定义泛型方法2
	public GenericTest<Integer> GetGnsObjectT(Integer i)
	{
		GenericTest<Integer> gns = new GenericTest<Integer>(i);
		return gns;
	}
	


	
	//输入参数和调用方法外围泛型类型关联，可配置
	
	public GenericTest()
	{
		
	}
	
	//实例化GenericTest工厂，返回类型T的实例
	public GenericTest(T t)
	{
		this.t = t;
	}
	
	public T getObject()
	{
		return this.t;
	}
	
	public void setObject(T t)
	{
		 this.t = t;
	}
	
}
