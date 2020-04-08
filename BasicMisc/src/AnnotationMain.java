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
	
	//��Ԫ��ע��
	public @interface AnnotationNoElement 
	{}

	//��ֵע��
	public @interface AnnotationSingle
	{
		String value();
	}

	//��ֵע��
	public @interface AnnotationMulti
	{
		String date();
		String name();
	}
	
	//TargetԪע��
	//��ʾMetaAnnoTargetע��ֻ�����ڷ���
	//�����Ļ���
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
	//RetentionԪע������������SOURCE CLASS
	//��Ԫע����������ע���Ƿ������Դ�롢JVM��CLASS���ֲ�ͬ������
	//��ע��һ�㱻���Թ���ʹ�ý϶࣬����Ϸ������ȡ��ע���ķ�����˵����Щ������Ҫ������
	
	//@InheritedԪע��
	//��ע���ע�������У�ʹ��������Լ̳и����ע��
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
