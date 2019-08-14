package ThreadPool;
//该线程池是newWorkStealingPool的底层类
//ForkJoinPool采用分制思想，适用于单个大任务。如果采用ThreadPoolExecutor有可能多核CPU只有一个CPU在跑大任务，其他在空闲
//ForkJoinPool采用有限的线程，默认线程池数和CPU数一样
//ForkJoinPool中每个线程都维护一个自己双端队列DEQUE实例,每个实例最多MAXIMUM_QUEUE_CAPACITY 64M
//ForkJoinPool中线程直接采用 “工作窃取”算法工作
//随着IDLE_TIMEOUT增加，池中的Worker会减少
//Pool中的线程上限时32767，maximum number of running threads to 32767.

//采用FORK-JOIN机制，把一个任务拆成多个小任务，在多个CPU上执行，然后再合并，由此可想任务是可拆分的大任务
//每个子任务都维护一个双端队列，其他线程在任务完成时使用工作窃取从双端队列尾部取得任务，
//RecusiveAction 没有返回值的任务
//RecusiveTask 有返回值的任务
//The @Contended annotation alerts JVMs to try to keep instances apart.

//一个ForkJoinPool中有多个WorkQueue，最大WorkQueue数组上限貌似是64，偶数WorkQueue保存的是submission，奇数submission保存的是task
//WorkQueue可以看成一个以2位幂的HASH表，Thread的数量是CPU核数（默认值），采用ThreadLocalrandom配对消费
//WorkQueue数组中的WorkQueue某些队列对象可能为空
//该线程池parallelism为JVM可用的CPU核心数
//WorkQueue中的并发操作所使用CAS，但是会有ABA的问题，因此配合版本戳使用
//线程池利用ThreadLocalrandom类把线程池的线程和WORK QUEUE HASH配对
//WorkQueue的窃取操作采用poll方法，POP、PUSH和POLL采用CAS模式对内存进行修改
//如果工作线程窃取worker窃取失败，则会停用并排队，之后随机选择一个新的WorkQueue继续
//


//虚类ForkJoinTask
//貌似是只为ForkJoinPool使用的虚类
//ForkJoinTask重量级比Thread轻，ForkJoinTask的任务分解需要基于DAG，有向无环图，不要使用异步死锁方法去fork join
//fork执行的方法，不要阻塞IO，或者修改和其他fork任务共享的变量
//通过CAS机制保证control status bits一致

//ForkJoinWorkerThread
//继承于Thread,被ForkJoinPools管理，用来执行ForkJoinTasks
//封装了一个杂七杂八的方法，包括重写方法onStart和OnTerminal，包括不会被显示调用的run方法，以及获取线程状态的方法

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolTest {

	static int INITIAL_QUEUE_CAPACITY = 1 << 13;
	
	public static void main(String[] args) {
		
		System.out.println(INITIAL_QUEUE_CAPACITY >>> 1);
		//ForkJoinWorkerThread
		ForkJoinPool fjwp;
	    RecursiveAction ra;

	}

}
