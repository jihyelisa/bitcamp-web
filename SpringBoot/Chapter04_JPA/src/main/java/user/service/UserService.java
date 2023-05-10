package user.service;

import java.util.List;

import user.bean.UserDTO;

public interface UserService {
	public void write(UserDTO userDTO);
	public String isExistId(String id);
	public List<UserDTO> getList();
	public List<UserDTO> search(String searchOption, String keyword);
}
