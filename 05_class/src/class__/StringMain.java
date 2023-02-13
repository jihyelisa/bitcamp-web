package class__;

public class StringMain {
	
	public static void main(String[] args) {
		//모든 클래스는 사용할 때 new 생성해야 하지만 String만 유일하게 literal 생성이 가능
		String a = "apple"; //메모리 heap 영역에 "apple" 문자열 생성, a에는 주소 저장
		String b = "apple"; //a와 같은 "apple"에의 주소 저장
		if(a==b) System.out.println("a와 b의 참조값이 같다.");
		else System.out.println("a와 b의 참조값이 다르다.");
		if(a.equals(b)) System.out.println("a와 b의 문자열이 같다.\n");
		else System.out.println("a와 b의 문자열이 다르다.\n");

		String c = new String("apple"); //new로 새 클래스 생성 했으므로 다른 주소, 다른 메모리
		String d = new String("apple"); //c와 마찬가지
		if(c==d) System.out.println("c와 d의 참조값이 같다.");
		else System.out.println("c와 d의 참조값이 다르다.");
		if(c.equals(d)) System.out.println("c와 d의 문자열이 같다.\n");
		else System.out.println("c와 d의 문자열이 다르다.\n");
		
		//문자열은 한 번 만들면 수정할 수 없다.
		String e = "오늘 날짜는 " + 2023 + 2 + 10; //메모리에 4번의 생성이 일어난다.
		//나중에 필요 없는 메모리가 garbage collector로 넘어갔다가 JVM이 소멸시킴
		//삭제되는 동안에는 컴퓨터 프로세서가 멈춤!
		System.out.println(e);
		
		System.out.println("문자열 크기 = " + e.length());
		
		for (int i=0; i<e.length(); i++) {
			System.out.println(i + " : " + e.charAt(i));
		} //for

		System.out.println("부분 문자열 추출 = " + e.substring(7)); //숫자 하나만 쓰면 해당 인덱스부터 끝까지
		System.out.println("부분 문자열 추출 = " + e.substring(7, 11));
		
		System.out.println("대문자 변경 = " + "Hello".toUpperCase());
		System.out.println("소문자 변경 = " + "Hello".toLowerCase());

		System.out.println("문자열 검색 = " + e.indexOf("짜"));
		System.out.println("문자열 검색 = " + e.indexOf("날짜"));
		System.out.println("문자열 검색 = " + e.indexOf("바부")); //-1
		
		System.out.println("문자열 치환 = " + e.replace("날짜", "일자"));
	}
}
