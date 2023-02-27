package member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberInsert implements Member {
	
	@Override
	public void execute(ArrayList<MemberDTO> arrayList) {
		Scanner scan = new Scanner(System.in);

		System.out.print("이름을 입력하시오: ");
		String name = scan.next();
		System.out.print("나이를 입력하시오: ");
		int age = scan.nextInt();
		System.out.print("휴대폰 번호를 입력하시오: ");
		String phone = scan.next();
		System.out.print("주소를 입력하시오: ");
		String address = scan.next();
		
		
		MemberDTO memberDTO = new MemberDTO(name, age, phone, address);
		arrayList.add(memberDTO);
	}
}
