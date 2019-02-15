import java.lang.annotation.*;

//indicate that the Annotation must used on the method
@Target(ElementType.METHOD)
//The Annotation must be used While JVM running ! 
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationTest {


	String source();
	int number() default 10; 
}
