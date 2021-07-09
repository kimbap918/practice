package ex01;

public class TestClass {
	void instanceMethod() {}
	static void staticMethod() {}
	
	void instanceMethod2() {
		instanceMethod();
		staticMethod();
	}
	
	static void staticMethod2() {
		//instanceMethod(); 인스턴스 메서드는 호출할수 없다.
		staticMethod();
	}

	}

