//등록
$('#writeBtn').click(function() {
	$.ajax({
		type: 'post',
		url: '/user/write',
		data: $('#writeForm').serialize(), //문자열 'name=홍길동&id=hong&pwd=111'을 전달
		success: function() {
			alert('등록 완료');
			location.href='/user/list'
		},
		error: function(err) {
			console.log(err);
		}
	})
})

//아이디 중복체크
$('#id').focusout(function() {
	if($('#id').val()=='') {
		$('#idDiv').text('아이디를 입력하세요');
	}
	else {
		$.ajax({
			type: 'post',
			url: '/user/isExistId',
			data: 'id=' + $('#id').val(),
			success: function(data) {
				console.log(data);
				
				if(data === 'exist') {
					$('#idDiv').text('이미 사용중인 아이디입니다');
					$('#id').focus();
				}
				else {
					$('#idDiv').text('사용 가능한 아이디입니다');
				}
			},
			error: function(err) {
				console.log(err);
			}
		})
	}
})