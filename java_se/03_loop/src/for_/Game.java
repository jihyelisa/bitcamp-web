package for_;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("insert coin: ");
		int coin = scan.nextInt();
		
		//잔고 확인 및 루프
		for (; coin>=300; coin-=300) {
			
			//컴퓨터와 사용자 선택지 필드 선언
			System.out.print("\n가위(1), 바위(2), 보(3) 중 번호 입력: ");
			int user = scan.nextInt();
			int com = (int)(Math.random() * 3 + 1);
			
			//선택지 한글로 출력
			String user_str="", com_str="";
			switch (user) {
			case 1 : user_str = "가위"; break;
			case 2 : user_str = "바위"; break;
			case 3 : user_str = "보"; break;
			}
			switch (com) {
			case 1 : com_str = "가위"; break;
			case 2 : com_str = "바위"; break;
			case 3 : com_str = "보"; break;
			}
			System.out.println("컴퓨터: " + com_str + "\t나: " + user_str);
			
			//승부 결과 출력
			if(user==com) System.out.println("You Draw!!");
			else if((user-com == 1)||(user-com == -2)) System.out.println("You Win!!");
			else System.out.println("You Lose!!");

		}
		

	}
}

/*
[문제] 가위, 바위, 보 게임
- 가위(1), 바위(2), 보자기(3) 지정한다.
- 컴퓨터(com)는 1 ~ 3까지 난수로 나온다
- 1게임당 300원으로 한다.

[실행결과]
insert coin : 1000

가위(1), 바위(2), 보(3) 중 번호 입력 : 3 (user, 사용자)
컴퓨터 : 바위   나 : 보자기
You Win!!

가위(1),바위(2),보(3) 중 번호 입력 : 1 (user)
컴퓨터 : 가위   나 : 가위
You Draw!!

가위(1),바위(2),보(3) 중 번호 입력 : 3 (user)
컴퓨터 : 가위   나 : 보자기
You Lose!!
*/