package ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//运行模式包括：1.fixedRate运行  2.fixedDelay运行  3.单次延迟固定时间运行  4.提交并马上执行  5.队列中任务全部马上执行
//任务是FIFO的
//如果任务取消，任务不会从队列中消失，只是被抑制执行，需要等待其超时。会有任务队列太长的风险
//可使用setRemoveOnCancelPolicy方法使任务cancel时立刻消失
//使用coolsize参数，没有线程worker超时一说，否则工作线程为0，任务无法执行
//ScheduledThreadPoolTest中有一个DelayedWorkQueue，DelayedWorkQueue中采用小根堆算法保证头结点最小
//维护小根堆算法在DelayedWorkQueue类中。
//通过GetDelay方法判断是否达到执行时间
//当有线程占有leader时，其他线程全部await


//fixedRate = 5000 是指，一个任务启动后，过了5S再启动另一个任务，过了5秒再启动下一个，以固定的速率启动
//fixedDelay = 1是指，一个任务执行，执行完毕后等待1S，再开始执行第二个任务。


import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

	public static void main(String[] args) throws InterruptedException
	{
		ScheduledThreadPoolTest stpt = new ScheduledThreadPoolTest();
		Subclass sc = stpt.new Subclass();
		Subclass1 s1 = stpt.new Subclass1();
		ScheduledThreadPoolExecutor ex = new ScheduledThreadPoolExecutor(4);
		//定时2S后执行
		//ex.schedule(sc1, 2l, TimeUnit.SECONDS);
		System.out.println("Main Thread time : " + System.currentTimeMillis()/1000);
		
		//按固定频率启动并执行作业
		ex.scheduleAtFixedRate(sc, 0, 2l, TimeUnit.SECONDS);
		Thread.sleep(8000);
		
		//任务执行时候可以继续提交任务
		ex.submit(s1);
		Thread.sleep(6000);
		
		//可以设置值，使任务结束后定时线程池再关闭
		ex.shutdown();
	}
	


    class Subclass implements Runnable
    {
		public void run() 
		{
			
			System.out.println("Subclass time is :" + System.currentTimeMillis()/1000);
			
		}
    	
    }
    
    class Subclass1 implements Runnable
    {
		public void run() 
		{
			
			System.out.println("1 time is :" + System.currentTimeMillis()/1000);
			
		}
    	
    }
}
