
public enum EnumTest {

	//����ö�����Ͷ���EnumTest������
	SMALL(),LARGE(),ANO("A");
	
	private String s = "default";

	//���캯����Ҫ����ö�ٶ�����棡
	  private EnumTest()
	    {
	    	return;
		}
	  
	  private EnumTest(String i)
	   {
	    	s = i;
	  }
	  
	  public String GetString()
	   {
	       return s;
	   }
}
