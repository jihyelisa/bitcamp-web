package board.service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.control.CommandProcess;

public class GetBoardService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		BoardDTO boardDTO = boardDAO.boardView(seq);
		
		//json 객체에 담기
		JSONObject json = new JSONObject();
		json.put("seq", seq);
		json.put("name", boardDTO.getName());
		json.put("subject", boardDTO.getSubject());
		json.put("content", boardDTO.getContent());
		json.put("hit", boardDTO.getHit());

		request.setAttribute("json", json);
		
		return "/board/getBoard.jsp";
	}
}
