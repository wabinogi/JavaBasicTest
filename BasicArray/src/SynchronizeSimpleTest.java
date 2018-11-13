
public class SynchronizeSimpleTest implements Runnable {

	static String s = "wabinogi";
	
	public static void main(String[] args)
	{ 
		test();
	}
	
	
	public static void test()
	{
		SynchronizeSimpleTest sst = new SynchronizeSimpleTest();

		Thread t1 = new Thread(sst);
		Thread t2 = new Thread(sst);
	
		t2.start();
		t1.start();
	}
	
	public synchronized void Print()
	{
	
		for(int i =0; i<5; i++)
		{
		  System.out.println("Thread : " + Thread.currentThread().getName() + " " +s);
		}
	}

	@Override
	public  void run() {
		// TODO Auto-generated method stub
		
		this.Print();
	}
	
	
}
