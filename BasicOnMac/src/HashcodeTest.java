import java.util.Objects;

public class HashcodeTest {
	
	static HashcodeTest ht = new HashcodeTest();
	
	public static void main(String[] args)
	{ 
		hashcodeT1();	
		//JAVA����д����û��override�ؼ���
		System.out.println(ht.toString());
		//���ط���
		System.out.println(ht.toString(1));
		//����ht����+���㣬�Զ�����tostring����
		System.out.println("auto plus " + ht);
	}
	
	public static void hashcodeT1()
	{
	   int a = 1;
	   String s = "a";
	   //��������hashֵ
	   //������ȵĶ���Ҫ������ȵ�HASHֵ��������ȵ�HASH��һ���������
	   System.out.println(Objects.hash(a,s));
	   //ȡ����������
	   System.out.println(s.getClass().getName());
	   
	}
	
	//��д��������һ��
	@Override
	public String toString()
	{
		return super.toString();
	}
	
	//overload��д������1һ��
	public int toString(int i)
	{
		return i;
	}
	
}
