import java.util.ArrayList;

public class CommitStrategy{

	private static volatile long starttime;
	private static volatile long endtime;
	private static ArrayList al = new ArrayList();
	
	public static void main(String[] args) throws Exception {
		
		
		initTimer();
		
		for(int i = 1; i <= 4000; i++)
		{
			addRecord("record");
			synchronized(al)
			{
				if(al.size() % 400 == 0)
				{
					doCommit("Main");
				}
			}
		}
	}
	
	public static void initTimer()
	{
		CommitStrategy cs = new CommitStrategy();
		CommitTimer ct = cs.new CommitTimer();
		Thread t = new Thread(ct);
		t.start();
		starttime = System.currentTimeMillis();
	}
	
	public static void doCommit(String thread) throws Exception
	{
		Thread.currentThread().sleep(1000);
		System.out.println(thread + " Commit ! Batch total " + al.size() );
		//设置初始状态
		synchronized(al)
		{
		   al.clear();
		}
		starttime = System.currentTimeMillis();
	}
	
	//do sth
	public static void addRecord(String rc) throws Exception
	{
		Thread.currentThread().sleep(10);
		synchronized(al)
		{
		   al.add(rc);
		}
	}

	class CommitTimer implements Runnable
	{
		@Override
		public void run() {
			
			try{
				while(true)
				{
					endtime = System.currentTimeMillis();
					synchronized(al)
					{
						if(endtime - starttime >= 4800 && al.size() != 0)
						{
							doCommit("Sub");
						}
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
