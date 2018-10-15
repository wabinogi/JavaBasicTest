package basic;
import java.io.*;


public class BreakLabelTest {

	public static void main(String[] args)
	{
		
		WabinogiLable1:
		{
			System.out.println("Start");
			break WabinogiLable1;	
			//后面的语句无法到达！
		}
		System.out.println("End");
		
	}
}
