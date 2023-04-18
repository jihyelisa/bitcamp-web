package user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.bean.UserPaging;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserPaging userPaging;

	@Override
	public void write(UserDTO userDTO) {
		userDAO.write(userDTO);
	}

	@Override
	public String isExistId(String id) {
		UserDTO userDTO = userDAO.getUser(id);
		if(userDTO == null)
			return "non_exist";
		else
			return "exist";
	}

	@Override
	public Map<String, Object> getUserList(String pg) {
		
		int endNum = Integer.parseInt(pg) * 3;
		int startNum = endNum - 2;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		
		List<UserDTO> list = userDAO.getUserList(map);
		System.out.println(list);
		
		//페이징 처리 - 1페이지당 3개씩
		int totalA = userDAO.getTotalA(); //총글수
		
		userPaging.setCurrentPage(Integer.parseInt(pg));
		userPaging.setPageBlock(3);
		userPaging.setPageSize(3);
		userPaging.setTotalA(totalA);
		userPaging.makePagingHTML(); //HTML 생성 메소드
		
		Map<String, Object> userListMap = new HashMap<String, Object>();
		userListMap.put("list", list);
		userListMap.put("userPaging", userPaging);
		
		return userListMap;
	}

	@Override
	public void update(UserDTO userDTO) {
		userDAO.update(userDTO);
	}
}
