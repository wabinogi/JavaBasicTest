
public interface WabinogiIN {

	//Ĭ��Ϊpublic final
	String s = "fixed string";
	
	//default�ӿڷ��������������в�ʵ�֣�����default
	default String GetName()
	{
		return "wangxing";
	}
	//û����default�����������෽����ʵ��
	void GetWife();
	
	//��ʹ�þ�̬����
	static void GetChild()
	{
		System.out.println("Baby!");
	}
}
