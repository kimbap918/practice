package ex01;

class MyMath1 {
	long a, b;
	
	long add() {return a+b;}
	long substract() {return a-b;}
	long multiply() {return a*b;}
	double divide() {return a/b;}
	
	static long add(long a, long b) {return a+b;}
	static long substract(long a, long b) {return a-b;}
	static long multiply(long a, long b) {return a*b;}
	static double divide(double d, double e) {return d/e;}
}

public class StaticTest {

	public static void main(String[] args) {
		System.out.println(MyMath1.add(200L, 100L));
		System.out.println(MyMath1.substract(200L, 100L));
		System.out.println(MyMath1.multiply(200L, 100L));
		System.out.println(MyMath1.divide(200.0, 100.0));
		
		MyMath1 mm = new MyMath1(); // 인스턴스를 생성
		mm.a = 200L;
		mm.b = 100L;
		System.out.println(mm.add());
	//	System.out.println(add()); 인스턴스메서드는 객체생성 후에만 호출 가능.
	//	The method add() is undefined for the type StaticTest
		System.out.println(mm.substract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
	}

}
