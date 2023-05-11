package user.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import user.bean.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO, String> { // <엔티티 클래스, primary key의 타입>
	// 쿼리 메소드
	// select * from usertable where name like '%'|| ? ||'%'
	
	public List<UserDTO> findByNameContaining(String keyword);
	public List<UserDTO> findByIdContaining(String keyword);
}
