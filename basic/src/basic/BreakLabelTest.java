package basic;


  
public class BreakLabelTest {
   
	static void BasicTest()
	{
		System.out.println("OK");
	}

	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		//1
		WabinogiLable1:
		{
			System.out.println("Start");
			if( 0==1) 
			{
			    break WabinogiLable1;	
			}
			else
			{
				System.out.println("End");
			}
		}
		System.out.println("End");
		
	}
}
