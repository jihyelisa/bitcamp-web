<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#pwdDiv {
	color: red;
	font-size: 12px;
	font-weight: bold;
}
</style>
</head>
<body>
	<img src="https://images.pexels.com/photos/14270010/pexels-photo-14270010.jpeg" onclick="location.href='/'" width="100"/>
	<br/><br/>
	
	<p>
		삭제할 아이디 입력 
		<input type="text" id="searchId" />
		<input type="button" id="searchIdBtn" value="검색" />
	</p>
	<div id="resultDiv"></div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="/js/delete.js"></script>
</body>
</html>