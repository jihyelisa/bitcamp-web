package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import user.bean.UserDTO;

/*
public class UserDAOImpl implements UserDAO {
	@Setter
	private JdbcTemplate jdbcTemplate;

//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	@Override
	public void write(UserDTO userDTO) {
		String sql = "INSERT INTO USERTABLE VALUES(?,?,?)";
		jdbcTemplate.update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "SELECT * FROM USERTABLE";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserDTO.class));
	}
}
*/

/*
public class UserDAOImpl extends JdbcDAOSupport implements UserDAO {

	@Override
	public void write(UserDTO userDTO) {
		String sql = "INSERT INTO USERTABLE VALUES(?,?,?)";
		getJdbcTemplate().update(sql, userDTO.getName(), userDTO.getId(), userDTO.getPwd());
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "SELECT * FROM USERTABLE";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(UserDTO.class));
	}
}
*/

public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
								//sql 구문에 ? 대신 이름을 넣을 수 있음
	@Override
	public void write(UserDTO userDTO) {
		String sql = "INSERT INTO USERTABLE VALUES(:name, :id, :pwd)";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", userDTO.getName());
		map.put("id", userDTO.getId());
		map.put("pwd", userDTO.getPwd());
		
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public List<UserDTO> getUserList() {
		String sql = "SELECT * FROM USERTABLE";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(UserDTO.class));
	}

	@Override
	public UserDTO getUser(String id) {
		String sql = "SELECT * FROM USERTABLE WHERE ID=?";
		try {
			return getJdbcTemplate().queryForObject(sql,
													new BeanPropertyRowMapper<UserDTO>(UserDTO.class),
													id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void update(Map<String, String> map) {
		String sql = "UPDATE USERTABLE SET NAME=:name, PWD=:pwd WHERE ID=:id";
		getNamedParameterJdbcTemplate().update(sql, map);
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE USERTABLE WHERE ID=:id";
		//getNamedParameterJdbcTemplate().update(sql, id);
		getJdbcTemplate().update(sql, id); //위 대신 사용해도 무관
	}
}