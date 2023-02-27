package for_;

public class For01 {
	
	
	public static void main(String[] args) {
		int i;
		for(i=1; i<=10; i++) {
			System.out.println("Hello Java..");
		} //for
	
		System.out.println("탈출 i = " + i);
		//for문 안에서 i 선언하면
		//i -> 변수 선언이 되지 않았다는 에러
		//i가 local variable(지역변수)이기 때문
		//int i;를 {}지역 밖에서 먼저 선언해주면 해결

		System.out.println();
		for(i=10; i>=1; i--) {
			System.out.print(i + " ");
		} //for
		System.out.println();

		for(i='A'; i<='Z'; i++) {
			System.out.print((char)i + " ");
		}
			
	
	}

}
