import java.util.ArrayDeque;
import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		
		Stack s = new Stack();
		s.push("a");
		s.push("b");
		s.push("c");
		s.push("d");
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.pop();
		System.out.println(s);
		s.peek();
		System.out.println(s);
		System.out.println(s.search("b"));
		
	}

	
}
