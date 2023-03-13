package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //테이블 형태
	
	private DataSource ds;
	
	private static BoardDAO boardDAO = new BoardDAO();
	public static BoardDAO getInstance() {
		return boardDAO;
	}
	
	private static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null) conn.close();
			if(conn != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) pstmt.close();
			if(pstmt != null) conn.close();
			if(conn != null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public BoardDAO() { //생성자로 driver loading
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			//Tomcat 서버는 java:comp/env/를 앞에 붙여주어야 함
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public int boardWrite(Map<String, String> map) {
		int su = 0;
		String sql = "INSERT INTO BOARD (SEQ,ID,NAME,EMAIL,SUBJECT,CONTENT,REF)"
				   + "VALUES (SEQ_BOARD.NEXTVAL,?,?,?,?,?,SEQ_BOARD.CURRVAL)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("id"));
			pstmt.setString(2, map.get("name"));
			pstmt.setString(3, map.get("email"));
			pstmt.setString(4, map.get("subject"));
			pstmt.setString(5, map.get("content"));
			
			su = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(conn, pstmt);
			//close를 static 함수로 선언해서 new 할 필요 없게 함
		} return su;
	}
	
	public List<BoardDTO> boardList(int startNum, int endNum) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "SELECT * "
				   + "FROM (SELECT ROWNUM RN, AA.* "
				   + "FROM (SELECT * FROM BOARD ORDER BY REF DESC, STEP ASC) AA "
				   + ") WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("SEQ"));
				boardDTO.setId(rs.getString("ID"));
				boardDTO.setName(rs.getString("NAME"));
				boardDTO.setEmail(rs.getString("EMAIL"));
				boardDTO.setSubject(rs.getString("SUBJECT"));
				boardDTO.setContent(rs.getString("CONTENT"));
				boardDTO.setRef(rs.getInt("REF"));
				boardDTO.setLev(rs.getInt("LEV"));
				boardDTO.setStep(rs.getInt("STEP"));
				boardDTO.setPseq(rs.getInt("PSEQ"));
				boardDTO.setReply(rs.getInt("REPLY"));
				boardDTO.setHit(rs.getInt("HIT"));
				boardDTO.setLogtime(rs.getDate("LOGTIME"));
				
				list.add(boardDTO);
			} //while
		
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; //에러났을 경우 null로 초기화
		} finally {
			BoardDAO.close(conn, pstmt, rs);
		} return list;
	}
	
	public int getTotalA() {
		String sql = "SELECT COUNT(*) FROM BOARD";
		int totalA = 0;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) totalA = rs.getInt("COUNT(*)");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(conn, pstmt, rs);
		} return totalA;
	}
	
	public BoardDTO boardView(int seq) {
		String sql = "SELECT * FROM BOARD WHERE SEQ=?";
		BoardDTO boardDTO = new BoardDTO();
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				boardDTO.setSeq(rs.getInt("SEQ"));
				boardDTO.setId(rs.getString("ID"));
				boardDTO.setName(rs.getString("NAME"));
				boardDTO.setEmail(rs.getString("EMAIL"));
				boardDTO.setSubject(rs.getString("SUBJECT"));
				boardDTO.setContent(rs.getString("CONTENT"));
				boardDTO.setRef(rs.getInt("REF"));
				boardDTO.setLev(rs.getInt("LEV"));
				boardDTO.setStep(rs.getInt("STEP"));
				boardDTO.setPseq(rs.getInt("PSEQ"));
				boardDTO.setReply(rs.getInt("REPLY"));
				boardDTO.setHit(rs.getInt("HIT"));
				boardDTO.setLogtime(rs.getDate("LOGTIME"));
			} //while
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(conn, pstmt, rs);
		} return boardDTO;
	}
	
	public boolean checkId(String id) {
		boolean existId = false;
		String sql = "SELECT * FROM BOARD WHERE ID=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) existId = true;
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(conn, pstmt, rs);
		} return existId;
	}
}