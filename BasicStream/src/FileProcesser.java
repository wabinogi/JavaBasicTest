import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileProcesser {

	static long endtime;
	static long starttime;
	static int filenum = 1; 
	static File f = new File("/home/whois/newdata/pak" + filenum + ".csv");
	static FileWriter fr;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		//另起线程写文件
		FileProcesser fp = new FileProcesser();
		SubFileProcesser sfp = fp.new SubFileProcesser();
		ExecutorService es = Executors.newFixedThreadPool(1);
		es.submit(sfp);
		
		starttime = endtime = System.currentTimeMillis();
		while(true)
		{
		   long range = (endtime - starttime)/1000;
		   System.out.println(range);
		   if(range > 180)
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
		  
    		Scanner in = new Scanner(new File("D:/whois_demo.csv"),"UTF-8");
    	    String aline;
    	  
    	    //writer
    	     //该文件
    	    File f = new File("D:/newwhois_demo.csv");
    	    FileWriter fr = new FileWriter(f);
    	    BufferedWriter bw = new BufferedWriter(fr);
    	    String splitor = "\",\"";
    	
    		while(in.hasNextLine())
    		{  
    			aline = in.nextLine();
    			aline = "\"" + "," + aline + "," + "\"";
    			String[] strArray = aline.split(splitor);
    			String newline = Arrays.toString(strArray);
    			newline = newline.substring(3,newline.length() - 1);
                System.out.println(newline);
    	        bw.append(newline);
    	        bw.newLine();	
    		}
    		
    		bw.flush();
    	    in.close();
    	    bw.close();
    	    fr.close();
		}
		
		class SubFileProcesser implements Runnable
		{
			@Override
			public void run()
			{
				long counter = 0;
				int  filecounter = 0;
				List<File> files = searchFiles(new File("/home/whois/cctlds_regular/whoisdata"), "csv");
		        System.out.println("total find:" + files.size() + " files ! ");
		        
		        try {
		        fr = new FileWriter(f);
			    bw = new BufferedWriter(fr);
			    
		        for (File file : files)
		        {
		        	filecounter = filecounter + 1;
		        	System.out.println("File counter is :" + filecounter);
		        	String filename = file.getAbsolutePath();
					Scanner in = new Scanner(new File(filename),"UTF-8");

				    //String splitor = "\",\"";
				    //String newline = "";
			    
					while(in.hasNextLine())
					{  		  	
						 String aline = in.nextLine();						
						 aline = "\"" + "," + aline + "," + "\"";

						 counter = counter + 1;						 
			  	         if(counter % 1000000 == 0)
			  	         {
			  	        	 bw.append(aline); 
			  	        	 bw.flush();
			  		         fr.close(); 
			  				 bw.close();
			  		         filenum = filenum + 1;
			  		         f = new File("/home/whois/newdata/pak" + filenum + ".csv");
			  		         fr = new FileWriter(f);
			  		         bw = new BufferedWriter(fr);
			  		         starttime = System.currentTimeMillis();
			  	        }
					    else
					    {
						    bw.append(aline); 
					    }
						//System.out.println(strArray.length);
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
