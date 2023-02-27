package basic;

public class calc {

	public static void main(String[] args) {
		int a, b;
		a = 320;
		b = 258;
		System.out.println("320 + 258 = " + (320 + 258));
		System.out.println("320 - 258 = " + (320 - 258));
		System.out.println("320 * 258 = " + (320 * 258));
		System.out.println("320 / 258 = " + String.format("%.2f", 320.0 / 258));
		
	}

}


/*
[문제] 320(a), 258(b)를 변수에 저장하여 합(sum), 차(sub), 곱(mul), 몫(div)을 구하시오.
단, 소수 이하 2째자리까지 출력하시오.

[실행결과]
320 + 258 = xxx
320 - 258 = xxx
320 * 258 = xxx
320 / 258 = x.xx
*/