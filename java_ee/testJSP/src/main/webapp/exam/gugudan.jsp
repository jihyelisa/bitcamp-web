<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>

<body>

<form name="paramForm" method="get">
<!-- method: get 또는 post 중 데이터 보낼 방식 선택 -->
<!-- action: submit 눌렀을 때 어느 주소로 데이터 보낼지 지정 -->

<table border="1" cellpadding="5" cellspacing="0">
<% for(int i=1; i<10; i++) { %>

	<tr>
		<% for(int dan=2; dan<10; dan++) { %>
	
			<td><%= dan %> * <%= i %> = <%= dan*i %></td>
			
		<% } %><br>
	</tr>
<% } %>

</table>
</body>
</html>