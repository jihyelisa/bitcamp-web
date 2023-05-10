//목록 로딩
$(document).ready(function() {
	$.ajax({
		type: 'post',
		url: '/user/getList',
		success: function(data) {
			$.each(data, function(index, item) {
				let userHTML = "<tr class='userData'>" +
					"<td align='center'>" + item.name + "</td>" +
					"<td align='center'>" + item.id + "</td>" +
					"<td align='center'>" + item.pwd + "</td>" +
					"</tr>";
				$(".userList").append(userHTML);
			});
		},
		error: function(err) {
			console.log(err);
		}
	});
});

//검색
$("#searchBtn").click(function() {
	if($("#keyword").val()==='')
		alert('검색어를 입력하세요');
		
	else {
		$.ajax({
			type: 'post',
			url: '/user/search',
			data: $('#searchForm').serialize(),
			success: function(data) {
				$(".userData").remove();
				
				$.each(data, function(index, item) {
					let userHTML = "<tr class='userData'>" +
						"<td align='center'>" + item.name + "</td>" +
						"<td align='center'>" + item.id + "</td>" +
						"<td align='center'>" + item.pwd + "</td>" +
						"</tr>";
					$(".userList").append(userHTML);
				});
			},
			error: function(err) {
				console.log(err);
			}
		});
	}
});
