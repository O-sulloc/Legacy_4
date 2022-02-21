<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>notice detail page</h1>
	
	<h3>title: ${dto.title }</h3>
	<h3>writer: ${dto.writer}</h3>
	<h3>contents: ${dto.contents}</h3>
	
	<a href="./list">List</a>
	<a href="./delete?num=${dto.num }">delete</a>
</body>
</html>