package sungJuk;

import java.util.ArrayList;

public class SungJukList implements SungJuk {
	
	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		System.out.println();
		
		
		//방법1. for문 사용
//		for(int i=0; i<arrayList.size(); i++) {
//			System.out.println(arrayList.get(i).getNo() + "\t"
//							 + arrayList.get(i).getName() + "\t"
//							 + arrayList.get(i).getKor() + "\t"
//							 + arrayList.get(i).getEng() + "\t"
//							 + arrayList.get(i).getMath() + "\t"
//							 + arrayList.get(i).getTotal() + "\t"
//							 + arrayList.get(i).getAvg() + "\t"
//							 );
//		}
		
//		//방법2. 확장형 for문 사용
//		for(SungJukDTO sungJukDTO : arrayList) {
//			System.out.println(sungJukDTO.getNo() + "\t"
//					 		 + sungJukDTO.getName() + "\t"
//					 		 + sungJukDTO.getKor() + "\t"
//					 		 + sungJukDTO.getEng() + "\t"
//					 		 + sungJukDTO.getMath() + "\t"
//					 		 + sungJukDTO.getTotal() + "\t"
//					 		 + sungJukDTO.getAvg() + "\t"
//					 );

		//방법3. 확장형 for문 + Override 사용
		for(SungJukDTO sungJukDTO : arrayList) {
		System.out.println(sungJukDTO); //.toString()이 생략된 것
										//DTO에서 Override한 것이 적용되도록 한다
										//안 하면 주소로 출력됨
		}
	}

}
