<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="member.dao.MemberDAO" %>
<%@ page import="member.bean.MemberDTO" %>
  
<%
//데이터
request.setCharacterEncoding("UTF-8");
String id = (String)session.getAttribute("memId"); //

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
int su = memberDAO.memberDelete(id);

if (su==1) {
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Membership Cancellation</title>
</head>
<body>
<h3>회원 탈퇴가 완료되었습니다.</h3>
</body>
</html>

<% } %>