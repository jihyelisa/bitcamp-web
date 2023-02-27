package constructor;

import java.util.Scanner;

public class MemberService {
	Scanner scan = new Scanner(System.in);
	
	private MemberDTO[] ar = new MemberDTO[2]; //객체 배열 (클래스를 집어넣을 것)
	
	
	public MemberService() {
//		System.out.println("기본 생성자");
	}
	
	public void menu() {
		
		for(int num=0; num!=5;) {
		System.out.print("menu\r\n"
				+ "*************\r\n"
				+ "   1. 가입\r\n"
				+ "   2. 출력\r\n"
				+ "   3. 수정\r\n"
				+ "   4. 탈퇴\r\n"
				+ "   5. 끝내기\r\n"
				+ "*************\r\n"
				+ "  번호 : ");
		num = scan.nextInt();
		
		if(num == 1) insert();
		else if(num == 2) list();
		else if(num == 3) update();
		else if(num == 4) delete();
		}
	}

	//1번 선택시
	public void insert() {
		
		int i=0;
		for(i=0; i<ar.length; i++) {
			if(ar[i] == null) break;
		}
		if(i == ar.length) {
			System.out.println(ar.length + "명의 정원이 꽉 찼습니다.");
			return; //함수 벗어남
		}
		
		//데이터 입력
		System.out.print("이름 입력: ");
		String name = scan.next();
		System.out.print("나이 입력: ");
		int age = scan.nextInt();
		System.out.print("핸드폰 입력: ");
		String phone = scan.next();
		System.out.print("주소 입력: ");
		String address = scan.next();
		
		//MemberDTO 클래스 생성
		for(i=0; i<ar.length; i++) {
			if(ar[i] == null) {
				ar[i] = new MemberDTO(name, age, phone, address);
				break; //for문 벗어남
			}
		}
		System.out.println("1 row created");
	}

	//2번 선택시
	public void list() {
		for(MemberDTO dto : ar) { //
			if(dto != null) {
				System.out.println(dto.getName()
						+ "\t" + dto.getAge()
						+ "\t" + dto.getPhone()
						+ "\t" + dto.getAddress());
			} //if
		} //for
	}
	
	//3번 선택시
	public void update() {
		System.out.print("핸드폰 번호 입력: ");
		String phone = scan.next();
		
		int i;
		for(i=0; i<ar.length; i++) {
			
			if(ar[i]!=null) {
				if(ar[i].getPhone().equals(phone)) {
					System.out.println(ar[i].getName()
							+ "\t" + ar[i].getAge()
							+ "\t" + ar[i].getPhone()
							+ "\t" + ar[i].getAddress());
					
					System.out.print("수정 할 이름 입력: ");
					ar[i].setName(scan.next());
					System.out.print("수정 할 나이 입력: ");
					ar[i].setAge(scan.nextInt());
					System.out.print("수정 할 핸드폰 입력 : ");
					ar[i].setPhone(scan.next());
					System.out.print("수정 할 주소 입력 : ");
					ar[i].setAddress(scan.next());
					
					System.out.println("1 row updated");
					
					break;
				} //if phone
			} //if null
		} //for i
		if(i==ar.length) System.out.println("찾는 회원이 없습니다.");
	}
	
	//4번 선택시
	public void delete() {
		System.out.println("핸드폰 번호 입력: ");
		String phone = scan.next();
		
		int i;
		for(i=0; i<ar.length; i++) {
			
			if(ar[i]!=null) {
				if(ar[i].getPhone().equals(phone)) {
					ar[i]=null;
					
					System.out.println("1 row deleted");
				}
			}
		}
	}
}
