import java.util.Objects;

public class WrapperTest {

	//args为可变数组
	public static void main(String... args)
	{ 
		EnumTest();
		IntegerTest();
	}
	
	public static void EnumTest()
	{ 
		//调用枚举
		System.out.println(EnumTest.SMALL);
		//调用枚举值的字方法
		System.out.println(EnumTest.SMALL.GetString());
		System.out.println(EnumTest.ANO.GetString());
		
		//通过Enum.valueOf构造枚举值，若不存在会报错
		EnumTest et = Enum.valueOf(EnumTest.class, "LARGE");
		System.out.println(et);
		//EnumTest.values()返回包含所有枚举的数组
		System.out.println(EnumTest.values()[0]);
		System.out.println(EnumTest.values()[2]);
	}
	
	public static void IntegerTest()
	{ 
		Integer i1 = 133;
		Integer i2 = 133;
		
		//将i1自动拆箱成i1.valueof（1）
		System.out.println(i1 + "aaa");
		
		//这个例子比较恶心！！由于数值的不同，可能会导致不同结果！
		//由于是133，所以不执行自动拆箱，比较的是引用，不相等
		if(i1 == i2)
		{
			System.out.println("i1 == i2");
		}
		else
		{
			System.out.println("i1 != i2");
		}
		
		//比较数值
		if(i1.equals(i2))
		{
			System.out.println("i1 equal i2");
		}
	}
}
