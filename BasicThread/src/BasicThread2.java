//Runnable接口实现方式
public class BasicThread2 implements Runnable{

	public static void main(String[] args) throws InterruptedException {

		//初始化
		BasicThread2 eThread = new BasicThread2();
		Thread tr = new Thread(eThread);
		tr.start();
		

	
		
		//设置优先级，10位最高，默认为5
		//如果一开始就设置成10，则创建的tr线程和主线程有同样优先级
		Thread.currentThread().setPriority(10);
		
		

		//执行操作
		Thread mT = Thread.currentThread();
		
		System.out.println("Thread Main Pro is : " + mT.getPriority());
		System.out.println("Thread Main group is : " + mT.getThreadGroup().toString());
		System.out.println("Thread Main Daemon : " + mT.isDaemon());
		mT.sleep(500);
	}
	
	@Override
	public void run()
	{
		Thread ta = Thread.currentThread();
		//设置线程名
		ta.setName("Wabinogi");
		
		//获取线程名
		String tName = Thread.currentThread().getName();
		System.out.println("Thread A name is : " + tName );
		//所在线程组信息
		System.out.println("Thread A group is : " + ta.getThreadGroup().toString());
		//所在线程组当前活着的线程数
		System.out.println("Thread A active count is : " + ta.activeCount());
		//优先级，10位最高
		System.out.println("Thread A Pro is : " + ta.getPriority());
		//Id
		System.out.println("Thread A id : " + ta.getId());
		//State
		System.out.println("Thread A State : " + ta.getState());
		//alive
		System.out.println("Thread A alive : " + ta.isAlive());
		//Daemon
		System.out.println("Thread A Daemon : " + ta.isDaemon());
		

	}

}
