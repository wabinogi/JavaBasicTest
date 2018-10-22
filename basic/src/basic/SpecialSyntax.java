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
}