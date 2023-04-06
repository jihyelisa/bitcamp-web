<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %> <%-- XML태그 시작 전에 내용의 공백을 제거 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- DB연동 - 아이디 hong이고 비번 111이면 로그인 성공으로 취급(true) --%>

<c:set var="result" value="true" />
<c:set var="message" value="홍길동님이 로그인하였습니다." />


<c:if test="${param.user_password != '111'}">
	<c:set var="result" value="false" />
	<c:set var="message" value="비밀번호가 맞지 않습니다." />
	
	<c:if test="${param.user_id != 'hong'}">
		<c:set var="result" value="false" />
		<c:set var="message" value="가입되지 않은 아이디입니다." />
	</c:if>
</c:if>

<%-- XML로 보내기 - 위의 contentType을 xml로 바꿔줌 --%>
<?xml version="1.0" encoding="UTF-8"?>
<check_id>
	<result>${result}</result>
	<message>${message}</message>
</check_id>
