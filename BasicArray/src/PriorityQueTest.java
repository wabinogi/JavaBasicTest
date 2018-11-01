import java.util.PriorityQueue;

//不能放NULL
//默认容量11,size是实际大小
//采用二叉树排序，查询，O（log2n）
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
	
	public static void print()
	{
		int j = pq.size();
		for(int i = 0; i < j; i++)
		System.out.println(pq.poll());
	
	}
	

}
