import java.util.concurrent.SynchronousQueue;
//�ö��в��洢����Ԫ�أ�ÿһ��PUT����ȴ�һ��TAKE����
//�ʺ�һ���̴߳�����Ϣ����һ���߳�
//�̳߳صײ�ʹ�øýṹ
//��ƽģʽ����QUEUE��FIFO
//�ǹ�ƽģʽ����STACK��LIFO
//�����߳̽�����E���������ʱ�������µ��߳����ʱ����������һС��ʱ�䣬Ȼ��UNPARK����(����)
//�����߳�TAKE�������Eʱ��ȡ��E�󣬻ỽ�Ѻ����ȴ����߳̽���
public class SynchronousQueNote {

	public static void main(String[] args) {
		SynchronousQueue sq;

		//1.�ն��У�PUT���ȴ�TAKE (e, false, 0)
        //�ն��У�TAKE���ȴ�PUT
		//2.�ǿն��У�PUT��PUT�������ȴ�
		//3.�ǿն���,TAKE��TAKE�ɹ�r(null, false, 0);

	}

}
