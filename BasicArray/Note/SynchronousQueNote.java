import java.util.concurrent.SynchronousQueue;
//该队列不存储任何元素，每一个PUT必须等待一个TAKE操作
//说SQ没有存储空间，实际上可以理解为空间为1的FIFO或者FILO结构
//适合一个线程传递信息给另一个线程
//线程池底层使用该结构
//公平模式采用QUEUE，FIFO
//非公平模式采用STACK，LIFO
//当有线程将对象E放入队列里时，再有新的线程PUT时，会先自旋一小段时间，然后PARK挂起(阻塞)
//也就是说，不存在队列结构，前面的E不被消费，后续生产者只会被阻塞PARK
//当有线程TAKE队列里的E时，取出E后，会唤醒后续等待的线程进队
//当队列为空时，消费者线程TAKE时，会生产E对空的NODE节点，自旋一小段时间，如果没有匹配则挂起（阻塞）

//由于无队列结构，没有“缓冲”，感觉会频繁的发生PARK，UNPARK，效率不高
public class SynchronousQueNote {

	public static void main(String[] args) throws InterruptedException {
		SynchronousQueue<Integer> sq = new SynchronousQueue();
		sq.put(1);
		sq.put(1);
		
		//1.空队列，PUT，等待TAKE (e, false, 0)
        //空队列，TAKE，等待PUT
		//2.非空队列，PUT。PUT被阻塞等待
		//3.非空队列,TAKE。TAKE成功r(null, false, 0);

	}

}
