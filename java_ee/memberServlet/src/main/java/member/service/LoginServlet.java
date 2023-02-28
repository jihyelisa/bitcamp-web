package member.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//데이터
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	boolean isMember = memberDAO.memberCheck(id, pwd);

	//응답
	response.setContentType("text/html; charset=UTF-8");
	PrintWriter out = response.getWriter();
	out.println("<html>");
	out.println("<body>");
	if (isMember==false) {
		out.println("<h3>로그인 실패</h3>");
		//이전 버튼
		out.println("<input type='button' value='← 이전' onclick='history.go(-1)'>");
	}
	else out.println("<h3>로그인 성공</h3>");
	out.println("</body>");
	out.println("</html>");
	}
}
