import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import static java.lang.System.out;


//基于linkedHashmap，采用双向链表
//其他和hashset一样
public class LinkedHashSetTest {

	static LinkedHashSet lhs;
	static HashSet hs;
	
	public static void main(String... args) 
	{
		 hs = new HashSet();
		 hs.add(1);
		 hs.add(2);
		 hs.add("a");
		 hs.add(-1);
		 hs.add(-2);
		 out.println(hs);
		 lhs = new LinkedHashSet(hs);
		 out.println(lhs);
		 
		 hs.remove("a");
		 lhs.remove("a");
		 out.println(hs);
		 out.println(lhs);
		 
		 hs.add("a");
		 lhs.add("a");
		 out.println(hs);
		 out.println(lhs);
		 
		 Print();
	}
	
	public static void Print() 
	{
		out.println("Print Start :");
		Iterator i = lhs.iterator();
		//
		while(i.hasNext())
		{
			out.println(i.next().toString());
		}
	}
}
