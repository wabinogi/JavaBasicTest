import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class PdnsProcesser {

	static long endtime;
	static long stime;
	static int filenum = 1; 
	
	static File f = new File("/grid/pdns/newdata/pak" + filenum + ".csv");

	//static File f = new File("E:/test/" + filenum + ".csv");
	static FileWriter fr;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//ReadWriteFile();
		PdnsProcesser fp = new PdnsProcesser();
		SubProcesser sp = fp.new SubProcesser();
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.submit(sp);

		stime = endtime = System.currentTimeMillis();
		while(true)
		{
		   long range = (endtime - stime)/1000;
		   System.out.println(range);
		   if((endtime - stime)/1000 > 3600)
	       {
		        bw.flush();
		        fr.close(); 
				bw.close();
	        	break;
	       }
		   else
		   {
				Thread.sleep(5000);
				endtime = System.currentTimeMillis();
		   }
		}
		es.shutdown();
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
	
	@Deprecated
	public static void ReadWriteFile() throws IOException
	{
	  
		Scanner in = new Scanner(new File("D:/pdns.txt"),"UTF-8");
	    String aline;
	  
	    //writer
	     //该文件
	    File f = new File("D:/newpdns.csv");
	    fr = new FileWriter(f);
	    bw = new BufferedWriter(fr);

	
		while(in.hasNextLine())
		{  
			aline = in.nextLine();
			aline = aline.substring(10);
			int p0 = aline.indexOf("\"");
			
			//name
			String name = aline.substring(0,p0);
			aline = aline.substring(p0 + 12);
			int p1 = aline.indexOf("\"");
			
			//type
			String type = aline.substring(0,p1);
			aline = aline.substring(p1 + 12);
			int p2 = aline.indexOf("\"");
			
			//ip
			String ip = aline.substring(0,p2);
			aline = aline.substring(p2 + 24);
			int p3 = aline.indexOf(",");
			
			//starttime
			String starttime = aline.substring(0, p3);
			aline = aline.substring(p3 + 2);
			int p4 = aline.indexOf(",");
			
			//endtime
			String endtime = aline.substring(0, p4);
			aline = aline.substring(p4 + 2);
			int p5 = aline.indexOf(",");
			
			//count
			String count = aline.substring(0, p5);
			String newline = name + "," + type + "," + ip + 
 		           starttime + "," + endtime + "," + count;
            System.out.println(newline);
	        bw.append(newline);
	        bw.newLine();	
		}
		
		bw.flush();
	    in.close();
	    bw.close();
	    fr.close();
	}
	
	class SubProcesser implements Runnable
	{
		@Override
		public void run() 
		{
			long counter = 0;
			long  filecounter = 0;
			//待导入文件路径
			List<File> files = searchFiles(new File("/grid/pdns/data/"), "txt");
			//List<File> files = searchFiles(new File("E:/test/pak1.csv"), "csv");
	        System.out.println("total find:" + files.size() + " files ! ");
			try
			{
				fr = new FileWriter(f);
				bw = new BufferedWriter(fr);
				for (File file : files)
			    {
					filecounter = filecounter + 1;
		        	String filename = file.getAbsolutePath();
		        	
		        	if(filecounter % 1000 == 0)
		        	{
		            	System.out.println("File counter is :" + filecounter);
		            	stime = System.currentTimeMillis();
		        	}

					Scanner in = new Scanner(new File(filename),"UTF-8");
					
					while(in.hasNextLine())
					{  
						
						counter = counter + 1;
						String aline = in.nextLine();
						//data(ip)
						int i0 = aline.indexOf("data");
						int i1 = aline.indexOf("\"", i0+5);
						int i2 = aline.indexOf("\"", i1+1);
						String data = aline.substring(i1+1,i2);
						
						//domainname
						int i3 = aline.indexOf("name");
						int i4 = aline.indexOf("\"", i3+5);
						int i5 = aline.indexOf("\"", i4+1);
						String name = aline.substring(i4+1,i5);
						
						//type
						int i6 = aline.indexOf("type");
						int i7 = aline.indexOf("\"", i6+5);
						int i8 = aline.indexOf("\"", i7+1);
						String type = aline.substring(i7+1,i8);
						
						//meta
						int i9 = aline.indexOf("meta");
						int i10 = aline.indexOf(",", i9+5);
						String sd = aline.substring(i10 - 13, i10);
						int i11 =  aline.indexOf(",", i10 + 1);
						String ed = aline.substring(i11 - 13, i11);
						
						String newline = name + ",," + type + ",," + data + ",," +
								sd + ",," + ed ;
			          
			  	         if(counter % 8000000 == 0)
			  	         {
			  	        	 bw.append(newline);
			  		         bw.flush();
			  		         fr.close(); 
			  				 bw.close();
			  		         filenum = filenum + 1;
			  		         f = new File("/grid/pdns/newdata/pak" + filenum + ".csv");
			  		         //f = new File("E:/test/" + filenum + ".csv");
			  		         fr = new FileWriter(f);
			  		         bw = new BufferedWriter(fr);
			  		         stime = System.currentTimeMillis();
			  	         }
			  	         else
			  	         {
						    bw.append(newline);
						    bw.newLine();
			  	         }
					}
					in.close();
			    }
			}
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
