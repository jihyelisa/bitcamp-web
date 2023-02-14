package com.zoo.safari;

import com.zoo.Zoo;
//폴더 밑에 있어도 다른 패키지이므로 import해야 한다.

public class Safari extends Zoo{
	
	public static void main(String[] args) {
		Zoo z = new Zoo();
		z.tiger();
//		z.giraffe(); //왜 접근 불가?
					 //super 클래스는 자신이 어떤 sub 클래스를 가지는지 알 수 없음
//		z.elephant();
//		z.lion();
		
		
		
		System.out.println();
		Safari s = new Safari(); //sub 클래스로 생성해서
								 //super 클래스를 끌어다 쓰는 식으로 사용해야 함
		s.tiger();
		s.giraffe();
//		s.elephant(); //default 접근제한자라 접근 안 됨
//		s.lion(); //private이라 접근 안 됨
	}
}
