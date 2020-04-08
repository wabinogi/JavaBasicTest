
public class Atest {

	static class _A{}
	static class _B{}
	
	static class father
	{
		public void printA(_A arg)
		{
			System.out.println("father print A ");
		}
		
		public void printB(_B arg)
		{
			System.out.println("father print B ");
		}
	}
	
	static class son extends father
	{
		public void printA(_A arg)
		{
			System.out.println("son print A ");
		}
		
		public void printB(_B arg)
		{
			System.out.println("son print B ");
		}
	}
	
	public void hello(father fa)
	{
		System.out.println("father ");
	}
	
	public void hello(son sn)
	{
		System.out.println("son ");
	}
	
	public static void main(String[] args) {
		
		father fa = new father();
		fa.printA(new _A());
		fa.printB(new _B());
		
		father son = new son();
		son.printA(new _A());
		son.printB(new _B());
		
		Atest at = new Atest();
		 at.hello(fa);
		 at.hello(son);
	}

}
