package class__;

import java.util.Scanner;

public class Exam {
	Scanner scan = new Scanner(System.in);
	
	private String name;
	private String dap;
	private char[] ox = new char[5];
	private int score;
	//상수화, 바꾸지 않을 값
	//필드명을 대문자로 정한다.
	private final String JUNG = "11111";
	
	
	//Insert name & answer
	public Exam() {
		System.out.print("\nYour name: ");
		name = scan.next();
		System.out.print("Your answer: ");
		dap = scan.next();
	}
	
	
	//Compare the answers
	public void compare() {
		for(int i=0; i<5; i++) {
			if(dap.charAt(i) == JUNG.charAt(i)) {
				ox[i] = 'O';
				score += 20;
			}
			else ox[i] = 'X';
		} //for i
	}

	
	//get methods
	public void getName() {
		System.out.print(name + "\t");
	}
	public void getOx() {
		for(int j=0; j<dap.length(); j++) {
			System.out.print(ox[j] + " ");
		} //for j
	}
	public void getScore() {
		System.out.print("\t" + score);
	}
}


/*
[문제] 사지선다형
- 총 5문제의 답을 입력 받는다
- 정답은 "11111"이다
- 맞으면 'O', 틀리면 'X'
- 1문제당 점수는 20점씩 처리

클래스명 : Exam
* 필드
private String name = null;
private String dap = null;
private char[] ox = null;
private int score = 0;
private final String JUNG = "11111"; //상수화

* 메소드
생성자 - Scanner 를 이용하여 이름과 답을 입력받는다.
compare() - 비교
getName()
getOx()
getScore()

[실행결과]
클래스명 : ExamMain
인원수 입력: 2

이름 입력: 홍길동
답 입력: 12311

이름 입력: 코난
답 입력: 24331

이름		1 2 3 4 5	점수
홍길동	O X X O O	60
코난		X X X X O	20


exam 클래스를 명수만큼 호출해 사용하기
*/