package ThreadPool;
//���̳߳���newWorkStealingPool�ĵײ���
//ForkJoinPool���÷���˼�룬�����ڵ����������������ThreadPoolExecutor�п��ܶ��CPUֻ��һ��CPU���ܴ����������ڿ���
//ForkJoinPool�������޵��̣߳�Ĭ���̳߳�����CPU��һ��
//ForkJoinPool��ÿ���̶߳�ά��һ���Լ�˫�˶���DEQUEʵ��,ÿ��ʵ�����MAXIMUM_QUEUE_CAPACITY 64M
//ForkJoinPool���߳�ֱ�Ӳ��� ��������ȡ���㷨����
//����FORK-JOIN���ƣ���һ�������ɶ��С�����ڶ��CPU��ִ�У�Ȼ���ٺϲ����ɴ˿��������ǿɲ�ֵĴ�����

//ForkJoinPool��һЩ����
//SMASK       ffff
//MAX_CAP 0111|fff
//EVENMASK fff|1110
//SQMASK  00|0111|1110
//INACTIVE SHARED_QUEUE 1000|000|0000
//SS_SEQ      1|0000|0000
//MODE_MASK  ffff|0000

//����ForkJoinTask
//ò����ֻΪForkJoinPoolʹ�õ�����
//ForkJoinTask��������Thread�ᣬForkJoinTask������ֽ���Ҫ����DAG�������޻�ͼ����Ҫʹ���첽��������ȥfork join
//forkִ�еķ�������Ҫ����IO�������޸ĺ�����fork������ı���
//ͨ��CAS���Ʊ�֤control status bitsһ��

//ForkJoinWorkerThread
//�̳���Thread,��ForkJoinPools��������ִ��ForkJoinTasks
//��װ��һ�������Ӱ˵ķ�����������д����onStart��OnTerminal���������ᱻ��ʾ���õ�run�������Լ���ȡ�߳�״̬�ķ���

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {

	static int INITIAL_QUEUE_CAPACITY = 1 << 13;
	
	public static void main(String[] args) {
		
		System.out.println(INITIAL_QUEUE_CAPACITY >>> 1);
		//ForkJoinWorkerThread
		ForkJoinPool fjwp;
	

	}

}
