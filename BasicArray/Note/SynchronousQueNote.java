import java.util.concurrent.SynchronousQueue;
//该队列不存储任务元素，每一个PUT必须等待一个TAKE操作
//适合一个线程传递信息给另一个线程
//线程池底层使用该结构
//公平模式采用QUEUE，FIFO
//非公平模式采用STACK，LIFO
//当有线程将对象E放入队列里时，再有新的线程入队时，会先自旋一小段时间，然后UNPARK挂起(阻塞)
//当有线程TAKE队列里的E时，取出E后，会唤醒后续等待的线程进队
public class SynchronousQueNote {

	public static void main(String[] args) {
		SynchronousQueue sq;

		//1.空队列，PUT，等待TAKE (e, false, 0)
        //空队列，TAKE，等待PUT
		//2.非空队列，PUT。PUT被阻塞等待
		//3.非空队列,TAKE。TAKE成功r(null, false, 0);

	}

}
