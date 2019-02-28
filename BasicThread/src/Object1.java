//ConcurrentHashMap、ConcurrentSkipListMap、ConcurrentSkipListSet、ConcurrentLinkedQueue
//以上几种集合是线程安全的，参考HASEMAP在做REHASH时被剥夺控制权导致不安全的例子。
//ConcurrentHashMap只是不会被并发破坏HASH表内部的数据结构，但是不能保证多个原子操作的一致性问题。比如两个线程同时更新一个HASH表，可能会出现不确定结果
//针对上面的情况，可是使用ConcurrentHashMap中的REPLACE函数，用新值替代原值，参考P676
//以上集合使用弱一致性迭代器，不会返回ConcurentModificationException

//Vector和HashTable是较早的提供线程安全的集合类，但是已经被弃用
//可以使用Arraylist和HashMap，同时结合同步包装器，使其变成线程安全。
//Collections.synchronizedList（）
//使用UTIL.CONCURENT中定义的同步集合是上上策

//读写锁......
public class Object1 {
	
	public  int ii = -2;
	
	public void printNo()
	{
		int j = 10;
		while(j>0)
		{
			j = j - 1;
		System.out.println(ii);
		}
	}
	
}
