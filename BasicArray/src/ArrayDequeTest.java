import java.util.ArrayDeque;

//没有容量限制，线程不安全，起始容量16
//不能空元素，貌似作为STACK比STACK类块，作为队列要比LINKEDLIST块
//采用循环数组实现的队列
//迭代器采用fail-fast机制
//主要继承了COLLECTION（添加、删除、存在）和QUE（进出队列）、DEQUE（进出栈）接口的方法
public class ArrayDequeTest {

	static ArrayDeque ad;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		init();
		add();
		print();
	}
	
	public static void print()
	{
		System.out.println(ad);
		//队列操作，左边输出
		System.out.println(ad.peek());
		System.out.println(ad.size());
	}
	public static void init()
	{
		ad = new ArrayDeque(4);
		
	}

	
	public static void add()
	{
		//左边ADD
		ad.addFirst(1);
		ad.addFirst(2);
		ad.push(3);
		//右边ADD
		ad.addLast(-1);
		//右边ADD
		ad.add(-2);
		ad.offer(-3);
		
	}
}
