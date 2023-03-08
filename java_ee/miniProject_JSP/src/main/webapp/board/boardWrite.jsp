<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>

<%
request.setCharacterEncoding("UTF-8");
String subject = request.getParameter("subject");
String content = request.getParameter("content");

BoardDTO boardDTO = new BoardDTO();
boardDTO.setSubject(subject);
boardDTO.setContent(content);

//DB
BoardDAO boardDAO = BoardDAO.getInstance();
int su = boardDAO.boardWrite(boardDTO);

//응답
if (su==1) {
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시물 등록 완료</h3>
<% } %>
</body>
</html>