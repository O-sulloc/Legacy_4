<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} reply page</h1>
	
	<form action="./reply" method="post">
		<input type="hidden" value="${dto.num }" name="num">
		title<input type="text" name="title">
		writer<input type="text" name="writer">
		contents<textarea name="contents" rows="" cols=""></textarea>
		
		<button type="submit">reply</button>
	</form>
</body>
</html>