import java.util.PriorityQueue;

//优先队列，不能放NULL
//默认容量11,size是实际大小
//采用二叉堆算法（小根堆）排序，查询，O（log2n），自平衡完全二叉树
//实现Comparator接口，无参构造实现Comparable
public class PriorityQueTest {
	
	static PriorityQueue pq ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 pq = new PriorityQueue();
		pq.add(1);
		pq.add(3);
		pq.add(2);
		pq.add(9);
		pq.add(5);
		System.out.println(pq);
		System.out.println("size is : " +pq.size());
		print();
	}
	
	//如果使用迭代器，则输出按默认顺序
	//使用REMOVE POLL ELEMENT PEER方法，输出按优先顺序
	public static void print()
	{
		int j = pq.size();
		for(int i = 0; i < j; i++)
		System.out.println(pq.poll());
	
	}
	

}
