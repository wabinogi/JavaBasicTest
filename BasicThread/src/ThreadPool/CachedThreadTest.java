package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//�̳߳ش�С������
//�̳߳��е��̳߳���60��δʹ�ã� ��ᱻ�Ƴ�
//ʹ�ù����̻߳ᱻ��������
//ÿ���������̶߳�����һ��SynchronousQueue����
public class CachedThreadTest {

	public static void main(String[] args) {
		
		SingleThreadTest stt  = new SingleThreadTest();
		ExecutorService executor = Executors.newCachedThreadPool();
		
		//ѭ��21��
		//�̳߳ؿ�ʼ��������̣߳�ͬʱ��ռCPU
		//�̴߳�����������ﵽһ����ֵ����Ϊ��½���оɵ��߳�ִ����Ϻ��ٴα�����
		for(int i= 0;i<=10; i++)
		{
			executor.execute(stt);
		}
//	executor.shutdown();
	}

}
