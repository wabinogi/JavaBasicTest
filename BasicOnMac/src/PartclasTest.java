import java.util.ArrayList;

public class PartclasTest {
	
	
	public static void main(String... args)
	{ 
		int[] ii = new int[]{1}; 
		new PartclasTest().Test1(ii);
		new PartclasTest().Test2();
		new PartclasTest().Test3();
		//������ʹ�÷�ʽ1�����ø��������
		ParentClass ps = new ChildClass()
				{
			//������д���෽��Child
			 public void Child()
			 {
				 ////ע�⣡����������getClass�͸���Ƚϻ᲻�ȣ�
				System.out.println(getClass().toString());
	    	    System.out.println("New Child!");
			 }
				};
				//�������ⲿ���øո���д�ķ���
				((ChildClass)ps).Child();
	
	
	}
	//�����ڲ���
	public void Test3()
	{
		//������ʹ�÷���2����1��ͬС��
		WabinogiIN aa = new WabinogiIN()
		{
			//ʵ�ֽӿ��෽��
			//ʵ�ֵ�default����public����
			 public String GetName()
			{
				return "wangxing";
			}
			
			//��ʼ����
				{
					  System.out.println("��ʼ����ķ���");
				}
			
		};
	}
	public void Test2()
	{
		//�����ڲ���
		//����һ��ʵ����WabinogiIN�������ڲ������acn
		WabinogiIN acn = new WabinogiIN()
	    {
			 public void GetWife()
			 {
	    	    System.out.println("�����ڲ���");
			 }
	    };
	    acn.GetWife();
	    
	}
	
	//�ڲ���
	public void Test1(int[] ii)
	{
		//�ֲ���������ֻ���ڸ÷����ڲ�
		//�������أ�������public��private�ؼ���
		ii[0] = 2;
	    class SubPartClass
		{
		     void Pprint()
			{
		        //����s�ھֲ�����Ϊfinal�����ܸı�
		    	 //stringbuilder��int[]����������
				System.out.println(ii[0]);
			}
		}
	    SubPartClass spc = new SubPartClass();
	    System.out.println("get ready!");
	    spc.Pprint();
	    
	}

}
