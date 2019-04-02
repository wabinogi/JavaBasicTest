import java.util.concurrent.ConcurrentHashMap;

public class ConHashMapT {

	 private static final int MAXIMUM_CAPACITY = 1 << 30;
	 static final int HASH_BITS = 0x7fffffff;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConcurrentHashMap chm;
		System.out.println(16 - (16 >>> 2));
		System.out.println(tableSizeFor(6));
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
