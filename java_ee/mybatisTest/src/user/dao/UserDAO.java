package user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.bean.UserDTO;

public class UserDAO {
	private SqlSessionFactory sqlSessionFactory; //sql 세션을 만들기 위해 필요
	
	private static UserDAO userDAO = new UserDAO();
	public static UserDAO getInstance() {
		return userDAO;
	}
	
	public UserDAO() {
//		Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
		
		InputStream inputStream;
		try {
			//만들어 놓은 환경설정 파일 읽어옴
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			//환경설정 파일 읽은 것을 기반으로 sql 세션 생성
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //SqlSession 생성하는 메소드
		sqlSession.insert("userSQL.write", userDTO); //("mapper xml 파일 안에 있는 태그의 id명", 넘겨줄 데이터)
		sqlSession.commit();
		sqlSession.close();
	}

	public List<UserDTO> getUserList() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");
		sqlSession.close();
		return list;
	}
	
	public UserDTO getUser(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO = null;
		userDTO = sqlSession.selectOne("userSQL.getUser", id);
		sqlSession.close();
		return userDTO;
	}
	
	public int update(UserDTO userDTO) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("userSQL.update", userDTO);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}
	
	public void delete(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete", id);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<UserDTO> search(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search", map);
		sqlSession.close();
		return list;
	}
}
