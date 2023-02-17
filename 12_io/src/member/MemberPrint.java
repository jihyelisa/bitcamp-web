package member;

import java.util.ArrayList;

public class MemberPrint implements Member {

	@Override
	public void execute(ArrayList<MemberDTO> arrayList) {

		for(MemberDTO data : arrayList) {

			System.out.print(data.getName() + "  ");
			System.out.print(data.getAge() + "  ");
			System.out.print(data.getPhone() + "  ");
			System.out.println(data.getAddress());
		}
		
		
	}

}
