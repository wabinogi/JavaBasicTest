package basic;
  
public class ObjectTest implements Cloneable
{
	public StringBuilder sb = new StringBuilder();
	private int a;
	
	public ObjectTest(int a)
	{
		sb.append("wabinogi");
		this.a = a;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	
	public ObjectTest clone() throws CloneNotSupportedException
	{
		ObjectTest cot = (ObjectTest)super.clone();
		cot.sb = new StringBuilder();
		cot.sb.append(this.sb.toString());
		return cot;
	}

}
