package ex01;
import java.util.*;

public class Practice50 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요.>");
			
			int user = sc.nextInt();
			int com = (int)(Math.random()*3)+1;
			
			switch(user) {
			case 1:
			System.out.println("당신은 가위입니다.");
			break;
			
			case 2:
			System.out.println("당신은 바위입니다.");
			break;
		
			case 3:
			System.out.println("당신은 보입니다.");

			}
			
			switch(com) {
			case 1:
			System.out.println("com은 가위입니다.");
			break;
			
			case 2:
			System.out.println("com은 바위입니다.");
			break;
		
			case 3:
			System.out.println("com은 보입니다.");	
			
			}
			
			switch(user-com) {
			case 2: case -1:
				System.out.println("당신이 졌습니다.");
				break;
				
			case 1: case -2:
				System.out.println("당신이 이겼습니다.");
				break;
				
			case 0:
				System.out.println("비겼습니다.");
				break;
			}
		}
	}

}
