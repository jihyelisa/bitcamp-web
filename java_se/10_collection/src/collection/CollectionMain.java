package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//public class CollectionMain implements Collection {
//모든 추상메소드를 Override해줘야 하는데 Collection 안에 너무 많음!!

public class CollectionMain {
	
	@SuppressWarnings("all") //강제로 warning을 억제함 (베스트 방법은 아님)
	public static void main(String[] args) {
		//implements 대신 메소드로 필요한 것만 가져옴
		//ArrayList가 인터페이스 Collection의 추상메소드를 약 15개를 모두 Override 하고 있음
		Collection coll = new ArrayList();
		
		coll.add("tiger");
		coll.add("lion");
		coll.add("tiger"); //중복 허용
		coll.add(25);
		coll.add(43.8);
		coll.add("giraffe");
		coll.add("elephant");
		
		
//		Iterator는 인터페이스이므로 new로 생성 불가
//		.iterator() 메소드를 이용해 불러올 수 있음
		Iterator it = coll.iterator();
		while(it.hasNext()) { //항목이 있나? true, false 반환
			System.out.println(it.next()); //항목을 꺼내고 다음 항목으로 이동
		}
	}

}
