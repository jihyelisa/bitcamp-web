package array;

import java.util.Scanner;

public class Lotto {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("금액 입력: ");
		int money = scan.nextInt();
		
		for(int k=1; k<=money/1000; k++) {

			int[] lotto;
			lotto = new int[6];
			
			//중복 없이 난수 발생
			for(int i=0; i<lotto.length; i++) {
				lotto[i] = (int)(Math.random()*45+1);
				
				for(int j=0; j<i; j++) {
					if(lotto[i]==lotto[j]) {
						i--;
						break;
					}
				} //for j
			} //for i
			
			/*
			//정렬 전 출력
			for(int data : lotto) {
				System.out.print(data + " ");
			}
			System.out.println();
			*/
			
			//오름차순 정렬
			int temp;
			for(int i=0; i<lotto.length-1; i++) {
				
				for(int j=i+1; j<lotto.length; j++) {
					
					if(lotto[i]>lotto[j]) {
						temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					} //if
				} //for j
			} //for i
			
			//정렬 후 출력
			for(int data : lotto) {
				System.out.print(String.format("%5d", data));
			}
			System.out.println();
			
			if(k%5==0) System.out.println();
		} //for money

		
	}

}

/*
[문제] 로또 - 자동
- 크기가 6개인 배열 생성
- 1 ~ 45 사이의 난수 발생
- 숫자는 오름차순하여 출력 (Selection Sort)
- 출력시 자리수는 5자리로 지정
- 중복 숫자가 나오면 안된다
- 1000원당 1줄이 나온다
- 5줄마다 줄바꿈

[실행결과]
    2    4   19   39   43   44
*/