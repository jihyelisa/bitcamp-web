package collection;

import java.util.Iterator;
import java.util.Set;

public class SetMain {
	
	public static void main(String[] args) {
		
		//Set은 순서가 없다.
		Set<String> set = new Set<String>();
		set.add("tiger");
		set.add("lion");
		set.add("tiger"); //중복 허용
		set.add("giraffe");
		set.add("elephant");
		
		Iterator it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
