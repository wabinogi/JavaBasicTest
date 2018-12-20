import java.io.Serializable;

//可序列化对象需要打上Serializable标签
public class ObjectSeriable implements Serializable{

	
	private String name;
	private String Age;
	
	public ObjectSeriable()
	{
		
	}
	
	public void SetName(String name)
	{
		this.name = name;
	}
	
	public void SetAge(String Age)
	{
       this.Age = Age;
	}
	
	public String GetName()
	{
		return this.name;
	}
	
	public String GetAge()
	{
		return  this.Age;
	}
}
