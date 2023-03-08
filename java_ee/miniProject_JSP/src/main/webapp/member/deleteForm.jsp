<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="member.dao.MemberDAO" %>
<%@ page import="member.bean.MemberDTO" %>
    
<%
request.setCharacterEncoding("UTF-8");
//세션으로 값 받아옴
String id = (String)session.getAttribute("memId");
String sessionPwd = (String)session.getAttribute("memPwd");
//입력한 값을 submit으로 다시 받아옴
String paramPwd = request.getParameter("pwd");

//비밀번호 일치 확인
boolean isCorrect = false;
if (paramPwd != null && paramPwd.equals(sessionPwd)) {
	isCorrect = true;
	response.sendRedirect("delete.jsp");
} %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Membership Cancellation</title>
</head>
<body>
<form name="deleteForm" method="post" action="deleteForm.jsp">
	<div style="text-align: center;">
	
		비밀번호 입력: <input type="password" name="pwd" id="pwd">
		
		<input type="button" value="탈퇴하기" onclick="checkDelete()">
		<br>
		<div id="pwdDiv">
			<%if(paramPwd != null && !isCorrect){ %>
				비밀번호가 일치하지 않습니다.
			<% } %>
		</div>
	</div>
</form>

<script type="text/javascript">
function checkDelete() {
	document.getElementById("pwdDiv").innerText = "";
	
	if(document.getElementById("pwd").value == "")
		document.getElementById("pwdDiv").innerText = "비밀번호를 입력하시오";
	else
		document.deleteForm.submit();
}
</script>
</body>
</html>