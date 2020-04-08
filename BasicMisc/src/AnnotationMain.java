import static java.lang.System.out;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


public class AnnotationMain {

	public static void main(String... args)
	{
		/*
		AnnotationMain am = new AnnotationMain();
		
		InnerAnnotation ia = am.new InnerAnnotation();
		
		for(Method m :ia.getClass().getDeclaredMethods() )
		{
			out.println(m.getName());
			AnnotationTest at = m.getAnnotation(AnnotationTest.class);
			if(at != null)
			{
			out.println(at.source());
			out.println(at.number());
			}
		}
		ia.equals(1);
		*/
		NoElementMethod();
		SingleValueMethod();
		MultiValueMethod();
	}
	
	@AnnotationNoElement
	public static void NoElementMethod()
	{
		System.out.println("No Element Annotation Method !");
	}
	
	@AnnotationSingle("single")
	public static void SingleValueMethod()
	{
		System.out.println("Single value Annotation Method !");
	}
	
	@AnnotationMulti(name = "wabinogi",date = "20190101")
	@MetaAnnoTarget
	public static void MultiValueMethod()
	{
		System.out.println("Multi value Annotation Method !");
	}
	
	//无元素注解
	public @interface AnnotationNoElement 
	{}

	//单值注解
	public @interface AnnotationSingle
	{
		String value();
	}

	//多值注解
	public @interface AnnotationMulti
	{
		String date();
		String name();
	}
	
	//Target元注解
	//表示MetaAnnoTarget注解只能用于方法
	//其他的还有
	/*ElementType.TYPE
	 * ElementType.FIELD
	 * ElementType.PARAMETER
	 * ElementType.CONSTRUCTOR
	 * ElementType.LOCAL_VARIABLE
	 */
	@Target(ElementType.METHOD)
	public @interface MetaAnnoTarget
	{
		
	}
	
	//@Retention(RetentionPolicy.RUNTIME)
	//Retention元注解有三个级别，SOURCE CLASS
	//该元注解用来限制注解是否出现在源码、JVM、CLASS三种不同环境下
	//该注解一般被测试工具使用较多，可配合反射机制取得注解后的方法，说明哪些方法需要被测试
	
	//@Inherited元注解
	//该注解标注到子类中，使得子类可以继承父类的注解
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
		
		//the method override father class Object
		@Override
		public boolean equals(Object obj)
		{
			return false;
			
		}
		
		
		
		//Must import org.Junit.Test
		//No annotation parameters , so use default value
		/*@Test public void Start()
		{
		\
			
			out.println("Annotation Test !");

		}*/
	}
	
	//indicate that the Annotation must used on the method
	@Target(ElementType.METHOD)
	//The Annotation must be used While JVM running ! 
	@Retention(RetentionPolicy.RUNTIME)
	public @interface AnnotationTest {


		String source();
		int number() default 10; 
	}
}
