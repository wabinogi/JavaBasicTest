import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueTest implements Runnable {

	Object1 ob1 = new Object1();
	static ArrayBlockingQueue<Object1> abq = new ArrayBlockingQueue<Object1>(5);
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ArrayBlockingQueTest ot = new ArrayBlockingQueTest();
		InputObject io = ot.new InputObject();

        //Thread 
		 Thread t = new Thread(ot);
		 Thread t2 = new Thread(io);
		 t2.start();
		 t.start();
		
	
		 //
		 ot.ob1.ii = 1;
		 System.out.println("Que in: " + ot.ob1.ii);
		 abq.offer(ot.ob1);
		
	}
    
	public void consumer() throws InterruptedException
	{
		System.out.println("Que out: ");
		Object1 oo = abq.poll();
		while(oo == null) 
	    {
			Thread.sleep(500);
			 oo = abq.poll();
	    }
	    
		while(oo != null)
		{
		  oo.printNo();
		  oo = abq.poll();
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			consumer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	public class InputObject implements Runnable
	{
		Object1 ob2 = new Object1();
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 ob2.ii = 2;
			 System.out.println("Que in: " + ob2.ii);
			 abq.offer(ob2);
		}
		
	}
	
}
