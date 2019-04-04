//StringBuffer��StringBuilder����һ��
//StringBuffer���̰߳�ȫ�ģ�����Synchronised�ؼ�������
//synchronized�ؼ��ֵ�ʹ��ע��
//����ͬһ��ʵ�������synchronized�Է����������Σ���ֻ��synchronized������ͬ���ģ���synchronized���ε���Ȼ���Բ���
public class StringBufferNote extends Thread{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		StringBufferNote sbn = new StringBufferNote();
		sbn.start();
		
		
		sbn.readSth();
		
	}
	
	public synchronized void readSth() throws InterruptedException
	{
		if((Thread.currentThread().getName().equals("main")))
		{
			Thread.currentThread().sleep(1000);
		}
		
		System.out.println(Thread.currentThread().getName() + " : Read");
	}

	public void writeSth()
	{
		System.out.println(Thread.currentThread().getName() + " : Write");
	}

	@Override
	public void run() {
		
		writeSth();
			
	
	}
}
