package for_;

import java.util.Scanner;

public class For04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("x값 입력: ");
		int x = scan.nextInt();
		System.out.print("y값 입력: ");
		int y = scan.nextInt();
		
		int i=1, result=1;
		for(; i<=y; i++) {
			result *= x;
		}
		System.out.println(x + "의 " + y + "승은 " + result);
	}
}
