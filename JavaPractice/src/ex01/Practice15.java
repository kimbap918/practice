package ex01;

public class Practice15 {

	public static void main(String[] args) {
		int i = 91234567;
		float f = (float)i;
		int i2 = (int)f;
		
		double d = (double)i;
		int i3 = (int)f;
		
		float f2 = 1.6666f;
		int i4 = (int)f2;
		
		System.out.printf("i=%d\n", i);
		System.out.printf("f=%f i2=%d\n",  f, i2);
		System.out.printf("d=%f i3=%d\n",  d, i3);
		System.out.printf("f2=%f i4=%d\n", f2, i4);
	}

}
