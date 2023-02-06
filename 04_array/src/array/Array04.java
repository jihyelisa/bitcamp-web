package array;

import java.util.Scanner;

public class Array04 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean[] lots = {false, false, false, false, false};
		int menu=0, locate=0;
		
		while(menu != 4) { //메뉴 4번 선택 시 프로그램 종료
			System.out.print("\n주차장 관리 프로그램\r\n"
					+ "**************\r\n"
					+ "   1. 입차\r\n"
					+ "   2. 출차\r\n"
					+ "   3. 리스트\r\n"
					+ "   4. 종료\r\n"
					+ "**************\r\n"
					+ "  메뉴 번호 선택 : ");
			menu = scan.nextInt();
			
			
			//메뉴 1번 선택
			if(menu==1) {
					System.out.print("위치 입력: ");
					locate = scan.nextInt()-1;
					
				while(lots[locate]) {
					System.out.println("이미 주차된 자리입니다.");
					System.out.print("새 위치 입력: ");
					locate = scan.nextInt()-1;
				}
				lots[locate] = true;
				System.out.println("주차되었습니다.");
			}
			
			
			//메뉴 2번 선택
			else if(menu==2) {
				System.out.print("위치 입력: ");
				locate = scan.nextInt()-1;
				
			while(!lots[locate]) {
				System.out.println("주차된 차량이 없습니다.");
				System.out.print("새 위치 입력: ");
				locate = scan.nextInt()-1;
			}
			lots[locate] = false;
			System.out.println("출차되었습니다.");
			}
			
			
			//메뉴 3번 선택
			else if(menu==3) {
				System.out.println();
				
				for(int i=0; i<5; i++) {
					System.out.println(i+1 + "위치: " + lots[i]);
				}
				System.out.println();
			}

			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

/*
[문제] 주차관리 프로그램

[실행결과]
주차장 관리 프로그램
**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
  메뉴 : 
  
1번인 경우
위치 입력 : 3
3위치에 입차 / 이미 주차되어있습니다

2번인 경우
위치 입력 : 4
4위치에 출차 / 주차되어 있지않습니다

3번인 경우
1위치 : true
2위치 : false
3위치 : true
4위치 : false
5위치 : false  
*/