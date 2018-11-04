import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

//本质是链表，实现了双端链表
//可以实现FIFO，队列数据结构，或者双端队列数据结构
//可以实现LIFO，栈数据结构
//顺序访问高效，随机访问低效 ，查找使用二分查找法，时间复杂度O(log2n)
//1.remove抛异常最快》2.无脑for循环》3.poll空时返回false》4.迭代器》5.get(index)随机访问
//线程不安全
//貌似没有增长限制一说
public class LinkedListTest {
	
	public static void main(String... args) 
	{
		Test();

	}
	static ListIterator li;

	
	public static void Test()
	{
		LinkedList ll = new LinkedList();
		ll.add("b");
		ll.add("a");
		
		ll.add("c");
		System.out.println(ll);
		
		ll.addFirst("0");
		System.out.println(ll);
		
		//如果INDEX越界，会报错
		//ll.add(6, "1");
		
		//去除第一次出现的某个值
		ll.removeLastOccurrence("b");
		System.out.println(ll);
		//取得索引对应的值
		System.out.println(ll.get(2));
		System.out.println(ll.peek());
		
		//用li列表遍历器遍历，但是要注意光标位置，每一次ADD SET REMOVE后，光标位置不动，
		 li = ll.listIterator();
		System.out.println(li.hasNext());
		System.out.println(li.next());
		//修改前需要调用下next
		li.set("7");
		System.out.println(ll);        
	}
	
}
