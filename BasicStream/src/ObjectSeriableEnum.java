
import java.io.ObjectStreamException;
import java.io.Serializable;

//安全类型枚举方法、（类似单例模式）
public class ObjectSeriableEnum implements Serializable{
	
	static final ObjectSeriableEnum OSE1 = new ObjectSeriableEnum("OSE1");
	static final ObjectSeriableEnum OSE2 = new ObjectSeriableEnum("OSE2");
	
	private String name;
	private ObjectSeriableEnum()
	{
		
	}

	private ObjectSeriableEnum(String name)
	{
		this.name = name;
	}
	
	public String GetName()
	{
		return this.name;
	}
	
	//如果不增加该方法，则反序列化后得到的对象和原对象不一致
	protected Object readResolve() 
	{
		if(this.name.equals("OSE1")) return OSE1;
		else  return OSE2;
	
	}
}
