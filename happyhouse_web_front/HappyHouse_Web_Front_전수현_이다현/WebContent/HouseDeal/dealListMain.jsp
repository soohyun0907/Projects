<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<title>실거래가 페이지</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script type="text/javascript">

	$(document).ready(
			function() {
				$("#btnSearchWord").click(
						function() {
							if ($("#searchName").val() == "") {
								alert("검색 정보 입력!!!");
								return;
							}
							$("#searchForm").attr("action",
									"${root}/membermain.do?action=SEARCH&pg=1&key=&word=")
									.submit();
						});
			});

	function pageMove(pg) {
		document.getElementById("pg").value = pg;
		document.getElementById("pageform").action = "${root}/membermain.do";
		document.getElementById("pageform").submit();
	}
</script>
</head>
<body>

<%@ include file="/header.jsp" %>
<br>
<br>
<br>
<br>
<form name="pageform" id="pageform" method="GET" action="">
		<input type="hidden" name="action" id="action" value="VIEW">
		<input type="hidden" name="pg" id="pg" value="">
		<input type="hidden" name="key" id="key" value="${key}">
		<input type="hidden" name="word" id="word" value="${word}">
</form>

<div class="container" align="center">

  <h4 class="text-center">실거래가 정보</h4>
  	<br>
  	<form id="searchForm" method="post" action="">
		<div class="input-group mt-3 mb-3">
				<select class="search" id="search" name="search">
					<option value="dong">동</option>
					<option value="apt">아파트</option>
				</select> 
				<input type="text" class="form-control" id="searchName" name="searchName" placeholder="검색할 동/아파트를 입력해주세요">
			<div class="input-group-append">
				<button id="btnSearchWord" class="btn btn-success">Go</button>
			</div>
		</div>
		</form>
		<br>
		<br>
		<table class="table table-hover">
		<thead>
       		<tr>
				<th>번호</th>
				<th>동</th>
				<th>아파트이름</th>
				<th>거래금액</th>
				<th>거래종류</th>
				<th>상세보기</th>
			</tr>
     	</thead>
     	<tbody id="boardTbody">

		<c:forEach var="deal" items="${deals}">
			<tr>
				<td>${deal.no }</td>
				<td>${deal.dong }</td>
				<td>${deal.aptName }</td>
				<td>${deal.dealAmount }</td>
				<td>${deal.type }</td>
				<td><a href="${root}/membermain.do?action=DETAIL&dealNo=${deal.no}">상세보기</a></td>
			</tr>
		</c:forEach>
     	</tbody>
   	</table>
   	<table>
	  	<tr>
	  	<td>
	  	${navigation.navigator}
	  	</td>
	  	</tr>
	 </table>
</div>
</body>
</html>