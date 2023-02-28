package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertMain {
	//Connection 인터페이스는 추상메소드 아주 많음
	//implements와 Override하기보다 connection 객체를 반환하는 메소드 사용
	private Connection conn;
	private PreparedStatement pstmt;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
					//"db 접근:db 종류:oracle에서 사용하는 드라이브:@어디로 접속:포트번호"
	private String username = "C##JAVA";
	private String password = "1234";
	
	public InsertMain() { //생성자로 driver loading
		try {
			//Class타입으로 생성 (new 사용 불가)
			Class.forName(driver);
			System.out.println("driver loading 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void insertArticle() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력: ");
		String name = scan.next();
		System.out.print("나이 입력: ");
		int age = scan.nextInt();
		System.out.print("키 입력: ");
		double height = scan.nextDouble();
		
		
		this.getConnection(); //아래의 접속 메소드 호출
		
		//변수 명시해주면 보안 약함
//		String sql = "insert into dbtest values('" + name + "', " + age + ", " + height + ", SYSDATE)";
		//?에 데이터 대입
		String sql = "insert into dbtest values(?, ?, ?, SYSDATE)";
		
		try {
			//sql 문장을 처리해줄 가이드를 생성함
			pstmt = conn.prepareStatement(sql);
			//sql문 속 ?에 넣어줄 값 순서대로 지정
			pstmt.setString(1, name); //java와 다르게 oracle은 0이 아닌 1부터 시작
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			int su = pstmt.executeUpdate(); //위에서 만든 가이드 실제로 실행, 행 개수 반환
			System.out.println(su + "행이(가) 삽입되었습니다.");
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
		InsertMain im = new InsertMain();
		im.insertArticle();

	}

}
