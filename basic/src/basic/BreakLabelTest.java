package basic;
import java.io.*;

  
public class BreakLabelTest {
   
	public static void main(String[] args)
	{
		//1
		WabinogiLable1:
		{
			System.out.println("Start");
			break WabinogiLable1;	
			
		}
		System.out.println("End");
		
	}
}
