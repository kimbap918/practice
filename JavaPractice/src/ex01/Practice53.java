package ex01;

import java.util.Scanner;

public class Practice53 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("당신의 주민번호 뒷자리를 입력하세요.>");
			String regNo = sc.nextLine();
			char gender = regNo.charAt(0);
			
			switch(gender) {
			case '1': case '3':
				switch(gender) {
					case '1':
						System.out.println("당신은 2000년 이전에 출생한 남자입니다.");
						break;
				}
				switch(gender) {
					case '3':
						System.out.println("당신은 2000년 이후에 출생한 남자입니다.");
						break;
				}
			case '2': case '4':
				switch(gender) {
					case '2':
						System.out.println("당신은 2000년 이전에 출생한 여자입니다.");
						break;
				}
				switch(gender) {
					case '4':
						System.out.println("당신은 2000년 이후에 출생한 여자입니다.");
						break;
			}
				break;
				
				
			default :
				System.out.println("유효한 값을 입력해주세요.");
				break;
		}
	}
	}
}
