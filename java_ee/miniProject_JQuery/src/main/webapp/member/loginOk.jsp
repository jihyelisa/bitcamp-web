<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body style="background-color: #F7F7EE; margin: 30px;">
<img src="../image/orange1.jpg" alt="orange" onclick="location.href='../index.jsp'" style="width:100px; cursor:pointer;">
<h3>
	${ sessionScope.memName }님 로그인 성공
</h3>

<form method="post">
	<button type="button" onclick="location.href='/mvcMember/member/logout.do'" class="select">로그아웃</button>
	<button type="button" onclick="location.href='updateForm.jsp'" class="select">회원정보 수정</button>
	<button type="button" onclick="location.href='deleteForm.jsp'" class="select">회원 탈퇴</button>
</form>
</body>
</html>