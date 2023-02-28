package testOjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example {
	private String name="Lisa";
	private String job="student";
	private int grade=4;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //테이블 형태
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public Example() { //생성자로 driver loading
		try {
			Class.forName(driver);
			System.out.println("driver loading 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//1. 입력 선택 시
	public void insertArticle() {
		
		this.getConnection(); // DB 접속
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO EXAMPLE VALUES(?, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setString(2, job);
			pstmt.setInt(3, grade);
			int su = pstmt.executeUpdate(); //insert된 행 수 반환
			System.out.println(su + "행 추가 완료");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} //1. 입력 메소드
	
	//2. 검색 선택 시
	public void selectArticle() {
		
		this.getConnection();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM EXAMPLE");
			rs = pstmt.executeQuery(); //테이블 형태로 결과 반환
			System.out.println("name: " + rs.getString("name") + "\t"
							 + "job: " + rs.getString("job") + "\t"
							 + "grade: " + rs.getInt("grade"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} //2. 검색 메소드
	
	//3. 삭제 선택 시
	public void deleteArticle() {
		
		this.getConnection(); // DB 접속
		
		String sql = "DELETE STUDENT2 WHERE NAME=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			int su = pstmt.executeUpdate();
			System.out.println(su + "개 행이 삭제되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	} //3. 삭제 메소드
	
	//DB 접속 메소드
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void main(String[] args) {
		Example example = new Example();
		example.insertArticle();
		example.selectArticle();
		example.deleteArticle();
	}
}




