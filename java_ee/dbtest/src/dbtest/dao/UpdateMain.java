package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	//Connection 인터페이스는 추상메소드 아주 많음
	//implements와 Override하기보다 connection 객체를 반환하는 메소드 사용
	private Connection conn;
	private PreparedStatement pstmt;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "C##JAVA";
	private String password = "1234";
	
	public UpdateMain() { //driver loading
		try {
			//Class타입으로 생성 (new 사용 불가)
			Class.forName(driver);
			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void updateArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름 입력: ");
		String name = scan.next();
		
		this.getConnection(); //아래의 접속 메소드 호출

		String sql = "UPDATE DBTEST SET AGE=AGE+1, HEIGHT=HEIGHT+1 WHERE NAME LIKE ?";
		try {
			//sql 문장을 처리해줄 가이드를 생성함
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			int su = pstmt.executeUpdate(); //위에서 만든 가이드 실제로 실행, 행 개수 반환
			System.out.println(su + "행의 나이와 키가 1씩 증가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				//DB 사용할 때는 항상 마지막에 닫아주기
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	//생성자 안에 접속 코드를 작성하면 단 한 번만 접속 가능하게  됨
	//언제나 접속할 수 있게 따로 메소드 작성
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("connection 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	public static void main(String[] args) {
		UpdateMain um = new UpdateMain();
		um.updateArticle();

	}

}

/*
검색할 이름 입력: 홍
-> 홍이 들어간 레코드의 나이, 키 1씩 증가
*/