import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodTest {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{ 
		MethodTest1();
	}
	
	public static void MethodTest1() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException
	{ 
		//����Java.lang.reflect.Methodȡ�÷���
		Method m1 = Wabinogi.class.getMethod("Getbrith");
		Method m2 = Wabinogi.class.getMethod("GetAge",String.class);
		//m1ȡ���˷��������ã��޲�������
		m1.invoke(Wabinogi.class.newInstance());
		//����������
		System.out.println(m2.invoke(Wabinogi.class.newInstance(),"wabinogi"));
	}
}
