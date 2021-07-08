package ex01;

class Data2 {int x;}

public class ReferenceReturnEx {
	public static void main(String[] args) {
		Data2 d = new Data2();
		d.x = 10;
		
		Data2 d2 = copy(d);
		System.out.println("d.x ="+d.x);
		System.out.println("d2.x ="+d2.x);
	}
	
	static Data2 copy(Data2 d) {
		Data2 tmp = new Data2();
		tmp.x = d.x;
		return tmp;
	}

}
