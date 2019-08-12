package ThreadPool;
//该线程池是newWorkStealingPool的底层类
//ForkJoinPool采用分制思想，适用于单个大任务。如果采用ThreadPoolExecutor有可能多核CPU只有一个CPU在跑大任务，其他在空闲
//ForkJoinPool采用有限的线程，默认线程池数和CPU数一样
//ForkJoinPool中每个线程都维护一个自己双端队列DEQUE实例,每个实例最多MAXIMUM_QUEUE_CAPACITY 64M
//ForkJoinPool中线程直接采用 “工作窃取”算法工作
//采用FORK-JOIN机制，把一个任务拆成多个小任务，在多个CPU上执行，然后再合并，由此可想任务是可拆分的大任务

//ForkJoinPool的一些参数
//SMASK       ffff
//MAX_CAP 0111|fff
//EVENMASK fff|1110
//SQMASK  00|0111|1110
//INACTIVE SHARED_QUEUE 1000|000|0000
//SS_SEQ      1|0000|0000
//MODE_MASK  ffff|0000

//虚类ForkJoinTask
//貌似是只为ForkJoinPool使用的虚类
//ForkJoinTask重量级比Thread轻，ForkJoinTask的任务分解需要基于DAG，有向无环图，不要使用异步死锁方法去fork join
//fork执行的方法，不要阻塞IO，或者修改和其他fork任务共享的变量
//通过CAS机制保证control status bits一致

//ForkJoinWorkerThread
//继承于Thread,被ForkJoinPools管理，用来执行ForkJoinTasks
//封装了一个杂七杂八的方法，包括重写方法onStart和OnTerminal，包括不会被显示调用的run方法，以及获取线程状态的方法

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {

	static int INITIAL_QUEUE_CAPACITY = 1 << 13;
	
	public static void main(String[] args) {
		
		System.out.println(INITIAL_QUEUE_CAPACITY >>> 1);
		//ForkJoinWorkerThread
		ForkJoinPool fjwp;
	

	}

}
