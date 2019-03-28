import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ORIGIN 256 100000000
		
		//ABITS 255  011111111
		//WBIT 128   010000000
		//SBITS -128 110000000
		//RBITS 127  001111111
		//RFULL 126  001111110
		//s+WBIT     110000000
		
		
		StampedLock sl = new StampedLock();
		
		System.out.println(Integer.toBinaryString(-128) );
	}

}
