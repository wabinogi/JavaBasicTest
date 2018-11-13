package basic;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;

  
public class SystemPropertyTest {
	
	public static void main(String[] args) throws IOException 
	{
		//注意：对于在basic包中的JAVA CLASS类的调用，需要在目录中存在BASIC，调用时在BASIC目录级别调用BAISC.METHOD方法
		//取得用户当前路径
		String a = System.getProperty("user.dir");	
		System.out.println(a);
		
		scannertest();

	}
	
	 private static void scannertest() throws IOException
	 {
		//该语句需要在函数体中加入throws IOException,并且在调用的函数体中也需要增加
			Scanner sc = new Scanner(System.in,"UTF-8");
	 }
}
