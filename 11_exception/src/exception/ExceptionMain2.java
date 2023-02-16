package exception;

import java.util.Scanner;

public class ExceptionMain2 {
	Scanner scan = new Scanner(System.in);
	int x=1, y=1, result=1;
	
	public void input() {
		
		System.out.print("x 입력: ");
		x = scan.nextInt();
		System.out.print("y 입력: ");
		y = scan.nextInt();
	}
	
	public void output() {
		if(y >= 0) {
			
			for(int i=1; i<=y; i++) {
				result *= x;
			}
			System.out.println(x + "의 " + y + "승은 " + result);
		} else {
//			System.out.println("y는 0보다 크거나 같아야 한다.");
			
			//개발자가 강제로 Exception 발생시킴 - throws가 아닌 throw 사용
			try {
				throw new Exception("y는 0보다 크거나 같아야 합니다.");
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain2 exceptionMain2 = new ExceptionMain2();
		exceptionMain2.input();
		exceptionMain2.output();
		
	}
	

}

/*
[문제] 제곱 연산
- x의 y승을 처리 한다.

[실행결과]
x 입력 : 2
y 입력 : 10         input()
----------------------------------
2의 10승은 xxx        output()
*/