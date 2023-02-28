package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMain {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //테이블 형태
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public SelectMain() { //driver loading
		try {
			Class.forName(driver);
			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void selectArticle() {
		
		this.getConnection();
		
		String sql = "SELECT * FROM DBTEST";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //테이블 형태로 결과 반환
			
			while(rs.next()) {
				System.out.println(rs.getString("name") + "\t"
								 + rs.getInt("age") + "\t"
								 + rs.getDouble("height") + "\t"
								 + rs.getString("logtime"));				
			} //while
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
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		SelectMain sm = new SelectMain();
		sm.selectArticle();
	}
}
