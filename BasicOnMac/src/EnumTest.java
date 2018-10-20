
public enum EnumTest {

	//所有枚举类型都是EnumTest的子类
	SMALL(),LARGE(),ANO("A");
	
	private String s = "default";

	//构造函数需要放在枚举定义后面！
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
