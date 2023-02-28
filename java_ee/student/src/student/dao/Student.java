package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	Scanner scan = new Scanner(System.in);
	private String name, value;
	private int code;
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //테이블 형태
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public Student() { //생성자로 driver loading
		try {
			Class.forName(driver);
			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//1. 입력 선택 시
	public void insertArticle() {
		System.out.println("\n****************");
		System.out.println("\t1. 학생");
		System.out.println("\t2. 교수");
		System.out.println("\t3. 관리자");
		System.out.println("\t4. 이전 메뉴");
		System.out.println("****************");
		System.out.print("\t번호선택: ");
		int num = scan.nextInt();
		if (num==4) return;
		
		System.out.print("이름 입력: ");
		name = scan.next();
		if (num==1) {System.out.print("학번 입력: "); code = 1;}
		else if (num==2) {System.out.print("과목 입력: "); code = 2;}
		else if (num==3) {System.out.print("부서 입력: "); code = 3;}
		value = scan.next();
		
		this.getConnection(); // DB 접속
		
		String sql = "INSERT INTO STUDENT2 VALUES(?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, value);
			pstmt.setInt(3, code);
			int su = pstmt.executeUpdate();
			System.out.println(su + "행 추가되었습니다.");
			
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
		System.out.println("\n****************");
		System.out.println("    1. 이름 검색");
		System.out.println("    2. 전체 검색");
		System.out.println("    3. 이전 메뉴");
		System.out.println("****************");
		System.out.print("    번호선택: ");
		int num = scan.nextInt();
		if (num==3) return;
		
		this.getConnection();
		
		//sql문 작성
		String sql="SELECT * FROM STUDENT2";
		if(num==1) sql += " WHERE NAME LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			if (num==1) {
				System.out.print("검색할 이름 입력: ");
				name = scan.next();
				pstmt.setString(1, "%" + name + "%");
			} //if
			
			rs = pstmt.executeQuery(); //테이블 형태로 결과 반환
			while(rs.next()) {
				String code_name=null;
				if(rs.getInt("code")==1) code_name="학번";
				if(rs.getInt("code")==2) code_name="과목";
				if(rs.getInt("code")==3) code_name="부서";
				
				System.out.println("이름=" + rs.getString("name") + "\t"
								 + code_name + "=" + rs.getString("value"));				
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
	} //2. 검색 메소드
	
	//3. 삭제 선택 시
	public void deleteArticle() {
		System.out.print("삭제할 이름 정확히 입력: ");
		name = scan.next();
		
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
			System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	//menu 반복 메소드
	public void menu() {
		while(true) {
			System.out.println("\n****************");
			System.out.println("\t관리");
			System.out.println("****************");
			System.out.println("\t1. 입력");
			System.out.println("\t2. 검색");
			System.out.println("\t3. 삭제");
			System.out.println("\t4. 종료");
			System.out.println("****************");
			System.out.print("\t번호선택: ");
			int num = scan.nextInt();
			
			if (num==4) break;
			if (num==1) insertArticle();
			if (num==2) selectArticle();
			if (num==3) deleteArticle();
		} //while
	}

	
	//menu 호출
	public static void main(String[] args) {
		Student student = new Student();
		student.menu();
	}
}
