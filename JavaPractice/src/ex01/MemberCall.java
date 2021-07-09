package ex01;

public class MemberCall {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	//static int cv2 = iv; 클래스변수는 인스턴스변수를 사용할수 없다.
	static int cv2 = new MemberCall().iv; // 객체 생성후 사용가능.
	
	static void staticMethod() {
		System.out.println(cv);
		//System.out.println(iv); 클래스메서드에서 인스턴스변수 사용 불가능.
		MemberCall  m = new MemberCall();
		System.out.println(m.iv); // 객체 생성후 사용가능.
	}
	
	void instanceMethod() {
		System.out.println(iv); //인스턴스메서드에서는 인스턴스변수 바로 사용가능.
		System.out.println(cv);
	}
	
	static void staticMethod2() {
		staticMethod();
		//instanceMethod(); 클래스메서드에서는 인스턴스메서드를 호출할수 없음.
		MemberCall m = new MemberCall();
		m.instanceMethod(); //인스턴스 생성 후 호출가능.
	}
	
	void instanceMethod2() {
		staticMethod();
		instanceMethod();
	}
		
	public static void main(String[] args) {
		staticMethod();
		MemberCall m = new MemberCall();
		m.instanceMethod();
	}

}
