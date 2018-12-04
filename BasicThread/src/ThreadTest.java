
public class ThreadTest implements Runnable {

	static ThreadTest threadObj;
	static Thread t1;
	
	public static void main(String[] args) throws InterruptedException {
	
		threadObj = new ThreadTest();
		threadObj.ThreadStart();
		System.out.println("Thread Name : " + t1.getName());
	
		threadObj.ThreadStatus();
		Thread.currentThread().sleep(1000);
		threadObj.ThreadInterupt();
		threadObj.ThreadStatus();
		//System.out.println("Static Interrupted : " + t1.isInterrupted());
		//threadObj.ThreadStatus();
		
	}

	public void ThreadInterupt() {
		
		//While thread in sleeping and waiting,invoke interrupt will causing InterruptedException
		//Set isInterrupted to true
		//Stop current thread
		t1.interrupt();
	}
	
	public  void ThreadStatus() {
		
		// status isInterrupted?
		System.out.println("Thread status : "  + t1.isInterrupted());
	}
	
	
	public void ThreadStart() throws InterruptedException {
		
		//Add class ob to Thread
	    t1 = new Thread(threadObj);
		t1.setName("Thread t1");
		//Maybe running or not !
		t1.start();
		
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread wabinogi Start!");
		
		
		  try {
		for(int i = 0; i <= 3; i++)
		{
			Thread.currentThread().sleep(1000);
			System.out.println("1");
			//throw new InterruptedException();
		}
		
			
		} catch (InterruptedException e) {
			
			System.out.println("Interrupted!");
		}
	    return;
	
	}

}
