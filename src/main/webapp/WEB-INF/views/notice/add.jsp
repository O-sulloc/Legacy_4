<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Notice Add page</h1>
	
	<form action="./add" method="post">
		title<input type="text" name="title">
		writer<input type="text" name="writer">
		contents<textarea name="contents" rows="" cols=""></textarea>
		hit<input type="number" name="hit">
		<button type="submit">add</button>
	</form>
</body>
</html>