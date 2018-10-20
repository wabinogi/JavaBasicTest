package basic;

import java.io.*;
import java.util.*;
  

public class CollectionTest {
	
	public static void main(String[] args)
	{
		System.out.print("S\r");
		String[] aa = new String[10];
		aa[0]="1";
		
		IteratorTest<String> it = new IteratorTest<String>("1");
		
		
		System.out.println(it.hasNext());
		System.out.println(it.next());
		//dd
	}

}
