package member;

import java.util.ArrayList;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.IOException;

public class MemberFileInput implements Member {

	@Override
	public void execute(ArrayList<MemberDTO> arraylist) {
		
		arraylist.clear(); //MemberService에서 생성한 arraylist를 초기화하고 파일 안 데이터를 불러옴

		//내가 쓴 코드
//		try {
//			FileInputStream fis = new FileInputStream("member.txt");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			ArrayList<MemberDTO> memberList = (ArrayList<MemberDTO>)ois.readObject();
//
//			for(MemberDTO memberDTO : memberList) {
//
//				System.out.print(memberDTO.getName() + "  ");
//				System.out.print(memberDTO.getAge() + "  ");
//				System.out.print(memberDTO.getPhone() + "  ");
//				System.out.println(memberDTO.getAddress());
//			} //for
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

		
			//선생님 코드
		try {
			FileInputStream fis = new FileInputStream("member.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			while(true) {
				try {
					MemberDTO memberDTO = (MemberDTO)ois.readObject();
					arraylist.add(memberDTO);
					
				} catch (EOFException e) { //EOF - 파일의 끝에 옴
					break; //파일 끝까지 가면 break로 for문 종료
				}
			} //while
			
			ois.close();
			System.out.println("파일 읽어오기 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
