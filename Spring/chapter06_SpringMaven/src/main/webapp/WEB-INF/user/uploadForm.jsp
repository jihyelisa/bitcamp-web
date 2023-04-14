<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>
	<a href="/chapter06_SpringMaven/"><img src="/chapter06_SpringMaven/image/orange1.jpg" width="50" height="50"></a>
	파일 업로드
</h3>

<!-- 단순 submit으로 연결 -->
<form method="post" enctype="multipart/form-data" action="/chapter06_SpringMaven/user/upload">
	<input type="file" name="img">
	<input type="submit" value="업로드 하기">
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$('#camera').click(function(){
	//강제 이벤트 발생
	$('#img').trigger('click');
});

function readURL(input){
	var reader = new FileReader();
	
	reader.onload = function(e){
		$('#showImg').attr('src', e.target.result); //e.target - 이벤트가 발생하는 요소를 반환
	}
	reader.readAsDataURL(input.files[0]);
}
</script>
</body>
</html>