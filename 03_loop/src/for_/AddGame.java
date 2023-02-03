package for_;

import java.util.Scanner;

public class AddGame {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a, b, dab=0, count=0;
		
		//새 문제 출제
		for(int i=1; i<6; i++) {
			
			//난수 생성
			a = (int)(Math.random() * 90 + 10);
			b = (int)(Math.random() * 90 + 10);
			
			//틀린 문제 재도전
			for(int ii=0; (dab != a+b) && ii<2; ii++) {
				
				//출제 및 채점
				System.out.print("[" + i + "] " + a + " + " + b + " = ");
				dab = scan.nextInt();
				if(dab == (a+b)) {
					System.out.println("Good Work!");
					count++;
				}
				else System.out.println("Wrong Answer..");
				
			} //for
		} //for
		
		//총 점수 출력
		System.out.println("당신은 총 " + count + "문제를 맞추어서 점수 " + count*20 + "점입니다.");
	}
}


/*
[문제]
덧셈 문제 내기
- 랜덤한 두자리 숫자(10~99)만 제공
- 총 5문제
- 1문제당 20점
- 틀리면 한 번 더 기회

[실행결과]
[1] 87 + 56 = 78
틀렸다
[1] 87 + 56 = 78
틀렸다... 정답은 143

[2] 17 + 64 = 81
참 잘했어요

...

[5] 82 + 45 = 78
틀렸다

당신은 총 x문제를 맞추어서 점수 xx점입니다.
*/