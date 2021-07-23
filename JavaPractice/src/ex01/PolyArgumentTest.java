package ex01;

class Product2 {
	int price;
	int bonusPoint;
	
	Product2(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}
	Product2() {}
}

class Tv6 extends Product2 {
	Tv6() { super(100); }
	public String toString() { return "Tv"; }
}

class Computer extends Product2 {
	Computer() { super(200); }
	public String toString() { return "Computer"; }
}

class Audio1 extends Product2 {
	Audio1() { super(50); }
	public String toString() { return "Audio"; }
}

class Buyer {
	int money = 1000;
	int bonusPoint = 0;
	Product2[] item =  new Product2[10];
	int i =0;
	
	void buy(Product2 p) {
		if(money <p.price) {
			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
			return;
		}
		
		money -= p.price;
		bonusPoint += p.bonusPoint;
		item[i++] = p;
		System.out.println(p + "을/를 구입하셨습니다.");
	}

void summary() {
	int sum = 0;
	String itemList = "";
	
	for(int i =0;i<item.length;i++) {
		sum += item[i].price;
		itemList += item[i] + ", ";
	}
	System.out.println("구입하신 물품의 총 금액은 " + sum + "만원입니다.");
	System.out.println("구입하신 제품은 " + itemList + "입니다.");
	}
}
class PolyArgumentTest {
	public static void main(String[] args) {
		
		Buyer b = new Buyer();
		
		b.buy(new Tv6());
		b.buy(new Computer());
		b.buy(new Audio1());
		b.summary();
		
	}
}
