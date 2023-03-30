//$(function() {}); - 아래처럼도 작성 가능
$(document).ready(function() {
	$.ajax({
		type: 'post',
		url: '/miniProject_JQuery/board/getBoard.do',
		data: 'seq='+ $('#seq').val() +'&pg='+ $('#pg').val(),
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
			$('.button').append($('<button/>', {
				class: 'listButton',
				onclick: 'location.href="boardList.do?pg=' +$('#pg').val()+ '"',
				text: '목록'
			}));
		},
		
		error: function(err) {
			console.log(err);
		}
	});
});
