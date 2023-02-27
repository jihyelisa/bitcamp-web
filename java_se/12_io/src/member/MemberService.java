package member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberService {
	private ArrayList<MemberDTO> arrayList = new ArrayList<MemberDTO>();
	
	Scanner scan = new Scanner(System.in);
	Member member = null;
	
	public void menu() {
		
		while(true) {
			
			System.out.println("\n********************");
			System.out.println(" \t1. 등록");
			System.out.println(" \t2. 출력");
			System.out.println(" \t3. 핸드폰 검색");
			System.out.println(" \t4. 이름으로 오름차순");
			System.out.println(" \t5. 파일 저장");
			System.out.println(" \t6. 파일 읽기");
			System.out.println(" \t7. 프로그램 종료");
			System.out.println("********************");
			System.out.print("\t번호 선택: ");
			int select = scan.nextInt();
			System.out.println();
			
			if (select==7) break;
			
			else if (select==1) member = new MemberInsert();
			else if (select==2) member = new MemberPrint();
			else if (select==3) member = new MemberPhoneSearch();
			else if (select==4) member = new MemberNameAsc();
			else if (select==5) member = new MemberFileOutput();
			else if (select==6) member = new MemberFileInput();
			else {
				System.out.println("Wrong number..");
				System.out.println();
				continue;
			}
			member.execute(arrayList);
		}
		System.out.println("프로그램을 종료합니다.");
		
	}

}
