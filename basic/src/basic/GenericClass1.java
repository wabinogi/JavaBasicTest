package basic;
import static java.lang.System.out;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.function.Predicate;

public class GenericClass1<T> extends GenericTest implements Closeable{
	
	public static void main(String...args)
	{
		new GenericClass1().Test();
		GetGenericType("none");
	}
	
	public static void GetGenericType(String s)
	{
		Class<?> cl = GenericClass1.class;
		System.out.println("Method Start!");
		for(Method m: cl.getDeclaredMethods())
		{
			//获得类修饰符、返回类型、名称
			System.out.print(Modifier.toString(m.getModifiers()) + " "+m.getGenericReturnType().getTypeName() + " "+ m.getName() + "|:");
			if(m.getParameterTypes().length != 0)
			{
				//getGenericParameterTypes，如果为泛型，返回参数修饰付，例如：<? super T>
			for(Type t : m.getGenericParameterTypes())
			{
				System.out.println(t.toString());
			}
			}
			else System.out.println();
			
			//获得完整的方法描述，包括泛型修饰符
	        //System.out.println(m.toGenericString());
			//System.out.println(m.toString());
		}
		System.out.println("Method End!");
		
		//取得类的修饰付
		System.out.print(Modifier.toString(cl.getModifiers()) + " ");
		//取得该类类型
		System.out.print(cl.getTypeName() +  " ");
        //取得类的参数,这的参数是泛型T
		Type[] ts = cl.getTypeParameters();
		for(Type t : ts)
		{
			System.out.println(t.toString());
		}
		
		//取得父类类型
		//System.out.println(cl.getGenericSuperclass());
		System.out.println(cl.getSuperclass());
		
		//取得接口
		for(Type t :cl.getInterfaces())
		{
			System.out.println(t.getTypeName());
		}

		
	}
	
	public void Test()
	{  
		GenericClass1<ParentClass> gp =  new GenericClass1<>(new ParentClass());
		//对于<? extends ParentClass> ，貌似只有构造函数能初始化
		GenericClass1<? extends ParentClass> gp1 = new GenericClass1<>(new ChildClass());

	    gp.SetGenericT(new ChildClass());
	    //下面这个方法是非法的！貌似?符号阻止所有传入
	    //Closeable cl = () -> { System.out.println("123");
	    //gp1.SetGenericT(new ChildClass());
	    
	    //定义一个ParentClass的父类(爷爷)的泛型，但是初始化很奇葩！可以穿各种不相干类型
	    GenericClass1<? super ParentClass> gp3 =  new GenericClass1<>(new Integer(2));
	    
	    //由于是? super ParentClass,但是只能赋值new ParentClass()或者ParentClass的子类
	    gp3.SetGenericT(new ChildClass());
	    //由于是? super ParentClass,不能用父类（例如传Object）初始化。
	    //gp3.SetGenericT(new Object());
	   
	    //静态调用
	    removesta(new GenericClass1<Object>(new Object())); //OK
	    removesta(new GenericClass1<ParentClass>(new ParentClass())); //OK
	    //removesta(new GenericClass1<ChildClass>(new ChildClass())); //ERROR，因为ChildClass不是ParentClass的父类
	    
	    //动态调用
	    GenericClass1<String> gg = new GenericClass1<>();
	    gg.remove(new GenericClass1<Object>(new Object())); //OK 
	    gg.remove(new GenericClass1<Comparable<String>>((s) -> {return 0;})); //OK
	    gg.remove(new GenericClass1<String>(new String())); //OK
	}
	


	//泛型T不能用在静态域中
	//和初始化T相关，传入T的一个父类型
	public void remove(GenericClass1<? super T> gp)
	{
		out.println("method invoke! ? super T");
	}
	
	//和T无关，表示传入一个ParentClass的父类，因此
	public static void removesta( GenericClass1<? super ParentClass> gp)
	{
		out.println("method invoke static!");
	}
	
	
	private T t;
	public T GetGenericT()
	{
		return this.t;
	}
	
	public void SetGenericT(T t)
	{
		this.t = t;
	}
	
	public GenericClass1()
	{
		
	}
	
	public GenericClass1(T t)
	{
		this.t = t;
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		
	}

}
