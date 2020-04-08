package BlockIO;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public static boolean IsOdd(int number)
	{
		return (number & 1) == 1;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Socket port
		int port = 429393;
		if(args != null && args.length > 0)
		{
			try
			{
				port = Integer.valueOf(args[0]);
			}
			catch(Exception e)
			{}
		}
		ServerSocket server = null;
		try
		{
			server = new ServerSocket(port);
			System.out.println("The time server is start in port : " + port);
			Socket socket = null;
			while(true)
			{
				socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(server != null)
			{
				System.out.println("The time server close");
				server.close();
				server = null;
			}
		}

	}

}
