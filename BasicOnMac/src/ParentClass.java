import java.sql.SQLException;

public class ParentClass {

	public void Parent()
	{
		System.out.println("Parent");
	}
	
	//throws Exception表示GetExp方法会抛出异常，并且会向外部调用者传递，需要配合new SQLException()
	public void GetExp(int i) throws Exception
	{
		try
		{
			//大于0抛出一个异常
			if(i>0) throw new Exception();
			else System.out.println("Is ok !");
		}
		catch(Exception e)
		{
			//异常处理
			System.out.println("Exp catched !");
			//处理完成后可以再次抛出新类型的异常！
			throw new SQLException();
		}
	}
	
	//同上
	public static void main(String...args) throws Exception 
	{
		try{
		new ParentClass().GetExp(1);
		}
		catch(Exception e)
		{
			System.out.println("Exp catched in main!");
			throw e;
		}
		
	}
	
}
