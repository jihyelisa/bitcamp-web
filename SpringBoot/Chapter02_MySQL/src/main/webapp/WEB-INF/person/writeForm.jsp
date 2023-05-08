<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="writeForm" border="1">
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age" /></td>
			</tr>
			<tr colspan="2">
				<img id="showImg" width=50" />
				<img id="camera" src="/img/camera.png" width="50" height="50" />
				<input type="file" id="img" name="img" style="visibility: hidden" />
			</tr>
			<tr colspan="2">
				<input id="writeBtn" type="button" value="등록" />
				<input type="reset" value="취소" />
			</tr>
		</table>
	</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="/js/write.js"></script>
<script type="text/javascript">
$('#camera').click(function() {
	// 강제 이벤트 발생
	$('#img').trigger('click');
});

// 업로드 버튼 누르기 전에 카메라 아이콘으로 미리보기


</script>
</body>
</html>