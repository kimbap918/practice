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

class Buyer2 {
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector();
	
	void buy(Product3 p) {
		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item.add(p);
		System.out.println(p + "을/를 구입하셨습니다.");
	}
	
	void refund(Product3 p) {
		if(item.remove(p)) {
			money += p.price;
			bonusPoint -= p.bonusPoint;
			System.out.println(p + "을/를 반품하셨습니다.");
		} else {
			System.out.println("구입하신 제품 중 해당 제품이 없습니다.");
		}
	}
	
	void summary() {
		int sum = 0;
		String itemList = "";
		
		if(item.isEmpty()) {
			System.out.println("구입하신 제품이 없습니다.");
			return;
		}
		
		for(int i =0;i<item.size();i++) {
			Product3 p = (Product3)item.get(i);
			sum += p.price;
			itemList += (i==0) ? "" + p : ", " + p;
		}
		System.out.println("구입하신 물품의 총금액은 " + sum + "만원입니다. ");
		System.out.println("구입하신 제품은 " + itemList  + "입니다. ");
	}
}

public class PolyArguementTest3 {
	public static void main(String[] args) {
		Buyer2 b = new Buyer2();
		Tv7 tv = new Tv7();
		Computer1 com = new Computer1();
		Audio2 audio = new Audio2();
		
		b.buy(tv);
		b.buy(com);
		b.summary();
		System.out.println();
		b.refund(com);
		b.summary();
	}
}
