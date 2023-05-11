package user.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void write(UserDTO userDTO) {
		userDAO.save(userDTO); //JpaRepository의 메소드 save()를 사용
	}
	
	@Override
	public String isExistId(String id) {
		Optional<UserDTO> userDTO = userDAO.findById(id); //존재하지 않는 id일 경우 Optional.empty 출력
		System.out.println(userDTO);
		
		if(userDTO.isPresent()) {
			return "exist";
		}
		else return "non_exist";
	}

	@Override
	public List<UserDTO> getList() {
		return userDAO.findAll();
	}

	@Override
	public List<UserDTO> search(Map<String, String> map) {
		String searchOption = map.get("searchOption");
		String keyword = map.get("keyword");
		if(searchOption.equals("name")) {
			return userDAO.findByNameContaining(keyword);
		}
		else {
			return userDAO.findByIdContaining(keyword);
		}
	}

	@Override
	public Optional<UserDTO> searchById(String searchId) {
		Optional<UserDTO> userDTO = userDAO.findById(searchId);
		return userDTO;
	}

	@Override
	public String delete(Map<String, String> map) {
		String pwd = userDAO.findById(map.get("id")).get().getPwd();

		System.out.println("서비스");
		System.out.println(pwd);
		System.out.println(map);
		
		if(pwd.equals(map.get("pwd"))) {
			userDAO.deleteById(map.get("id"));
			return "match";
		}
		else return "unmatch";
	}
}
