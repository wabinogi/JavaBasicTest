
//使用synchronized(object)获取对象的锁，实现阻塞
//注意！貌似基本类型和包装器类型不能获得锁！
public class SychronizdLockObjectTest implements Runnable {

	//volatile关键字，保证如果主存的值改变，则多个线程从主存 中读到新值，而非线程缓存。
	//被volatile修饰后，编译器不会优化代码执行顺序
	volatile Object1 o1 = new Object1();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SychronizdLockObjectTest sot = new SychronizdLockObjectTest();
		Thread t = new Thread(sot);
		t.start();
		sot.method1();

	}

	public  void method1()
	{
		synchronized(o1){
		for (int i =0; i <=10; i ++)
		{
			o1.ii = o1.ii + 1;
				System.out.println("main :" + o1.ii);
		}
		  }
	}
	
	public  void method2()
	{
		synchronized(o1){
		for (int i =0; i <=10; i ++)
		{
			o1.ii = o1.ii + 1;
				System.out.println("second :"+o1.ii);
		}
	   }
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		method2();
	}
}
