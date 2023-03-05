<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>

<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>

<%
	//데이터
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	boolean isMember = memberDAO.memberCheck(id, pwd);

	if (isMember==false) {
%>
	<h3>로그인 실패</h3>
	<input type='button' value='← 이전' onclick='history.go(-1)'>
	
	<% } else { %>
	<h3>로그인 성공</h3>
	
	<form method="post" action="updateForm.jsp">
	<button type="submit" name="id" value=<%=id%> class="select">회원정보 수정</button>
	</form>
	<% } %>
</body>
</html>