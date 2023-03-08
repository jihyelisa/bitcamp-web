<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//쿠키
/*
Cookie[] ar = request.getCookies();

if(ar != null) {
	for(int i=0; i<ar.length; i++) {
		if(ar[i].getName().equals("memName")) {
			ar[i].setMaxAge(0); //쿠키 삭제
			response.addCookie(ar[i]);
		}
	}
}
*/

//세션
session.removeAttribute("memName");
session.removeAttribute("memId");

session.invalidate(); //한 번에 다 만료시키기
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>로그아웃 되었습니다.</h3>

<script type="text/javascript">
window.onload=function() {
	alert("로그아웃")
	location.href="../index.jsp"
}
</script>
</body>
</html>