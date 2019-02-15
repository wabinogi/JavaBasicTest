import static java.lang.System.out;

import java.lang.reflect.Method;

import org.junit.Test;

public class AnnotationMain {

	public static void main(String... args)
	{
		Start();
		AnnotationMain am = new AnnotationMain();
		for(Method m :am.getClass().getDeclaredMethods() )
		{
			AnnotationTest at = m.getAnnotation(AnnotationTest.class);
			out.println(at.source());
			out.println(at.number());
		}
		
	}
	
	//Must import org.Junit.Test
	//No annotation parameters , so use default value
	@Test 
	public static void Start()
	{
		
		out.println("Annotation Test !");

	}
	
	@AnnotationTest(source = "wangxing",number = 20)
	public void SomeMethod()
	{
		out.println("Do nothing !");
	}

}
