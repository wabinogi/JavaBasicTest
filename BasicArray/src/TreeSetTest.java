import java.util.Comparator;
import java.util.TreeSet;
import static java.lang.System.out;

//线程不同步，采用fail-fast机制，触发该机制会抛出 ConcurrentModificationException
//基于TreeMap实现
//时间复杂度O(log2n)
//有插入先后顺序，系统自动排列，按升序排列
//采用红黑树算法。该算法是一种自平衡（大概平衡）的二叉树，二叉树貌似有两个地址指针，指向左右节点。
//1.根节点和端点为黑 2.根到每个端，具有相同的黑节点数 3.红色的子节点为黑，且同一层必须颜色一致
//插入、删除、修改时，动态自平衡机制靠旋转和变色实现，时间复杂度O（1）。
public class TreeSetTest {
	
	
	public static void main(String[] args)
	{ 
		Add1();
		Add2();
		UpdateDelete();
		FirstLast();
	}
	
	public static void FirstLast()
	{
		TreeSet<Integer> ts = new TreeSet();
		ts.add(3);
		ts.add(-1);
		ts.add(0);
		ts.add(-10);
		out.println(ts);
		//取得头尾元素
		out.println(ts.first());
		out.println(ts.last());
		//lower
		out.println(ts.lower(3));
		//poll删除
		ts.pollFirst();
		ts.pollLast();
		out.println(ts);
		ts.toArray();
	}
	public static void UpdateDelete()
	{
		TreeSet<Integer> ts = new TreeSet();
		ts.add(1);
		ts.add(2);
		ts.add(3);
		ts.add(6);
		ts.add(-1);
		out.println(ts);
		//集合大小
		out.println(ts.size());
		//head子集合
		out.println(ts.headSet(3,true));
		//tail子集合
		out.println(ts.tailSet(2,true));
		//删除
		ts.remove(6);
		out.println(ts);
	}
	
	public static void Add1()
	{
		Integer i = 0;
		String s = "a";
		//初始化默认，添加的Set元素对象的类必须实现Comparable接口
		TreeSet tt = new TreeSet();
		//不可添加重复元素，如果执行重复添加，add返回false
		tt.add(1);
		tt.add(3);
		tt.add(-2);
		//不可插入NULL
		//tt.add(null);
        //默认从小到大排序		
		out.println(tt);
		
	}
	
	public static void Add2()
	{
		//实现Comparator接口的构造方法
		TreeSet ts = new TreeSet(new Tree(null));
		ts.add(new Tree("a"));
		ts.add(new Tree("c"));
		ts.add(new Tree("b"));
		ts.add(new Tree("2"));
		ts.add(new Tree("d"));
		//Tree实现toString即可打印
		out.println(ts);
		//返回从大到小SET集合
		out.println(ts.descendingSet());
	}
	
	static class Tree implements Comparator
	{
		String s = null;
		Tree(String s)
		{
		   this.s = s;
		}
		
		public String toString()
		{
			return this.s;
		}
		
		
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			String s1 = o1.toString();
			String s2 = o2.toString();
			return s1.compareTo(s2);
		}
	}
	
}
