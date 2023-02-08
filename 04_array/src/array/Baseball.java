package array;

import java.util.Scanner;

public class Baseball {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] com = new int[3];
		int[] user = new int[3];
		
		String game;
		while(true) {
			System.out.print("게임을 실행하시겠습니까(y/n)? ");
			game = scan.next();
			if(game.equals("y") || game.equals("n")) break;
		}
		
		if(game.equals("y")) {
			
			System.out.println("게임을 시작합니다");
			
			//컴퓨터 숫자 생성 (중복 없이 난수 발생)
			for(int i=0; i<com.length; i++) {
				com[i] = (int)(Math.random()*9+1);
				
				for(int j=0; j<i; j++) {
					
					if(com[i]==com[j]) {
						i--;
						break;
					} //if
				} //for j
			} //for i
			
			
			int strike=0, ball=0;
			
			//strike가 3이 될 때까지 반복
			while(strike<3) {
				strike=0; ball=0;
				
				//유저 숫자 입력 받기
				System.out.print("\n숫자 입력: ");
				int num = scan.nextInt();
				//charAt() 함수 이용하는 방법도 있음
				user[0] = num / 100;
				user[1] = num / 10 % 10;
				user[2] = num % 10;
				
//				//코드 점검 시 정답 확인
//				for(int data : com) System.out.print(data);
//				System.out.println();
//				for(int data : user) System.out.print(data);
//				System.out.println();
				
				//정답 개수 세기
				for(int i=0; i<3; i++) {
					
					if(user[i]==com[i]) strike++;
					else if(user[i]==com[0] || user[i]==com[1] || user[i]==com[2]) ball++;
				} //for
				
				//정답 출력
				System.out.println(strike + " strike & " + ball + " ball");
			} //while(strike<3)
			System.out.println("***3 STRIKES!***");
		} //if(game=="y")
		System.out.println("프로그램을 종료합니다.");
	}
}



/*
[문제] 야구게임
크기가 3개인 정수형 배열을 잡고 1~9사이의 난수를 발생한다
발생한 수를 맞추는 게임
중복은 제거한다

[실행결과]
게임을 실행하시겠습니까(Y/N) : w
게임을 실행하시겠습니까(Y/N) : u
게임을 실행하시겠습니까(Y/N) : y

게임을 시작합니다

숫자입력 : 123
0스트라이크 0볼

숫자입력 : 567
0스트라이크 2볼

숫자입력 : 758
1스트라이크 2볼
...

숫자입력 : 785
3스트라이크 0볼

프로그램을 종료합니다.
*/