package collection;

import java.util.ArrayList;

public class PersonMain {
	
	public ArrayList<PersonDTO> init() {
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("프로도", 30);
		PersonDTO cc = new PersonDTO("라이언", 40);
		
		ArrayList<PersonDTO> arrayList = new ArrayList<PersonDTO>();
		arrayList.add(aa);
		arrayList.add(bb);
		arrayList.add(cc);
		
		return arrayList;
	}
	
	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		
		for(PersonDTO data : pm.init()) System.out.println(data);
		
	}

}
