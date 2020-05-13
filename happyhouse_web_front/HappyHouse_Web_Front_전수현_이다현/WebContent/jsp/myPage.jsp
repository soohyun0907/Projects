<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>SSAFY-회원가입</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#updateBtn").click(function() {
		
		if($("#uName").val() == "") {
			alert("이름 입력!!!");
			return;
		} else if($("#uid").val() == "") {
			alert("아이디 입력!!!");
			return;
		} else if($("#upw").val() == "") {
			alert("회원정보를 수정하시려면 비밀번호를 입력해주세요!");
			return;
		} else {
			$("#memberform").attr("action", "${root}/membermain.do?action=MEMBERUPDATE").submit();
		}
	});
	$("#deleteBtn").click(function() {
		
		if($("#uid").val() == "") {
			alert("아이디 입력!!!");
			return;
		} else if($("#upw").val() == "") {
			alert("회원탈퇴를 하시려면 비밀번호를 입력해주세요!");
			return;
		} else {
			$("#memberform").attr("action", "${root}/membermain.do?action=DELETEMEMBER").submit();
		}
	});
});
</script>


</head>
<body>
<%@ include file="/header.jsp" %>
<br>
<br>
<br>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
		<h2>회원 정보</h2>
		<form id="memberform" method="post" action="">
			<div class="form-group" align="left">
				<label for="name">이름</label>
				<input type="text" class="form-control" id="uName" name="uName" placeholder="${user.uName }">
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="uid" name="uid" placeholder="${user.uId }">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="upw" name="upw" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="tel">전화번호</label><br>
				<div id="tel" class="custom-control-inline">
				<input type="text" class="form-control" id="phoneNum" name="phoneNum" placeholder="${user.uPhone }">
				</div>
			</div>
			<div class="form-group" align="left">
				<label for="">주소</label><br>
				<input type="text" class="form-control" id="uaddress" name="uaddress" placeholder="${user.uAddress }">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="updateBtn">수정</button>
				<button type="button" class="btn btn-warning" id="deleteBtn">회원탈퇴</button><br>
				<a href="${root}/membermain.do?action=mvMain">메인페이지로 돌아가기</a>
			</div>
		</form>
	</div>
</div>
</body>
</html>