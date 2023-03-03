package member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import member.bean.MemberDTO;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //테이블 형태
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
					//"db 접근:db 종류:oracle에서 사용하는 드라이브:@어디로 접속:포트번호"
	private String username = "C##JAVA";
	private String password = "1234";
	
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
			//Class타입으로 생성 (new 사용 불가)
			Class.forName(driver);
			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	//언제나 접속할 수 있게 따로 메소드 작성
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public int memberWrite(MemberDTO memberDTO) {
		int su = 0;
		String sql = "insert ";
		
		//생성자 안에 접속 코드를 작성하면 단 한 번만 접속 가능하게 됨
		this.getConnection();
		
		sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
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
			System.out.println(su + "행이(가) 삽입되었습니다.");
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			MemberDAO.close(conn, pstmt);
			//close를 static 함수로 선언해서 new 할 필요 없게 함
		} return su;
	}
	
	public boolean memberCheck(String id, String pwd) {
		boolean isMember = false;
		String sql = "SELECT ID, PWD FROM MEMBER";
		
		//생성자 안에 접속 코드를 작성하면 단 한 번만 접속 가능하게 됨
		this.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //테이블 형태로 결과 반환
			
			while(rs.next()) {
				if(rs.getString("ID").equals(id) && rs.getString("PWD").equals(pwd)) {
						isMember=true;
						break;
				} //if
			} //while
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			MemberDAO.close(conn, pstmt, rs);
			//close를 static 함수로 선언해서 new 할 필요 없게 함
		}
		return isMember;
	}
}
