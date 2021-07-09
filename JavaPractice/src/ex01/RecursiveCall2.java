package ex01;

import java.util.*;

public class RecursiveCall2 {
	static long factorial(int n) {
		if (n <= 0 || n > 20)
			return -1;
		if (n <= 1)
			return 1;
		return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("factorial 값을 구할 정수를 입력해주세요(20이하).>");
			int n = sc.nextInt();
			long result = 0;

			for (int i = 1; i <= n; i++) {
				result = factorial(i);

				if (result == -1) {
					System.out.println("유효하지 않은 값입니다.");
					break;
				}

				System.out.printf("%2d!=%20d%n", i, result);
			}
		}
	}
}
