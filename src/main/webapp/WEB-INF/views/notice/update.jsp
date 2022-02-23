<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>notice update page</h1>
	
	<form action="./update" method="post">
	<input readonly="readonly" type="hidden" name="num" value="${dto.num }">
		title<input type="text" name="title" value="${dto.title }">
		contents<input type="text" name="contents" value="${dto.contents }">
	
	<input type="submit" value="update">
	
	</form>
</body>
</html>