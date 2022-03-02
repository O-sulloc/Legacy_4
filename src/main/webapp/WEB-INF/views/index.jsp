<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/header_css.jsp"></c:import>
</style>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>

	<h1>Index Page</h1>
	<h3>${member.name }님환영합니다.</h3>
	<!-- sessionScope.member.name 인데 
	앞에 sessionscope는 생략 가능.
	의미는 sessionscope에 member의 memberdto의 name을 꺼내는 것 -->

	<div>
		<c:if test="${not empty member }">
			<a href="./member/mypage">Mypage</a>
			<a href="./member/logout">Logout</a>
		</c:if>

		<c:if test="${empty member }">
			<a href="./member/login">login</a>
			<a href="./member/join">join</a>
		</c:if>

	</div>
</body>
</html>