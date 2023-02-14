package interface_;

import java.util.Scanner;

public class ComputeService {
	
	public void menu() {
		Scanner scan = new Scanner(System.in);
		Compute com = null;
		
		int num;
		while(true) {
			System.out.println();
			System.out.println("*******************");
			System.out.println("	1. sum");
			System.out.println("	2. sub");
			System.out.println("	3. mul");
			System.out.println("	4. div");
			System.out.println("	4. finish");
			System.out.println("*******************");
			System.out.print("	select: ");
			
			num = scan.nextInt();
			System.out.println();
			
			if(num==5) break;

			//부모 클래스인 Compute 클래스가 sub 클래스를 모두 참조할 수 있다.
			if(num == 1) com = new Sum();
			else if(num == 2) com = new Sub();
			else if(num == 3) com = new Mul();
			else if(num == 4) com = new Div();
			com.disp();
			
		} //while
	} //menu()
}
