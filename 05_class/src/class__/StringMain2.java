package class__;

import java.util.Scanner;

public class StringMain2 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Insert String
		System.out.print("문자열 입력: ");
		String origin = scan.next();
		System.out.print("현재 문자열 입력: ");
		String current = scan.next();
		System.out.print("바꿀 문자열 입력: ");
		String change = scan.next();
		
		//String 길이 잘못 입력 시 함수 종료
		if(origin.length() < current.length()) {
			System.out.println("입력한 문자열의 크기가 작습니다.");
			System.out.println("치환할 수 없습니다.");
			return;
//			System.exit(0); //프로그램 강제 종료 명령
		}
		
		origin = origin.toLowerCase();
		current = current.toLowerCase();
		
		
		//내가 쓴 코드 - index가 증가하지 않음
//		while(true) {
//			int index = origin.indexOf(current);
//			int index_end = index + current.length();
//			origin.indexOf(current, index_end);
//			
//			//origin 끝까지 찾으면 break
//			if(index_end >= origin.length()) break;
//		} //while
		
		
		//선생님 코드
		int index = 0;
		int count = 0;
		
		//indexOf 찾는 게 없으면 -1 반환
		while((index = origin.indexOf(current, index)) != -1) {
			count++;
			index += current.length();
		} //while
		System.out.println(origin.replace(current, change));
		System.out.println(count + "번 치환했습니다.");
	}
}



/*
[문제]
반복문 아님!!

치환하는 프로그램을 작성하시오 - indexOf(?, ?), replace()
String 클래스의 메소드를 이용하시오
대소문자 상관없이 개수를 계산하시오

[실행결과]
문자열 입력 : aabba
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aAbbA
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환

문자열 입력 : aabbaa
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbbdd
2번 치환

문자열 입력 : AAccaabbaaaaatt
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddccddbbddddatt
4개 치환

문자열 입력 : aabb
현재 문자열 입력 : aaaaa
바꿀 문자열 입력 : ddddd
입력한 문자열의 크기가 작습니다
치환 할 수 없습니다
*/