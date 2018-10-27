package basic;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionClassTest {

	public static void main(String...args)
	{
		//try with resource只是一个语法糖，jvm仍会将其变异成传统形式
		//如果resource出现错误，会自动执行auto/closeable接口，且能够catch到资源关闭前的异常
		try(IOTest it = new IOTest();)
		{
			
		}
		catch(Exception e)
		{
			
		}
		
		ExpTest();
		
	}
	
	public static class IOTest implements Closeable
	{
		public void close() throws FileNotFoundException
		{	
			//do sth resource close
			System.out.println("resource close methods");
			//must be none exp OR subclass expclass!
			throw new FileNotFoundException();
		}
	}
	
    //*比较难以理解的例子！
	public static void ExpTest() 
	{
	         try
	    	{
	    		Scanner in = new Scanner(new File("erth.txt"),"UTF-8");
	    	    while(in.hasNext())
	    	    	System.out.println(in.next());
	    	    in.close();
	    	}
	         catch(Throwable t)
	         {
	        	 //调用该方法后，编译器对NoCheckedExp中throw (T)e理解为非受查异常，因而抛出后ExpTest可不做处理
	        	 //但是这个例子本身实用性意义不大！就算ExpTest不做处理，可是语法中还是使用catch做捕获
	        	 ExceptionClassTest.<RuntimeException>NoCheckedExp(t);
	        	 
	         }
	   
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Throwable> void NoCheckedExp(Throwable e) throws T
	{
	   throw (T)e;
	}

	
	
	
}
