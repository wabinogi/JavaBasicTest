import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class InputStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//ReadByte();
		//ReadChar();
		ReadWriteFile();
	}
	
	//字节读入
	public static void ReadByte() throws IOException
	{
		Reader in = new InputStreamReader(System.in,StandardCharsets.UTF_8);
		System.out.println((char)in.read());		
	}

	//字符读入
	public static void ReadChar() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		
		if(sc.hasNext())
		{
			System.out.println(sc.next());
		}
	}
	
	
	//读文件
	public static void ReadWriteFile() throws IOException
	{
	  
    		Scanner in = new Scanner(new File("D:/wangxing.txt"),"UTF-8");
    	   
    	    String aline;
    	  
    	    //writer
    	    File f = new File("D:/wangxing_1.txt");
    	    FileWriter fr = new FileWriter(f);
    	    BufferedWriter bw = new BufferedWriter(fr);
    	    
    		while(in.hasNextLine())
    		{  
    			aline = in.nextLine();

    	    bw.append(aline);
    	    bw.newLine();
    			}
    		bw.flush();
    	    in.close();
    	    bw.close();
    	    fr.close();

	}
	
	
}
