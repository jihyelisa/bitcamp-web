<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#writeForm div {
		color: red;
		font-size: 8pt;
		font-weight: bold;
	}
</style>
</head>
<body>

<h3>
	<a href="/chapter06_SpringMaven/">
		<img src="/chapter06_SpringMaven/image/orange1.jpg" width="50" height="50">
		회원가입
	</a>
</h3>

<form id="writeForm">
<table>
	<tr>
		<th width="100">이름</th>
		<td>
			<input type="text" name="name" id="name">
			<div id="nameDiv"></div>
		</td>
	</tr>
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id" id="id">
			<div id="idDiv"></div>
		</td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td>
			<input type="password" name="pwd" id="pwd">
			<div id="pwdDiv"></div>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="button" value="등록" id="writeBtn">
			<input type="reset" value="취소">
		</td>
	</tr>
</table>
</form>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/write.js"></script>
</body>
</html>