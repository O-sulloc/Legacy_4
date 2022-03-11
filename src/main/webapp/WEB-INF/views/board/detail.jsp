<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
<link href="../resources/css/table.css" rel="styleSheet" />
<link href="../resources/css/list.css" rel="styleSheet" />
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<h1>${board} detail page</h1>
	
	<h3>title: ${dto.title }</h3>
	<h3>writer: ${dto.writer}</h3>
	<h3>contents: ${dto.contents}</h3>
	<div>
		<c:forEach items="${dto.fileDTOs}" var="f">
			<a href="../resources/upload/${board}/${f.fileName}"> ${f.oriName}</a>
		</c:forEach>
	</div>
	
	<a href="./list">List</a>
	<a href="./update?num=${dto.num }">update</a>
	<a href="./delete?num=${dto.num }">delete</a>
	<c:if test="${board ne 'notice'}">
	<a href="./reply?num=${dto.num }">reply</a>
	</c:if>
</body>
</html>