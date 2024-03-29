package user.dao;

import java.util.List;
import java.util.Map;

import user.bean.UserDTO;

public interface UserDAO {

	public void write(UserDTO userDTO);
	public UserDTO getUser(String id);
	public List<UserDTO> getUserList(Map<String, Integer> map);
	public void update(UserDTO userDTO);
	public int getTotalA();
}
