package ex01;

public class ConstructorTest {
	public static void main(String[] args) {
		DataEx1 d1 = new DataEx1();
		DataEx2 d2 = new DataEx2(10); // 기본생성자 이외에 생성자가 있으면
									// 컴파일러가 자동으로 기본생성자를 만들지 않음.
	}
}	
	class DataEx1 {
		int value;
	}

	class DataEx2 {
		int value;
		
		DataEx2(int x) {
			value = x;
		}
	}

