import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class InputStream {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		//ReadByte();
		//ReadChar();
		//ReadWriteFile();
		
			//List<File> files = searchFiles(new File("/grid/pdns/newdata/"), "csv");
		String aa = "123,,,456,,,78,,,0123,,,456";
		String[] ay = aa.split(",,,");
		System.out.println(ay[0]);
		System.out.println(ay[1]);
		System.out.println(ay[2]);
		System.out.println(ay[3]);
	     
	}
	
	public static List<File> searchFiles(File folder,  String keyword) {
        List<File> result = new ArrayList<File>();
        if (folder.isFile())
            result.add(folder);
 
        File[] subFolders = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return true;
                }
                if (file.getName().toLowerCase().contains(keyword)) {
                    return true;
                }
                return false;
            }
        });
 
        if (subFolders != null) {
            for (File file : subFolders) {
                if (file.isFile()) {
                    // 如果是文件则将文件添加到结果列表中
                    result.add(file);
                } else {
                    // 如果是文件夹，则递归调用本方法，然后把所有的文件加到结果列表中
                    result.addAll(searchFiles(file, keyword));
                }
            }
        }
        return result;
    }

	
	//字节读入
	 public  static void ReadByte() throws IOException
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
