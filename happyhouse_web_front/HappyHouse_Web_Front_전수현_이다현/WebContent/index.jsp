<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>MainPage</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link href="css/styles.css" rel="stylesheet">
<link rel="stylesheet" href="css/heading.css">
<link rel="stylesheet" href="css/body.css">
</head>
<body id="page-top">
	<%@ include file="/header.jsp"%>
	<header class="masthead bg-primary text-black text-center">
		<div class="container d-flex align-items-center flex-column">
			<img class="masthead-avatar mb-5" src="assets/img/happyhouseLogo.JPG"
				alt="">
			<!-- 머리쪽-->
			<h1 class="masthead-heading mb-0">HAPPSY HOUSE </h1>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- 환영인사-->
			<p class="pre-wrap masthead-subheading font-weight-light mb-0" style="text-align: left">Welcome to HAPPY HOUSE!</p>
		</div>
	</header>
	<section class="page-section portfolio" id="portfolio">
		<div class="container">
			<!-- 맵구현-->
			<div class="text-center">
				<h2 class="page-section-heading text-secondary mb-0 d-inline-block">Map</h2>
			</div>
			<!-- 별짝대기-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- 맵-->
			<div class="row justify-content-center">
				<div class="card-body">
					<!-- here start -->
					<script>
					$(document).ready(function(){
						$.get("${pageContext.request.contextPath}/FSelectBoxController"
							,{command:"sido"}
							,function(data, status){
								$.each(data, function(index, vo) {
									$("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
								});//each
							}//function
							, "json"
						);//get
					});//ready
					$(document).ready(function(){
						$("#sido").change(function() {
							$.get("${pageContext.request.contextPath}/FSelectBoxController"
									,{command:"gugun", sido:$("#sido").val()}
									,function(data, status){
										$("#gugun").empty();
										$("#gugun").append('<option value="0">선택</option>');
										$.each(data, function(index, vo) {
											$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
										});//each
									}//function
									, "json"
							);//get
						});//change
						$("#gugun").change(function() {
							$.get("${pageContext.request.contextPath}/FSelectBoxController"
									,{command:"dong", gugun:$("#gugun").val()}
									,function(data, status){
										$("#dong").empty();
										$("#dong").append('<option value="0">선택</option>');
										$.each(data, function(index, vo) {
											$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
										});//each
									}//function
									, "json"
							);//get
						});//change
						$("#dong").change(function() {
							$.get("${pageContext.request.contextPath}/FSelectBoxController"
									,{command:"apt", dong:$("#dong").val()}
									,function(data, status){
										$("#searchResult").empty();
										$.each(data, function(index, vo) {
											$("#searchResult").append(vo.dong+" "+vo.AptName+" "+vo.jibun+"<br>");
										});//each
									}//function
									, "json"
							);//get
						});//change
					});//ready
				</script>
					시도 : <select id="sido"><option value="0">선택</option></select> 구군 :
					<select id="gugun"><option value="0">선택</option></select> 읍면동 : <select
						id="dong"><option value="0">선택</option></select>
					<p id="searchResult"></p>
				</div>

				<!--<table class="table mt-2">
					<thead>
						<tr>
							<th>번호</th>
							<th>법정동</th>
							<th>아파트이름</th>
							<th>지번</th>
							<th>지역코드</th>
							<th>위도</th>
							<th>경도</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table> -->
							<!-- here end -->
							<!-- map start -->
							<div id="map" style="width: 100%; height: 500px; margin: auto;"></div>

							<script
								src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
							<script async defer
								src="https://maps.googleapis.com/maps/api/js?key=[]&callback=getMapData"></script>
							<script>
				
				var INFO_WINDOW_HTML = 
			    	'<div class="card" style="width:200px">' +
					/* '<img class="card-img-top" src="/img/다세대주택.jpg" alt="Card image" width="200px; height="200px;">' + */
					'<div class="card-body">' +
					'<p class="card-no" id="dealNo" name="dealNo">^NO</p>' +
					'<h4 class="card-title">^APT_NAME</h4>' +
					'<p class="card-text">^DONG</p>' +
					/* '<a href="${pageContext.request.contextPath}/membermain.do?action=DETAIL" class="btn btn-primary">자세히 보기</a>' + */
					'</div>' +
					'</div>';
					
			    function initMap() {
					var map = new google.maps.Map( document.getElementById('map'), 
						{ zoom: 10,
			        		center: {
			        			lat: parseFloat(locations[0].lat), lng: parseFloat(locations[0].lng)
			        		}
			      		}
					);

					var labels = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
					var markers = locations.map(

						function(location, i) {
			        		return new google.maps.Marker(
			     				{	
			       					position: { lat: parseFloat(location.lat), lng: parseFloat(location.lng) },	// should be float, not string
			       					label: labels[i % labels.length],
			       					aptName: location.AptName,
			       					dong: location.dong,
			       					no: location.no
			     				}
			        		);
			     		 }
					);

					var markerCluster = new MarkerClusterer(
						map,
						markers,
						{
							imagePath: 'https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/m'
						}
					);
					
					
					markers.map(
						function(marker, i){
							marker.addListener('click', function() {
								var infowindow = new google.maps.InfoWindow({
								    content: INFO_WINDOW_HTML.replace('^NO', marker.no).replace('^APT_NAME', marker.aptName).replace('^DONG', marker.dong)
								});
								infowindow.open(map, marker);
							});
						}
					);
			    }
			    
				var locations;

				function getMapData(){
					
					$.ajax(
					{
				        type : 'get',
				        url : '${pageContext.request.contextPath}/GoogleMapServlet',
				        command: 'GetMap',
				        dataType : 'json',
				        success : function(data, status, xhr) {
				        	locations = data;
				        	initMap();
				        }, 
				        error: function(jqXHR, textStatus, errorThrown) 
				        { 
				        	alertify.notify(
			           			'Opps!! 글 Map data를 받는 과정에 문제가 생겼습니다.', 
			           			'error', //'error','warning','message'
			           			3, //-1
			           			function(){
			           				console.log(jqXHR.responseText); 
			           			}
			           		);
				        }
				    });
				}
				</script>
							<!-- map end -->
						</div>
					</div>
				</section>
	
	<section class="page-section bg-primary text-black mb-0" id="about">
		<div class="container">
			<!-- About Section Heading-->
			<div class="text-center">
				<h2 class="page-section-heading d-inline-block text-black">ABOUT</h2>
			</div>
			<!-- Icon Divider-->
			<div class="divider-custom divider-light">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- About Section Content-->
			<div class="row">
				<div class="col-lg-4 ml-auto">
					<p class="pre-wrap lead" style="text-align: left">안녕하세요. HAPPY HOUSE입니다. 저희 HAPPY HOUSE는 여러분이 쉽고 간편하게 원하는 집의 정보를 얻을 수 있도록 도와드립니다.
					</p>
				</div>
				<div class="col-lg-4 mr-auto">
					<p class="pre-wrap lead" style="text-align: left" >동과 아파트 이름으로 손쉽게 원하는 집을 찾을 수 있을 뿐만 아니라, 집의 자세한 정보 또한 제공하고 있으며 동시에 집의 위치 또한 한눈에 알아볼 수 있는 맵서비스를 제공하고 있습니다.</p>
				</div>
			</div>
		</div>
	</section>
	<section class="page-section" id="contact">
		<div class="container">
			<!-- Contact Section Heading-->
			<div class="text-center">
				<h2 class="page-section-heading text-secondary d-inline-block mb-0">CONTACT</h2>
			</div>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Contact Section Content-->
			<div class="row justify-content-center">
				<div class="col-lg-4">
					<div class="d-flex flex-column align-items-center">
						<div class="icon-contact mb-3">
							<i class="fas fa-mobile-alt"></i>
						</div>
						<div class="text-muted">Phone</div>
						<div class="lead font-weight-bold">(555) 555-5555</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="d-flex flex-column align-items-center">
						<div class="icon-contact mb-3">
							<i class="far fa-envelope"></i>
						</div>
						<div class="text-muted">Email</div>
						<a class="lead font-weight-bold" href="mailto:name@example.com"
							style="color: black">name@example.com</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer class="footer text-center">
		<div class="container">
			<div class="row">
				<!-- Footer Location-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="mb-4">LOCATION</h4>
					<p class="pre-wrap lead mb-0">서울특별시 강남구 테헤란로 212 (삼성SDS멀티캠퍼스)</p>
				</div>
				<!-- Footer Social Icons-->
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="mb-4">AROUND THE WEB</h4>
					<a class="btn btn-outline-light btn-social mx-1"
						href="https://www.facebook.com/hellossafy"><i
						class="fab fa-fw fa-facebook-f"></i></a><a
						class="btn btn-outline-light btn-social mx-1"
						href="https://www.twitter.com/"><i
						class="fab fa-fw fa-twitter"></i></a><a
						class="btn btn-outline-light btn-social mx-1"
						href="https://www.instagram.com/hellossafy/"><i
						class="fab fa-fw fa-linkedin-in"></i></a><a
						class="btn btn-outline-light btn-social mx-1"
						href="https://pf.kakao.com/_Vhxoxnxb"><i
						class="fab fa-fw fa-dribbble"></i></a>
				</div>
				<!-- Footer About Text-->
				<div class="col-lg-4">
					<h4 class="mb-4">ABOUT SSAFY</h4>
					<p class="pre-wrap lead mb-0">삼성의 SW 교육 경험과 고용노동부의 취업 지원 노하우를 바탕으로,취업 준비생에게 SW 역량 향상 교육 및 다양한 취업지원 서비스를 제공하여 취업에 성공하도록 돕는 프로그램입니다.</p>
				</div>
			</div>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<!-- Third party plugin JS-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
	<script src="js/scripts.js"></script>
</body>
</html>