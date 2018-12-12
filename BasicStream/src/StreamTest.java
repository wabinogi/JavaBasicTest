import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//当调用s.count时，Stream在使用，再调用其他涉及到流的方法会报错。
public class StreamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateStream();
	}

	
	public static void CreateStream()
	{
		//Create Method
		//数组
		String[] ss = new String[]{"a","b","c"};
		Stream<String> s = Stream.of(ss); 
		
		//数组的另一种形式
		s = Stream.of("aa","bb","cc");
		//单类型
		//s = Stream.of("aa");
		//空流
		//s = Stream.empty();
		
		//创建无限流，繁复调用函数产生
		//s = Stream.generate(()->"abc");
		
		//从文件创建流
		//s = Files.lines()
		
		ShowStream(s);
		
		s.close();
	}
	
	public static void CreateNewStream(Stream s)
	{
		Stream<String> s2 = s.filter(predicate)
	}
	
	public static void ShowStream(Stream s)
	{
		Print(Arrays.toString(s.toArray()));
	}
	
	
	public static void Print(String p)
	{
		System.out.println(p);
	}
	
	public static void Print(Long p)
	{
		System.out.println(p);
	}
}
