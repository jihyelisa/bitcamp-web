package member;

import java.util.Collections;
import java.util.List;

public class MemberNameAsc implements Member {

	@Override
	public void execute(List<MemberDTO> list) {
		Collections.sort(list);
		
		System.out.println("이름\t나이\t핸드폰\t\t주소");
		for(MemberDTO memberDTO : list) {
			System.out.println(memberDTO);
		}//for
	}

}
