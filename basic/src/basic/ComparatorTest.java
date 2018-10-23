package basic;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest implements Comparator<String>{

	public static void main(String[] args) throws CloneNotSupportedException
	{
		String[] ss = new String[]{"aaaa","bb","cc","ddddd"};
		Comparator<String> cs = new ComparatorTest();
		//Arrays.sort实现了一个排序，但是需要自己实现ss类型的排序接口实现类cs
		Arrays.sort(ss,cs);
		System.out.println(Arrays.toString(ss));
		
		
	
		
		//实现浅拷贝，ObjectTest类中实现类clonable接口，和clone方法！
		ObjectTest ot = new ObjectTest(1);
		ObjectTest ot1 = ot.clone();
		System.out.println(ot.getA());
		System.out.println(ot1.getA());
		//浅拷贝！，由于拷贝对象ot1和ot同时引用了共享对象sb，因此ot中的sb改变会导致ot1的对象改变
		//如果需要深拷贝，需要在clone重写方法中做更多工作
		ot.sb.append("223");
		System.out.println(ot.sb.toString());
		System.out.println(ot1.sb.toString());
	}  

	@Override //实现接口方法
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.length() - o2.length();
	}
	
	public static void compare1() {
		
		
	}
}
