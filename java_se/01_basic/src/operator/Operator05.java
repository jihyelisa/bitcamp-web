package operator;

public class Operator05 {

	public static void main(String[] args) {
		
		boolean a = 25 > 36;
		System.out.println("a = " + a);
		System.out.println("!a = " + !a);
		
		String b = new String("apple");
		String c = "apple";
		String d = "apple";
		//String 클래스는 문자열 literal 생성이 가능
		//사용하기 위해 new 생성할 필요 없음
		
		String result1 = b == c ? "같다" : "다르다"; //다르다
		String result2 = c == d ? "같다" : "다르다"; //같다
		//b, c 같은 내용의 문자열이지만 메모리상에 저장된 주소가 다르다.
		//c는 그냥 문자열 literal인 "apple" 데이터에 연결되어 있고
		//b는 new로 생성한 String 클래스 안의 "apple"에 연결되어 있다.
		
		String result3 = b.equals(c) ? "같다" : "다르다"; //같다
		//.equals()를 쓰면 주소가 아닌 내용의 일치 여부를 확인한다.
		
		System.out.println("!b.equals(c): " + ((!b.equals(c) ? "참" : "거짓")));
	}
}
