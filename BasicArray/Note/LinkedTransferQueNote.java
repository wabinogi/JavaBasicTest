import java.util.concurrent.LinkedTransferQueue;
//�޽����
//�������޽���У���˲������������ޣ���������Զ��������
//FIFO
//tryTransfer,���û�������ߣ����̷��أ���������еȴ�
//�����߳̽���TAKE����ʱ���������Ϊ�գ�������һ��EΪNULL�Ľڵ㣬����Ԥռ�ã�ͬʱ����һ��ʱ�䣬���Բ���ȡ����������н���PARK����������
//���̶߳��TAKE�����γ�Ԥռ�ö��У����̰߳�����˳�����PARK����
//�������̶߳�ν���PUT����������ν��������

//���ǵ�ά��ͷβָ��Ŀ������Լ�����ṹά���Ŀ����������˻���SLACKֵ��ͷβָ��ά���㷨������ÿ��PUT�������ͷβָ��
//ͷβ֮���2~3��NODEԪ���൱�ڻ�����
//����M$S�����㷨����
//�о���SynchronousQueueҪ��Ч
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
