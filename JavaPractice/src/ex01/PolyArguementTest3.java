package ex01;
import java.util.*;

class Product3 {
	int price;
	int bonusPoint;
	
	Product3(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	
	Product3() {
		price = 0;
		bonusPoint = 0;
	}
}

class Tv7 extends Product3 {
	Tv7() { super(100); }
	public String toString() { return "Tv7"; }
}

class Computer1 extends Product3 {
	Computer1() { super(200); }
	public String toString() { return "Computer1"; }
}

class Audio2 extends Product3 {
	Audio2() { super(50); }
	public String toString() { return "Audio2"; }
}

public class PolyArguementTest3 {
	public static void main(String[] args) {

	}
}
