//$(function() {}); - 아래처럼도 작성 가능
$(document).ready(function() {
	$.ajax({
		type: 'post',
		url: '/miniProject_JQuery/board/getBoard.do',
		data: 'seq='+ $('#seq').val(),
		dataType: 'json', //객체를 담아올 수 있는 자료형 없음, json 형식으로 받아야 함
		success: function(data) {
			$('.subject').append($('<h1/>', {
				align: 'center',
				text: data.subject
			}));
			$('.seq').text('글번호: ' + data.seq);
			$('.name').text('작성자: ' + data.name);
			$('.hit').text('조회수: ' + data.hit);
			$('.content').text(data.content);
			
			//수정, 삭제 버튼 추가 여부
			if($('#memId').val() == data.id) $('#UpdateDelete').show();
			else $('#UpdateDelete').hide();
		},
		
		error: function(err) {
			console.log(err);
		}
	});
});

$('#boardUpdateFormBtn').click(function(){
	$('#boardViewForm').attr('action', '/miniProject_JQuery/board/boardUpdateForm.do');
	$('#boardViewForm').submit();
});
$('#boardReplyBtn').click(function(){
	$('#boardViewForm').attr('action', '/miniProject_JQuery/board/boardReplyForm.do');
	$('#boardViewForm').submit();
});
$('#boardListBtn').click(function(){
	$('#boardViewForm').attr('action', '/miniProject_JQuery/board/boardList.do?pg=' + $('#pg').val());
	$('#boardViewForm').submit();
});

$('#boardDeleteBtn').click(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_JQuery/board/boardDelete.do',
		data: 'seq='+ $('#seq').val(),
		dataType: 'text', //객체를 담아올 수 있는 자료형 없음, json 형식으로 받아야 함
		success: function(data) {
			data = data.trim();
			if(data == 'ok') alert('글이 삭제되었습니다.');
			location.href = '/miniProject_JQuery/board/boardList.do?pg=1';
		},
		
		error: function(err) {
			console.log(err);
		}
	});
});