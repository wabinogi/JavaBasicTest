import java.util.TreeMap;

//基于红黑树,按自然比较大小，从小到大排序，O（log(n)）
//Comparable，Comparator，Equals接口函数很重要
//not synchronized、fail-fast

public class TreeMapTest {
	
	static TreeMap tm;
	public static void main(String[] args) {
		
		Init();
		 Add();
		 Print();
		 
	}
	
	public static void Init() {
		
		tm = new TreeMap();
		
	}
	
	public static void Add() {
		tm.put(3, "c");
		tm.put(1, "a");
		tm.put(2, "b");
		tm.put(0, "0");
		
	}
	
    public static void Print() {
		
    	System.out.println(tm.size());
    	System.out.println(tm.keySet());
    	System.out.println(tm.values());
    	System.out.println(tm.firstKey() + " " + tm.lastKey() );
    	System.out.println(tm.firstEntry() + " " + tm.lastEntry() );
    	System.out.println(tm.lowerEntry(2) + " " + tm.higherEntry(2) );
    	System.out.println(tm.descendingKeySet());
    	System.out.println(tm.descendingMap());
	}
}
