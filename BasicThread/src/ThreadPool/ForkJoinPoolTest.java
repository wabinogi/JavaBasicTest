package ThreadPool;
//该线程池是newWorkStealingPool的底层类
//ForkJoinPool采用分制思想，适用于单个大任务。如果采用ThreadPoolExecutor有可能多核CPU只有一个CPU在跑大任务，其他在空闲
//ForkJoinPool采用有限的线程，默认线程池数和CPU数一样
//ForkJoinPool中每个线程都维护一个自己双端队列DEQUE实例
//ForkJoinPool中线程直接采用 “工作窃取”算法工作
//采用FORK-JOIN机制，把一个任务拆成多个小任务，在多个CPU上执行，然后再合并，由此可想任务是可拆分的大任务

public class ForkJoinPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
