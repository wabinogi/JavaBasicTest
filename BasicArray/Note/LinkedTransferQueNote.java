import java.util.concurrent.LinkedTransferQueue;
//无界队列
//由于是无界队列，因此不存在容量上限，生产者永远不会阻塞
//FIFO
//tryTransfer,如果没有消费者，立刻返回，不进入队列等待
//消费线程进行TAKE操作时，如果队列为空，会生成一个E为NULL的节点，进行预占用，同时自旋一定时间，若仍不能取到，则如队列进行PARK挂起（阻塞）
//多线程多次TAKE，会形成预占用队列，且线程按队列顺序进行PARK挂起
//生产单线程多次进行PUT操作，按多次进入队列算

//考虑到维护头尾指针的开销，以及链表结构维护的开销，采用了基于SLACK值的头尾指针维护算法。不是每次PUT都会更新头尾指针
//头尾之间的2~3个NODE元素相当于缓冲区
//基于M$S队列算法变种
//感觉比SynchronousQueue要高效
public class LinkedTransferQueNote implements Runnable{

	static Integer signal = 0;
	static Integer signal1 = 1;
	static Integer signal2 = 2;
	static Integer signal3 = 3;
	static Integer signal4 = 4;
	static LinkedTransferQueue<Integer> ltq = new LinkedTransferQueue<Integer>();
	
	public static void main(String[] args) throws InterruptedException {


		LinkedTransferQueNote ltqn  = new LinkedTransferQueNote();
        Thread t = new Thread(ltqn);
        t.start();
        
        Thread.currentThread().sleep(200);
        ltq.put(signal);
        ltq.put(signal1);
        ltq.put(signal2);
        ltq.put(signal3);
        ltq.put(signal4);
	
		
	}

	@Override
	public void run() {
	
		 
	}

}
