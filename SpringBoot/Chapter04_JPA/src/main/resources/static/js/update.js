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
						`<form id="updateForm">
						<table border="1">
						<tr>
							<th>이름</th>
							<td>
								<input id="name" type="text" name="name" value="${data.name}" />
								<div id="nameDiv"></div>
							</td>
						</tr>
						<tr>
							<th>아이디</th>
							<td>
								<input id="id" type="text" name="id" value="${data.id}" readonly />
							</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>
								<input id="pwd" type="password" name="pwd" />
								<div id="pwdDiv"></div>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input id="updateBtn" type="button" value="수정"/>
								<input id="resetBtn" type="button" value="취소"/>
							</td>
						</tr>
						</table>
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

$(document).on("click", "#updateBtn", function () {
	$("#nameDiv").empty();
	$("#pwdDiv").empty();

	if(!$("#name").val()) {
		$("#nameDiv").text("이름을 입력하세요");
		$('#name').focus();
	}
	else if(!$("#pwd").val()) {
		$("#pwdDiv").text("비밀번호를 입력하세요");
		$('#pwd').focus();
	}
	
	else {
		$.ajax({
			type: 'post',
			url: '/user/write',
			data: $("#updateForm").serialize(),
			success: function() {
				alert("수정되었습니다");
				location.href="/user/list";
			},
			error: function(err) {
				console.log(err);
			}
		});
	}
});

$(document).on("click", "#resetBtn", function () {
	$("#nameDiv").empty();
	$("#pwdDiv").empty();
	$("#searchIdBtn").click();
});
