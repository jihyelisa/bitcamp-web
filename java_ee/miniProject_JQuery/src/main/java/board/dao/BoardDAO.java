package board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import board.bean.BoardDTO;

public class BoardDAO {
	
	private static BoardDAO boardDAO = new BoardDAO();
	public static BoardDAO getInstance() {
		return boardDAO;
	}
	
	private SqlSessionFactory sqlSessionFactory;
	public BoardDAO() {
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
	
	public int boardWrite(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession(); //SqlSession 생성하는 메소드
		int su = sqlSession.insert("boardSQL.boardWrite", map); //("mapper xml 파일 안에 있는 태그의 id명", 넘겨줄 데이터)
		sqlSession.commit();
		sqlSession.close();
		return su;
	}
	
	public List<BoardDTO> boardList(int startNum, int endNum) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		list = sqlSession.selectList("boardSQL.boardList", map);
		sqlSession.close();
		return list;
	}
	
	public List<BoardDTO> boardSearch(String searchBy, String search) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Map<String, String> map = new HashMap<String, String>();
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		map.put("searchBy", searchBy);
		map.put("search", search);
		list = sqlSession.selectList("boardSQL.boardSearch", map);
		sqlSession.close();
		return list;
	}
	
	public int getTotalA() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int totalA = sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.close();
		return totalA;
	}
	
	public BoardDTO boardView(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.boardView", seq);
		sqlSession.close();
		return boardDTO;
	}
	
	public int boardReply(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		//1. step update - 같은 그룹 안에서 뒤로 보낼 글 step 밀기
		//update board set step=step+1 where ref=원글ref and step>원글step
		BoardDTO boardDTO = sqlSession.selectOne("boardSQL.boardView", map.get("pseq"));
		sqlSession.update("boardSQL.boardReply1", boardDTO);
		
		//2. insert
		//답글ref = 원글ref
		//답글lev = 원글lev+1
		//답글step = 원글step+1
		map.put("ref", boardDTO.getRef());
		map.put("lev", boardDTO.getLev()+1);
		map.put("step", boardDTO.getStep()+1);
		sqlSession.update("boardSQL.boardReply2", map);
		
		//3. reply update - 원글에 속하는 답글수 +1
		//update board set reply=reply+1 where seq=원글번호		
		int su = sqlSession.insert("boardSQL.boardReply3", boardDTO.getSeq());
		
		sqlSession.commit();
		sqlSession.close();
		return su;
	}
	
	public int boardUpdate(Map<String, Object> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int su = sqlSession.update("boardSQL.boardUpdate", map);
		sqlSession.commit();
		sqlSession.close();
		return su;
	}

	public void boardDelete(int seq) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//1. 원글 답글수 줄이기
		//2. 삭제글의 답글 앞에 말머리 붙이기
		//3. 삭제
		sqlSession.delete("boardSQL.boardDelete", seq);
		sqlSession.commit();
		sqlSession.close();
	}
}