import java.util.concurrent.ArrayBlockingQueue;
//实现BlockingQueue接口
//BlockingQueue接口，如果队列满，则生产者线程 入队 时 阻塞等待，如果队列空，则消费者 出队 时 阻塞等待
//ArrayBlockingQueNote采用Array，因此是有界的
//ArrayBlockingQueNote 的阻塞底层采用AQS实现，调用的是 UNSAFE.park
//进出队列采用ReentrantLock lock上锁，因此效率相当于AQS底层的机制
//所谓的公平和非公平模式，底层是采用公平非公平的ReentrantLock示例
public class ArrayBlockingQueNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBlockingQueue abq;
	}

}
