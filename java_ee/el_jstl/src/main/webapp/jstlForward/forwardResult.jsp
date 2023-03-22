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
결과 = ${ requestScope.list }<br>
세번째 항목 = ${ requestScope.list[2] }<br><br>

<!-- 아래처럼 쓰면 주소값으로 출력됨 -->
<!-- 결과 = ${ requestScope.list2 } -->

<c:forEach var="personDTO" items="${ list2 }">
	이름 = ${ personDTO.getName() } &emsp; 나이 = ${ personDTO.getAge() }<br>
	<!-- 변수명을 메소드명 대신 사용 가능 -->
	이름 = ${ personDTO.name } &emsp; 나이 = ${ personDTO.age }<br>
</c:forEach>
</body>
</html>