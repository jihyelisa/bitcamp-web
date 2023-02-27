package operator;

public class Boxing {

	public static void main(String[] args) {
		
		int a = 25;
		double b = (double)a / 3; //Casting, 강제형변환/자동형변환
		
		String c = "25";
//		int d = (int)c; //에러: 객체형을 기본형으로 강제형변환 불가
		int d = Integer.parseInt(c);
		
		int e = 5;
		Integer f = new Integer(e); ///JDK 5.0 이전에 기본형 > 객체형 형변환하던 방법
		Integer f = e; //JDK 5.0부터 AutoBoxing 가능 (그냥 넣으면 자동으로 형변환)
		
		Integer g = 5;
		int h = g.intValue(); //JDK 5.0 이전
		int h = g; //unAutoBoxing (객체형 > 기본형)
	}
}
