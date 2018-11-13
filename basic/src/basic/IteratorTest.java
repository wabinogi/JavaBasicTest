package basic;

import java.util.*;
  

public class IteratorTest<E> implements Iterator<E>{
	
	private E ee;
	
	public  IteratorTest()
	{
				
	}
	
	public  IteratorTest(E e)
	{
		this.ee = e;
		
	}
	
	
	public boolean hasNext()
	{ 

		if (ee instanceof String) {
			return true;  
		}
		
		if (ee instanceof Double) {
			return true;  
		}
	

		if (ee instanceof Integer) {
			return true;  
		}
	
		return false;
	}

	public E next()
	{
		return ee;
	}
	
	public void remove()
	{
		
		return;
	}
}
