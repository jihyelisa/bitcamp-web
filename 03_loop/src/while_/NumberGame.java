package while_;

import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String yn = "y";
		
		while(yn.equals("y")) {
			//(yn == "y")로 쓰면 실행 안 됨
			
			int com, user=0, count=0;
			
			com = (int)(Math.random()*100 + 1);
			System.out.println("\n***1 ~ 100사이의 숫자를 맞추세요***\n");
			
			while (user != com) {
				count++;
				
				System.out.print("숫자 입력: ");
				user = scan.nextInt();
				
				if(com > user) System.out.println(user + "보다 큰 숫자입니다.\n");
				else if(com < user) System.out.println(user + "보다 작은 숫자입니다.\n");
				
			} //while
			
			System.out.println("정답! " + count + "번만에 맞추셨습니다.\n");
			System.out.print("한 번 더? (y/n 입력) ");
			yn = scan.next();
		} //while
		System.out.println("***프로그램을 종료합니다.***");
	}
}

/* [문제] 숫자 맞추기 게임
- 컴퓨터가 1 ~ 100사이의 난수를 발생하면, 발생한 난수를 맞추는 게임
- 몇 번만에 맟주었는지 출력한다.

[실행결과]
1 ~ 100사이의 숫자를 맞추세요 (70)

숫자 입력 : 50
50보다 큰 숫자입니다.

숫자 입력 : 85
85보다 작은 숫자입니다.

~~~

숫자 입력 : 70
딩동뎅...x번만에 맞추셨습니다.

한 번 더 (y / n)?
*/