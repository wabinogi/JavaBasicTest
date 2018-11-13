import java.lang.Integer;
import java.lang.reflect.Field;
public class ClassTest {

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException, SecurityException
	{ 
		wabinogiTest();
		String s = "java.util.ArrayList";
		//如果s中的类不存在，会报错！
		Class cs = Class.forName(s);
		Class cs1 = Integer.class;
		System.out.println(cs.toString());
		System.out.println(cs1.toString());
		
		//用反射创建对象
		Object o = Class.forName("java.util.ArrayList").newInstance();
		System.out.println(o);
	}
	
	public static void wabinogiTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, NoSuchFieldException, SecurityException
	{
		Wabinogi wi = new Wabinogi();
		String name = "Wabinogi";
		Class cs = Class.forName(name);
		
		//反射取得所有域的名字
		for(Field f: cs.getDeclaredFields())
		{
			System.out.println(f.getName().toString());
		}
		
		for(Field f: cs.getDeclaredFields())
		{
		  
		   Field ff = cs.getDeclaredField(f.getName().toString());
		   //通过下语句使得反射机制绕过JAVA访问控制！！可以访问wi中private修饰的域！！
		   ff.setAccessible(true);
		    System.out.println(ff.get(wi).toString());
		}
		
	}
	
}
