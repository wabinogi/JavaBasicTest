import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//被表示为transient的变量，不会被序列化。例如：一些本地化方法的句柄地址等。
public class ObjectStreamTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
        //test1();
        test2();
	}

	static public void test1() throws IOException, ClassNotFoundException
	{
		ObjectSeriable os = new ObjectSeriable();
		os.SetAge("30");
		os.SetName("wabinogi");
		
		//序列化写入文件
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("wabinogi.txt")))
		{
			out.writeObject(os);
		}
		System.out.println(System.getProperty("user.dir"));
		
		//序列化读出文件
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("wabinogi.txt")))
		{
			ObjectSeriable nos = (ObjectSeriable)in.readObject();
			System.out.println(nos.GetName() + nos.GetAge());
		}
	}
	
	static public void test2() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		ObjectSeriableEnum o1 =  ObjectSeriableEnum.OSE1;
		ObjectSeriableEnum o11 =  ObjectSeriableEnum.OSE1;
		if(o11 == o1)
		{
			System.out.println("OK!");
		}
		
		
		//序列化写入文件
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.txt")))
		{
			out.writeObject(o1);
			out.close();
		}
		
		
		//序列化读出文件
		ObjectSeriableEnum no1;
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.txt")))
		{
			 no1 = (ObjectSeriableEnum)in.readObject();
			System.out.println(no1.GetName());
			in.close();
		}
		
		if(no1 == ObjectSeriableEnum.OSE1)
		{
			System.out.println("Equal!");
		}
		else
		{
			System.out.println("Not Equal!");
		}
	}
	
}
