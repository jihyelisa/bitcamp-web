<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="pg" value="${pg}">

<h3>
	<a href="/chapter06_SpringMaven/">
		<img src="/chapter06_SpringMaven/image/orange1.jpg" width="50" height="50">
		목록
	</a>
</h3>

<table id="userListTable" border="1" frame="hsides" rules="rows" cellspacing="0" cellpadding="5">
	<tr>
		<th width="150">이름</th>
		<th width="150">아이디</th>
		<th width="150">비밀번호</th>
	</tr>
	
	<!-- 동적 처리 -->
	
</table>

	<div id="userPagingDiv" style="width: 650px; text-align: center; margin-top: 3px;"></div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/list.js"></script>
<script type="text/javascript">
function userPaging(pg){
	location.href = "/chapter06_SpringMaven/user/list?pg=" + pg;
}
</script>
</body>
</html>