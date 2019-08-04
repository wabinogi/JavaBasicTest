package ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//����ģʽ������1.fixedRate����  2.fixedDelay����  3.�����ӳٹ̶�ʱ������  4.�ύ������ִ��  5.����������ȫ������ִ��
//������FIFO��
//�������ȡ�������񲻻�Ӷ�������ʧ��ֻ�Ǳ�����ִ�У���Ҫ�ȴ��䳬ʱ�������������̫���ķ���
//��ʹ��setRemoveOnCancelPolicy����ʹ����cancelʱ������ʧ
//ʹ��coolsize������û���߳�worker��ʱһ˵���������߳�Ϊ0�������޷�ִ��
//ScheduledThreadPoolTest����һ��DelayedWorkQueue��DelayedWorkQueue�в���С�����㷨��֤ͷ�����С
//ά��С�����㷨��DelayedWorkQueue���С�
//ͨ��GetDelay�����ж��Ƿ�ﵽִ��ʱ��
//�����߳�ռ��leaderʱ�������߳�ȫ��await


//fixedRate = 5000 ��ָ��һ�����������󣬹���5S��������һ�����񣬹���5����������һ�����Թ̶�����������
//fixedDelay = 1��ָ��һ������ִ�У�ִ����Ϻ�ȴ�1S���ٿ�ʼִ�еڶ�������


import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {

	public static void main(String[] args) throws InterruptedException
	{
		ScheduledThreadPoolTest stpt = new ScheduledThreadPoolTest();
		Subclass sc = stpt.new Subclass();
		Subclass1 s1 = stpt.new Subclass1();
		ScheduledThreadPoolExecutor ex = new ScheduledThreadPoolExecutor(4);
		//��ʱ2S��ִ��
		//ex.schedule(sc1, 2l, TimeUnit.SECONDS);
		System.out.println("Main Thread time : " + System.currentTimeMillis()/1000);
		
		//���̶�Ƶ��������ִ����ҵ
		ex.scheduleAtFixedRate(sc, 0, 2l, TimeUnit.SECONDS);
		Thread.sleep(8000);
		
		//����ִ��ʱ����Լ����ύ����
		ex.submit(s1);
		Thread.sleep(6000);
		
		//��������ֵ��ʹ���������ʱ�̳߳��ٹر�
		ex.shutdown();
	}
	


    class Subclass implements Runnable
    {
		public void run() 
		{
			
			System.out.println("Subclass time is :" + System.currentTimeMillis()/1000);
			
		}
    	
    }
    
    class Subclass1 implements Runnable
    {
		public void run() 
		{
			
			System.out.println("1 time is :" + System.currentTimeMillis()/1000);
			
		}
    	
    }
}
