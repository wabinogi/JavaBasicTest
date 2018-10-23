
public class Wabinogi implements WabinogiIN
{

	private String brith  = "1986";
	public String money  = "1000";
	public String sex = "male";
	private  int age = 30;
    
	public void Getbrith() throws Exception
	{
		System.out.println("1986");
	}
	
	public int GetAge(String name)
	{
		if (name.equals("wabinogi")) return 30;
		else return 0;
	
	}
	
	public void GetWife()
	{
		System.out.println("Mandy");
	}
}
