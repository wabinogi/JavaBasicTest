import java.util.concurrent.SynchronousQueue;
//�ö��в��洢�κ�Ԫ�أ�ÿһ��PUT����ȴ�һ��TAKE����
//˵SQû�д洢�ռ䣬ʵ���Ͽ������Ϊ�ռ�Ϊ1��FIFO����FILO�ṹ
//�ʺ�һ���̴߳�����Ϣ����һ���߳�
//�̳߳صײ�ʹ�øýṹ
//��ƽģʽ����QUEUE��FIFO
//�ǹ�ƽģʽ����STACK��LIFO
//�����߳̽�����E���������ʱ�������µ��߳�PUTʱ����������һС��ʱ�䣬Ȼ��PARK����(����)
//Ҳ����˵�������ڶ��нṹ��ǰ���E�������ѣ�����������ֻ�ᱻ����PARK
//�����߳�TAKE�������Eʱ��ȡ��E�󣬻ỽ�Ѻ����ȴ����߳̽���
//������Ϊ��ʱ���������߳�TAKEʱ��������E�Կյ�NODE�ڵ㣬����һС��ʱ�䣬���û��ƥ�������������

//�����޶��нṹ��û�С����塱���о���Ƶ���ķ���PARK��UNPARK��Ч�ʲ���
public class SynchronousQueNote {

	public static void main(String[] args) throws InterruptedException {
		SynchronousQueue<Integer> sq = new SynchronousQueue();
		sq.put(1);
		sq.put(1);
		
		//1.�ն��У�PUT���ȴ�TAKE (e, false, 0)
        //�ն��У�TAKE���ȴ�PUT
		//2.�ǿն��У�PUT��PUT�������ȴ�
		//3.�ǿն���,TAKE��TAKE�ɹ�r(null, false, 0);

	}

}
