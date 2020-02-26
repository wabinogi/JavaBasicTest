package FakeAIO;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		int port = 10001;
		if(args != null && args.length >0 )
		{
			port = Integer.valueOf(args[0]);
		}
		ServerSocket server = null;
		
		server = new ServerSocket(port);
		System.out.println("Server Start in port : " + port);
        Socket socket = null;
        TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,10000);
        while(true)
        {
        	socket = server.accept();
        	singleExecutor.execute(new BlockIO.TimeServerHandler(socket));
        }
        
	}

}
