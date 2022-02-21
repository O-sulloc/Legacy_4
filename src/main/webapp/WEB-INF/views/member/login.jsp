<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member login page</h1>
	<div>
		<form action="./login" method="post">
			<fieldset>
				<legend>id</legend>
				<input type="text" name="id">
			</fieldset>

			<fieldset>
				<legend>pw</legend>
				<input type="password" name="pw">
			</fieldset>
			
			<fieldset>
				<button type="submit">login</button>
			</fieldset>
		</form>
	</div>
</body>
</html>