package sungJuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SungJukSort implements SungJuk {
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		System.out.println("********************");
		System.out.println("	1. 총점으로 내림차순");
		System.out.println("	2. 이름으로 오름차순");
		System.out.println("	3. 이전 메뉴");
		System.out.println("********************");
		System.out.print("	번호: ");
		int num = scan.nextInt();
		
		if(num==3) return;
		
		else if(num==1) {
			Collections.sort(arrayList);
			for(SungJukDTO sungJukDTO : arrayList) {
				System.out.println(sungJukDTO);
			} //for sungJukDTO
		} //if(num==1)
		
		else if(num==2) {
			Comparator<SungJukDTO> comparator = new Comparator<SungJukDTO>() {
				
				@Override
				public int compare(SungJukDTO dto1, SungJukDTO dto2) {
				//인터페이스라 new 불가 - 익명inner클래스 사용
					return dto1.getName().compareTo(dto2.getName());
					//dto1가 먼저 오므로 오름차순
				}
			};
			
			//sort 메소드로 정렬
			Collections.sort(arrayList, comparator);
			for(SungJukDTO sungJukDTO : arrayList) {
				System.out.println(sungJukDTO);
			} //for sungJukDTO
		} //if(num==2)
	} //execute()
}




/*
7. SungJukSort.java
********************
  1. 총점으로 내림차순
  2. 이름으로 오름차순
  3. 이전 메뉴
********************
  번호 : 
*/