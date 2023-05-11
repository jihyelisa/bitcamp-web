<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<img src="https://images.pexels.com/photos/14270010/pexels-photo-14270010.jpeg" onclick="location.href='/'" width="100"/>
	<br/><br/>
	
	<table class="userList" style="border:none">
		<tr>
			<th width="100">이름</th>
			<th width="100">아이디</th>
			<th width="100">비밀번호</th>
		</tr>
	</table>
	<br/>
	
	<div style="width:450px">
		<form id="searchForm">
			<select id="searchOption" name="searchOption">
				<option value="name">이름</option>
				<option value="id">아이디</option>
			</select>
			<input type="text" id="keyword" name="keyword" />
			<input type="button" id="searchBtn" value="검색" />
		</form>
	</div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="/js/list.js"></script>
</body>
</html>