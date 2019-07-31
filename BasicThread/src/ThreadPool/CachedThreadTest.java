package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//�̳߳ش�С������
//�̳߳��е��̳߳���60��δʹ�ã� ��ᱻ�Ƴ�
//ʹ�ù����̻߳ᱻ��������
//����Ϊʲô��SynchronousQueue��ʵ��newCachedThreadPool��
//һ��newCachedThreadPool�����е������߳̾�ʹ��һ��SynchronousQueue����
//ÿ���������̣߳�execute��ִ�е�������󣬾�����SQ�е�Transfer�����У����ȴ�������������
//Transfer��������CPU���ã���̬��������ʱ�䣬������һ��ʱ�䣬����PARK
//�����������߳�ֱ�ӵ���Addworker���������߳̽������ѣ�������������ѵĵȴ�ʱ�伸��û�У����Բ���Ҫ���⿪��ά���͵��ȶ��У���˲����޶��нṹ��SQ
public class CachedThreadTest implements Runnable{

	public static void main(String[] args) {
		
		CachedThreadTest stt  = new CachedThreadTest();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		//ѭ��21��
		//�̳߳ؿ�ʼ��������̣߳�ͬʱ��ռCPU
		//�̴߳�����������ﵽһ����ֵ����Ϊ��½���оɵ��߳�ִ����Ϻ��ٴα�����
		for(int i= 0;i<=10; i++)
		{
			executor.execute(stt);
		}
	executor.shutdown();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
        try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OK");
	}

}
