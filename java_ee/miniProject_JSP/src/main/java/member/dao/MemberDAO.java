package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.dao.BoardDAO;
import member.bean.MemberDTO;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //테이블 형태
	
//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//					//"db 접근:db 종류:oracle에서 사용하는 드라이브:@어디로 접속:포트번호"
//	private String username = "C##JAVA";
//	private String password = "1234";
	
	//위처럼 직접 connection을 하지 않고 서버에 만들어놓은 connection pool을 사용
	private DataSource ds;
	
	private static MemberDAO memberDAO = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return memberDAO;
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
	
	public MemberDAO() { //생성자로 driver loading
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			//Tomcat 서버는 java:comp/env/를 앞에 붙여주어야 함
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	//언제나 접속할 수 있게 따로 메소드 작성
//	public void getConnection() {
//		try {
//			conn = DriverManager.getConnection(url, username, password);
//			System.out.println("connection 성공");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
		
	public int memberWrite(MemberDTO memberDTO) {
		int su = 0;
		String sql = "insert ";
		
		
		sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getId());
			pstmt.setString(3, memberDTO.getPwd());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getEmail1());
			pstmt.setString(6, memberDTO.getEmail2());
			pstmt.setString(7, memberDTO.getPhone1());
			pstmt.setString(8, memberDTO.getPhone2());
			pstmt.setString(9, memberDTO.getPhone3());
			pstmt.setString(10, memberDTO.getZipcode());
			pstmt.setString(11, memberDTO.getAddr1());
			pstmt.setString(12, memberDTO.getAddr2());
			
			su = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt);
			//close를 static 함수로 선언해서 new 할 필요 없게 함
		} return su;
	}
	
	public MemberDTO memberLogin(String id, String pwd) {
		MemberDTO memberDTO = new MemberDTO();
		String sql = "SELECT * FROM MEMBER WHERE ID=? AND PWD=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery(); //테이블 형태로 결과 반환
			
			if(rs.next()) {
				memberDTO = new MemberDTO();
				memberDTO.setName(rs.getString("NAME"));
				memberDTO.setEmail1(rs.getString("EMAIL1"));
				memberDTO.setEmail2(rs.getString("EMAIL2"));
			} //if
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt, rs);
		} return memberDTO;
	}
	
	public MemberDTO memberUpdateForm(String id) {
		MemberDTO memberDTO = new MemberDTO();
		String sql = "SELECT * FROM MEMBER WHERE ID=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				memberDTO.setName(rs.getString("NAME"));
				memberDTO.setPwd(rs.getString("PWD"));
				memberDTO.setGender(rs.getString("GENDER"));
				memberDTO.setEmail1(rs.getString("EMAIL1"));
				memberDTO.setEmail2(rs.getString("EMAIL2"));
				memberDTO.setPhone1(rs.getString("TEL1"));
				memberDTO.setPhone2(rs.getString("TEL2"));
				memberDTO.setPhone3(rs.getString("TEL3"));
				memberDTO.setZipcode(rs.getString("ZIPCODE"));
				memberDTO.setAddr1(rs.getString("ADDR1"));
				memberDTO.setAddr2(rs.getString("ADDR2"));
			} //if
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt, rs);
		} return memberDTO;
	}
	
	public int memberUpdate(MemberDTO memberDTO) {
		int su = 0;
		String sql = "UPDATE MEMBER SET NAME=?, PWD=?, GENDER=?, EMAIL1=?, EMAIL2=?,"
				   + "TEL1=?, TEL2=?, TEL3=?, ZIPCODE=?, ADDR1=?, ADDR2=? WHERE ID=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDTO.getName());
			pstmt.setString(2, memberDTO.getPwd());
			pstmt.setString(3, memberDTO.getGender());
			pstmt.setString(4, memberDTO.getEmail1());
			pstmt.setString(5, memberDTO.getEmail2());
			pstmt.setString(6, memberDTO.getPhone1());
			pstmt.setString(7, memberDTO.getPhone2());
			pstmt.setString(8, memberDTO.getPhone3());
			pstmt.setString(9, memberDTO.getZipcode());
			pstmt.setString(10, memberDTO.getAddr1());
			pstmt.setString(11, memberDTO.getAddr2());
			pstmt.setString(12, memberDTO.getId());
			
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt);
		} return su;
	}
	
	public int memberDelete(String id) {
		int su = 0;
		String sql = "DELETE FROM MEMBER WHERE ID=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			su = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MemberDAO.close(conn, pstmt);
		} return su;
	}
}
