package user.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserDeleteService implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println();
		System.out.print("삭제할 아이디 입력: ");
		String id = scan.next();
		UserDTO userDTO = userDAO.getUser(id);
		
		if(userDTO==null) {
			System.out.println("없는 아이디입니다.");
		} else {			
			userDAO.delete(id);
			System.out.println("계정이 삭제되었습니다.");
			System.out.println();
		}
	}
}
