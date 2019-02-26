
public class StaticShare {

	static Integer i = new Integer(1);
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		StaticShare ss = new StaticShare();
		//System.out.println("Main before:" + i);
		ss.begin();
		//Thread.sleep(10);
		//System.out.println("Main after:" + i);
		
	}
	
	public void begin()
	{
		for(int j = 0; j <3; j ++)
		{
			try {
				Thread.currentThread().sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      new Thread(new Runnable(){

			@Override
			public void run() {
				
			
				new subA().add();
			} 
	      }).start();

		}
	}

	public class subA
	{
		public void add()
		{
			//System.out.println(Thread.currentThread().getName());
			i = i + 1;
			System.out.println(Thread.currentThread().getName() + " after : " + i);
		}
	}
	

}
