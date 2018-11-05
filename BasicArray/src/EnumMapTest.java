import java.util.EnumMap;

//EnumSet、EnumMap没有关系
//不允许NULL
//迭代器输出顺序与ENUM枚举定义顺序一致
public class EnumMapTest {
	
	
	static EnumMap es;
	static EnumMap es1;
	public static void main(String[] args) {
		
		es = new EnumMap(InnerEnum.class);
		es.put(InnerEnum.A, 1);
		es.put(InnerEnum.B, 2);
		es.put(InnerEnum.C, 3);
		
		es1 = new EnumMap(InnerEnum.class);
		es1.put(InnerEnum.A, 1);
		es1.put(InnerEnum.C, 3);
		es1.put(InnerEnum.B, 2);
		
		System.out.println(es.size());
		System.out.println(es);
		System.out.println(es1);
		System.out.println(es.equals(es1));
		
	}
	
    enum InnerEnum
	{
    	B(2),A(1),C(3),D(4),E(5),F(6);
		
	    int index = 0;
		InnerEnum(int i)
		{
			index = i;
		}
		
		public String toString()
		{
			return String.valueOf(index);
		}
	}
	
}
