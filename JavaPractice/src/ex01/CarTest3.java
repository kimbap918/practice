package ex01;

class Car3 {
	String color;
	String gearType;
	int door;
	
	Car3() {
		this("white", "auto", 4);
	}
	
	Car3(Car3 c) {
		this(c.color, c.gearType, c.door);
		System.out.printf("Car3(Car3 c)의 색상=%s, 기어=%s, 문=%d%n", c.color, c.gearType, c.door);
	}
	
	Car3(String color, String gearType, int door) {
		this.color = color;
		this.gearType = gearType;
		this.door = door;
		System.out.printf("Car3(String color, String gearType, int door)의 색상=%s, 기어=%s, 문=%d%n", this.color, this.gearType, this.door);

	}
}

public class CarTest3 {
	public static void main(String[] args) {
		Car3 c1 = new Car3();
		Car3 c2 = new Car3(c1);
		
		System.out.println("c1의 color=" + c1.color +", gearType=" + c1.gearType+ ", door="+c1.door);
		System.out.println("c2의 color=" + c2.color +", gearType=" + c2.gearType+ ", door="+c2.door);
		c1.door=100;
		System.out.println("c1.door=100; 수행후");
		System.out.println("c1의 color="+ c1.color + ", gearType="+ c1.gearType+ ", door="+c1.door);
		System.out.println("c2의 color="+ c2.color + ", gearType="+ c2.gearType+ ", door="+c2.door);


	}

}
