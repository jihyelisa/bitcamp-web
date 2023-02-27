package array;

public class Array05 {
	
	public static void main(String[] args) {
		
		char[] ar = new char[50];
		int[] count = new int[26];
		
		
		//내가 쓴 코드
//		//count 배열 모든 번호에 0 입력
//		for(int i=0; i<26; i++) count[i] = 0;
//		
//		
//		//다섯 줄 반복
//		for(int j=0; j<5; j++) {
//			
//			//한 줄 생성
//			for(int i=j*10; i<j*10+10; i++) {
//				
//				//배열에 랜덤한 문자 저장, 출력
//				char alpha = (char)(Math.random()*(90-65+1) + 65);
//				ar[i] = alpha;
//				System.out.print(ar[i] + " ");
//				
//				//알파벳에 해당하는 count 인덱스의 데이터값 1 증가
//				count[(int)alpha-65]++;
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//		
//		//알파벳별 개수 출력
//		for(int i=0; i<26; i++) {
//			System.out.println((char)(i+65) + ": " + count[i]);
//		}
		
		
		
		//선생님 코드
		
		for(int i=0; i<ar.length; i++) {
			ar[i] = (char)(Math.random() * 26 + 65);
			
			for(int j=0; j<count.length; j++) {
				if(ar[i] == 65+j) count[j]++;
			}
		}
		
		//알파벳 출력
		for(int i=0; i<ar.length; i++) {
			System.out.print(ar[i] + " ");
			if((i+1)%10 == 0) System.out.println();
		}
		
		//개수 출력
		System.out.println();
		for(int i=0; i<count.length; i++) {
			System.out.print((char)(i+65) + " : " + count[i] + "\t");
			if((i+1)%5 == 0) System.out.println();
		}
		
		
		
		
	}
}

/*
[문제] 크기가 50개인 문자배열을 잡아서 65~90사이의 난수를 발생하여 저장 후 출력하시오
- 1줄에 10개씩 출력
- A의 개수? B의 개수? C의 개수? ~~~ Z의 개수 ?

[실행결과]
D F A G H I J K L T
O P W E R F V A S B
P Y R O L E E Z L I
F E U Z T U P P P A
S P G B F F O W J C

A : 2
B : 3
...
X : 0
Y : 1
Z : 0
*/