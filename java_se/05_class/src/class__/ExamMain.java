package class__;

import java.util.Scanner;

public class ExamMain {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many people?: ");
		int cnt = scan.nextInt();
		
		
		//객체배열 생성
		Exam[] arr = new Exam[cnt];
		
		for(int i=0; i<cnt; i++) {
			arr[i] = new Exam();
			arr[i].compare();
		}
		
		
		//출력
		System.out.print("\n이름\t1 2 3 4 5\t점수");
		
//		for(int j=0; j<arr.length; j++) {
		for(Exam e : arr) { //확장형 for문 사용하기
			System.out.println();
			e.getName();
			e.getOx();
			e.getScore();
		}
		
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