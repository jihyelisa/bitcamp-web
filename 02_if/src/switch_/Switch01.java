package switch_;

import java.util.Scanner;

public class Switch01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int days; //초기값 넣지 않으면 에러
				  //switch에 해당하는 값이 없어 print까지 아무 값도 부여되지 않을 수 있음
		  		  //또는 switch 마지막에 default값을 줄 수 있음
		
		System.out.print("월 입력: ");
		int month = scan.nextInt();
		
		switch(month) {
		case 1 : days=31; break; //if와 달리 break를 쓰지 않으면
		case 2 : days=28; break; //조건에 적합한 case를 만나는 순간부터 아래 명령들을 모두 수행
		case 3 : days=31; break;
		case 4 : days=30; break;
		case 5 : days=31; break;
		case 6 : days=30; break;
		default : days=0;
		}
		
		//break 적절히 이용하기
		switch(month) {
		case 1 :
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 : days=31; break;
		
		case 2 : days=28; break;
		
		case 4 :
		case 6 :
		case 9 :
		case 11 : days=30; break;
		
		default : days=0;
		}
		
		System.out.println(month + "월은 " + days + "일입니다.");
	}
	
}
