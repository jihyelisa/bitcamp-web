package class__;

import java.util.Scanner;

public class StringBufferMain {
	Scanner scan = new Scanner(System.in);
	
	int dan;
	public void input() {
		System.out.print("원하는 단을 입력: ");
		this.dan = scan.nextInt();
		System.out.println();
	}
	
	public void output() {
		//StringBuffer를 사용하면 append(), delete() 함수로 수정 가능하다.
		StringBuffer buffer = new StringBuffer();
		
		for(int i=1; i<=9; i++) {
//			System.out.println(dan + "*" + i + "=" + dan*i);

			buffer.append(dan);
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);
			
			System.out.println(buffer.toString());
			
			buffer.delete(0, buffer.length());
		}
	}
	
	
	public static void main(String[] args) {
		StringBufferMain sbm = new StringBufferMain();
		sbm.input();
		sbm.output();
	}

}


/*
[문제] 구구단

input() 함수 이용
원하는 단을 입력: 5

output() 함수 이용
5*1=5
...
5*9=45

*/