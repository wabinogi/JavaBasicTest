import java.util.concurrent.CopyOnWriteArrayList;

//CopyOnWriteArrayList/Set
//当需要修改的时候，COPY一份副本，在副本中修改，在让指针指向新的副本
//采用读写分离的思想，读写在不同的容器中，读不用加锁
//用于读多写少的场景
//如果内存对象过大，采用该策略会有问题，因为COPY的副本会加剧内存的使用，且GC负担大
//使用批量添加可以减少添加的次数，从而减少COPY的次数
//提供最终一致性，而不是实时一致的（即脏读）
public class CopyOnWriteArrayListNote {

	public static void main(String[] args) {
		
	}

}
