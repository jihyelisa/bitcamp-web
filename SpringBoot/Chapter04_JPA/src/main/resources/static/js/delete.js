$("#searchIdBtn").click(function() {
	if($("#searchId").val()==='')
		alert('아이디를 입력하세요');
		
	else {
		$.ajax({
			type: 'post',
			url: '/user/searchById',
			data: {searchId: $('#searchId').val()},
			success: function(data) {
				$("#resultDiv").empty();
				
				if(data === null) {
					$("#resultDiv").text("존재하지 않는 아이디입니다.")
					$('#searchId').focus();
				}
				else {
					let tableHTML =
						`<form id="deleteForm">
						<table width="200" border="1">
						<tr>
							<th>이름</th>
							<td>${data.name}</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td>${data.id}</td>
						</tr>
						</table>
						<br/>
						
						비밀번호 입력: 
						<input id="pwd" type="text" name="pwd" />
						<input type="hidden" name="id" value="${data.id}" />
						<input id="deleteBtn" type="button" value="삭제"/>
						<div id="pwdDiv"></div>
						</form>`
					$("#resultDiv").append(tableHTML);
				}
			},
			error: function(err) {
				console.log(err);
			}
		});
	}
});

$(document).on("click", "#deleteBtn", function () {
	$("#pwdDiv").empty();
	
	$.ajax({
		type: 'post',
		url: '/user/delete',
		data: $("#deleteForm").serialize(),
		success: function(data) {
			if(data === 'match') {
				alert("삭제되었습니다");
				location.href="/user/list";
			}
			else {
				$("#pwdDiv").text("비밀번호가 맞지 않습니다.");
				$('#pwd').focus();
			}
		},
		error: function(err) {
			console.log(err);
		}
	});
});
