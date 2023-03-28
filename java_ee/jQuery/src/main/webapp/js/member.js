$(function() { //따로 호출 없이 실행
	$('#join').submit(function() {
		var user_id = $('input[name="user_id"]').val();
		if(!user_id) {
			alert("아이디를 입력하세요")
			$('input[name="user_id"]').focus();
			return false;
		}
		
		var user_pw = $('input[name="user_pw"]').val();
		if(!user_pw) {
			alert("비밀번호를 입력하세요")
			$('input[name="user_pw"]').focus();
			return false;
		}
		
		var juminno = $('input[name="juminno"]').val();
		if(!juminno) {
			alert("주민번호를 입력하세요")
			$('input[name="juminno"]').focus();
			return false;
		}
		
		if(!$('input[name="gender"]').is(':checked')) {
			alert("성별을 선택하세요");
			
			//radio 타입은 배열로 전달됨
			//document.form1.gender[0].checked=true;
			
			//eq 사용하는 방법도 있음
			//$('input[name="gender"]:eq(1)').attr('checked', true);
			$('input[name="gender"]:eq(1)').prop('checked', true);
			
			return false;
		}
		
		var email = $('input[name="email"]').val();
		if(!email) {
			alert("이메일을 입력하세요")
			$('input[name="email"]').focus();
			return false;
		}
		
		var url = $('input[name="url"]').val();
		if(!url) {
			alert("url을 입력하세요")
			$('input[name="url"]').focus();
			return false;
		}
		
		var hpno = $('input[name="hpno"]').val();
		if(!hpno) {
			alert("핸드폰 번호를 입력하세요")
			$('input[name="hpno"]').focus();
			return false;
		}
		
		if(!$('input[name="hobby"]').is(':checked')) {
			alert("취미를 선택하세요");
			$('input[name="hobby"]:eq(0)').prop('checked', true);
			return false;
		}
		
		if($('select[name="job"] > option:selected').index() < 1) {
			alert("직업을 선택하세요");
			$('select[name="job"] > option:eq(1)').attr('selected', true);
			return false;
		}
		
		//입력한 내용을 화면에 출력
		var gender = $('input[name="gender"]:checked').val();
		
		//선택한 값들만 넘어옴
		var hobby = $('input[name="hobby"]:checked');
		var hobby_val = '';
		hobby.each(function() { //for문
			//alert($(this).val()); //for문을 돌며 반환 받는 값 = this
			hobby_val += $(this).val();
		});

		var job = $('select[name="job"] > option:selected').val();
		var result = '<ul>';
		result += '<li>아이디: ' + user_id + '</li>';
		result += '<li>비밀번호: ' + user_pw + '</li>';
		result += '<li>주민번호: ' + juminno + '</li>';
		result += '<li>성별: ' + gender + '</li>';
		result += '<li>이메일: ' + email + '</li>';
		result += '<li>핸드폰: ' + hpno + '</li>';
		result += '<li>취미: ' + hobby_val + '</li>';
		result += '<li>직업: ' + job + '</li>';
		result += '</ul>';
	});
});