package for_;

import java.util.Scanner;

public class For02 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("원하는 단을 입력: ");
		int dan = scan.nextInt();
		
		int num;
		for(num=1; num<=9; num++) {
			System.out.println(dan + " * " + num + " = " + dan*num);
		}
		
	}

}
