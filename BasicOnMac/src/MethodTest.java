import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{ 
		MethodTest1();
	}
	
	public static void MethodTest1() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{ 
		//利用Java.lang.reflect.Method取得方法
		Method m1 = Wabinogi.class.getMethod("Getbrith");
		Method m2 = Wabinogi.class.getMethod("GetAge",String.class);
		//m1取得了方法的引用，无参数调用
		m1.invoke(Wabinogi.class.newInstance());
		//单参数调用
		System.out.println(m2.invoke(Wabinogi.class.newInstance(),"wabinogi"));
	}
}
