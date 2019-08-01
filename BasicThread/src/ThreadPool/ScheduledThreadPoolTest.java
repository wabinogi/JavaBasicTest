package ThreadPool;

//周期运行、或延迟运行
//任务是FIFO的
//如果任务取消，任务不会从队列中消失，只是被抑制执行，需要等待其超时。会有任务队列太长的风险
//可使用setRemoveOnCancelPolicy方法使任务cancel时立刻消失
//使用coolsize参数，没有线程worker超时一说，否则工作线程为0，任务无法执行

//fixedRate = 5000 是指，一个任务启动后，过了5S再启动另一个任务，过了5秒再启动下一个，以固定的速率启动
//fixedDelay = 1是指，一个任务执行，执行完毕后等待1S，再开始执行第二个任务。

public class ScheduledThreadPoolTest {

	public static void main(String[] args)
	{
	

	}

}
