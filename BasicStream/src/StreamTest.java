import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//当调用s.count时，Stream在使用，再调用其他涉及到流的方法会报错。
//只要使用一个涉及到STREAM的操作时，该流只能操作一次，然后被废弃。
//但是可以使用新引用，接受产生的新流
public class StreamTest {


	public static void main(String[] args) {

		Stream<String> s,ss,s1,s2,s3,s4,s5,s6,s7;

		
		Predicate<String> p0 = e -> true;
		Predicate<String> p1 = e -> e == "aa";
		Predicate<String> p2 = e -> e == "bb";
		//Predicate<String> p3 = p1.or(p2);
		
		//Function<T,R> R-return
		Function<String,String> f1 = e -> e.toUpperCase();
		
		//创建对象s
		s = CreateStream();
		//流对象s在执行filter后就丢弃不可使用了，但是却创建了新的子流，可使用SS引用接受子流
		ss = s.filter(p0);
	    ShowStream(ss);	
	    CloseStream(ss);
			
		//创建中间对象，以及创建对象s1
	    s1 = FilterStream(CreateStream());
		ShowStream(s1);	
		CloseStream(s1);
		
		//流过滤操作，p2.or(p1)
	    s2 = CreateStream().filter(p2.or(p1));
		ShowStream(s2);	
		CloseStream(s2);
		
		//流map操作，f1
	    s3 = CreateStream().map(f1);
		ShowStream(s3);	
		CloseStream(s3);
		
		//ArrayList转换为Stream
		List<Integer> al = new ArrayList<Integer>();
		Integer[] ii = new Integer[]{1,2,3,4,5,6,7,8,9,10};
		//任意数组转换为List数组
		al = Arrays.asList(ii);
		Comparator<Integer> cp = (a,b) -> (a - b);
		//Terminal处理，采用MAX函数,之后采用ifPresent处理
		al.stream().max(cp).ifPresent(e -> Print(e));
		ShowStream(al.stream());	
		CloseStream(al.stream());
		//取得最大值，如果没有，默认值为-1
		//Print(ol.orElse(-1));
		
		//跳过并限制输出
		s4 = CreateStream().limit(3).skip(1);
		s5 = CreateStream().limit(3).skip(1);
		//组合流
		//distinct去重复
		Comparator c = (a,b) -> (a.hashCode()-b.hashCode());
		//排序
		s6 = Stream.concat(s4, s5).distinct().sorted(c);
		//ShowStream(s6);	
		EachStream(s6);
		CloseStream(s6);
		
		//Peek操作，可以带一个函数接口，可用于DEBUG
		Consumer<? super String> cs = (String e) ->{Print("PEEK: " + e);};
		//terminal操作findFirst
		//还有AnyMatch、AllMatch、NoneMatch等
	    Print(CreateStream().peek(cs).findFirst().get());
	    
	    //将STREAM转换为LIST
	    s7 = CreateStream();
		List<String> ll = s7.collect(Collectors.toList());
	    Print(ll.toString());

	    //reduce
	    //假设reduce的操作是 f()，则对整个流的操作是 i1 f() i2 f() i3 f()...in
	    //该操作与流中元素的位置应该是无关的,遵守自自反性 a f() b <=> b f() a
	    Integer[] ii1 = new Integer[]{1,2,3,4,5,6,7,8,9,10};
	    Optional<Integer> ol = Arrays.asList(ii1).stream().reduce(Integer::sum);
	    //Optional<Integer> ol = Arrays.asList(ii1).stream().reduce((a,b) -> {Print(a + b); return (a+b);});
	    Print(ol.orElse(-1));
	}

	
	public static Stream<String> CreateStream()
	{
		 Stream<String> s;
		//Create Method
		//数组
		String[] ss = new String[]{"a","b","c"};
		 s = Stream.of(ss); 
		
		//数组的另一种形式
		s = Stream.of("aa","bb","cc","aa","11");
		//单类型
		//s = Stream.of("aa");
		//空流
		//s = Stream.empty();
		
		//创建无限流，繁复调用函数产生
		//s = Stream.generate(()->"abc");
		
		//从文件创建流
		//s = Files.lines()
		return s;
	}
	
	//Filter
	public static Stream<String> FilterStream(Stream<String> s)
	{
		return s.filter(e-> e == "aa");
	}
	
	public static void EachStream(Stream<?> s)
	{
		s.forEach(e -> Print(e));
	}
	
	public static void ShowStream(Stream<?> s)
	{
		Print(Arrays.toString(s.toArray()));
		//s.forEach(e -> Print(e));
	}
	
	public static void CloseStream(Stream<?> s)
	{
		s.close();
	}
	
	
	public static void Print(Object e)
	{
		System.out.println(e);
	}
	
	public static void Print(int p)
	{
		System.out.println(p);
	}
	
	public static void Print(Long p)
	{
		System.out.println(p);
	}
}
