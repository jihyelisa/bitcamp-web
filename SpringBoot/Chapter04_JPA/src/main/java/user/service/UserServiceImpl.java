package user.service;

import java.util.List;
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
	public List<UserDTO> search(String searchOption, String keyword) {
		return null;
	}
}
