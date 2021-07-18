package ex01;

public class InstanceofTest {
	public static void main(String[] args) {
		FireEngine2 fe = new FireEngine2();
		
		if(fe instanceof FireEngine2) {
			System.out.println("This is a FireEngine instance.");
		}
		
		if(fe instanceof Car5) {
			System.out.println("This is a Car5 instance.");
		}

		if(fe instanceof Object) {
			System.out.println("This is an Object instance.");
		}
		
		System.out.println(fe.getClass().getName());
	}

}

class Car5 { }
class FireEngine2 extends Car5 { }
