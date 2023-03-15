<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>

<%@ page import="member.bean.MemberDTO" %>
<%@ page import="member.dao.MemberDAO" %>

<%
	//데이터
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	MemberDTO memberDTO = memberDAO.memberLogin(id, pwd);
	
	if (memberDTO.getName()==null) {
		//페이지 이동
		response.sendRedirect("loginFail.jsp");
	} else {
		//세션
		//HttpSession session = request.getSession(); //JSP는 세션 객체 생성 할 필요 없음 - 이미 내장돼 있음
		session.setAttribute("memName", memberDTO.getName());
		session.setAttribute("memEmail", memberDTO.getEmail1() + "@" + memberDTO.getEmail2());
		session.setAttribute("memId", id);
		session.setAttribute("memPwd", pwd);
		
		//페이지 이동
		response.sendRedirect("loginOk.jsp");
	} %>
</body>
</html>