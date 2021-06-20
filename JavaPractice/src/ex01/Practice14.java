package ex01;

public class Practice14 {

	public static void main(String[] args) {
		
		System.out.println("실수의 형변환 연습입니다.");
		float f = 9.1234567f;
		double d = 9.1234567;
		double d2 = (double)f;
		
		System.out.printf("f =%20.18f\n",  f);
		System.out.printf("d =%20.18f\n",  d);
		System.out.printf("d2=%20.18f\n", d2);
	}

}
