
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

//基于HashMap实例实现，有单向链结构
//没有顺序，尤其随着时间推移，元素的顺序可能会变
//元素唯一，可以有一个NULL
//读写性能很好，ADD、REMOVE、UPDATE,几乎是 O(1)
//线程不同步
//非线程安全的修改，采用fail-fast机制，触发该机制会抛出 ConcurrentModificationException
//但是fail-fast机制可能不保证立刻发生，因此依靠ConcurrentModificationException来作为执行条件是不可行的
//迭代器访问时，性能由已存元素数和Bucket共同决定，如果HashSet的Bucket太大（或Load factor太小，意思就是经常再散列），会影响迭代性能，
public class HashSetTest {

	static HashSet hs;
	public static void main(String... args) 
	{
		init();
		write();
		read();
	}
	
	public static void read()
	{
		System.out.println(hs.contains("a"));
	}
	
	public static void write()
	{
		//默认容量16
		 hs =  new HashSet();
		hs.add("t");
		
		//三个4不是一种类型，所以可以保存
		hs.add(new Short("4"));
		hs.add(4l);
		hs.add(new Integer(4));
		
		hs.add(null);
		hs.add(3);
		//"a"和'a'不是一种对象
		hs.add("a");
		hs.add('a');
		System.out.println(hs.toString());
		hs.remove("t");
		System.out.println(hs.toString());
		
	}
	
	public static void init()
	{
		//load factor 默认0.75
		HashSet hs =  new HashSet();
		//LF设置为1.5
		HashSet hh =  new HashSet(1,1.5f);
		System.out.println(hs.size());
		
		//增加4个不重复的元素后，SIZE为4，否则为0
		HashSet hs1 =  new HashSet(4);
		hs1.add(1);
		hs1.add(2);
		hs1.add(3);
		hs1.add(4);
		System.out.println(hs1.size());
		
	}
	
}
