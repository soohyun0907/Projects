<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<nav id="index_nav_login">
	<ul class="m-0 p-0" style="list-style: none;">
		<li class="float-right"><a class="p-1" href="${pageContext.request.contextPath}/jsp/join.jsp"> 
		<span id="spanForSignUp" style ="color : black">SignUp</span></a></li>
		<li class="float-right"><a class="p-1" href="#"> 
		<span id="spanForLogin" data-toggle="modal" data-target="#loginModal" style ="color : black" >Login</span>
		</a></li>
		<li class="float-right"><a class="p-1" href="#"><span id="spanForID" style="display: none; color : black;"> </span>
		<span id="spanForLogout" style="display: none; color : black;"> Logout</span></a></li>
		<li class="float-right"><a class="p-1" href="${pageContext.request.contextPath}/membermain.do?action=MYPAGE"> 
		<span id="spanForUserInfo" style="display: none;color : black">회원정보</span></a></li>
	</ul>
</nav>
<!-- Grey with black text : 메뉴 바 start -->
<nav class="navbar navbar-expand-lg navbar-light rounded">
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link"
			href="${pageContext.request.contextPath}/membermain.do?action=mvMain">메인으로</a></li>
		<li class="nav-item active"><a class="nav-link"
			href="${pageContext.request.contextPath}/membermain.do?action=MYPAGE">마이페이지</a></li>
		<li class="nav-item"><a class="nav-link"
			href="${pageContext.request.contextPath}/membermain.do?action=VIEW&pg=1&key=&word=">실거래가 목록</a>
		</li>
		<%-- <li class="nav-item"><a class="nav-link"
			href="${pageContext.request.contextPath}/membermain.do?action=SEARCHALL">회원정보</a></li> --%>
		<li class="nav-item"><a class="nav-link" href="#">관심지역</a></li>
		<li class="nav-item"><a class="nav-link" href="#">공지사항</a></li>
		<li class="nav-item"><a class="nav-link disabled" href="#">Back_End_PJT</a>
		</li>
	</ul>
</nav>
<!-- Grey with black text : 메뉴 바 end -->
<!-- login modal start -->
<div class="modal" id="loginModal">
	<div class="modal-dialog modal-md" style="vertical-align: middle;">
		<div class="modal-content">
			<!-- ModalHeader -->
			<div class="modal-header">
				<h4 class="modal-title">LogIn</h4>
				<button type="button" class="close dataDismiss" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal body -->
			<div class="modal-body">
				<div class="form-group">
					<label for="mbr_id_header">ID:</label> <input type="text"
						id="mbr_id_header" class="form-control" placeholder="Enter ID">
				</div>
				<div class="form-group">
					<label for="mbr_pwd_header">Password:</label> <input
						type="password" id="mbr_pwd_header" class="form-control"
						placeholder="Enter Password">
				</div>
			</div>
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" id="modalLogInBtn" class="btn btn-primary" data-dismiss="modal">LogIn</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				<a class="p-1" href="#"> <span id="spanForFindPwd" data-toggle="modal" data-target="#findPwdModal" data-dismiss="modal"><font color="black">비밀번호 찾기</font></span></a>
			</div>
		</div>
	</div>
</div>
<!-- login modal end -->

<!-- findPwd modal start -->
<div class="modal" id="findPwdModal">
	<div class="modal-dialog modal-md" style="vertical-align: middle;">
		<div class="modal-content">
			<!-- ModalHeader -->
			<div class="modal-header">
				<h4 class="modal-title">비밀번호 찾기</h4>
				<button type="button" class="close dataDismiss" data-dismiss="modal">&times;</button>
			</div>
			<!-- Modal body -->
			<div class="modal-body">
				<div class="form-group">
					<label for="mbr_name_header">이름:</label> <input type="text"
						id="mbr_name_header" class="form-control" placeholder="Enter Name">
				</div>
				<div class="form-group">
					<label for="mbr_uid_header">아이디:</label> <input type="text"
						id="mbr_uid_header" class="form-control" placeholder="Enter ID">
				</div>
				<div class="form-group">
					<label for="mbr_phone_header">전화번호:</label> <input
						type="text" id="mbr_phone_header" class="form-control"
						placeholder="Enter Phone Number">
				</div>
			</div>
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" id="modalFindPwdBtn" class="btn btn-primary" data-dismiss="modal">비밀번호 찾기</button>
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<!-- findPwd modal end -->

<!-- login script start -->
<script>
		$(document).ready(function() {
			if(${user_session != null && user_session.uId != null && user_session.uId != ''}) {
				$("#spanForSignUp").css("display","none");
				$("#spanForLogin").css("display","none");
				$("#spanForID").text(" ${user_session.uId}님 ");
				$("#spanForID").css("display","inline");
				$("#spanForLogout").css("display","inline");
				$("#spanForUserInfo").css("display","inline");
			} else {
				$("#spanForSignUp").css("display","inline");
				$("#spanForLogin").css("display","inline");
				$("#spanForID").text("");
				$("#spanForID").css("display","none");
				$("#spanForLogout").css("display","none");
				$("#spanForUserInfo").css("display","none");
			}
		});//ready
		
		$(document).ready(function() {
			$("#modalFindPwdBtn").click(function() {
				if($.trim($("#mbr_name_header").val()) == ''){
					alert("이름을 입력해 주세요.");
					return;
				}
				if($.trim($("#mbr_uid_header").val()) == ''){
					alert("아이디를 입력해 주세요.");
					return;
				}
				if($.trim($("#mbr_phone_header").val()) == ''){
					alert("전화번호를 입력해 주세요.");
					return;
				}
				$.post(
						"${pageContext.request.contextPath}/membermain.do"
						,{
							action:'FINDPWD'
							,uname:$("#mbr_name_header").val()
							,uid:$("#mbr_uid_header").val()
							,uphone:$("#mbr_phone_header").val()
						}
						, function(data, status) {
							if(status == "success"){
								if(data[0].message_code == "-1") {
									alert("시스템 관리자에게 문의 바랍니다.");
								} else if(data[0].message_code == "0"){
									alert("등록된 회원정보가 없습니다.");
								} else {
									alert("새로운 비밀번호 " + data[0].newPwd +" 가 발급 되었습니다. \n"
											+"다시 로그인 해 주세요.");
								}
							} else {
								alert("시스템 관리자에게 문의 바랍니다.");
							}
						}//function
						, "json"
				);//post
			});//click
			$("#modalLogInBtn").click(function() {
				if($.trim($("#mbr_id_header").val()) == ''){
					alert("ID를 입력해 주세요.");
					return;
				}
				if($.trim($("#mbr_pwd_header").val()) == ''){
					alert("Password를 입력해 주세요.");
					return;
				}
				$.post(
						"${pageContext.request.contextPath}/membermain.do"
						,{
							action:'LOGIN'
							,uid:$("#mbr_id_header").val()
							,upw:$("#mbr_pwd_header").val()
						}
						, function(data, status) {
							if(status == "success"){
								if(data[0].message_code == "-1") {
									alert("시스템 관리자에게 문의 바랍니다.");
								} else if(data[0].message_code == "0"){
									alert("잘못된 ID 또는 Password 입니다.");
								} else {
									$("#spanForSignUp").css("display","none");
									$("#spanForLogin").css("display","none");
									$("#spanForID").text(" " + data[0].userid + "님 ");
									$("#spanForID").css("display","inline");
									$("#spanForLogout").css("display","inline");
									$("#spanForUserInfo").css("display","inline");
								}
							} else {
								alert("시스템 관리자에게 문의 바랍니다.");
							}
						}//function
						, "json"
				);//post
			});//click
			$("#spanForLogout").click(function() {
				$.post(
						"${pageContext.request.contextPath}/membermain.do"
						,{ action:'LOGOUT' }
						, function(data, status) {
							if(status == "success"){
								if(data == 1) {
									$("#spanForSignUp").css("display","inline");
									$("#spanForLogin").css("display","inline");
									$("#spanForID").text("");
									$("#spanForID").css("display","none");
									$("#spanForLogout").css("display","none");
									$("#spanForUserInfo").css("display","none");
									alert("로그아웃 되었습니다.");
								} else {
									alert("시스템 관리자에게 문의 바랍니다.");
								}
							} else {
								alert("시스템 관리자에게 문의 바랍니다.");
							}
						}//function
						, "json"
				);//post
			});//click
			$("#spanForID").click(function() {
				$.post(
						"${pageContext.request.contextPath}/membermain.do"
						,{ action:'LOGOUT' }
						, function(data, status) {
							if(status == "success"){
								if(data == 1) {
									$("#spanForSignUp").css("display","inline");
									$("#spanForLogin").css("display","inline");
									$("#spanForID").text("");
									$("#spanForID").css("display","none");
									$("#spanForLogout").css("display","none");
									$("#spanForUserInfo").css("display","none");
									alert("로그아웃 되었습니다.");
								} else {
									alert("시스템 관리자에게 문의 바랍니다.");
								}
							} else {
								alert("시스템 관리자에게 문의 바랍니다.");
							}
						}//function
						, "json"
				);//post
			});//click
		});//ready
</script>

<!-- login script end -->