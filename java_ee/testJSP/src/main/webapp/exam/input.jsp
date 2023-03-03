<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<title>Insert title here</title>

<form name="calcForm" method="get" action="result.jsp">
<!-- method: get 또는 post 중 데이터 보낼 방식 선택 -->
<!-- action: submit 눌렀을 때 어느 주소로 데이터 보낼지 지정 -->

<h3>XY 계산기</h3>

<table border="1" cellpadding="5" cellspacing="0">
<tr>
	<th width="70">X</th>
	<td>
		<input type="text" name="x">
	</td>
</tr>

<tr>
	<th width="70">Y</th>
	<td>
		<input type="text" name="y">
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
		<input type="submit" value="계산">
		<input type="reset" value="취소">
	</td>
</tr>
</table>
</form>
</body>
</html>