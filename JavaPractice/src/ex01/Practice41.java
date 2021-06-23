package ex01;
import java.util.*;

public class Practice41 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			char ch = ' ';
			
			System.out.printf("문자 및 숫자를 하나 입력하세요.>");
			String input = sc.nextLine();
			ch = input.charAt(0);
			
			if(('ㄱ'<= ch && ch <= 'ㅎ')) {
				System.out.printf("입력하신 문자는 한글입니다.%n");
			
			
			if(('a'<= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z')) {
				System.out.printf("입력하신 문자는 영문자입니다.%n");
				
			if(('0')<= ch && ch <= '9') {
				System.out.printf("입력하신 문자는 숫자입니다.%n");
			}
			}
		}
	}

	}
}
