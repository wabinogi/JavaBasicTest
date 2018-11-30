import java.util.BitSet;

//线程不安全
//经过测算，10亿条数据，需要15625000个LONG，125000000个BYTE，相当于119.21MB
public class BitSetTest {

	static BitSet bs;
	static BitSet bs1;
	static BitSet bs2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		bs = new BitSet();
		bs1 = new BitSet();
		bs2 = new BitSet();
		//bs.flip(67);
		//设置为1
		bs.set(0);
		bs.set(3,false);
		bs.set(9);
		System.out.println(bs);
		//设置相应位的补集
		//bs.flip(5);
		//从第一位开始检查，直到找到下一个为TRUE的BIT的位置索引，包含1
		System.out.println(bs.nextSetBit(1));
		for(long ll:bs.toLongArray())
		{
			System.out.println(ll);
		}
		//返回已用BITSET位的容量个数
		System.out.println(bs.length());
		//返回为TRUE的位的个数
		System.out.println(bs.cardinality());
		
		//00011
		bs1.set(0,2);
		//01110
		bs2.set(1,4);
		//是否有交集？
		System.out.println(bs1.intersects(bs2));
		//00010
		bs1.and(bs2);
		System.out.println(bs1.toByteArray()[0]);
		//01110
		bs1.or(bs2);
		System.out.println(bs1.toByteArray()[0]);
		System.out.println("TEST");
		Test();
	}
	
	public static void Test() {
		
		bs = new BitSet();
		for(long ll:bs.toLongArray())
		{
			System.out.println(ll);
		}
		//BitSet实际用到的位数大小，小于等于64位实际用到一个LONG，返回64，超过64会自动扩展一个单位，为128位
		System.out.println(bs.size());
		
		
	}

}
