package board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class BoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		//Data
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardList.jsp?pg=1");
		return "/index.jsp";
	}
}
