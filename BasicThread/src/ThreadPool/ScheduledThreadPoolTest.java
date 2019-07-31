package ThreadPool;

//周期运行、或延迟运行
//任务是FIFO的
//如果任务取消，任务不会从队列中消失，只是被抑制执行，需要等待其超时。会有任务队列太长的风险
//可使用setRemoveOnCancelPolicy方法使任务cancel时立刻消失
//使用coolsize参数，没有线程worker超时一说，否则工作线程为0，任务无法执行

public class ScheduledThreadPoolTest {

	public static void main(String[] args)
	{
	

	}

}
