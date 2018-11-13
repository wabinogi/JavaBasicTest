import java.lang.Integer;
import java.lang.reflect.Field;
public class ClassTest {

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException, SecurityException
	{ 
		wabinogiTest();
		String s = "java.util.ArrayList";
		//���s�е��಻���ڣ��ᱨ��
		Class cs = Class.forName(s);
		Class cs1 = Integer.class;
		System.out.println(cs.toString());
		System.out.println(cs1.toString());
		
		//�÷��䴴������
		Object o = Class.forName("java.util.ArrayList").newInstance();
		System.out.println(o);
	}
	
	public static void wabinogiTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException, SecurityException
	{
		Wabinogi wi = new Wabinogi();
		String name = "Wabinogi";
		Class cs = Class.forName(name);
		
		//����ȡ�������������
		for(Field f: cs.getDeclaredFields())
		{
			System.out.println(f.getName().toString());
		}
		
		for(Field f: cs.getDeclaredFields())
		{
		  
		   Field ff = cs.getDeclaredField(f.getName().toString());
		   //ͨ�������ʹ�÷�������ƹ�JAVA���ʿ��ƣ������Է���wi��private���ε��򣡣�
		   ff.setAccessible(true);
		    System.out.println(ff.get(wi).toString());
		}
		
	}
	
}
