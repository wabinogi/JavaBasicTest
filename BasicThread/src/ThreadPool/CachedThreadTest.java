package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程池大小是伸缩
//线程池中的线程超过60秒未使用， 则会被移除
//使用过的线程会被重新利用
//每个创建的线程对象是一个SynchronousQueue对象
public class CachedThreadTest {

	public static void main(String[] args) {
		
		SingleThreadTest stt  = new SingleThreadTest();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		//循环21次
		//线程池开始创建多个线程，同时抢占CPU
		//线程创建的数量会达到一个峰值，因为会陆续有旧的线程执行完毕后再次被利用
		for(int i= 0;i<=10; i++)
		{
			executor.execute(stt);
		}
//	executor.shutdown();
	}

}
