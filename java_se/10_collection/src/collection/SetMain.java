package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMain {
	
	public static void main(String[] args) {
		
		//Set은 순서가 없다.
		Set<String> set = new HashSet<String>();
		set.add("tiger");
		set.add("lion");
		set.add("tiger"); //중복 허용x, 순서 무작위
		set.add("giraffe");
		set.add("elephant");
		
		Iterator it = set.iterator(); //메소드로 인터페이스 사용
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
