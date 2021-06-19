package ex01;

public class Practice2 {
	public static void main(String[]args) {
		int x = 0, y = 10;
		int tmp = 0;
		
		System.out.println("x:" + x + "y:" + y);
		
		tmp = x;
		x = y;
		y = tmp;
		
		System.out.println("x:" + x + "y:" + y);
		
		
	}
}
