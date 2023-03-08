<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="member.dao.MemberDAO" %>

<%
String id = (String)session.getAttribute("memId");
session.invalidate(); //세션 전체 무효화

MemberDAO memberDAO = MemberDAO.getInstance();
int su = memberDAO.memberDelete(id);

if (su==1) {
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successfully removed</title>
</head>
<body>
<script type="text/javascript">
window.onload=function(){
	alert("회원 탈퇴 완료");
	location.href = "../index.jsp";
}
</script>
<% } %>
</body>
</html>