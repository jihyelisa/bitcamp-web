package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukUpdate implements SungJuk {
	
	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Insert your number: ");
		int no = scan.nextInt();
		
		for(int i=0; i<arrayList.size(); i++) {
			
			if(no == arrayList.get(i).getNo()) {
				//현재 데이터 출력
				for(SungJukDTO sungJukDTO : arrayList) {
					System.out.println(sungJukDTO);
				} //for DTO

				//수정할 데이터 입력 받기
				System.out.print("New name to change: ");
				arrayList.get(i).setName(scan.next());
				System.out.print("New Korean score to change: ");
				arrayList.get(i).setKor(scan.nextInt());
				System.out.print("New English score to change: ");
				arrayList.get(i).setEng(scan.nextInt());
				System.out.print("New Math score to change: ");
				arrayList.get(i).setMath(scan.nextInt());
				System.out.println("Data successfully updated.");
				
				//다시 계산
				arrayList.get(i).calc(); //내 코드에서 빼먹은 부분!!
				
				//번호 찾으면 for문 종료
				break;
				
			} //if no
			//if문 다 돌 때까지 break 만나지 못하면 번호 없음 출력
			System.out.println("Sorry, there's no such number..");
		} //for i
	}
}