package sungJuk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukDelete implements SungJuk {
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {

		System.out.print("Insert the name to delete: ");
		String deleteName = scan.next();
		int sizeBefore = arrayList.size();
		
		for(int i=0; i<arrayList.size(); i++) {
			
			if(arrayList.get(i).getName().equals(deleteName)) {
				arrayList.remove(i);
				i--; //remove로 인덱스가 앞으로 하나 당겨짐
				System.out.println("Data successfully deleted.");
			} //if
		} //for i
		
		//arrayList.size()가 for문 전보다 줄어들지 않았으면 출력
		if(arrayList.size() >= sizeBefore) {
			System.out.println("There's no such name..");
		}
		
		
		//선생님 코드
//		Iterator<SungJukDTO> it = arrayList.iterator();
//		int count=0;
//		
//		while(it.hasNext()) {
//			SungJukDTO sungJukDTO = it.next();
//			
//			if(sungJukDTO.getName().equals(deleteName)) {
//				it.remove(); //it.next()가 반환하는 항목을 지운다.
//				count++;
//			} //if
//		} //while
//		
//		if(count == 0) {
//			System.out.println();
//			System.out.println("회원의 정보가 없습니다");
//		}
	}
}

/*
6. SungJukDelete.java
- 이름을 입력하여 없는 이름이면 "회원의 정보가 없습니다" 출력하시오
- 똑같은 이름이 있으면 모두 삭제한다.

삭제할 이름 입력 : 천사
회원의 정보가 없습니다

또는 

삭제하였습니다.
*/