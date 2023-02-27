package operator;

public class Dice {

	public static void main(String[] args) {
		
		int dice1, dice2;
		dice1 = (int)(Math.random() * 6 + 1);
		dice2 = (int)(Math.random() * 6 + 1);
		System.out.println("주사위1: " + dice1);
		System.out.println("주사위2: " + dice2);
		
		int large = Math.max(dice1, dice2);
		String result;
		result = large == dice1 ? "주사위1 승" : "주사위2 승";
		result = dice1 == dice2 ? "무승부" : result;
		
		System.out.println(result);
		
	}

}

//x ~ y 사이의 난수 만들기
//(int)(Math.random() * (y-x+1) + x)



//[문제] 주사위 게임 - 난수
//2개의 주사위를 던져서 큰값을 가진 주사위가 승이다.
//주사위 값의 합도 출력하시오
//
//[실행결과]
//주사위1 : 3   주사위2 : 1
//주사위1 승
//-----------------------------
//주사위1 : 4   주사위2 : 6
//주사위2 승
//-----------------------------
//주사위1 : 3   주사위2 :3
//무승부
