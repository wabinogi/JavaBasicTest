import java.util.Hashtable;

//synchronized
//键、值均不能为null
//初始化容量和HASHMAP不一样，单线程时效率应该比HASHMAP慢
//和HASHMAP的HASH算法貌似不一样
public class HashtableTest {

	static Hashtable ht;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		ht = new Hashtable();
		ht.put(1, 1);
		ht.put(2, 1);
		ht.put(3, 1);
		ht.put(null, 1);
		
		
		System.out.println(ht.keySet());
		
	}

}
