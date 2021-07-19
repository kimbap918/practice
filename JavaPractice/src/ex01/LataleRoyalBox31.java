package ex01;

class S {
	static String ShinChuk = "신축이";
	static String Rex = "렉스";
	static String Ratcci = "랫찌";
	static String Happy = "해피";
	static String SweetHairCoupon = "스위트 헤어 쿠폰";
	static String ShynicClothBox = "샤이닉 의상 상자";
	static String HappyNewYearTitle_2021 = "2021 해피 뉴 이어 타이틀";

}

public class LataleRoyalBox31 extends S {
	public static void main(String[] args) {
			int random = 0;
			random = (int)(Math.random()*7)+1;
			System.out.print("시스템 메세지 : ");
		switch(random) {
		
		case 1: 
			System.out.println("준긴잉 님께서 " + S.ShinChuk + "을(를) 획득하였습니다.");
			break;
		case 2:
			System.out.println("준긴잉 님께서 " + S.Rex + "을(를) 획득하였습니다.");
			break;
		case 3:
			System.out.println("준긴잉 님께서 " + S.Ratcci + "을(를) 획득하였습니다.");
			break;
		case 4:
			System.out.println("준긴잉 님께서 " + S.Happy + "을(를) 획득하였습니다.");
			break;
		case 5:
			System.out.println("준긴잉 님께서 " + S.SweetHairCoupon + "을(를) 획득하였습니다.");
			break;
		case 6:
			System.out.println("준긴잉 님께서 " + S.ShynicClothBox + "을(를) 획득하였습니다.");
			break;
		case 7:
			System.out.println("준긴잉 님께서 " + S.HappyNewYearTitle_2021 + "을(를) 획득하였습니다.");
			break;
		default :
			System.out.println("잘못된 시도입니다.");
			
			}
		}
	

}
