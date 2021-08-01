package ex01;

public class InnerEx3 {
	private int outerIv = 0;
	static int outerCv = 0;
	
		class InstanceInner {
			int iiv = outerIv;
			int iiv2 = outerCv;
		}
		
		static class StaticInner {
			// int cv = outerIv; 불가능. static class는 외부 클래스의 인스턴스에 접근 불가능하다.
			static int scv = outerCv;
		}
		
		void myMethod() {
			int lv = 0;
			final int LV = 0;
			
			class LocalInner {
				int liv = outerIv;
				int liv2 = outerCv;
				int liv3 = lv;
				int liv4 = LV;
			}
		}
}
