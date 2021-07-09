package ex01;

public class RecursiveCall {

	public static void main(String[] args) {
		int result = factorial(12);
		System.out.println(result);
	}
	
	static int factorial(int n) {
		int result=0;
		System.out.println(n);
		
		if(n <=0 || n > 12) return -1;
		if(n==1)
			result = 1;
		else
			result = n * factorial(n-1);
		
		return result; 
		
		// static int factorial(int n) {
		//	if(n==1) return 1
		//	retrun n * factorial(n-1);
		//	}
	}

}
