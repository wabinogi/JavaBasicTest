import java.util.HashMap;
import java.util.Spliterator;
import java.util.concurrent.ConcurrentHashMap;

//ConcurrentHashMap
//采用CAS方法，Synchronised关键字对Node级别进行加锁，可以说是数据行锁
//Spliterator可以同时开启多个线程，通过trySplit将数据分成多个子集，多线程同时处理
public class ConHashMapT {

	 private static final int MAXIMUM_CAPACITY = 1 << 30;
	 static final int HASH_BITS = 0x7fffffff;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConcurrentHashMap chm;
	    HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	    for(int i = 0; i<=30; i++)
	    {
	      hm.put(i, i);
	    }
	    Spliterator<Integer> s0 = hm.keySet().spliterator().trySplit();
	    //Spliterator<Integer> s1 = s0.trySplit();
	    
	   // System.out.println(st.estimateSize());
	    //st.tryAdvance((Integer t) -> { System.out.println(t);});
	    s0.forEachRemaining((t) -> { System.out.println("s0 " + t);} );
	    //s1.forEachRemaining((t) -> { System.out.println("s1 " +t);} );
	    //sl1.forEachRemaining( (Integer t) -> { System.out.println(t);} );
	  //  System.out.println(sl1.toString());
	    
	    
	    
	}

	 private static final int tableSizeFor(int c) {
	        int n = c - 1;
	        n |= n >>> 1;
	        n |= n >>> 2;
	        n |= n >>> 4;
	        n |= n >>> 8;
	        n |= n >>> 16;
	        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	    }
	 
	 static final int spread(int h) {
	        return (h ^ (h >>> 16)) & HASH_BITS;
	    }
}
