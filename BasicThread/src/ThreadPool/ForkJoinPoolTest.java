package ThreadPool;
//���̳߳���newWorkStealingPool�ĵײ���
//ForkJoinPool���÷���˼�룬�����ڵ����������������ThreadPoolExecutor�п��ܶ��CPUֻ��һ��CPU���ܴ����������ڿ���
//ForkJoinPool�������޵��̣߳�Ĭ���̳߳�����CPU��һ��
//ForkJoinPool��ÿ���̶߳�ά��һ���Լ�˫�˶���DEQUEʵ��,ÿ��ʵ�����MAXIMUM_QUEUE_CAPACITY 64M
//ForkJoinPool���߳�ֱ�Ӳ��� ��������ȡ���㷨����
//����FORK-JOIN���ƣ���һ�������ɶ��С�����ڶ��CPU��ִ�У�Ȼ���ٺϲ����ɴ˿��������ǿɲ�ֵĴ�����
//maximum number of running threads to 32767.
//ÿ��������ά��һ��˫�˶��У������߳����������ʱʹ�ù�����ȡ��˫�˶���β��ȡ������
//RecusiveAction û�з���ֵ������
//RecusiveTask �з���ֵ������
//The @Contended annotation alerts JVMs to try to keep instances apart.

//һ��ForkJoinPool���ж��WorkQueue��ż��WorkQueue�������submission������submission�������task
//ÿ��WorkQueue��һ�������̣߳�Ҳ����û�У�
//���̳߳�parallelismΪJVM���õ�CPU������
//WorkQueue�еĲ���������ʹ��CAS�����ǻ���ABA�����⣬�����ϰ汾��ʹ��


//����ForkJoinTask
//ò����ֻΪForkJoinPoolʹ�õ�����
//ForkJoinTask��������Thread�ᣬForkJoinTask������ֽ���Ҫ����DAG�������޻�ͼ����Ҫʹ���첽��������ȥfork join
//forkִ�еķ�������Ҫ����IO�������޸ĺ�����fork������ı���
//ͨ��CAS���Ʊ�֤control status bitsһ��

//ForkJoinWorkerThread
//�̳���Thread,��ForkJoinPools��������ִ��ForkJoinTasks
//��װ��һ�������Ӱ˵ķ�����������д����onStart��OnTerminal���������ᱻ��ʾ���õ�run�������Լ���ȡ�߳�״̬�ķ���

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolTest {

	static int INITIAL_QUEUE_CAPACITY = 1 << 13;
	
	public static void main(String[] args) {
		
		System.out.println(INITIAL_QUEUE_CAPACITY >>> 1);
		//ForkJoinWorkerThread
		ForkJoinPool fjwp;
	    RecursiveAction ra;

	}

}
