import java.io.*;
import java.net.*;
import java.util.*;


public class SocketTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//test();
		//test2();
		
	}
	

	
	public static void test2() throws IOException
	{
		Scanner sc = new Scanner(System.in,"UTF-8");
		boolean b = true;
		//采用整行读入，如果是hasNext就是一个单元一个单元的读入，比如遇到空格，就会触发结束
		while(b && sc.hasNextLine())
		{
			
			//nextLine在于整行输出，标识可以是/r/n
			//next在于单个输出，标识可以是空格、回车，换行符
			String tmp = sc.next();
			
			if(tmp.equals("Quit"))
			{
				b = false;
			}
			
			System.out.println(tmp);
			
		}
		
	}
	
	public static void test() throws IOException
	{
		try(ServerSocket ss = new ServerSocket(8189))
		{
			try(Socket incoming = ss.accept())
			{
				InputStream is = incoming.getInputStream(); 
				OutputStream os = incoming.getOutputStream(); 
				
				try(Scanner sc = new Scanner(is,"UTF-8"))
				{
					PrintWriter out = new PrintWriter(new OutputStreamWriter(os,"UTF-8"),true);
					out.println("Hi ! Enter Quit to Exit !");
					
					boolean done = false;
					while(!done && sc.hasNextLine())
					{
						String line = sc.nextLine();
						out.println("Line is :" + line);
						if(line.trim().equals("Quit"))
						{
							done = true;
						}
					}
				}
			}
			
		}
	}

}
