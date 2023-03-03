package guestbook.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.bean.GuestbookDTO;
import guestbook.dao.GuestbookDAO;

@WebServlet("/GuestbookListServlet")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//html에서 주소를 타고 서블릿으로 바로 들어오므로 get 방식이어야 함
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//데이터
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//페이징 처리 - 1페이지당 2개씩
		int endNum = pg*2;
		int startNum = endNum-1;
		
		//DB
		GuestbookDAO guestbookDAO = GuestbookDAO.getInstance();
		ArrayList<GuestbookDTO> list = guestbookDAO.guestbookList(startNum, endNum);
		
		//총 글 수
		int totalA = guestbookDAO.getTotalA();
		
		//총 페이지 수
		int totalP = (totalA+1) / 2;
		
		//응답
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); //스트림 생성
		out.println("<html>");
		out.println("<style>");
		out.println("#currentPaging {float:left; text-align:center; width:20px; margin-right:10px;"
				  				  + "border: 1px pink solid; border-radius:50%;}");
		out.println("#paging {float:left; text-align:center;"
						   + "color:black; width:20px; margin-right:10px;}");
		out.println("a {text-decoration:none;}");
		
		out.println("</style>");
		out.println("<body style='margin:32px;'>");
		
		//페이지 번호
		for(int i=1; i<=totalP; i++) {
			if(i==pg) out.println("<div id ='currentPaging'><a href='/guestbookServlet/GuestbookListServlet?pg=" + i + "'>" + i + "</a></div>");
			else out.println("<div id ='paging'><a href='/guestbookServlet/GuestbookListServlet?pg=" + i + "'>" + i + "</a></div>");
		}
		
		out.println("<br/><br/>");
		
		for(GuestbookDTO guestbookDTO : list) {
			if (list==null) {
				out.println("<h3>글이 없습니다.</h3>");
				break;
			}
			else {
				out.println("<table border='1' cellpadding='10' cellspacing='0' width='400px'>");
				out.println("<tr><th>작성자</th><td>");
				out.println(guestbookDTO.getName());
				out.println("</td><th>작성일</th><td>");
				out.println(guestbookDTO.getLogtime());
				out.println("</td></tr><tr><th>이메일</th><td colspan='3'>");
				out.println(guestbookDTO.getEmail());
				out.println("</td></tr><tr><th>홈페이지</th><td colspan='3'>");
				out.println(guestbookDTO.getHomepage());
				out.println("</td></tr><tr><th>제목</th><td colspan='3'>");
				out.println(guestbookDTO.getSubject());
				out.println("</td></tr><tr><td colspan='4' height='200px'><pre>");
				out.println(guestbookDTO.getContent());
				out.println("</pre></td></tr>");
				out.println("</table><br/>");
			}
		}
		out.println("<input type='button' value='← 새글쓰기' onclick='location.href=\"http://localhost:8080/guestbookServlet/guestbook/guestbookWriteForm.html\"'>");
		out.println("</body>");
		out.println("</html>");
	}
}
