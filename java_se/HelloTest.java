class HelloTest {
	public static void main(String[] args){
		System.out.print("안녕하세요\n");
		System.out.print("반갑습니다\n");
		System.out.println(25 + 3);
		System.out.println("25 + 3");
		System.out.println("25" + "3");
		System.out.println("25 + 3 = " + 25 + 3);
		System.out.println("25 + 3 = " + (25 + 3));
		System.out.println("25 / 3 = " + (25 / 3));  // 정수 / 정수
		System.out.println("25 / 3 = " + (25.0 / 3));  // 실수 / 정수
		System.out.println("25 / 3 = " + String.format("%4.2f", 25.0 / 3));  // 소수 이하 둘째 자리
		System.out.println("25 / 3 = " + String.format("%.2f", 25.0 / 3));  // 전체 자릿수는 생략가능
	}
}