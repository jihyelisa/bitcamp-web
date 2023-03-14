package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		UserDAO userDAO = UserDAO.getInstance();
		UserDTO userDTO = null;
		
		while (true) {
			System.out.print("찾고자 하는 아이디 입력: ");
			String id = scan.next();
			userDTO = userDAO.getUser(id);
			
			if (userDTO==null) System.out.println("존재하지 않는 아이디입니다.\n");
			
			else {
				System.out.println("[NAME]\t[ID]\t[PASSWORD]");
				System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
				break;
			}
		} //while

		System.out.print("변경할 이름 입력: ");
		String name = scan.next();
		System.out.print("변경할 비밀번호 입력: ");
		String pwd = scan.next();
		userDTO.setName(name);
		userDTO.setPwd(pwd);
		
		int su = userDAO.update(userDTO);
		if (su==1) {
			System.out.println("데이터 수정 완료");
		}
	}
}
