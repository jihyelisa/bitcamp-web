package operator;

public class Comp {
	
	public static void main(String[] args) {
		
		//선생님 답
		char ch = 'e';
		int result = ch >= 'A' && ch <= 'Z' ? ch+32 : ch-32;
		System.out.print((char)(result));
		
		//내가 쓴 답
//		char ch = 'e';
//		int result = (ch >= 97 && ch <= 122) ? ch-32 : ch+32;
//		System.out.println((char)(result));
	}

}

/*
[문제] 변수의 값이 대문자이면 소문자로 변환해서 출력, 소문자이면 대문자로 변환해서 출력하시오
대소문자 코드 차이는 32

[실행결과]
B → b         e → E
*/