import java.sql.SQLException;

public class ParentClass {

	public void Parent()
	{
		System.out.println("Parent");
	}
	
	//throws Exception��ʾGetExp�������׳��쳣�����һ����ⲿ�����ߴ��ݣ���Ҫ���new SQLException()
	public void GetExp(int i) throws Exception
	{
		try
		{
			//����0�׳�һ���쳣
			if(i>0) throw new Exception();
			else System.out.println("Is ok !");
		}
		catch(Exception e)
		{
			//�쳣����
			System.out.println("Exp catched !");
			//������ɺ�����ٴ��׳������͵��쳣��
			throw new SQLException();
		}
	}
	
	//ͬ��
	public static void main(String...args) throws Exception 
	{
		try{
		new ParentClass().GetExp(1);
		}
		catch(Exception e)
		{
			System.out.println("Exp catched in main!");
			throw e;
		}
		
	}
	
}
