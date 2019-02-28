import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;

public class ArraylistTest {
	
	public static void main(String[] args)
	{ 
		//ARRAYLISTЧ�ʱ�����ͣ�ɾ��һ��Ԫ�أ����к����Ԫ�ػ�ǰ��
		arrayListT1();
		arrayListT2();
		arrayListT3();
		arrayListT4();
	}
	
	public static void arrayListT4()
	{
		System.out.println("__________________T4");
		//����5������
		Wabinogi[] wi = new Wabinogi[5];
		//�������������ͣ�����Ϊ��
		//System.out.println(wi[0].money);
		
		//cl.getComponentType()����ȷ�����������
		System.out.println(wi.getClass().getComponentType());
		//���ʹ���Array.newInstance���г�ʼ��,���getComponentType���ص����������ͣ����ʼ������ֻ�����ã�ֵΪnull
		Object ob = Array.newInstance(wi.getClass().getComponentType(), 5);
		//ʹ�û�������int.class�������з��ص�ֵΪ0����סintegerΪint�İ�װ��
		Object ib = Array.newInstance(int.class, 5);
		System.out.println(((int[])ib)[1]);
	
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
