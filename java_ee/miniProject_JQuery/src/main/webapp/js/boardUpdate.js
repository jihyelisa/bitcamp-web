const subject;
const content;

//$(function() {}); - 아래처럼도 작성 가능
$(document).ready(function() {
	$.ajax({
		type: 'post',
		url: '/miniProject_JQuery/board/getBoard.do',
		data: 'seq='+ $('#seq').val(),
		dataType: 'json', //객체를 담아올 수 있는 자료형 없음, json 형식으로 받아야 함
		success: function(data) {
			subject = data.subject;
			content = data.content;
			$('#subject').attr('value', subject);
			$('#content').html(content);
		},
		
		error: function(err) {
			console.log(err);
		}
	});
});

$('#boardResetBtn').click(function(){
		$('#subject').attr('value', subject);
		$('#content').html(content);
});

$('#boardWriteBtn').click(function() {
	if($('#subject').val() == '') {
		$('#subjectDiv').text('제목을 입력하세요');
	}
	else if($('#content').val() == '') {
		$('#contentDiv').text('내용을 입력하세요');
	}
	else {
		$.ajax({
			type: 'post',
			url: '/miniProject_JQuery/board/boardUpdate.do',
			data: $('#boardWriteForm').serialize(),
			dataType: 'text',
			success: function(data) {
				data = data.trim();
				if(data=='ok') {
					alert("게시물이 수정되었습니다.");
					location.href = '/miniProject_JQuery/board/boardList.do?pg=' + $('#pg')
				}
			},
			error: function(err) {
				console.log(err);
			}
		});
	}
});
