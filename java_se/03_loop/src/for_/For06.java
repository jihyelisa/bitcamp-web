package for_;

import java.util.Scanner;

public class For06 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//숫자 입력 받기
		System.out.print("숫자 입력 (1~10) : ");
		int num = scan.nextInt();
		
		//필드 선언
		int result = 1;
		String facto="1";
		
		//루프
		for (int i=2; i<=num; i++) {
			result *= i;
			facto += "*" + i;
		}
		
		//최종 출력
		System.out.println(num + "! = " + result + " (" + facto + ")");
	}

}

/*
[문제]
팩토리얼을 구하시오 (for)
- 입력되는 숫자는 1 ~ 10 사이만 입력한다.

[실행결과]
숫자 입력 : 3
3! = 6 (1*2*3)
---------------------

숫자 입력 : 5
5! = 120 (1*2*3*4*5)
*/