<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="board.dao.BoardDAO" %>

<%
//Data
BoardDAO boardDAO = BoardDAO.getInstance();
String id = request.getParameter("id");
boolean existId = boardDAO.checkId(id);
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (existId) { %>
	<form action="checkId.jsp">
	<p>이미 존재하는 아이디입니다.</p>
	아이디<input type="text" name="id"><input type="submit" value="중복체크">
	</form>
<% } else { %>
	<p>사용 가능한 아이디입니다.</p>
	<input type="button" value="사용하기" onclick="checkIdClose()">
<% } %>

<script type="text/javascript">
function checkIdClose() {
	opener.writeForm.id.value = "<%=id%>";
	opener.document.getElementById("idDiv").innerText = "";
	window.close();
	opener.writeForm.pwd.focus();
}
</script>

</body>
</html>