package ex01;

public class Practice24 {

	public static void main(String[] args) {
		int a = 1_000_000;
		int b = 2_000_000;
		
		long c = a * b;
		long d = (long)a * b;
		
		System.out.println(c);
		System.out.println(d);
	}

}
