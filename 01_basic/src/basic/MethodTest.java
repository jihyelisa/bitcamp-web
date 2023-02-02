package basic;

public class MethodTest {

	public static void main(String[] args) {
		//25, 36 중 큰 값을 구하시오.
		int big = Math.max(25, 36);  //호출
		System.out.println("최대값 = " + big);
		
		//25.8, 78.6 중 작은 값을 구하시오.
		double small = Math.min(25.8, 78.6);
		System.out.println("최소값 = " + small);
		
		//250을 2진수로 출력하시오.
		String binary = Integer.toBinaryString(250);
		//내가 만든 함수가 아니고 Integer 클래스 안의 함수이므로 클래스 명시
		System.out.println("2진수 = " + binary);
		
		String oct = Integer.toOctalString(250);
		System.out.println("8진수 = " + oct);
		
		String hexa = Integer.toHexString(250);
		System.out.println("16진수 = " + hexa);
		
		//2진수 = 11111010
		//16진수 = fa
		//2진수를 4개씩 끊어 묶은 후, 8-4-2-1로 계산
	}

}
