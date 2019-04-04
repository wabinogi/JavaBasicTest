//StringBuffer和StringBuilder几乎一样
//StringBuffer是线程安全的，采用Synchronised关键字上锁
//synchronized关键字的使用注意
//对于同一个实例，如果synchronized对方法进行修饰，则只有synchronized方法是同步的，非synchronized修饰的依然可以并发
public class StringBufferNote extends Thread{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		StringBufferNote sbn = new StringBufferNote();
		sbn.start();
		
		
		sbn.readSth();
		
	}
	
	public synchronized void readSth() throws InterruptedException
	{
		if((Thread.currentThread().getName().equals("main")))
		{
			Thread.currentThread().sleep(1000);
		}
		
		System.out.println(Thread.currentThread().getName() + " : Read");
	}

	public void writeSth()
	{
		System.out.println(Thread.currentThread().getName() + " : Write");
	}

	@Override
	public void run() {
		
		writeSth();
			
	
	}
}
