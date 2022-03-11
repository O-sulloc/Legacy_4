<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Add page</h1>
	
	<form action="./add" method="post" enctype="multipart/form-data">
		title<input type="text" name="title">
		writer<input type="text" name="writer">
		contents<textarea name="contents" rows="" cols=""></textarea>
		
		<div>
			<input type="file" name="files">
			<input type="file" name="files">
			<input type="file" name="files">
		</div>
		
		<button type="submit">add</button>
	</form>
</body>
</html>