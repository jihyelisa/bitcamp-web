package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.bean.MemberDTO;
import member.dao.MemberDAO;

//@WebServlet("/writeServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	//데이터
		//get과 다르게 post 방식을 사용할 때는 DB로 데이터 넘기기 전 인코딩 처리 해야 함
	request.setCharacterEncoding("UTF-8");
		//getParameter는 name 속성으로 값을 찾아 가져온다.
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String gender = request.getParameter("gender");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String zipcode = request.getParameter("zipcode");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setName(name);
	memberDTO.setId(id);
	memberDTO.setPwd(pwd);
	memberDTO.setGender(gender);
	memberDTO.setEmail1(email1);
	memberDTO.setEmail2(email2);
	memberDTO.setPhone1(phone1);
	memberDTO.setPhone2(phone2);
	memberDTO.setPhone3(phone3);
	memberDTO.setZipcode(zipcode);
	memberDTO.setAddr1(addr1);
	memberDTO.setAddr2(addr2);
		
	
	//DB
	
//	MemberDAO memberDAO = new MemberDAO();
	//Servlet에서 new 하는 대신 static 객체를 생성하는 메소드 getInstance를 만들어 쓰는 이유
	//여기서 new 하면 form을 제출할 때마다 힙 영역에 새 객체가 생성 - 메모리 낭비
	//static 객체는 메모리상 static 영역에 단 한 번만 생성된다 - 메모리 효율 높음
	MemberDAO memberDAO = MemberDAO.getInstance();
	int su = memberDAO.memberWrite(memberDTO);

	
	//응답
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<body>");
	if (su==0) {
		out.println("<h3>회원가입 실패</h3>");
		//이전, 로그인 버튼
		out.println("<input type='button' value='← 이전' onclick='history.go(-1)'>");
		out.println("<input type='button' value='로그인' onclick=\"location.href='http://localhost:8080/memberServlet/loginForm.html'\">");
	}
	else out.println("<h3>회원가입 성공</h3>");
	out.println("<input type='button' value='← 이전' onclick='history.go(-1)'>");
	out.println("<input type='button' value='로그인' onclick=\"location.href='http://localhost:8080/memberServlet/loginForm.html'\">");
	out.println("</body>");
	out.println("</html>");
	}
}
