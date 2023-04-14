<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- Ajax 통신 -->
<form>
	<table border="1">
		<tr>
		
		</tr>
	</table>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$('#camera').click(function(){
	//강제 이벤트 발생
	$('#img').trigger('click');
})

//업로드 버튼을 누르기 전에 카메라 아이콘을 통해 선택한 이미지가 맞는지 확인
$('#img').charge(function(){
	readURL(this);
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