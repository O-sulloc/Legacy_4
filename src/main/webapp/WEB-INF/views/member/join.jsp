<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member join page</h1>
	
	<div>
		<form action="./join" method="post">
			<fieldset>
				<legend>ID</legend>
				<input type="text" name="id">
			</fieldset>

			<fieldset>
				<legend>Password</legend>
				<input type="password" name="pw">
			</fieldset>

			<fieldset>
				<legend>Name</legend>
				<input type="text" name="name">
			</fieldset>

			<fieldset>
				<legend>phone</legend>
				<input type="text" name="phone">
			</fieldset>

			<fieldset>
				<legend>Email</legend>
				<input type="text" name="email">
			</fieldset>

			<fieldset>
				<button type="submit">join</button>
			</fieldset>

		</form>
	</div>
	
</body>
</html>