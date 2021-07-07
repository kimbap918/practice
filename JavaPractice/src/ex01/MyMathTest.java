package ex01;

public class MyMathTest {
	public static void main(String[] args) {
		MyMath mm = new MyMath();
		long result = mm.add(5L, 3L);
		long result1 = mm.substract(5L, 3L);
		long result2 = mm.multiply(5L, 3L);
		double result3 = mm.divide(5.0, 3.0);
		
		System.out.println("add(5L, 3L) = " + result);
		System.out.println("substact(5L, 3L) = " + result1);
		System.out.println("multiply(5L, 3L) = " + result2);
		System.out.println("devide(5.0, 3.0) = " + result3);
	}

}

class MyMath {
	long add(long a, long b) {
		long result = a+b;
		return result;
		// return a+b;
	}
	
	long substract(long a, long b) {return a - b;}
	long multiply(long a, long b) {return a + b;}
	double divide(double a, double b) {return a / b;}
}