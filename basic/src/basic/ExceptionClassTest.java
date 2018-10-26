package basic;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

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
	
}
