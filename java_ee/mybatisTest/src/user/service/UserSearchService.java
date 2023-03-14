package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserSearchService implements UserService {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		int num = 0;
		
		System.out.println();
		System.out.println("***************");
		System.out.println("  1. 이름으로 검색");
		System.out.println("  2. 아이디로 검색");
		System.out.println("  3. 종료");
		System.out.println("***************");
		System.out.print("   번호 선택 : ");
		num = scan.nextInt();
		
		Map<String, String> map = new HashMap<String, String>();
		
		if(num == 1) {
			System.out.print("찾으려는 이름 입력: ");
			map.put("name", scan.next());
			map.put("id", "");
		}
		else if(num == 2) {
			System.out.print("찾으려는 아이디 입력: ");
			map.put("id", scan.next());
			map.put("name", "");
		}

		UserDAO userDAO = UserDAO.getInstance();
		List<UserDTO> list= userDAO.search(map);
		System.out.println("[NAME]\t[ID]\t[PASSWORD]");
		for(UserDTO userDTO : list) {
			System.out.println(userDTO.getName() + "\t" + userDTO.getId() + "\t" + userDTO.getPwd());
		}
	}
}
