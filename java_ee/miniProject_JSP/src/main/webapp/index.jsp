<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	body {background-color: #F7F7EE;}
	img {margin-top: 30px;}
	h2 {color: #17706E; font-family: serif; font-weight: 700; margin-bottom: 30px;}
	a:link, a:visited {color: #FB7813;}
	a:hover, a:active {color: #B6EB7A;}
	a {text-decoration: none;}
</style>

</head>
<body>
<div style="text-align: center;">
<img src="image/ice.jpg" alt="icecream" onclick="location.href='index.jsp'" style="width:50px; cursor:pointer;">

<h2><i>[ main ]</i></h2>
<h3>
<% if (session.getAttribute("memId") == null) { %>
	<a href="./member/writeForm.jsp">회원가입</a><br><br>
	<a href="./member/loginForm.jsp">로그인</a><br><br>
	
<% } else { %>
	<a href="./member/logout.jsp">로그아웃</a><br><br>
	<a href="./member/updateForm.jsp">회원정보수정</a><br><br>
	<a href="./member/deleteForm.jsp">회원탈퇴</a><br><br>
	<a href="./board/boardWriteForm.jsp">글쓰기</a><br><br>
<% } %>
	<a href="./board/boardList.jsp?pg=1">목록</a><br>
</h3>
</div>
</body>
</html>