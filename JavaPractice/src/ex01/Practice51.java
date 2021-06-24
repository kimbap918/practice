package ex01;
import java.util.*;

public class Practice51 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
		System.out.print("당신의 주민번호 뒷자리를 입력하세요.(0123456)>");
		String regNo = sc.nextLine();
		
		char gender = regNo.charAt(0);
		
		switch(gender) {
		case '1': case '3':
			System.out.println("당신은 남자입니다.");
			break;
			
		case '2': case '4':
			System.out.println("당신은 여자입니다.");
			break;
			
		default:
			System.out.println("유효하지 않은 주민등록번호입니다.");
		}
		
	}
	}
}
