<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>사용 가능한 아이디입니다.</p>
<input type="button" value="사용하기" onclick="checkIdClose()">

<script type="text/javascript">
function checkIdClose() {
	opener.writeForm.id.value = "${ id }";
	opener.document.getElementById("idDiv").innerText = "";
	window.close();
	opener.writeForm.pwd.focus();
}
</script>

</body>
</html>