package com.apple;

import com.zoo.Zoo; //다른 패키지의 클래스는 import 해주어야 사용 가능

public class Apple {
	
	public static void main(String[] args) {
		System.out.println("red apple");
		
		Zoo zoo = new Zoo();
		zoo.tiger();
//		zoo.giraffe();
//		zoo.elephant();
//		zoo.lion();
	}

}
