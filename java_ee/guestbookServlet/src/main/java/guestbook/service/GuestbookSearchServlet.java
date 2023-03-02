package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookSearchServlet")
public class GuestbookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터
		request.setCharacterEncoding("UTF-8");
		String seq = request.getParameter("seq");
		
		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		GuestbookDTO guestbookDTO = guestbookDAO.guestbookSearch(seq);
		String name=guestbookDTO.getName();
		String email=guestbookDTO.getEmail();
		String homepage=guestbookDTO.getHomepage();
		String subject=guestbookDTO.getSubject();
		String content=guestbookDTO.getContent();
		String logtime=guestbookDTO.getLogtime();
	
		//응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		if (logtime==null) {
			out.println("<h3>검색 결과가 없습니다.</h3>");
			//이전 버튼
			out.println("<input type='button' value='← 다시 검색' onclick='history.go(-1)'>");
		}
		else {
			out.println("<h3>검색 결과</h3>");
			out.println("<table border='1' cellpadding='10' cellspacing='0'>");
			out.println("<tr><th>작성자</th><td>");
			out.println(name);
			out.println("</td><th>작성일</th><td>");
			out.println(logtime);
			out.println("</td></tr><tr><th>이메일</th><td colspan='3'>");
			out.println(email);
			out.println("</td></tr><tr><th>홈페이지</th><td colspan='3'>");
			out.println(homepage);
			out.println("</td></tr><tr><th>제목</th><td colspan='3'>");
			out.println(subject);
			out.println("</td></tr><tr><td colspan='4'>");
			out.println(content);
			out.println("</td></tr>");
			out.println("</table><br/>");
			out.println("<input type='button' value='← 다시 검색' onclick='history.go(-1)'>");
			out.println("</body>");
			out.println("</html>");
		}
	}
}
