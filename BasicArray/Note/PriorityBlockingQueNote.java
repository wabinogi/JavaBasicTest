import java.util.concurrent.PriorityBlockingQueue;

//该队列不会阻塞生产者，只会在消费者没得消费时阻塞消费者
//优先级通过构造函数的Comparable接口确定
//注意生产者不能快于消费者，否则缓存撑爆
//单锁结构
public class PriorityBlockingQueNote {
	
	public void PriorityBlockingQueNote()
	{
		PriorityBlockingQueue pbq;
	}

}
