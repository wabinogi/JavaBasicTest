import java.util.Iterator;
import java.util.LinkedHashMap;

//可以实现LRU内存结构
//基于双向链表
public class LinkedHashMapTest {

	
	static LinkedHashMap lhm;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//设为TRUE，按访问顺序排序，每次使用GET访问后，被访问的元素会移动到最后端
		lhm = new LinkedHashMap(10,0.8f,true);
		
 		lhm.put(5, 5);
		lhm.put(4, 4);
		lhm.put(3, 3);
		lhm.put(2, 2);
		lhm.put(1, 1);
		System.out.println(lhm.keySet());
		System.out.println("PUT");
		
		lhm.put(3, 0);
		System.out.println(lhm.keySet());
		lhm.put(2, 0);
		System.out.println(lhm.keySet());
		lhm.put(1, 0);
		System.out.println(lhm.keySet());
		lhm.put(5, 0);
		System.out.println(lhm.keySet());
		lhm.put(4, 0);
		System.out.println(lhm.keySet());
		
		System.out.println("GET");
		lhm.get(5);
		System.out.println(lhm.keySet());
		lhm.get(4);
		System.out.println(lhm.keySet());
		lhm.get(3);
		System.out.println(lhm.keySet());
		lhm.get(2);
		System.out.println(lhm.keySet());
		lhm.get(1);
		
		System.out.println(lhm.keySet());
	
	 
		


	}
	
	

}
