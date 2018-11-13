package basic;

public class SpecialSyntax {
	static {
		System.out.println(Math.pow(2.0D, 3.0D));
	}

	public SpecialSyntax() {
		System.out.println("last structure");
	}

	public static void main(String[] args) {
		new SpecialSyntax();
	}
	
	/* System error message output 
	 * Java MyProgram 2> error.txt
	 * 
	 * System out and error message output 
	 * Java MyProgram 1> error.txt 2>&1
	 * 
	 * show all class invokcation path
	 * Java -verbose MyProgram
	 * 
	 * Show all method invokcation statistic
	 * Java -Xprof MyProgram
	 */
	 
}