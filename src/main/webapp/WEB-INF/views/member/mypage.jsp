<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>my page</h1>

	<h3>${dto.name }님의회원정보입니다.</h3>

	<h3>id: ${dto.id }</h3>
	<h3>name: ${dto.name }</h3>
	<h3>phone: ${dto.phone }</h3>
	<h3>email: ${dto.email }</h3>
	<!-- model에 dto로 해놓음 -->
	
	<a href="./update?id=${dto.id }">update</a>
</body>
</html>