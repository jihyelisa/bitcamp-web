package array;

import java.util.Scanner;

public class Array03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] ar;
		int size, sum=0;
		
		System.out.print("배열 크기 입력: ");
		size = scan.nextInt();
		System.out.println();
		
		ar = new int[size];
		
		for(int i=0; i<size; i++) {
			System.out.print("ar[" + i + "] 입력: ");
			ar[i] = scan.nextInt();
			
			sum += ar[i];
			
			//내가 쓴 코드 (초기값을 0으로 줘서 음수를 고려 안 함)
//			if(max<ar[i]) max = ar[i];
//			if(min>ar[i]) min = ar[i];
		}
		
		//선생님 코드
		int max, min;
		max = min = ar[0];
		for(int i=0; i<ar.length; i++) {
			if(max<ar[i]) max = ar[i];
			if(min>ar[i]) min = ar[i];
		}
		
		
		System.out.println();
		for(int data : ar) {
			System.out.print(data + " ");
		}
		
		System.out.println("\n합 = " + sum);
		System.out.println("최대값 = " + max);
		System.out.println("최소값 = " + min);
	}
}

