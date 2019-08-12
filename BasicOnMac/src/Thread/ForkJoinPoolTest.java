package Thread;
//一个任务拆成多个小任务在多个CPU上跑
//maximum number of running threads to 32767.
//每个子任务都维护一个双端队列，其他线程在任务完成时使用工作窃取从双端队列尾部取得任务，
//RecusiveAction 没有返回值的任务
//RecusiveTask 有返回值的任务
//The @Contended annotation alerts JVMs to try to keep instances apart.
public class ForkJoinPoolTest {

	public static void main(String[] args) 
	{
		
	}

}
