package member;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MemberNameAsc implements Member {

	@Override
	public void execute(ArrayList<MemberDTO> arraylist) {
		Collections.sort(arraylist, );
		
		for(MemberDTO data : arraylist) {
			System.out.print(data.getName() + "  ");
			System.out.print(data.getAge() + "  ");
			System.out.print(data.getPhone() + "  ");
			System.out.println(data.getAddress());
		}
		
	}

}
