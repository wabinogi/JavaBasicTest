import java.io.*;


public class StringBuilderTest {
 
	public static void main(String[] args)
	{
		SbTest1();
		//SbTest2();
		
	}

	public static void SbTest2()
	{
		String a = "\uD835\uDD6B";
		String b = new String(a.codePoints().toArray(),0,1);
		System.out.println(a.length());	
		System.out.println(a.codePointCount(0, 1));
		System.out.println(a.codePointAt(0));
		System.out.println(a);
	}
	
	public static void SbTest1()
	{
		//��1.5�У�������ǰ����StringBuffer������������ڴӼ��̶���û��ַ����ݻ�ȡ���롣
		//�൱��һ��BUFFER�����ͨ��TOSTRING����һ����д��һ���¹�����STRING�������С�
		//��ɲ��ô�ͳ��STRING���ӣ�+����ʽ��+�Ĺ����лṹ�����STRING����Ч�ʵ���
		StringBuilder sb = new StringBuilder();
		//sb.append("\uD835\uDD6B");
		sb.append("12");
		//����sb�������ַ�����code units,��code point
		System.out.println(sb.length()); 
		
		//unicode 97��ʾ����a����������a
		sb.appendCodePoint(97);
		System.out.println(sb.toString());
		
		//�ڵ�N��code unitλ�ò����ַ��������ַ������
		sb.insert(3, "c");
		System.out.println(sb.toString());
		
		
	
		
	}
}
