package user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO, String> { // <엔티티 클래스, primary key의 타입>
	
	// 쿼리 메소드
	// select * from usertable where name like '%'|| ? ||'%'
	public List<UserDTO> findByNameContaining(String keyword);
	public List<UserDTO> findByIdContaining(String keyword);
	
	// 어노테이션
	// 검색 대상이 테이블 x, 영속성 컨텍스트에 등록된 엔티티 o
	// 작명 시 대소문자 구분하여 정확히
	@Query("select dto from UserDTO dto where dto.name like '%' || ?1 || '%'") // * 사용불가, 1은 물음표 수
	public List<UserDTO> getUserSearchName(String keyword);
	@Query("select dto from UserDTO dto where dto.id like '%' || :keyword || '%'") // ? 대신 :변수명 사용가능
	public List<UserDTO> getUserSearchId(String keyword);
}
