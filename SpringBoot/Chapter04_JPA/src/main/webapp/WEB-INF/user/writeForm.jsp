<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#idDiv {
	color: red;
	font-size: 12px;
	font-weight: bold;
}
</style>
</head>
<body>
	<img src="https://images.pexels.com/photos/14270010/pexels-photo-14270010.jpeg" onclick="location.href='/'" width="100"/>
	<form id="writeForm">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" /></td>
			</tr>
			
			<tr>
				<th>아이디</th>
				<td>
					<input id="id" type="text" name="id"/>
					<div id="idDiv"></div>
				</td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input id="writeBtn" type="button" value="등록"/>
					<input type="reset" value="취소"/>
				</td>
			</tr>
		</table>
	</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="/js/write.js"></script>
</body>
</html>