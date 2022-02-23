<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member update page</h1>
	
	<form action="./update" method="post">
		<input readonly="readonly" type="hidden" name="id" value="${dto.id }">
		name<input type="text" name="name" value="${dto.name }">
		phone<input type="text" name="phone" value="${dto.phone }">
		email<input type="text" name="email" value="${dto.email }">
		
		<input type="submit" value="update">
	</form>
</body>
</html>