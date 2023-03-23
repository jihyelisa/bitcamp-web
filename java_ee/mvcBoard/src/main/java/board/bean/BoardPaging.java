package board.bean;

import lombok.Data;

@Data
public class BoardPaging {
	private int currentPage; //현재페이지
	private int pageBlock; //[이전][1][2][3][다음]
	private int pageSize; //1페이지 당 5개씩
	private int totalA; //총 글 수
	private StringBuffer pagingHTML;
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer(); //생성
		int totalP = (totalA + pageSize - 1) / pageSize; //총 페이지 수
		int startPage = (currentPage -1) / pageBlock * pageBlock + 1;
		
		int endPage = startPage + pageBlock - 1;
		if (endPage > totalP) endPage = totalP;
		
		if(startPage > pageBlock) {
			pagingHTML.append("<span id='prevNext' onclick='boardPaging(" + (startPage-1) + ")'>이전</span>");
		}
		
		for (int i=startPage; i<=endPage; i++) {
			if (i==currentPage) {
				pagingHTML.append("<span id='currentPaging' onclick='boardPaging(" + i + ")'>" + i + "</span>");
			}
			else pagingHTML.append("<span id='paging' onclick='boardPaging(" + i + ")'>" + i + "</span>");
		}
		
		if (endPage < totalP) {
			pagingHTML.append("<span id='prevNext' onclick='boardPaging(" + (endPage+1) + ")'>다음</span>");
		}
	}
}
