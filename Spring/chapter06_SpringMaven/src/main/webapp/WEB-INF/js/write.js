//등록
$('#writeBtn').click(function(){
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#name').val() == '') {
		$('#nameDiv').text('이름을 입력하세요');
		$('#name').focus();
	}
	else if($('#id').val() == '') {
		$('#idDiv').text('아이디를 입력하세요');
		$('#id').focus();
	}
	else if($('#pwd').val() == '') {
		$('#pwdDiv').text('비밀번호를 입력하세요');
		$('#pwd').focus();
	}
	else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringMaven/user/write.js',
			data: $('#writeForm').
			success: function(){
				alert("가입을 축하합니다.");
				location.href='/chapter06_SpringMaven/user/list'
			},
			error: function(err){
				console.log(err);
			}
		});
	}
});

//아이디 중복체크
$('#id').focusout(function(){
	alert('test alert');
});