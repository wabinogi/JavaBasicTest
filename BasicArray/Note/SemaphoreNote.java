import java.util.concurrent.Semaphore;

public class SemaphoreNote implements Runnable{

	//һ��ֻ������2���߳̽���ִ��
	static Semaphore sp = new Semaphore(2);
	public static void main(String[] args) {
		SemaphoreNote sn = new SemaphoreNote();
		
		for(int i = 0;i<=4;i++)
		{
			Thread t = new Thread(sn);
			t.start();
		}
	}

	@Override
	public void run() {
		//��ΪSemaphore(2)��Ե�ʣ�������ֻ��2����־
		try {
			//��ȡ�����־
			//�ײ���չ��AQS��
			//����ʾλ��ԣ��ʱ��acquireֻ���¼�����״̬��ʲô������
			//����ʾλ����ʱ����ͨ��AQS�ķ�����������߳�
			sp.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName());	
		//�ͷŸñ�־
		//release�������¼���������������������̣߳�����
		sp.release();
		
	}

}
