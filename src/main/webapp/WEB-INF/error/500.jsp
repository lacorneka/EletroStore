<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Whoooops! Server internal error</title>
<!-- Mobile Specific Metas
  ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- CSS
  ================================================== -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/bootstrap.min.css'/>" media="screen">
<!-- jquery ui css -->
<link rel="stylesheet"
	href="<c:url value='/resources/css/jquery-ui-1.10.1.min.css'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/css/customize.css'/>">
<link rel="stylesheet"
	href="<c:url value='/resources/css/font-awesome.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
<!-- fancybox -->
<link rel="stylesheet"
	href="<c:url value='/resources/js/fancybox/jquery.fancybox.css'/>">
</head>
<body>
	<div>
		<div
			style="clear: both; display: block; text-align: center; margin: 80px;">
			<h1 style="font-size: 100px; color: #fb6f58; padding: 15px;">
				<strong>500</strong>
			</h1>
			<div style="padding: 20px;">
				<p style="font-size: 30px;">Sorry, An error was occurred on
					server ...</p>
				<div style="font-size: 20px">
					<p
						style="font-size: 20px; padding-top: 20px; padding-bottom: 10px;">
						<strong>An error was occurred on our server when you
							access current link.</strong>
					</p>
					<p>You might wanna browse our site instead:</p>
					<ul class="inline">
						<li><a href="${pageContext.request.contextPath}/welcome.do">Home</a></li>
						<li><a href="${pageContext.request.contextPath}/login.do">Login</a></li>
						<li><a href="${pageContext.request.contextPath}/register.do">Register</a></li>
						<li><a
							href="${pageContext.request.contextPath}/listproduct.do">Products</a></li>
						<li><a href="${pageContext.request.contextPath}/search.do">Search</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>