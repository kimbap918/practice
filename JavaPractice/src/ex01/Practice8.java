package ex01;

public class Practice8 {

	public static void main(String[] args) {
		char ch = 'A';
		int code = (int)ch;
		
		System.out.println("형변환 연습입니다.");
		System.out.printf("%c=%d(%#X)%n", ch, code, code);
		
		char hch = '가';
		System.out.printf("%c=%d(%#X)%n",  hch, (int)hch, (int)hch);
		
	}

}
