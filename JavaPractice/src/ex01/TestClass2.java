package ex01;

public class TestClass2 {
	int iv = 10;
	static int cv = 20;
	
	void instanceMethod() {
		System.out.println(iv);
		System.out.println(cv);
	}
	
	static void staticMethod() {
		//System.out.prontln(iv); 인스턴스 변수는호출할수 없다.
		System.out.println(cv);
	}
	
	public static void main(String[] args) {
		TestClass2 t = new TestClass2();
		System.out.println(t.iv); //객체 생성 후에 인스턴스변수 참조 가능.
	}
}
