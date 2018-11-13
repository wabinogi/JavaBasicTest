import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import static java.lang.System.out;

//和Arraylist很类似
//随机读最快O(1),随机写在查询的时候是O(1),但是每增加，删除一个元素，后面的元素都需要移动！
//也就是说删除后，索引会改变！因此不适合做添加、删除操作，适合查询、修改
//顺序读写（迭代器、FOR循环一般）
//其中的Enumeration接口引用是遗留产物，可以用iterator全替代
public class VectorTest {

	//线程同步
	//构造函数默认起始容量为10
		public static void main(String[] args)
		{ 
			Init();
			Add();
			
		}
		
		public static void Add()
		{ 
			//索引按插入先后顺序自动赋值
			Vector vr = new Vector(4,10);
			vr.add("a");
			vr.add("b");
			vr.add(3);
			
			//get和elementAt几乎一样
			out.print(vr.get(0));
			out.print(vr.get(1));
			out.println(vr.get(2));
			
			//增加了一个值，元素向后移动，索引改变
			vr.add(0, 0);
			out.print(vr.get(0));
			out.print(vr.get(1));
			out.println(vr.get(2));
	
		}
		
		@SuppressWarnings("rawtypes")
		public static void Init()
		{ 
			//默认容量是10个
			//初始化容量为4,每次增加10
			Vector vr = new Vector(4,10);
			vr.add(1);
			vr.add(2);
			vr.add(3);
			vr.add(4);
			vr.add(5);
			out.println(vr.toString());
			//去除多余存储容量
			vr.trimToSize();
			//设置最小容量，立即生效
			vr.ensureCapacity(20);
			//容量大小
			out.println("capacity is : " +vr.capacity());
			out.println();
			
			//Collection方式初始化
			Vector vr1 = new Vector(vr);
			out.println(vr1.toString());
			//保留4个元素，形成一个子集，不能超出INDEX上限，
			vr1.setSize(4);
			out.println(vr1.toString());
			//元素个数
			out.println("size is :" + vr1.size());
			out.println("capacity is : " +vr1.capacity());
			out.println();
			
			//copyInto,线程同步，但是需要Object[]类型输入
			//数组初始化大小要符合，否则报错
			Object[] ss = new Object[5];	
			vr1.copyInto(ss);
			out.println(Arrays.toString(ss));
			
		}
		
		
	
	    
	   
}
