package ex01;

public class Practice13 {

	public static void main(String[] args) {
		System.out.println("정수형의 형변환 연습입니다.");
		
		
		int i = 10;
		byte b = (byte)i;
		System.out.printf("[int] -> [byte] i=%d -> b=%d%n", i, b);
		
		System.out.println("i="+Integer.toBinaryString(i));

		
		i = 300;
		b = (byte)i;
		System.out.printf("[int] -> [byte] i=%d -> b=%d%n", i, b);
		
		System.out.println("i="+Integer.toBinaryString(i));

		b = 10;
		i = (int)b;
		System.out.printf("[byte] -> [int] b=%d -> i=%d%n", b, i);
		
		System.out.println("i="+Integer.toBinaryString(i));

		
		b = -2;
		i = (int)b;
		System.out.printf("[byte] -> [int] b=%d -> i=%d%n", b, i);
		
		System.out.println("i="+Integer.toBinaryString(i));
		
	}

}
