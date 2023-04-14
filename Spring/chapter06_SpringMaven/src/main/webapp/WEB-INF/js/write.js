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
			url: '/chapter06_SpringMaven/user/write',
			data: $('#writeForm').serialize(),
			success: function(){
				alert("가입을 축하합니다!");
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
	$('#idDiv').empty();
	
	if($('#id').val() == '') {
		$('#idDiv').text('아이디를 입력하세요');
		$('#id').focus();
	}
	else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringMaven/user/isExistId',
			data: 'id=' + $('#id').val(),
			dataType: 'text',
			success: function(data){
				if(data == 'exist') {
					$('#idDiv').text('이미 사용중인 아이디입니다.');
					$('#idDiv').css('color', 'red');
				}
				else {
					$('#idDiv').text('사용 가능한 아이디입니다.');
					$('#idDiv').css('color', 'blue');
				}
			},
			error: function(err){
				console.log(err);
			}
		});
	} //else
});