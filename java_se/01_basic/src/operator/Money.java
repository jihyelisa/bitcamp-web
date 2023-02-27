package operator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Money {

	public static void main(String[] args) {
		
		int money;
		//키보드로부터 입력 받는 Scanner 클래스를 생성
		Scanner scan = new Scanner(System.in);
		System.out.print("돈 입력: ");
		money = scan.nextInt();
		
		// 선생님 답
		// 5378원일 때
//		int thou = money / 1000;  //5
//		int thou_mod = money % 1000;  //378
//		int hund = thou_mod / 100;  //3
//		int hund_mod = thou_mod % 100;  //78
//		int ten = hund_mod / 10;  //7
//		int one = hund_mod % 10;  //8
		
		// 내가 쓴 답
		int thou, hund, ten, one;
		thou = money / 1000;
		hund = (money / 100) % 10;
		ten = (money / 10) % 10;
		one = money % 10;
		
		DecimalFormat df = new DecimalFormat();
		System.out.println("현금: " + df.format(money) + "원");
		System.out.println("천원: " + thou + "장");
		System.out.println("백원: " + hund + "개");
		System.out.println("십원: " + ten + "개");
		System.out.println("일원: " + one + "개");
	}
}

/*
[문제] 동전교환기
현금 5378원이 있다.

[실행결과]
현금: 5378원
천원: 5장
백원: 3개
십원: 7개
일원: 8개
*/