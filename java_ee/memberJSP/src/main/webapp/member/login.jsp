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
	String name = memberDAO.memberCheck(id, pwd);
	
	//데이터를 쿠키에 실을 건지 세션에 실을 건지 - 세션을 더 많이 사용
	if (name==null) {
		//페이지 이동
		response.sendRedirect("loginFail.jsp");
	} else {
		//쿠키
		/*
		Cookie cookie = new Cookie("memName", name);
		cookie.setMaxAge(30*60); //데이터 30분간 유지
		response.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("memId", id);
		cookie2.setMaxAge(30*60); //데이터 30분간 유지
		response.addCookie(cookie2);
		*/

		//세션
		//HttpSession session = request.getSession(); //JSP는 세션 객체 생성 할 필요 없음 - 이미 내장돼 있음
		session.setAttribute("memName", name);
		session.setAttribute("memId", id);
		session.setAttribute("memPwd", pwd);
		
		//페이지 이동
		response.sendRedirect("loginOk.jsp");
	} %>
</body>
</html>