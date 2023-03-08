<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>

<% 
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String gender = request.getParameter("gender");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String zipcode = request.getParameter("zipcode");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setName(name);
	memberDTO.setId(id);
	memberDTO.setPwd(pwd);
	memberDTO.setGender(gender);
	memberDTO.setEmail1(email1);
	memberDTO.setEmail2(email2);
	memberDTO.setPhone1(phone1);
	memberDTO.setPhone2(phone2);
	memberDTO.setPhone3(phone3);
	memberDTO.setZipcode(zipcode);
	memberDTO.setAddr1(addr1);
	memberDTO.setAddr2(addr2);
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	int su = memberDAO.memberWrite(memberDTO);
	
	//응답
%>
<% if (su==0) { %>
	<h3>회원가입 실패</h3>
	<input type='button' value='← 이전' onclick='history.go(-1)'>
	<input type='button' value='로그인' onclick="location.href='loginForm.jsp'">
<% } else { %>
	<h3>회원가입 성공</h3>
	<input type='button' value='← 이전' onclick='history.go(-1)'>
	<input type='button' value='로그인' onclick="location.href='loginForm.jsp'">
<% } %>
</body>
</html>