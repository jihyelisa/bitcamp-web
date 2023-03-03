<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	//전역 - 한 번만 실행됨
	String name = "홍길동";
	int age = 25;
%>

<%
	//스크립트릿 - 지역, 호출시마다 실행
	age++;
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test</title>
</head>
<body>

<!-- html 주석: 브라우저 화면에 안 보일 뿐 소스는 전달됨 -->
<!-- This is a test page, hello!<br/> -->
<!-- 주석 안의 java 코드도 작동함 -->
<!-- 내 나이는 <%=age %>살입니다.<br>  -->

<%-- jsp 주석: 아예 소스가 브라우저로 전달되지도 않음 --%>
<%-- 한글도 잘 나와요.<br/> --%>
<%-- 당연히 주석 안의 java 코드도 작동 안 함 --%>
<%-- 내 나이는 <%=age %>살입니다.<br> --%>

나의 이름은 <%=name %>입니다.<br/>

</body>
</html>