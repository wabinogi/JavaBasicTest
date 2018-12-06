
public class ThreadLocalTest implements Runnable {

	//为每个线程创造一个自己的Object1对象
	//通过oo.get()对向前线程的对象进行访问。
	public static final ThreadLocal<Object1> oo = ThreadLocal.withInitial(()->new Object1());
	//Object1 ob1 = new Object1();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadLocalTest tlt = new ThreadLocalTest();
		Thread t = new Thread(tlt);
		t.start();
		tlt.method1();
		
	}
	
	public void method1()
	{
		for(int i = 0 ; i <= 9; i++)
		{
			
			oo.get().ii = oo.get().ii + 1;
			System.out.println("MAIN : " + oo.get().ii);
		}
	}
	
	public void method2()
	{
		for(int i = 0 ; i <= 9; i++)
		{
			oo.get().ii = oo.get().ii + 1;
			System.out.println("SECOND : " + oo.get().ii);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		method2();
	}

	
}
