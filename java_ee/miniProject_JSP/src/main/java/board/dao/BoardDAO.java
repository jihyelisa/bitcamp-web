package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import board.bean.BoardDTO;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //테이블 형태
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
					//"db 접근:db 종류:oracle에서 사용하는 드라이브:@어디로 접속:포트번호"
	private String username = "C##JAVA";
	private String password = "1234";
	
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
		
	public int boardWrite(BoardDTO boardDAO) {
		int su = 0;
		String sql = "INSERT INTO (SEQ, SUBJECT, CONTENT) BOARD VALUES (SEQ_BOARD.NEXTVAL,?,?)";
		
		//생성자 안에 접속 코드를 작성하면 단 한 번만 접속 가능하게 됨
		this.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDAO.getSubject());
			pstmt.setString(2, boardDAO.getContent());
			
			su = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BoardDAO.close(conn, pstmt);
			//close를 static 함수로 선언해서 new 할 필요 없게 함
		} return su;
	}
	
}