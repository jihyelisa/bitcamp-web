//$(function() {}); - 아래처럼도 작성 가능
$(document).ready(function() {
	$.ajax({
		type: 'post',
		url: '/miniProject_JQuery/board/getBoardList.do',
		data: 'pg=' + $('#pg').val(), //json 사용 → {'pg':$('#pg').val()}
		dataType: 'json', //객체를 담아올 수 있는 자료형 없음, json 형식으로 받아야 함
		success: function(data) {
			//console.log(JSON.stringify(data));
			//console.log(data.list[0].seq);
			$.each(data.list, function(index, items) {
				//console.log(index + ", " + items.seq);
				
				$('<tr/>').append($('<td/>', { //괄호 안 내용을 자식 요소로 추가
					align: 'center',
					text: items.seq
					
				})).append($('<td/>', {
					}).append($('<a/>', { //subject는 a 태그 안에 추가
						href: '#',
						class: 'subjectA',
						text: items.subject
				
				}))).append($('<td/>', {
					align: 'center',
					text: items.id
				})).append($('<td/>', {
					align: 'center',
					text: items.hit
				})).append($('<td/>', {
					align: 'center',
					text: items.logtime
				})).appendTo($('#boardListTable')) //괄호 안 요소의 자식으로 추가
			});
			//페이징 html
			$('#boardPagingDiv').html('<br>' + data.pagingHTML + '<br>');
			
			//글 조회 시 로그인 여부 확인
			$('.subjectA').click(function(){
				if($('#memId').val() == ''){
					alert('먼저 로그인 하세요');
					location.href='/miniProject_JQuery/member/loginForm.do'
				}
				else {
					//제목(this)으로 글번호 가져오기
					var seq = $(this).parent().prev().text();
					var pg = $('#pg').val();
					
					location.href='/miniProject_JQuery/board/boardView.do?seq='+seq+'&pg='+pg;
				}
			});
		},
		error: function(err) {
			console.log(err);
		}
	});
});
