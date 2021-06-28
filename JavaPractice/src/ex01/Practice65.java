package ex01;

public class Practice65 {

	public static void main(String[] args) {
		int i =11;
		
		System.out.println("카운트 다운을 시작합니다.");
		
		while(i--!=0) {
			System.out.println(i);
			for(Long j=0L;j<2_000_000_000L;j++) {
				;
			}
		}
		System.out.println("GAME OVER");
	}

}
