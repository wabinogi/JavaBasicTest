import static java.lang.System.out;

import java.lang.reflect.Method;

import org.junit.Test;

public class AnnotationMain {

	public static void main(String... args)
	{
		AnnotationMain am = new AnnotationMain();
		
		InnerAnnotation ia = am.new InnerAnnotation();
		
		for(Method m :ia.getClass().getDeclaredMethods() )
		{
			out.println(m.getName());
			AnnotationTest at = m.getAnnotation(AnnotationTest.class);
			out.println(at.source());
			out.println(at.number());
		}
		
	}
	
	


	public class InnerAnnotation
	{
		InnerAnnotation()
		{
			
		}
		
		@AnnotationTest(source = "wangxing",number = 20)
		public void SomeMethod()
		{
			out.println("Do nothing !");
		}
		
		//Must import org.Junit.Test
		//No annotation parameters , so use default value
		/*@Test public void Start()
		{
			
			out.println("Annotation Test !");

		}*/
	}
}
