package for_;

public class For05 {
	
	public static void main(String[] args) {
		
		
		int A_num=0;
		
		for (int ii=1; ii<=10; ii++) { //10줄 반복
			String line = "";
			
			for (int i=1; i<=10; i++) { //한 줄 생성 및 출력
				//랜덤한 대문자 알파벳 생성
				char alpha = (char)(Math.random()*('Z'-'A'+1) +'A');
				line += alpha + "  ";
				if(alpha=='A') A_num++; //A일 경우 개수 추가
				
			} //for
			System.out.println(line); //한 줄 출력
			
		} //for
		System.out.println("A의 개수 = " + A_num);
	}

}


/*
[문제]
대문자(A~Z)를 100개 발생하여 출력하시오
- 1줄에 10개씩 출력
- 100개중에서 A가 몇개 나왔는지 개수를 출력

[실행결과]
H  D  D  R  A  Y  A  K  T  H
C  X  F  Z  B  S  L  Y  Q  D
H  K  O  H  O  B  Z  N  J  T
U  P  A  P  K  Q  G  W  F  A
S  U  D  Z  I  V  J  U  O  G
L  M  Z  L  H  U  Y  D  Q  R
F  T  I  Z  A  W  E  O  F  Z
A  Y  C  I  U  Z  O  B  C  G
H  G  Y  Z  V  P  I  R  L  G
Y  H  R  R  M  H  Y  S  B  P

A의 개수 = 6
*/