<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
body{
	margin: 50px;
	font-family: serif;
	background-color: #EDF1D6;
	}
h2 {
	color: #609966;
	}
table, td {
	border-collapse: collapse;
	background-color: #9DC08B;
	border: #EDF1D6 1px solid;
	padding: 16px;
	margin: 16px;
	}
input, button {
	padding: 6px;
	background-color: #EDF1D6;
	border: #EDF1D6;
	color: #40513B;
	font-weight: 700;
}
input:hover, input:hover,
button:hover, button:active {
	text-decoration: underline;
}
th {
	padding: 8px;
	background-color: #40513B;
	color: #EDF1D6;
	border: #EDF1D6 1px solid;
}
#idDiv, #pwdDiv {
	margin-top: 8px;
	color: #40513B;
	font-weight: 600;
	font-size: 12px;
</style>

</head>

<body>
	<h2><i>You already have your account?</i></h2>
	
	<form name="loginForm" method="post" action="/miniProject_JQuery/member/login.do">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" id="id">
					<div id="idDiv"></div>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pwd" id="pwd">
					<div id="pwdDiv"></div>
				</td>
			</tr>
		</table>
		
		<button type="button" style="margin-left:96px; margin-right:32px;" onclick="checkLogin()">로그인</button>
		<input type="button" value="회원가입" onclick="location.href='writeForm.do'">
	</form>
	
<script type="text/javascript">
function checkLogin() {
	document.getElementById("idDiv").innerText = "";
	document.getElementById("pwdDiv").innerText = "";

	if (document.loginForm.id.value == "") {
		document.getElementById("idDiv").innerText = "아이디를 입력하세요";
	} else if (document.loginForm.pwd.value == "") {
		document.getElementById("pwdDiv").innerText = "비밀번호를 입력하세요";
	} else {
		document.loginForm.submit();
	}
}
</script>