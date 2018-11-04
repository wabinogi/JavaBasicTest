import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//键、值可以有NULL,和Hashtable类似，但是hashmap不能存空，
//KEY不能重复，KEY和VALUE一一对应，线程不安全
//MAP接口取代旧的Dictionary虚类
//键值记录不保证顺序
//水桶不够时，重新哈希的桶大小为其2倍
//迭代器采用fast-fail机制
//键采用HashCode(),因此对于传入的复杂对象，可能需要重写HashCode()方法，保持对象一致
//KEY和VALUE的集合Collection<T>实际是个两个单向链表，每次HASH插入都需要维护链表指针，指针的顺序是地址顺序，不是插入顺序。
//过大时BUCKET采用红黑树
public class HashMapTest {

	static HashMap hm;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		init();
		add();
		print();
		
		
 	}
	
	public static void add()
	{
		
		hm.put(7, "a");
		hm.put(5, "b");
		hm.put(1, "c");
		hm.put(null, null);
		//返回旧值
		System.out.println(hm.put(1, "d"));
		
	}
	
	public static void print()
	{
		System.out.println(hm);
		System.out.println(hm.size());
		//不存在返回NULL
		System.out.println(hm.get(1));
		//Key,类型Set
		System.out.println(hm.keySet());
		//Values,类型Collection<V>
		Collection c = hm.values();
		System.out.println(c);
		
		//Iterator方法
		Iterator it = c.iterator();
		System.out.println("iterator methods : ");
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		//EntrySet,Set<Map.Entry<K,V>>
		System.out.println(hm.entrySet());
		
		hm.remove(null,null);
		System.out.println(hm.entrySet());
		
	}
	
	public static void init()
	{
		//10个大小，0.8装填
		hm = new HashMap(10,0.8f);
		
	}

}
