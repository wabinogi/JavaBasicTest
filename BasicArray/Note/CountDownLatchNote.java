import java.util.concurrent.CountDownLatch;

//����һ�������߳�һ�µȴ���ֱ�������̲߳���ִ�������ִ��
public class CountDownLatchNote implements Runnable{

	//������Ҫ��ʵ���߳���ƥ�䣬���ֹ������������߳���Զ�ڵȴ�
	static CountDownLatch cdl = new CountDownLatch(4);
	public static void main(String[] args) throws InterruptedException 
	{
		CountDownLatchNote cdln = new CountDownLatchNote();
		for(int i = 0; i <= 3; i++)
		{
			Thread t = new Thread(cdln);
			t.start();
			
		}
		//�����߳���ɺ�ִ�еȴ�����
		cdl.await();
		System.out.println("Main");
	}

	@Override
	public void run() {
		
		System.out.println(Thread.currentThread().getName());		
		//���߳�ִ����ɺ󣬼�������1
		cdl.countDown();

	}

}
