package user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

//DB와 연동하는 역할이므로 @Component 대신 @Repository 사용
@Repository
public class UserDAOImpl extends NamedParameterJdbcDaoSupport implements UserDAO {
	
	@Autowired
	public void setDS(DataSource dataSource) {
		setDataSource(dataSource); //JdbcDaoSupport에 있는 setDataSource 메소드를 호출
	}
	
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