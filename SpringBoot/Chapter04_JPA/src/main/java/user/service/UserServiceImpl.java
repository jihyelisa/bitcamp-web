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

	// 쿼리 메소드 사용
//	@Override
//	public List<UserDTO> search(Map<String, String> map) {
//		String searchOption = map.get("searchOption");
//		String keyword = map.get("keyword");
//		if(searchOption.equals("name")) {
//			return userDAO.findByNameContaining(keyword);
//		}
//		else {
//			return userDAO.findByIdContaining(keyword);
//		}
//	}

	// 어노테이션 사용
	@Override
	public List<UserDTO> search(Map<String, String> map) {
		String searchOption = map.get("searchOption");
		String keyword = map.get("keyword");
		if(searchOption.equals("name")) {
			return userDAO.getUserSearchName(keyword);
		}
		else {
			return userDAO.getUserSearchId(keyword);
		}
	}

/*
쿼리 메소드
JPA에서 제공하는 CrudRepository, 또는 JpaRepository를 이용해서 기본적인 CRUD 기능을 수행했다.
일반적으로 JPA를 이용해서 목록 기능을 구현할 때는 JPQL(Java Persistence Query Language)을 이용하면 된다.
JPQL은 검색 대상이 테이블이 아닌 엔티티 라는 것만 제외하고는 기본 구조와 문법이 기존의 SQL과 유사하다.

스프링 JPA에서는 복잡한 JPQL을 대신해서 처리할 수 있는 쿼리 메소드라는 기능을 제공한다.
쿼리 메소드는 메소드의 이름으로 필요한 쿼리를 만들어주는 기능이다.

쿼리 메소드를 작성할 때 엔티티 이름은 생략할 수 있다.
현재 사용하는 Repository 인터페이스에서 선언된 타입 정보를 기준으로 자동 엔티티 이름이 적용된다.

쿼리 메소드의 리턴 타입은 Page<T>, Slice<T>, List<T> 이며 모두 Collection<T> 타입이다.
이 중에서 가장 많이 사용하는 것은 Page<T>, List<T>로서, 단순히 목록을 검색하려면 List<T>를 사용하고 페이징 처리를 하려면 Page<T>를 사용하면 된다.
------------------------

@Query 어노테이션
일반적인 쿼리는 지금까지 학습한 스프링 데이터 JPA의 쿼리 메소드만으로도 충분하다. 
하지만 복잡한 쿼리를 사용하거나 연관관계에 기반한 조인 검색을 처리하기 위해서는 JPQL(Java Persistence Query Language)을 사용해야 한다. 
또는 성능상 어쩔 수 없이 특정 데이터베이스에 종속적인 네이티브 쿼리를 사용해야하는 경우도 있다.

JPQL은 일반적인 SQL과 유사한 문법을 가지고 있지만 검색 대상이 테이블이 아니라 영속성 컨텍스트에 등록된 엔티티이다.
따라서 FROM 절에 엔티티 이름과 컬럼 대신 엔티티가 가지고 있는 변수를 조회하기 때문에
SELECT나 WHERE 절에서 사용하는 변수 이름은 대소문자를 구분하여 정확하게 지정해야 한다.
*/

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
