
//�ӿ��еķ������η�һ��û�У���Ϊ����public
public interface WabinogiIN {

	//Ĭ��Ϊpublic final
	String s = "fixed string";
	
	//default�ӿڷ��������������в�ʵ�֣�����default
	default String GetName()
	{
		return "wangxing";
	}
	//û����default�����������෽����ʵ��
	default void GetWife()
	{
		System.out.println("Mandy!");
	}
	
	//��ʹ�þ�̬����
	static void GetChild()
	{
		System.out.println("Baby!");
	}
}
