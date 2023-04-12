package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateService implements UserService {
	@Setter
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println();
		System.out.print("수정할 아이디 입력: ");
		map.put("id", scan.next());
		UserDTO userDTO = userDAO.getUser(map.get("id"));
		
		if(userDTO==null) {
			System.out.println("없는 아이디입니다.");
		} else {
			System.out.print("* 수정할 이름 입력 : ");
			map.put("name", scan.next());
			System.out.print("* 수정할 비밀번호 입력 : ");
			map.put("pwd", scan.next());
			
			userDAO.update(map);
			System.out.println("정보가 수정되었습니다.");
			System.out.println();
		}
	}
}
