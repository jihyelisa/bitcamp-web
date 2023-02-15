package collection;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionMain2 {
	
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("tiger");
		list.add("lion");
		list.add("tiger"); //중복 허용
//		list.add(25);
//		list.add(43.8); //ArrayList는 타입 지정하여 여기서 int는 add 불가
		list.add("giraffe");
		list.add("elephant");
		
		for(int i=0; i<list.size(); i++) System.out.println(list.get(i));
		
		System.out.println();
		
		for(String data : list) System.out.println(data);
	
	}

}
