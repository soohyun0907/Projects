<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>회원 정보 페이지</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/alertify.min.js"></script>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/alertify.min.css"/>
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.12.0/build/css/themes/default.min.css"/>
</head>
<body>

<%@ include file="/header.jsp" %>
<br>
<br>
<br>
<br>
<div class="container">

  <h4 class="text-center">회원 정보</h4>       
  

	<table class="table table-hover">
		<thead>
       		<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>주소</th>
				<th>전화번호</th>
			</tr>
     	</thead>
     	<tbody id="boardTbody">

		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.uId }</td>
				<td>${user.uName }</td>
				<td>${user.uAddress }</td>
				<td>${user.uPhone }</td>
			</tr>
		</c:forEach>
			    
     	</tbody>
   	</table>
   
	<div id="paginationWrapper"></div>

</div>
</body>
</html>