<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>*** 변수 설정 ***</h3>
<c:set var="name" value="홍길동"/> <!-- 태그 사이에 넣을 값 없으면 닫는 태그 안 써도 됨 -->
<c:set var="age">25</c:set>

나의 이름은 <c:out value="${name}"></c:out>입니다.<br>
내 나이는 ${age}살입니다.<br><br>

<h3>*** forEach ***</h3>
<c:forEach var="i" begin="1" end="10" step="1">
	${i }&emsp;
	<c:set var="sum" value="${sum+i }"/>
</c:forEach>

<br>
1~10까지의 합 = ${sum }<br><br>

<c:forEach var="j" begin="1" end="10" step="1">
	<c:set var="k" value="${11-j }"/>
	${k }&emsp;
</c:forEach>

</body>
</html>