package ex01;

public class Practice88 {

	public static void main(String[] args) {
		String[] names = {"kim", "park", "lee"};
		
		for(int i=0;i<names.length;i++)
			System.out.println("names["+i+"]:"+names[i]);
		
		String tmp = names[2];
		System.out.println("tmp:"+tmp);
		names[0] = "yu";
		
		for(String str: names)
			System.out.println(str);
	}

}
