package board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;
import board.bean.BoardDTO;
import board.bean.BoardPaging;

public class BoardListService implements CommandProcess {

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
		
		int totalA = boardDAO.getTotalA();
		int totalP = (totalA + 4) / 5;
		
		//Pagination
		BoardPaging boardPaging = new BoardPaging();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(3);
		boardPaging.setPageSize(5);
		boardPaging.setCurrentPage(pg);
		boardPaging.setTotalA(totalA);
		
		boardPaging.makePagingHTML();

		request.setAttribute("list", list);
		request.setAttribute("boardPaging", boardPaging);
		
		request.setAttribute("display", "/board/boardList.jsp?pg=1");
		return "/index.jsp";
	}
}
