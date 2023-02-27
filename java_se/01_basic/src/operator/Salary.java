package operator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Salary {
	
	public static void main(String[] args) {
		
		//입력 받기
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String name = scan.nextLine();
		System.out.print("직급 입력: ");
		String position = scan.nextLine();
		System.out.print("기본급 입력: ");
		int base = scan.nextInt();
		System.out.print("수당 입력: ");
		int allowance = scan.nextInt();
		
		//합계
		int total = base + allowance;
		
		//세금
		double tax_rates = 0.01;
		tax_rates = (total >= 5000000 | total >= 3000000) ? 0.03 : 0.02;
		int tax = (int)(total * tax_rates);
		
		//월급
		int salary = total - tax;
		
		//결과
		DecimalFormat df = new DecimalFormat();
		System.out.println("\n*** " + name + " " + position + " 월급 ***");
		System.out.println("기본급: " + df.format(base) + "원");
		System.out.println("수당: " + df.format(allowance) + "원");
		System.out.println("합계: " + df.format(total) + "원");
		System.out.println("세금: " + df.format(tax) + "원");
		System.out.println("월급: " + df.format(salary) + "원");

	}
}


/*
[문제] 월급 계산 프로그램 - 조건 연산자
이름, 직급, 기본급, 수당을 입력하여 합계, 세금, 월급을 출력하시오
단 합계가 5,000,000원 이상이면 3%
       3,000,000원 이상이면 2%
       아니면 1%
       
합계 = 기본급 + 수당
세금 = 합계 * 세율
월급 = 합계 - 세금

[실행결과]
이름 입력 : 홍길동
직급 입력 : 부장
기본급 입력 : 4900000
수당 입력 : 200000

*** 홍길동 부장 월급 ***
기본급 : 4,900,000원
수당 : 200,000원
합계 : 5,100,000원
세금 : 153,000원
월급 : 4,947,000원
*/
