
public interface WabinogiIN {

	//默认为public final
	String s = "fixed string";
	
	//default接口方法可以在子类中不实现，采用default
	default String GetName()
	{
		return "wangxing";
	}
	//没有用default，必须在子类方法中实现
	void GetWife();
	
	//可使用静态方法
	static void GetChild()
	{
		System.out.println("Baby!");
	}
}
