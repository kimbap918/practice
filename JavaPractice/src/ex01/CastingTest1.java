package ex01;

public class CastingTest1 {

	public static void main(String[] args) {
		Car4 car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;
		fe2 = (FireEngine)car;
		fe2.water();
	}
}

class Car4 {
	String color;
	int door;
	
	void drive() {
		System.out.println("drive");
	}
	
	void stop() {
		System.out.println("stop");
	}
	
}

class FireEngine extends Car4 {
	void water() {
		System.out.println("water");
	}
}
