package basic;

//1. static 함수가 아니므로 import로 어디 있는 클래스인지 알려줌
import java.util.Random;
import java.util.Arrays;

public class MethodTest02 {
	
	public static void main(String[] args) {
		
		//2. import한 클래스의 함수 주소를 new 생성으로 알려줌
		Random r = new Random();
		double b = r.nextDouble();
		System.out.println("Random class 난수 = " + b);
		
		//Math 클래스의 static 함수를 사용할 수도 있음
		double a = Math.random();
		System.out.println("Math class 난수 = " + a);
		
		//배열 만들기
		//파이썬의 list 형식과 비슷
		int[] ar = new int[5];  //메모리 상에 정수형이 들어갈 방을 5개 만듦
		ar[0] = 25;
		ar[1] = 13;
		ar[2] = 45;
		ar[3] = 30;
		ar[4] = 15;
		System.out.println(ar[0] + ", " + ar[1] + ", " + ar[2] + ", " + ar[3] + ", " + ar[4]);
		
		//오름차순 정렬하기
		Arrays.sort(ar);  //정렬만 하고 반환값은 없으므로 변수에 할당하면 안 됨
		System.out.println(ar[0] + ", " + ar[1] + ", " + ar[2] + ", " + ar[3] + ", " + ar[4]);
	}

}

//난수 : 컴퓨터가 불규칙적으로 발생시키는 수
//: 0 <= 난수 < 1
