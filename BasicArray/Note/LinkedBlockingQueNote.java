import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

//�ײ�ʵ�ֲ���������������2������һ�Ѵ棬һ��ȡ����ͬʱ��������
//�����ʼ������ʱ��ָ��������С��Ĭ�������޵Ķ��У���ˣ�ȡ���ٶ�̫�����ᵼ�¶���̫��ű��ڴ�
public class LinkedBlockingQueNote extends AbstractQueuedSynchronizer implements Runnable {

	public static void main(String[] args) throws InterruptedException {
	
		
		LinkedBlockingQueNote lbqn = new LinkedBlockingQueNote();
		LinkedBlockingQueue<Runnable> lbq = new LinkedBlockingQueue<Runnable>();
		
		lbq.offer(lbqn);
	
		lbq.offer(lbqn);
	
		//lbq.poll();
		
		
		//��������˫�˶���
		//����һ��ȫ��������ʵ�֣����е�ͷβ�������в�������ʹ����LOCK������ռ
		//�о�������ʲô���̴߳�˫��ͬʱ���ӵ��������Ϊֻ���ͷ������ܲ���
		LinkedBlockingDeque lbd;
	}

	LinkedBlockingQueNote()
	{
		setState(-1);
	}
	@Override
	public void run() {
		
		System.out.println("is run !");
	}

}
