package ex01;
import java.util.*;

public class Practice66 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
		int num = 0, sum = 0;
		System.out.print("숫자를 입력하세요.(예:12345)>");
		String tmp = sc.nextLine();
		num = Integer.parseInt(tmp);
		
		while(num!=0) {
			sum += num%10;
			System.out.printf("sum=%3d num=%d%n",  sum, num);
			
			num /= 10;
		}
		
		System.out.println("각 자리수의 합:"+sum);
		}
	}

}
