import java.util.ArrayList;
import java.util.*;

public class ArraylistTest {
	
	
	public static void main(String[] args)
	{ 
		//ARRAYLISTЧ�ʱ�����ͣ�ɾ��һ��Ԫ�أ����к����Ԫ�ػ�ǰ��
		arrayListT1();
		arrayListT2();
		arrayListT3();
	}
	

	public static void arrayListT3()
	{
		System.out.println("__________________T3");
		String[] ss = new String[3];
		ArrayList<String> al = new ArrayList();
		al.add("a");al.add("b");
		//ArrayListת��String[]
		al.toArray(ss);
		System.out.println(Arrays.toString(ss));
	}
	public static void arrayListT2()
	{
	    String[] ss  = new String[40];
	    //�Ѿ��и�40����λ
	    System.out.println(ss.length);
	    
		//��������100����λ��Ǳ����
		ArrayList<String> as = new ArrayList<>(100);
		//ArrayList�Ǳ߳��ģ���ʼֵ��10����С
		//��ָ��ensureCapacityʱ��ÿ�β������飬���ܻᵼ������Ƶ�������ݡ�COPY�����������½�
		//ensureCapacity��20������ʾ�ڴ��������ÿ��׷��20����λ
		as.ensureCapacity(1);
        
	}
	
	public static void arrayListT1()
	{
		//ArrayList��ʼ�����ַ���
		ArrayList<String> as = new ArrayList<>();
		ArrayList<String> as1 = new ArrayList<>(5);
		ArrayList<HashcodeTest> aht = new ArrayList<>();
		
		//as1��ʼ��5����λ����ʵ��sIZE��0
		System.out.println(as1.size());
		as1.add("a");
		//replace index 0 content
		as1.set(0, "b");
		
		//������0��ʼ
		aht.add(0,new HashcodeTest());
		
		System.out.println(as.size());
		//���Ӻ�Ϊ1
		System.out.println(as1.size() + ": "+as1.toString());
		
		System.out.println(aht.size() + ": "+aht.toString());
		
	}
}
