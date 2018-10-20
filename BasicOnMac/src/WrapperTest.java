import java.util.Objects;

public class WrapperTest {

	//argsΪ�ɱ�����
	public static void main(String... args)
	{ 
		EnumTest();
		IntegerTest();
	}
	
	public static void EnumTest()
	{ 
		//����ö��
		System.out.println(EnumTest.SMALL);
		//����ö��ֵ���ַ���
		System.out.println(EnumTest.SMALL.GetString());
		System.out.println(EnumTest.ANO.GetString());
		
		//ͨ��Enum.valueOf����ö��ֵ���������ڻᱨ��
		EnumTest et = Enum.valueOf(EnumTest.class, "LARGE");
		System.out.println(et);
		//EnumTest.values()���ذ�������ö�ٵ�����
		System.out.println(EnumTest.values()[0]);
		System.out.println(EnumTest.values()[2]);
	}
	
	public static void IntegerTest()
	{ 
		Integer i1 = 133;
		Integer i2 = 133;
		
		//��i1�Զ������i1.valueof��1��
		System.out.println(i1 + "aaa");
		
		//������ӱȽ϶��ģ���������ֵ�Ĳ�ͬ�����ܻᵼ�²�ͬ�����
		//������133�����Բ�ִ���Զ����䣬�Ƚϵ������ã������
		if(i1 == i2)
		{
			System.out.println("i1 == i2");
		}
		else
		{
			System.out.println("i1 != i2");
		}
		
		//�Ƚ���ֵ
		if(i1.equals(i2))
		{
			System.out.println("i1 equal i2");
		}
	}
}
