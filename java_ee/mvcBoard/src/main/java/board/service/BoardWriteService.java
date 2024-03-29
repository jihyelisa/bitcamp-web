package board.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardWriteService implements CommandProcess {
	
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		//세션 생성
		HttpSession session = request.getSession();

		//임시로 세션에 데이터 등록
		session.setAttribute("memId", "jh");
		session.setAttribute("memName", "jh");
		session.setAttribute("memEmail", "jh@naver.com");
		//세션 데이터 꺼내옴
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");

		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("name", name);
		map.put("email", email);
		map.put("subject", subject);
		map.put("content", content);
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.boardWrite(map);
		
		//응답
		return "/board/boardWrite.jsp";
	}
}