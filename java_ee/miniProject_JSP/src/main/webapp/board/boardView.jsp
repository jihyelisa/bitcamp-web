<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>
<%@ page import="java.util.Map" %>

<%
int seq = Integer.parseInt(request.getParameter("seq"));
int pg = Integer.parseInt(request.getParameter("pg"));

BoardDAO boardDAO = BoardDAO.getInstance();
BoardDTO boardDTO = boardDAO.boardView(seq);

String name = boardDTO.getName();
String subject = boardDTO.getSubject();
String content = boardDTO.getContent();
int hit = boardDTO.getHit();
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	body{
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
		}
	th {
		width: 100px;
		padding: 8px;
		background-color: #DF7857;
		color: #EDE9D5;
	}
	.subjectA:link, .subjectA:visited {color: #617143;}
	.subjectA:hover, .subjectA:active {color: #DF7857; text-decoration: underline;}
	a, span {text-decoration: none; cursor: pointer;}
	
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
	#currentPaging,
	#paging:hover, #paging:active {
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
	input {
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
	pre {
    	white-space: pre-wrap;
    }
    .info {
    	margin: 32px;
    }
    button {
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
</style>

</head>
<body>

<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<th>제목</th>
		<td><h1><%=subject%></h1></td>
	</tr>
	<tr>
		<td colspan="2">
			<span class="info">글번호: <%=seq%></span>
			<span class="info">작성자: <%=name%></span>
			<span class="info">조회수: <%=hit%></span>
		</td>
	</tr>
	<tr>
		<th>내용</th>
		<td><pre><%=content%></pre></td>
	</tr>
</table>
<br>
<button onclick="location.href='boardList.jsp?pg=<%=pg%>'">목록</button>

</body>
</html>