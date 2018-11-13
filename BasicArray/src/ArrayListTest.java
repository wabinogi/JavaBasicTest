import java.io.*;
import java.lang.reflect.Array;
import java.util.*;



//支持快速随机访问
//内部用数组保存[1],[2],[3],[4],[5]......每个数组对应一个地址。和链表结构不太一样。
//插入元素，其他元素后移；删除元素，其他元素前移
//添加、修改、删除效率不高
//随机访问快于FOR循环快于迭代器
//线程不安全
//优点——————————————————————————————————————————————————————
//动态增长
//可以加入重复的value
public class ArrayListTest {

	//初始化10个单位
	static ArrayList<String> al = new ArrayList<String>(10);
	
	public static void main(String[] args)
	{ 
		//ArrayList只能顺序添加，按加入的先后顺序赋索引。
		ALadd();
		ALupdate();
		ALdelete();
		ALiteread();
		ALListIterRead();
		ALClone();
		ALEqual();
		AltoArray();
		Altrim();
	}
	static Object ob;
	
	public static void Altrim()
	{
		ArrayList aa = new ArrayList(2);
		
		aa.add("1");
		aa.add("2");
		//一次性扩展到位！生成10个elements，如果10个不够了，则扩展变成10*1.5个
		aa.ensureCapacity(10);
	
		//trimToSize去除数组动态增长后多余的那部分！
		aa.trimToSize();
		
	}
	
	//数组转换
	public static void AltoArray()
	{
		ArrayList aa = new ArrayList();
		aa.add("w");
		aa.add("a");
		aa.add("b");
		aa.add("i");
		//将Arraylist转换为数组类型！
		String[] ss =  (String[]) aa.<String>toArray(new String[]{});
		System.out.println(Arrays.toString(ss));
		//将Arraylist转换为OBJECT数组类型！
		Object[] sss = aa.toArray();
		
	}
	
	//ArrayList中数组元素值和位置全一样，equals才相等！
	public static void ALEqual()
	{
		String[] s = new String[]{"a","b"};
		//通过Arrays.asList将数组转换成ArrayList
		ArrayList aa = new ArrayList(Arrays.asList(s));
		System.out.print("list aa size :" + aa.size() + " ");
		System.out.println(aa.toString());
		
		String[] ss = new String[]{"a","b"};
		//通过Arrays.asList将数组转换成ArrayList
		ArrayList a = new ArrayList(Arrays.asList(ss));
		System.out.print("list a size :" + a.size() + " ");
		System.out.println(a.toString());
		
		System.out.println("they are equal ? " + a.equals(aa));
	}
	
	public static void ALClone()
	{
		//Clone方法OK，但是是浅复制
		ArrayList aa = (ArrayList) al.clone();
		System.out.print("size :" + aa.size() + " ");
		System.out.println(aa.toString());
		
		//创建子集合
		List l = (List) al.subList(0, 2);
		System.out.println(l.toString());
		//清空集合
		aa.clear();
		System.out.print("size :" + aa.size() + " ");
		System.out.println(aa.toString());
	}
	
	//双向游标
	public static void ALListIterRead()
	{
		ListIterator il =  al.listIterator();
		while(il.hasNext())
		{
			if(il.hasPrevious())
			{
				int index1 = il.previousIndex();
				String s1 = (String) il.previous();
				il.next();
				System.out.println("Pindex: " + index1 + " listiter Pvalue: " + s1);
			}
			else
			{
				System.out.println("No previous");
			}
			
			int index = il.nextIndex();
			String s = (String) il.next();
			System.out.println("index: " + index + " listiter value: " + s);
		}
	}
	
	public static void ALiteread()
	{
		int length = al.size();
		for(int i = 0;i < length; i ++)
		{
			System.out.println("index :" + i + " value : " + al.get(i));
		}
		
		//利用Iterator游标模式遍历，
		Iterator<String> it = al.iterator();
		while(it.hasNext())
		{
			String s = (String) it.next();
			if(s.equals("-1"))
				{it.remove();}
			else
			{
			System.out.println("iterator value: " +s);
			}
		}
		
	}
	
	public static void ALdelete()
	{
		int length = al.size();
		for(int i = 0;i < length; i ++)
		{
			System.out.println("index :" + i + " value : " + al.get(i));
		}
		
		//取得元素的索引，如果没有返回-1。如果多个元素，返回第一个！lastindexof方法从后开始数
		System.out.println(al.indexOf("1"));
		//删除index为1的元素，返回index所在的value,如果不存在INDEX，则报异常
		System.out.println(al.remove(1));
		
	}
	
	public static void ALupdate()
	{
		//是否为空？
		System.out.println(al.isEmpty());
		//在现有索引处更新，更新返回旧值
		//不可在没有元素的地方更新，否则数组越界！
		System.out.println(al.set(1, "1").toString());
		//是否包含某个元素？返回0，1，注意类型要一致
		System.out.println(al.contains("3"));
		
	}
	
	//顺序插入，顺序输出
	public static void ALadd()
	{
		//无索引添加
		al.add("2");
		al.add("3");
		al.add("1");
	

		System.out.println(al.toString());
		//实际大小
		System.out.println(al.size());
		//用索引随机访问
		int length = al.size();
		for(int i = 0;i < length; i ++)
		{
			System.out.println("index :" + i + " value : " + al.get(i));
		}

		//在相同的index位置增加新值，所有旧值自动向后移动
		//不可跳跃增加！比如index 0，1，2，增加一个索引位置4
		al.add(1, "-2");
		System.out.println(al.size());
		 length = al.size();
		for(int i = 0;i < length; i ++)
		{
			System.out.println("index :" + i + " value : " + al.get(i));
		}
		
	}
	
	public static void ALtest2()
	{
		String[] ss = new String[]{"a","b","c"};
		Object[] oo = new Object[3];
		//将ss拷贝到oo中
		System.arraycopy(ss, 0, oo, 0, Math.min(ss.length, oo.length));
		
		System.out.println(Arrays.toString(ss));
		System.out.println(Arrays.toString(oo));
	}
	
	public static void ALtest3()
	{
		Object[] o = (Object[]) Array.newInstance(String.class, 5);
		//将ss拷贝到oo中
		System.out.println(Arrays.toString(o));
	}
}
