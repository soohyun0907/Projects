<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>실거래 상세정보 페이지</title>
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

	<h4 class="text-center">거래정보 - dealDetail</h4>       
  	<img src="${root}/img/다세대주택.jpg" class="mx-auto d-block">
	<table class="table table-hover">
		<tbody>
	    	<tr><td>번호</td><td id="tdBoardId" data-boardId='${deal.no}'>${deal.no}</td></tr>
			<tr><td>동</td><td>${deal.dong}</td></tr>
			<tr><td>아파트이름</td><td>${deal.aptName}</td></tr>
			<tr><td>거래금액</td><td>${deal.dealAmount}</td></tr>
			<tr><td>거래종류</td><td>${deal.type}</td></tr>
		</tbody>
	</table>
	
	<h4> <a href="${root}/membermain.do?action=LOGOUT">로그아웃</a></h4>
	<h4> <a href="${root}/membermain.do?action=VIEW&pg=1&key=&word=">목록으로 이동</a></h4>
</div>
</body>
</html>