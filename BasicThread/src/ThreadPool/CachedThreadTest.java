package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程池大小是伸缩
//线程池中的线程超过60秒未使用， 则会被移除
//使用过的线程会被重新利用
//关于为什么用SynchronousQueue来实现newCachedThreadPool？
//一个newCachedThreadPool中所有的消费线程均使用一个SynchronousQueue对象
//每个生成者线程（execute）执行的任务对象，均传入SQ中的Transfer方法中，“等待”消费者消费
//Transfer方法根据CPU配置，动态计算自旋时间，先自旋一段时间，最终PARK
//由于消费者线程直接调用Addworker方法创建线程进行消费，因此理论上消费的等待时间几乎没有，所以不需要额外开销维护和调度队列，因此采用无队列结构的SQ
public class CachedThreadTest implements Runnable{

	public static void main(String[] args) {
		
		CachedThreadTest stt  = new CachedThreadTest();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		//循环21次
		//线程池开始创建多个线程，同时抢占CPU
		//线程创建的数量会达到一个峰值，因为会陆续有旧的线程执行完毕后再次被利用
		for(int i= 0;i<=10; i++)
		{
			executor.execute(stt);
		}
	executor.shutdown();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
        try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OK");
	}

}
