<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="jstlResult.jsp">
	<table border="1" cellpadding="10" cellspacing="0">
		<tr>
			<th>이름</th>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age"></td>
		</tr>
		<tr>
			<th>색깔</th>
			<td>
				<select name="color" style="width: 100px;">
					<optgroup label="색깔">
					    <option value="red">빨강</option>
					    <option value="green">초록</option>
					    <option value="blue">파랑</option>
					    <option value="violet">보라</option>
					    <option value="cyan">하늘</option>
					</optgroup>
				</select>
				<div id="colorDiv"></div>
			</td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<input type="checkbox" name="hobby" id="reading" value="reading">
				<label for="reading">독서</label>
				<input type="checkbox" name="hobby" id="movie" value="movie">
				<label for="movie">영화</label>
				<input type="checkbox" name="hobby" id="music" value="music">
				<label for="music">음악</label>
				<input type="checkbox" name="hobby" id="game" value="game">
				<label for="game">게임</label>
				<input type="checkbox" name="hobby" id="shopping" value="shopping">
				<label for="shopping">쇼핑</label>
				<div id="hobbyDiv"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="SEND"> <!-- JS 함수 호출 -->
				<input type="reset" value="CANCEL">
			</td>
		</tr>
	</table>
</form>

</body>
</html>