package ex01;
import java.util.*;

public class Practice100 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
		String[][] words = {
				{"chair", "의자"},
				{"conputer", "컴퓨터"},
				{"integer", "정수"}
		};
		
		for(int i=0;i<words.length;i++) {
			System.out.printf("Q%d. %s의 뜻은?", i+1, words[i][0]);
			
			String tmp = sc.nextLine();
			if(tmp.equals(words[i][1])) {
				System.out.printf("정답입니다.%n%n");
			} else {
				System.out.printf("틀렸습니다. 정답은 %s입니다. %n%n", words[i][1]);
			}
		}
	}

	}
	}
