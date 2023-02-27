package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {
	
	public static void main(String[] args) {
		
		//배열 정렬하기---------------------------------------------------
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};		
		System.out.print("정렬 전 = ");
		for(String data : ar) {
			System.out.print(data + "  ");
		}
		System.out.println();
		
		Arrays.sort(ar); //문자열을 인덱스별로 체크하며 문자의 코드가 누가 더 큰지 판단하는 메소드
		System.out.print("정렬 후 = ");
		for(String data : ar) {
			System.out.print(data + "  ");
		}
		System.out.println("\n");
		
		
		//객체배열 정렬하기-------------------------------------------------
		//객체배열은 일반배열과 달리 여러개의 항목이 세트로 움직이므로 정렬 기준을 정해주어야 한다.
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("프로도", 40);
		PersonDTO cc = new PersonDTO("라이언", 35);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("정렬 전");
		for(PersonDTO personDTO : list) {
			System.out.println(personDTO);
		}
		System.out.println("\n");
		
		Collections.sort(list);

		System.out.println("나이로 오름차순");
		System.out.println("정렬 후");
		for(PersonDTO personDTO : list) {
			System.out.println(personDTO);
		}
		System.out.println("\n");
		
		
		//다른 정렬 기준을 주고 싶을 때
		System.out.println("이름으로 내림차순");
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() {
			
			@Override
			public int compare(PersonDTO dto1, PersonDTO dto2) {
			//인터페이스라 new 불가 - 익명inner클래스 사용
				return dto2.getName().compareTo(dto1.getName());
				//dto1과 dto2 자리를 바꿔 오름차순 -> 내림차순
				//또는 그냥 -1을 곱해 결과값을 뒤집어 줄 수도 있음 (결과가 -1, 0, 1로 나오므로)
			}
		};
		
		Collections.sort(list, com);
		System.out.println("정렬 후");
		for(PersonDTO personDTO : list) {
			System.out.println(personDTO);
		}
		System.out.println("\n");
	}
}
