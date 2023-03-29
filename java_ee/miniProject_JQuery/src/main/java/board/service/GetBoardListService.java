package board.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.bean.BoardPaging;
import board.dao.BoardDAO;

public class GetBoardListService implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		//Data
		int pg = Integer.parseInt(request.getParameter("pg"));
		int endNum = pg*5;
		int startNum = endNum-4;
		
		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		String searchBy = request.getParameter("searchBy");
		String search = request.getParameter("search");
		List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
		
		//List 객체를 json으로 변환해 보내야 함
		//(boardList.js에서 받을 데이터 타입을 json으로 지정함)
		JSONObject json = new JSONObject();
		
		if(list != null) {
			JSONArray array = new JSONArray();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
			
			for(BoardDTO boardDTO: list) {
				JSONObject temp = new JSONObject();
				temp.put("seq", boardDTO.getSeq());
				temp.put("id", boardDTO.getId());
				temp.put("name", boardDTO.getName());
	            temp.put("email", boardDTO.getEmail());
	            temp.put("subject", boardDTO.getSubject());
	            temp.put("content", boardDTO.getContent());
	            temp.put("ref", boardDTO.getRef());
	            temp.put("lev", boardDTO.getLev());
	            temp.put("step", boardDTO.getStep());
	            temp.put("pseq", boardDTO.getPseq());
	            temp.put("reply", boardDTO.getReply());
	            temp.put("hit", boardDTO.getHit());
	            temp.put("logtime", sdf.format(boardDTO.getLogtime())); //logtime이 Date형이어서 에러 발생 - String으로 형변환
	            
	            array.add(temp);
			}
			json.put("list", array);
		}
		
		//응답
		request.setAttribute("json", json);
		return "/board/getBoardList.jsp";
	}
}
