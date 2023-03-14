package user.service;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		UserDAO userDAO = UserDAO.getInstance();
		
		String id;
		while (true) {
			System.out.print("검색할 아이디 입력: ");
			id = scan.next();
			UserDTO userDTO = userDAO.getUser(id);
			
			if (userDTO==null) System.out.println("존재하지 않는 아이디입니다.\n");
			
			else {
				userDAO.delete(id);
				System.out.println("계정이 삭제되었습니다.");
				break;
			}
		} //while
	}
}
