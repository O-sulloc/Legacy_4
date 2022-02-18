<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>bankbook list page</h1>


	<!-- bookname, rate, sale -->
	<table>
		<tr>
			<th>상품명</th>
			<th>이자율</th>
			<th>판매여부</th>
		</tr>

		<c:forEach items="${list}" var="book">
			<tr>
				<td><a href="./detail?bookNumber=${book.bookNumber}">${book.bookName}</a></td>
				<td>${book.bookRate}</td>
				<td>${book.bookSale}</td>
			</tr>
		</c:forEach>

	</table>
	
	<a href="./add">ADD</a>
</body>
</html>