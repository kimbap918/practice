package ex01;

public class SuperTest2 {
	public static void main(String[] args) {
		Child1 c = new Child1();
		c.method();
	}
}

class Parent1 {
	int x =10;
}

class Child1 extends Parent { 
	int x=20;
	
	void method() {
		System.out.println("x=" + x);
		System.out.println("this.x=" + this.x);
		System.out.println("super.x=" + super.x);
	}
}
