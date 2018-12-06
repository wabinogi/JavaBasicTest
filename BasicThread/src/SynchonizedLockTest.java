
//使用锁的经验，不用锁>使用阻塞队列（各种BlockingQue）或者Concurrent机制（JAVA.UTIL.CONCURRENT中定义的集合）>内部锁>重入锁
//每个对象都有一个内部锁，使用synchronized指定获取锁
//可以使用wait和notifyAll、notify方法释放阻塞，使其重新竞争
//synchronized基于JVM机制
//不能中断一个视图获得内部锁的线程。
//获取内部锁不能设定超时
public class SynchonizedLockTest implements Runnable {

	int i = 0;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		SynchonizedLockTest slt = new SynchonizedLockTest();
		Thread t1 = new Thread(slt);
		t1.start();
		slt.Method1();
	}
	
	public synchronized void Method1() throws InterruptedException
	{
		Thread.sleep(500);
		for( i = 0; i<= 9 ; i++)
		{
			while(i == 3) wait();
			System.out.println("Main: " + i);
		}
	}

	public synchronized void Method2()
	{
		for(; i<= 9 ; i++)
		{
			System.out.println("Second: " + i);
		}
		notifyAll();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		this.Method2();
		
	}
}
