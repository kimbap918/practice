package ex01;

import java.util.Scanner;

public class Practice52 {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
		String grade = " ";
		
		System.out.print("당신의 점수를 입력하세요.(1~100)>");
		int score = sc.nextInt();
		
	
		switch(score/10) {
		case 10: case 9:
			grade = "A";
			break;
		case 8: case 7:
			grade = "B";
			break;
		case 6:
			grade = "C";
			break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			grade = "F";
			break;
		default :
			grade = "null";
			System.out.println("유효하지 않은 값입니다.");
			break;
		}
		System.out.println("당신의 성적은 "+ grade +"입니다.");
	}
	}
}
