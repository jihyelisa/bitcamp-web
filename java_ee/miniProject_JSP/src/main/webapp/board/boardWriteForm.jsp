<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>

<style type="text/css">
	body{
		margin: 50px;
		font-family: serif;
		}
	h3 {
		color: #539165;
		}
	table {
		border-collapse: collapse;
		background-color: #B5EAEA;
		border: #EDF6E5 3px solid;
		}
	input, textarea {
		padding: 6px;
		background-color: #EDF6E5;
		border: #EDF6E5;
		color: #F38BA0;
		font-weight: 700;
	}
	th {
		padding: 8px;
		background-color: #F38BA0;
		color: #EDF6E5;
	}
	#subjectDiv, #contentDiv {
		margin-top: 8px;
		color: #F38BA0;
		font-weight: 600;
		font-size: 12px;
	}
</style>

</head>
<body>

<form name="boardWriteForm" method="post" action="boardWrite.jsp">
<table border="1" cellpadding="10" cellspacing="0">
	<tr>
		<th>제목</th>
		<td>
			<input type="text" name="subject">
			<div id="subjectDiv"></div>
		</td>
	</tr>
	
	<tr>
		<th>내용</th>
		<td>
			<textarea cols="50" rows="15" name="content"></textarea>
			<div id="contentDiv"></div>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<input type="submit" value="게시물 등록" onclick="checkBoardWrite()" style="margin-left:150px;">
			<input type="reset" value="다시 작성" style="margin-left:50px;">
		</td>
	</tr>

</table>
</form>

<script type="text/javascript">
function checkBoardWrite() {
	document.getElementById("subjectDiv").innerText = "";
	document.getElementById("contentDiv").innerText = "";

	if (document.boardWriteForm.subject.value == "") {
		document.getElementById("subjectDiv").innerText = "제목을 입력하세요";
		document.boardWriteForm.subject.focus();
	} else if (document.boardWriteForm.content.value == "") {
		document.getElementById("contentDiv").innerText = "내용을 입력하세요";
		document.boardWriteForm.content.focus();
	} else {
		document.boardWriteForm.submit();
	}
}
</script>

</body>
</html>