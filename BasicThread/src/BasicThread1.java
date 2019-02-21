
//一个类只能继承一个父类，这种方式有局限性
public class BasicThread1 extends Thread{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		BasicThread1 eThread = new BasicThread1();
		eThread.start();
		System.out.println("Thread Main");
	}
	
	@Override
	public void run()
	{
		super.run();
		System.out.println("Thread A");
	}

}
