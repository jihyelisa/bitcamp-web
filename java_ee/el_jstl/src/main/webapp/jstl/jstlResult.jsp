<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fmt:requestEncoding value="UTF-8"/>
	<ul>
		<li>이름: ${param.name }</li>
		
		<li>
			나이: ${param.age }세
			<c:if test="${param.age >= 19 }"><strong>성인</strong></c:if>
			<c:if test="${param.age < 19 }"><strong>청소년</strong></c:if>
		</li>
		
		<li>
			색깔:
			<c:if test="${param.color == 'red' }">빨강</c:if>
			<c:if test="${param.color == 'green' }">초록</c:if>
			<c:if test="${param.color == 'blue' }">파랑</c:if>
			<c:if test="${param.color == 'magenta' }">핑크</c:if>
			<c:if test="${param.color == 'cyan' }">하늘</c:if>
		</li>
		
		<li>
			색깔:
			<c:choose>
				<c:when test="${param.color == 'red' }">빨강</c:when>
				<c:when test="${param.color == 'green' }">초록</c:when>
				<c:when test="${param.color == 'blue' }">파랑</c:when>
				<c:when test="${param.color == 'magenta' }">핑크</c:when>
				<c:otherwise>하늘</c:otherwise>
			</c:choose>
		</li>
		
		<!-- 체크박스 값들은 배열로 들어옴 -->
		<li>
			취미: ${paramValues.hobby[0] }
				 ${paramValues.hobby[1] }
				 ${paramValues['hobby'][2] }
				 ${paramValues['hobby'][3] }
				 ${paramValues['hobby'][4] }
		</li>
		
		<li>
			취미:
			<c:forEach var="data" items="${paramValues.hobby }">
				${data }
			</c:forEach>
		</li>
	</ul>
</body>
</html>