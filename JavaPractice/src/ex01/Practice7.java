package ex01;
import java.util.*;

public class Practice7 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("입력기 연습입니다.");
			System.out.print("두자리 정수 중 하나 입력해주세요.>");
			String input = sc.nextLine();
			int num = Integer.parseInt(input);
			
			System.out.println("입력내용 : " + input);
			System.out.printf("num=%d%n",  num);
		}
		
	}
}
