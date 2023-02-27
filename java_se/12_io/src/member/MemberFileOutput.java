package member;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberFileOutput implements Member {

	@Override
	public void execute(ArrayList<MemberDTO> arraylist) {
		//throws 사용 불가 - override당한 메소드 찾아다니며 일일이 다 넣어줘야 함
		//대신 try-catch 사용
		
		try {
			FileOutputStream fos = new FileOutputStream("member.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(arraylist); //객체 리스트를 write로 oos에 전달
			oos.close();
		
		} catch(IOException e) {
			e.printStackTrace();
			}
		
	}

}
