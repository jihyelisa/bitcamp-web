package member;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberPhoneSearch implements Member {

	@Override
	public void execute(ArrayList<MemberDTO> arrayList) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("휴대폰 번호를 입력하시오: ");
		String phone = scan.next();
		
		for(MemberDTO data : arrayList) {
			if (data.getPhone().equals(phone)) {
				
				System.out.print(data.getName() + "  ");
				System.out.print(data.getAge() + "  ");
				System.out.print(data.getPhone() + "  ");
				System.out.println(data.getAddress());
			}
		}
	}
}
