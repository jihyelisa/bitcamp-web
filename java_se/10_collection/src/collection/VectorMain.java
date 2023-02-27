package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {
	
	public static void main(String[] args) {
		//Vector는 거의 Java에서만 써서 아주 중요하지는 않음
		Vector<String> v = new Vector<String>();
		System.out.println("벡터 크기 = " + v.size()); //0
		System.out.println("벡터 용량 = " + v.capacity()); //기본용량 10, 10개씩 증가
		System.out.println();
		
		System.out.println("항목 추가");
		for(int i=0; i<10; i++) {
			v.add(i + 1 + "");
			System.out.print(v.get(i) + " ");
		} //for
		System.out.println();
		System.out.println("벡터 크기 = " + v.size()); //10
		System.out.println("벡터 용량 = " + v.capacity()); //10
		System.out.println();
		
		System.out.println("항목 1개 추가");
		v.addElement(5 + ""); //중복 허용
		System.out.println("벡터 크기 = " + v.size()); //11
		System.out.println("벡터 용량 = " + v.capacity()); //20
		System.out.println();
		
		for(int i=0; i<v.size(); i++)
			System.out.print(v.get(i) + " ");
		System.out.println();
		
		System.out.println("마지막 항목 삭제");
		v.remove(v.size()-1);

		Iterator<String> it = v.iterator(); //생성
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}
}





