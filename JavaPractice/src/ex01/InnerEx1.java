package ex01;

public class InnerEx1 {
	class InstanceInner {
		int iv = 100;
		final static int CONST = 100;
		//static int cv = 100; static 변수 선언 불가능
	}
	
	static class StaticInner {
		int iv = 200;
		static int cv = 200; // static 클래스만 static 멤버 정의가능
	}
	
	void myMethod() {
		class LocalInner {
			int iv =300;
			final static int CONST = 300;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(InstanceInner.CONST);
		System.out.println(StaticInner.cv);
	}

}
