//등록
$('#writeForm').click(function() {
	$.ajax({
		type: 'post',
		url: 'user/write',
		data: $('#writeForm').serialize(), //문자열 'name=홍길동&id=hong&pwd=111'을 전달
		success: function() {
			alert('등록 완료');
			
		},
		error: fuction(err) {
			console.log(err);
		}
	})
})