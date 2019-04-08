import java.util.concurrent.LinkedBlockingQueue;

//底层实现采用重入锁，且是2把锁，一把存，一把取，可同时进出队列
//如果初始化队列时不指定容量大小，默认是无限的队列，因此，取得速度太慢，会导致队列太大撑爆内存
public class LinkedBlockingQueNote {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedBlockingQueue lbq;
	}

}
