package user.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import user.bean.UserDTO;

public interface UserService {
	public void write(UserDTO userDTO);
	public String isExistId(String id);
	public List<UserDTO> getList();
	public List<UserDTO> search(Map<String, String> map);
	public Optional<UserDTO> searchById(String searchId);
	public String delete(Map<String, String> map);
}
