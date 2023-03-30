package board.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		//Pagination
		int totalA = boardDAO.getTotalA();
		
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setCurrentPage(pg);
		boardPaging.setTotalA(totalA);
		
		boardPaging.makePagingHTML();
		
		
		//List, BoardPaging 객체를 json으로 변환해 보내야 함
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
		
		//paging json으로 전달, pagingHTML 필드가 StringBuffer이기 때문에 형변환
		json.put("pagingHTML", boardPaging.getPagingHTML().toString());
		
		//글 조회 시 로그인 체크 위해 boardList.js에 아이디 전달
		HttpSession session = request.getSession();
		String memId = (String) session.getAttribute("memId");
		
		//응답
		request.setAttribute("memId", memId); //이것도 json.put() 해서 가져가도 문제 없음
		request.setAttribute("json", json);
		return "/board/getBoardList.jsp";
	}
}
