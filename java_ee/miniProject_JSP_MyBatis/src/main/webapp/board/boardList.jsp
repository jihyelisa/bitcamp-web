<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>
<%@page import="board.bean.BoardPaging"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
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
%>

<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style type="text/css">
	body {
		margin: 50px;
		background-color: #EDE9D5;
		font-family: serif;
		font-weight: 600;
	}
	h3 {
		color: #617143;
	}
	table {
		width: 600px;
		text-align: center;
		border-collapse: collapse;
		background-color: #EDE9D5;
		color: #617143;
		border: #E7AB9A 2px solid;
		border-left: transparent;
		border-right: transparent;
	}
	th {
		padding: 8px;
		background-color: #DF7857;
		color: #EDE9D5;
	}
	a, span {
		text-decoration: none;
		cursor: pointer;
	}
	
	.subjectA:link, .subjectA:visited {
		color: #617143;
	}
	.subjectA:hover, .subjectA:active {
		color: #DF7857; text-decoration: underline;
	}	
	#currentPaging, #paging, #prevNext {
		height: 20px;
		width: 20px;
		float:left;
		text-align:center;
		margin-right:10px;
		font-weight: 700;
		border-radius: 50%;
		color: #DF7857;
		border: 2px #DF7857 solid;
	}
	#currentPaging, #paging:hover, #paging:active {
		color: #617143;
		border: 2px #617143 solid;
	}
	#prevNext {
		width: 50px;
		padding: 2px 4px;
		color: #DF7857;
		border-radius: 50%;
		border: 2px transparent solid;
	}
	#prevNext:hover, #prevNext:active {
		border-radius: 10%;
		color: #617143;
		border: 2px #617143 solid;
	}
	.paging {
		color: #DF7857;
		padding: 5px;
	}
	.main {
		background-color: #E7AB9A;
		border: none;
		color: white;
		padding: 5px 20px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 200px;
  		cursor: pointer;
	}
	.searchForm {
		}
</style>
</head>

<body>
<h3><i>LIST</i></h3>
<form name="boardList">
<table border="1" cellpadding="10" cellspacing="0" rules="rows">
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성일</th>
	</tr>

<% for (BoardDTO boardDTO : list) { %>
	<tr>
		<td><%=boardDTO.getSeq()%></td>
		
		<td>
		<% if (session.getAttribute("memId")==null) { %>
			<a class="subjectA" onclick="loginFirst()"><%=boardDTO.getSubject()%></a>
		<% } else { %>
			<a class="subjectA" href="boardView.jsp?seq=<%=boardDTO.getSeq()%>&pg=<%=pg%>"><%=boardDTO.getSubject()%></a>
		<% } %>
		</td>
		
		<td><%=boardDTO.getName()%></td>
		<td><%=boardDTO.getHit()%></td>
		<td>
			<%=new SimpleDateFormat("yyyy.MM.dd").format(boardDTO.getLogtime())%>
		</td>
	</tr>
<% } %>
	
</table>
<br>

<!-- 페이징 출력 클래스 -->
<%=boardPaging.getPagingHTML()%>

<input type="button" class="main" value="← main" onclick="location.href='../index.jsp'">
</form>

<form class="searchForm" method="get" action="boardList.jsp">
<select name="searchBy">
	<option value="name">작성자</option>
	<option value="subject">제목</option>
</select>
<input type="text" name="search" id="search">
<input type="hidden" name="pg" value=1>
<input type="submit" value="검색">
</form>

<script type="text/javascript">
function boardPaging(pg) {
	location.href="boardList.jsp?pg=" + pg;
}
function loginFirst() {
	alert("먼저 로그인하세요");
	location.href="../member/loginForm.jsp";
}
</script>
</body>
</html>