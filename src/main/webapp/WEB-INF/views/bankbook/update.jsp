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
	<h1>BankBook Update Page</h1>

	<form action="./update" method="post">
	<!-- action에는 url 주소 -->
		<input readonly type="hidden" name="bookNumber" value="${dto.bookNumber }">
		BookName <input type="text" name="bookName" value="${dto.bookName}">
		<!-- 아까 컨트롤러 update에 dto자료를 dto라는 이름으로 넣어놓기로 했잖아. 이제 그거 꺼내오는거
		그럼 이전에 입력했던 정보들 불러올 수 있음. -->
		BookRate<input type="text" name="bookRate" value="${dto.bookRate}">
		BookContents <textarea name="bookContents" rows="" cols="">${dto.bookContents }</textarea>
		<!-- textara에는 value 적지 않음.  --> 
		
		BookSale
		<div>
			<!-- 얘는 이전에 체크했던 곳에 체크가 되어있어야 함.
			그러려면 js자바스크립트가 더 편함.
			따라서 radio, checkbox는 자스 배우면 다시 하자. -->
			판매<input type="radio" name="bookSale" value="1">
			판매중지<input type="radio" name="bookSale" value="0">
		</div>
		
		<div>
			checkbox
			<input type="checkbox" name="ch">
			<input type="checkbox" name="ch">
			<input type="checkbox" name="ch">
		</div>
		
		<input type="submit" value="add">
		
	</form>
</body>
</html>