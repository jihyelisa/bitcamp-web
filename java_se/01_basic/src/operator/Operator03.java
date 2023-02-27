package operator;

public class Operator03 {
	
		public static void main(String[] args) {
			int a = 5;
			a += 2;
			a *= 3;
			a /= 5;
			System.out.println("a = " + a); //4
			
			//증감연산자
			//a++ 1씩 더해짐  //a-- 1씩 줄어듦
			//++, -- 연산자 우선권이 높다
			a++;
			System.out.println("a = " + a); //5
			
			//선행연산 (++a) vs 후행연산 (a++)
			//위의 a와 같이 혼자 연산할 때는 상관없음
			
			//후행연산일 경우
			//해당 줄 연산 중 가장 마지막에 실행
			int b = a++;
			//1. b = a 할당
			//2. a++ 연산
			System.out.println("a = " + a + ", b = " + b); //a=6 b=5
			
			//선행연산일 경우
			int c = ++a * b--;
			//1. ++a
			//2. int c = a * b
			//3. b--
			System.out.println("a = " + a + ", b = " + b + ", c = " + c); //a=7 b=4 c=35
			
			System.out.println("a++ = " + a++); //a=7
			System.out.println("a = " + a); //a=8
		}
}
