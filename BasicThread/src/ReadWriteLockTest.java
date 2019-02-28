import java.util.concurrent.locks.ReentrantReadWriteLock;

//使用场合：被多个线程同时读，或者被一个线程写，不能被同时读写，因为同时读写被锁定，是互斥的！
//具体而言：多个线程读取时可以的，而且读取的数据是共享的，读的时候没有锁，不互斥，可以同时读。写入时候多个线程是互斥的，单位时间只能有一个线程写入
//reentranceReadWriteLock是readwritelock接口的唯一实现类

public class ReadWriteLockTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReentrantReadWriteLock  rrwl = new ReentrantReadWriteLock();
		//全自动化操作
		//读锁定的时候，可以并发读，互斥写
		rrwl.readLock().lock();
		//写锁定的时候全互斥
		rrwl.writeLock().lock();
	}

}
