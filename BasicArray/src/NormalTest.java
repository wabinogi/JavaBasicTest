import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class NormalTest {

	public static void main(String[] args)
	{ 
		//��ʼ������12
		int[] ii = {1,2,3,4,5};
		//��ʼ������2��Ĭ�ϸ�ֵΪ0
		int[] kk = new int[5];
		
		int[] jj = ii;
		//�޸�jjҲ���޸�ii��ֵ
		jj[4] = 10;
		
		//Arrays.copyOf��������ֵ���飬�������ԭ���鳤�ȣ������Ϊ0��С�ڵĻ��ᱻ����
		int[] zz = Arrays.copyOf(ii, 10);
		
		//����Arrays.toString()�������
		System.out.println(Arrays.toString(ii));
		System.out.println(Arrays.toString(jj));
		System.out.println(Arrays.toString(kk));
		System.out.println(Arrays.toString(zz));
		
		//���ڽ�����ڵ�����������������args
		System.out.println(Arrays.toString(args));
		
		int[] aa = {7,6,5,4,3,2,1};
		System.out.println(Arrays.toString(aa));
		//�Ż����������㷨�������������
		Arrays.sort(aa);
		System.out.println(Arrays.toString(aa));
		
		//�ö��ַ����ң���������ֵ
		System.out.println(Arrays.binarySearch(aa, 3));
	}
}
