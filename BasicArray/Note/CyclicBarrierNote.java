import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

//���ڶ��̷߳���
//ÿ���̶߳�����ȴ������̣߳��ﵽ"�ϳ�"��׼������
//�������Ϊ������������
//����������ʵ��
public class CyclicBarrierNote implements Runnable {

	static DelayQueNote sn = new DelayQueNote();
	//����2����λ��ÿ��2����λ��2���߳�ռ�ݺ󣬽�������ִ�У�����sn��Runnable�ӿ��ж���ķ���
	//���2����λû�б�ռ���������������̣߳��ȴ����������߳��ϳ�
	static CyclicBarrier cb = new CyclicBarrier(2,sn);
	public static void main(String[] args) {
		
		CyclicBarrierNote sbn = new CyclicBarrierNote();
		for(int i = 1 ; i <=2; i ++)
		{
			
			Thread t = new Thread(sbn);
			t.start();
		}
	}

	@Override
	public void run() {
	
		System.out.println(Thread.currentThread().getName());
		
		try {
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
