<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Your Profile</title>

<style type="text/css">
	body{
		margin: 50px;
		font-family: serif;
		}
	h3 {
		color: #539165;
		}
	table {
		border-collapse: collapse;
		background-color: #539165;
		border: #F7C04A 3px solid;
		}
	input {
		padding: 6px;
		background-color: #F7C04A;
		border: #F7C04A;
		color: #3F497F;
	}
	.select {
		/* margin-left: 32px; */
		font-weight: 700;
		width: 100px;
		}
	option {
		padding: 4px;
		width: 80px;
	}
	th {
		padding: 8px;
		background-color: #3F497F;
		color: #F7C04A;
	}
	#nameDiv, #pwdDiv, #repwdDiv, #emailDiv, #phoneDiv, #addrDiv {
		margin-top: 8px;
		color: white;
		font-weight: 600;
		font-size: 12px;
	}
</style>
</head>
<body onload="loadForm()"> <!-- JS코드로 input 요소에 데이터 전달 -->

<%@ page import="member.dao.MemberDAO" %>
<%@ page import="member.bean.MemberDTO" %>

<% 
	//데이터
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("memId"); //
	
	//DB
	MemberDAO memberDAO = MemberDAO.getInstance();
	MemberDTO memberDTO = memberDAO.memberUpdateForm(id);
	
	String name = memberDTO.getName();
	String gender = memberDTO.getGender();
	String pwd = memberDTO.getPwd();
	String email1 = memberDTO.getEmail1();
	String email2 = memberDTO.getEmail2();
	String phone1 = memberDTO.getPhone1();
	String phone2 = memberDTO.getPhone2();
	String phone3 = memberDTO.getPhone3();
	String zipcode = memberDTO.getZipcode();
	String addr1 = memberDTO.getAddr1();
	String addr2 = memberDTO.getAddr2();
	
	System.out.print("updateForm" + name);
%>

<h3><i>Has your profile changed?</i></h3>

<form name="updateForm" method="post" action="update.jsp">

	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" value="<%=name%>" placeholder="이름을 입력하세요">
				<div id="nameDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="id" value="<%=id%>" readonly>
				<div id="idDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="pwd" value="<%=pwd%>" style="width: 320px;">
				<div id="pwdDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>재확인</th>
			<td>
				<input type="password" name="repwd" value="<%=pwd%>" style="width: 320px;">
				<div id="repwdDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" id="gender_m" value="0">
				<label for="gender_m">남자</label>
				&nbsp;
				<input type="radio" name="gender" id="gender_w" value="1">
				<label for="gender_w">여자</label>
				
				<div id="genderDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email1" value="<%=email1%>" style="width: 120px;">
				<span>@</span>
				<input type="text" name="email2" id="email2" value="<%=email2%>" style="width: 120px;">
				<select name="email3" id="email3" style="width: 100px;" onchange="select()">
				    <option value="">직접입력</option>
				    <option value="naver.com">naver.com</option>
				    <option value="gmail.com">gmail.com</option>
				    <option value="nate.com">nate.com</option>
				</select>
				<div id="emailDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>휴대폰</th>
			<td>
				<select name="phone1" style="width: 50px;">
				    <option value="010">010</option>
				    <option value="011">011</option>
				    <option value="019">019</option>
				</select>
				<span>-</span>
				<input type="text" name="phone2" value="<%=phone2%>" style="width: 120px;">
				<span>-</span>
				<input type="text" name="phone3" value="<%=phone3%>" style="width: 120px;">
				<div id="phoneDiv"></div>
			</td>
		</tr>
		
		<tr>
			<th>주소</th>
			<td>
				<input type="text" name="zipcode" id="zipcode" value="<%=zipcode%>" placeholder="우편번호" readonly>
				<input type="button" value="우편번호 검색" name="zipButton" id="zipButton" onclick="execDaumPostcode()" style="margin-left:16px;">
				<br/><br/>
				<input type="text" name="addr1" id="addr1" value="<%=addr1%>" placeholder="주소" style="width: 90%;" readonly>
				<br/><br/>
				<input type="text" name="addr2" value="<%=addr2%>" placeholder="상세주소" style="width: 90%;">
				<div id="addrDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="저장하기" onclick="updateCheck()" class="select">
				<!-- <input type="reset" value="되돌리기" name="reset" class="select"> -->
			</td>
		</tr>
	</table>
</form>

<!-- 다음 우편번호 api -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- 절대주소로 js파일로 이어줌 (상대주소도 사용 가능) -->
<script type="text/javascript" src="../js/member.js"></script>

<script type="text/javascript">
	function loadForm() {
		document.updateForm.gender[<%=gender%>].checked = true;
		document.updateForm.phone1.value = "<%=memberDTO.getPhone1()%>";
	}
</script>

</body>
</html>