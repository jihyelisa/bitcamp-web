package class__;

import java.util.StringTokenizer;

public class Token {
	
	public static void main(String[] args) {
		String str = "학원,집,,게임방";

		//비어 있는 값은 무시하고 토큰 3개로 분리됨
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("토큰 개수 = " + st.countTokens()); //3
		
		//토큰은 인덱스 번호가 없다.
		//while문을 이용해 토큰의 유무로 판단한다.
		//(토큰이 없어 while문이 false가 되면 반복 종료)
		while(st.hasMoreTokens()) { //토큰이 있으면 true
			System.out.println(st.nextToken()); //토큰 값을 반환한 뒤 다음 토큰으로 이동
		} //while
		
		System.out.println("-----------");
		
		//비어 있는 값도 데이터로 취급해서 4개
		String[] ar = str.split(",");
		for(String data : ar) {
			System.out.println(data);
		}
	}

}
