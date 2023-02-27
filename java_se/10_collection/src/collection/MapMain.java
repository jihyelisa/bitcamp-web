package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain {
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "백설공주"); //Value 중복 허용
		map.put("book301", "피오나");
		map.put("book101", "엄지공주"); //같은 Key값 넣으면 Value 덮어씀

		System.out.println(map.get("book101"));
		System.out.println(map.get("book102"));
		System.out.println(map.get("book501")); //없는 key 출력해도 에러 아님
												//null값 반환
	}

}
