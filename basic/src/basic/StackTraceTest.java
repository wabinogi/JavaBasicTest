package basic;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

public class StackTraceTest {

	public static void main(String[] args)
	{
		StackTraceTest1();
		
	}
	
	//获取方法进站信息
	public static void  StackTraceTest1()
	{
	   Throwable th = new Throwable();
       StackTraceElement[] ste = th.getStackTrace();
       for(StackTraceElement st : ste)
       {
    	  System.out.println(st.toString());
       }
       
       //线程堆栈轨迹
       Map<Thread, StackTraceElement[]> m = Thread.getAllStackTraces();
	   for(Thread t :m.keySet())
	   {
		   StackTraceElement[] ss = m.get(t);
		   System.out.println(ss.toString());
	   }
	   //Thread.dumpStack();
	}
	

}
