import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//使用场合：被多个线程同时读，或者被一个线程写，不能被同时读写，因为同时读写被锁定，是互斥的！
//具体而言：多个线程读取时可以的，而且读取的数据是共享的，读的时候没有锁，不互斥，可以同时读。写入时候多个线程是互斥的，单位时间只能有一个线程写入
//reentranceReadWriteLock是readwritelock接口的唯一实现类

//读写锁，是逻辑上的读写操作，与具体IO操作无关！
//读锁可重入，拥有同一读锁的不同对象可以并发，无论该锁是否解锁

//读写锁本质上是基于AQS队列数据结构实现的
//读锁是共享锁shared
//写锁的独占锁exclusive
//获取一个写锁的操作和ReentranceLock中获取一个普通锁的过程相同

public class ReadWriteLockTest {

	static ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ReadWriteLockTest rlt = new ReadWriteLockTest();
		InnerThread it = rlt.new InnerThread();
	
		
		Thread t1 = new Thread(it);
		t1.start();
	
				
		//Thread.sleep(200);
		rrwl.writeLock().lock();
		WriteSth();
		ReadSth();
		//关于锁降级，当前线程在使用写锁后，可以立刻用读锁进行加锁，进行读操作
		//反之不行
		rrwl.readLock().lock();
		System.out.println("Lock degrade !");
		
		rrwl.writeLock().unlock();
		
		
	}
	

	public static void ReadSth() throws FileNotFoundException
	{
		Scanner sc = new Scanner(new File("D:\\wangxing.txt"));
		while(sc.hasNextLine())
		{
			System.out.println(sc.nextLine());
		
		}
		
		sc.close();
	}
	
	public static void WriteSth() throws IOException
	{
	   File f = new File("D:/wangxing.txt");
 	   FileWriter fr = new FileWriter(f);
 	   BufferedWriter bw = new BufferedWriter(fr);
 	   bw.append("11111");
 	   bw.newLine();
 	   bw.append("22222");
	   bw.newLine();
	   bw.append("33333");
	   bw.flush();
	   bw.close();
	   fr.close();
	   
	   
	}

    public class InnerThread implements Runnable
    {
    	
    	public void run() {
    		
    	     rrwl.writeLock().lock();
    		 Thread t = Thread.currentThread();
    		 System.out.println(t.getName());
    		 rrwl.writeLock().unlock();
    	}
    }

    



}
