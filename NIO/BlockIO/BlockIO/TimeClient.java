package BlockIO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TimeClient 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
       int port = 10001;
       if(args != null && args.length > 0)
       {
    	   try
    	   {
    		   port = Integer.valueOf(args[0]);
    	   }
    	   catch(Exception e)
    	   {
    		   
    	   }
       }
       Socket socket = null;
       BufferedReader in = null;
       PrintWriter out = null;
       try
       {
    	   socket = new Socket("127.0.0.1",port);
    	   in = new BufferedReader(new InputStreamReader
    			   (socket.getInputStream()));
    	   out = new PrintWriter(socket.getOutputStream(),true);
    	   out.println("QUERY TIME ORDER");
    	   System.out.println("Send order 2 server succeed.");
    	   String resp = in.readLine();
    	   System.out.println("Now is : " + resp);
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
       finally
       {
    	   if(out != null)
    	   {
    		   out.close();
    		   out = null;
    	   }
    	   
    	   if(in != null)
    	   {
    		   try{
    			   in.close();
    		   }catch(Exception e)
    		   {
    			   e.printStackTrace();
    		   }
    	   }
    	   in = null;
       }
       
       if(socket != null)
       {
    	   try{ socket.close();}
    	   catch(Exception e)
    	   {
    		  e.printStackTrace();
    	   }
    	   socket = null;
       }
       
	}

}
