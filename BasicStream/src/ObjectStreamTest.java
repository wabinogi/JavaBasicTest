import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

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

	
}
