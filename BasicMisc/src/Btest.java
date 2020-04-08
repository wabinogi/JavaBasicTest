
public class Btest {

	
	static abstract class abs{}
	static class test1 extends abs{}
	static class test2 extends abs{}
	
	public void hello(abs arg)
	{
		System.out.println("abs hello ");
	}
	
	public void hello(test1 arg)
	{
		System.out.println("test1 hello ");
	}
	
	public void hello(test2 arg)
	{
		System.out.println("test2 hello ");
	}
	
	public static void main(String[] args) {
		
		abs t1  = new test1();
		abs t2  = new test2();
		
		Btest bt = new Btest();
		bt.hello(t1);
		bt.hello(t2);
	}

}
