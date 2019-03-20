import java.util.concurrent.atomic.AtomicInteger;

//自旋锁
//保证在多线程并发下，共享资源的原子性
//采用自旋锁的多个线程会一直执行FOR循环（自旋），不断试图获取被其他线程获取的锁，直到成功
//非自旋的锁的多线程会休眠，等待其他线程放弃锁的通知
//自旋锁由于不断访问的特性，会占用CPU，因此不适合长时间等待
//自旋锁是不可重入的！因为一个线程如果在递归中开启另一个线程调用自己，则会产生死锁
//在单CPU中不用，在SMP中使用比较普遍（对应numa[非一致性内存架构]）
public class SpinLockTest implements Runnable{

	//内存区共享变量share
	volatile static AtomicInteger share = new AtomicInteger(0);
	
	volatile static AtomicInteger local = new AtomicInteger(-1);

	public static void main(String[] args) {
		
		SpinLockTest slt = new SpinLockTest();
		for(int i = 0; i<50; i ++)
		{
			Thread th = new Thread(slt);
			th.start();
		}
      
	}

	//CAS算法
	//Compare And Swap
	//CAS算法在UNSAFE类的NATIVE本地方法中实现，貌似用C或C++实现
	//该本地方法基于底层硬件的原子性操作实现
	//CAS是乐观锁的一种实现，属于非阻塞多线程同步的方法
	//CAS存在ABA的问题，但是在JDK中有某个类可以解决
	//当线程竞争较少时，使用自旋锁比较合适。因为不存在线程休眠、唤醒、线程切换（上下文切换）、进入内核态等开销
	//CAS一般结合自旋锁使用，当CAS返回为FALSE时（不一致），CPU空转（自旋），直到状态一致
	@Override
	public void run() {
		
		while(true)
		{
			local = share;
			if(local.equals(share))
			{
			    System.out.println(Thread.currentThread().getName() + " No : " + share.addAndGet(1));
			    break;
			}
		
		}
	}
	


}
