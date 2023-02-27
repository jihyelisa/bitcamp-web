package class_;

import java.util.Scanner;

public class ComputeMain {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//배열 크기 입력 받기
		System.out.print("횟수 입력: ");
		int num = scan.nextInt();
		Compute[] ar = new Compute[num];

		
		//입력 받은 횟수 num만큼 x, y 입력 받기
		for(int i=0; i<num; i++) {

			System.out.println("\n[" + (i+1) + "번째]");
			System.out.print("x 입력: ");
			int x = scan.nextInt();
			System.out.print("y 입력: ");
			int y = scan.nextInt();
			
			ar[i] = new Compute();
			ar[i].setData(x, y);
		} //for i
		
		
		//성적표 출력
		System.out.println("\nx\ty\tsum\tsub\tmul\tdiv");
		for(int i=0; i<num; i++) {
			
			ar[i].calc();
			System.out.print(ar[i].getX() + "\t"
							+ ar[i].getY() + "\t"
							+ ar[i].getSum() + "\t"
							+ ar[i].getSub() + "\t"
							+ ar[i].getMul() + "\t"
							+ ar[i].getDiv());
			System.out.println();
		} //for i
	}
}


/*
[문제] 사칙연산
x, y를 입력하여 합, 차, 곱, 몫을 구하시오

클래스명 : Compute (1인분)
필드 : x, y, sum, sub, mul, div
메소드 : setData(x의 값, y의 값)
        calc()
        getX()
        getY()
        getSum()
        getSub()
        getMul()
        getDiv()
        
클래스명 : ComputeMain        

[실행결과]
횟수 입력 : 2

[1번째]
x 입력 : 25
y 입력 : 36

[2번째]
x 입력 : 35
y 입력 : 12

x   y   sum      sub      mul      div
25   36
35   12
*/