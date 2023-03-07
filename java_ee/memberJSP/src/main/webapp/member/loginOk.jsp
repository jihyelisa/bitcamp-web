<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
//데이터
String name = null;
String id = null;

//쿠키
/*
Cookie[] ar = request.getCookies(); //특정 쿠키를 선택해서 가져올 수는 x, 전체 다 가져와야 함
if (ar != null) {
	for(int i=0; i<ar.length; i++) {
		String cookieName = ar[i].getName();
		String cookieValue = ar[i].getValue();

		System.out.println("쿠키명 = " + cookieName);
		System.out.println("쿠키값 = " + cookieValue);
		System.out.println();

		if(cookieName.equals("memName")) name = cookieValue;
		if(cookieName.equals("memId")) id = cookieValue;
	}
}
*/

//세션
name = (String)session.getAttribute("memName");
id = (String)session.getAttribute("memId");
//getAttribute()는 값을 Object 타입으로 가져옴
//자식 클래스인 String이 부모 클래스 Object를 바로 참조할 수 없으므로 형변환

session.setAttribute("memId", id);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h3><%=name%>님 로그인</h3>

<form method="post">
	<button type="button" onclick="location.href='logout.jsp'" class="select">로그아웃</button>
	<button type="button" onclick="location.href='updateForm.jsp'" class="select">회원정보 수정</button>
	<button type="button" onclick="location.href='deleteForm.jsp'" class="select">회원 탈퇴</button>
</form>
</body>
</html>