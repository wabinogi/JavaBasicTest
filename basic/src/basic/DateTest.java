package basic;

import java.io.*;
import java.time.LocalDate;
public class DateTest {

	public static void main(String[] args)
	{
		//LocalDate.now初始化
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		//LocalDate.of初始化
		LocalDate ld1 = LocalDate.of(1999, 12, 24);
		System.out.println(ld1);
		
		//方法测试
		System.out.println(ld1.getDayOfMonth());
		System.out.println(ld1.getDayOfWeek());
		System.out.println(ld1.plusDays(100).getMonthValue());
		System.out.println(ld1);
		
	}
}
