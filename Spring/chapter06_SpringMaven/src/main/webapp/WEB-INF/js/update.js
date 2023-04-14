$(function(){
	$('#updateDiv').hide();
	
	//아이디 찾기
	$('#searchIdBtn').click(function(){
		$('#resultDiv').empty();
		
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/getUser',
			data: 'id=' + $('#searchId').val(),
			//dataType: 'json',
			/*
			아이디가 있으면 UserDTO가 JSON 변환되어 오지만, 없는 아이디일 경우 불가
			→ dataType 명시하지 않으면 자료에 맞게 자동으로 형식 지정됨
			*/
			
			success: function(data){
				console.log(JSON.stringify(data));
				
				if(data == ''){
					$('#updateDiv').hide();
				
					$('#resultDiv').text('찾고자 하는 아이디가 없습니다');
					$('#resultDiv').css('color', 'red').css('font-weight', 'bold');
				
				}else{
					$('#updateDiv').show();
					
					$('#name').val(data.name);
					$('#id').val(data.id);
					$('#pwd').val(data.pwd);
				}
			},
			error: function(err){
				console.log(err);
			}			
		});//ajax
	});
	
	$('#updateBtn').click(function(){		
		$('#nameDiv').empty();
		$('#pwdDiv').empty();
		
		if($('#name').val() == '') {
			$('#nameDiv').text('이름을 입력하세요');
			$('#name').focus();
		}
		else if($('#pwd').val() == '') {
			$('#pwdDiv').text('비밀번호를 입력하세요');
			$('#pwd').focus();
		}
		else {
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringMaven/user/update',
				data: $('#updateForm').serialize(),
				success: function(){
					alert("계정 정보가 수정되었습니다.");
					location.href='/chapter06_SpringMaven/user/list'
				},
				error: function(err){
					console.log(err);
				}
			});
		}
	});
});
