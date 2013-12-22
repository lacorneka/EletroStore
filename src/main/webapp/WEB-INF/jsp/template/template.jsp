<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html>
<!--<![endif]-->
<head>
<!-- Basic Page Needs
  ================================================== -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><tiles:insertAttribute name="title" /></title>
<!-- Mobile Specific Metas
  ================================================== -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<!-- CSS
  ================================================== -->
<link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css'/>" media="screen">
<!-- jquery ui css -->
<link rel="stylesheet" href="<c:url value='/resources/css/jquery-ui-1.10.1.min.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/customize.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/font-awesome.css'/>">
<link rel="stylesheet" href="<c:url value='/resources/css/style.css'/>">
<!-- fancybox -->
<link rel="stylesheet" href="<c:url value='/resources/js/fancybox/jquery.fancybox.css'/>">
<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>
		<link rel="stylesheet" href="<c:url value='/resources/css/font-awesome-ie7.css'/>">
	<![endif]-->
<!-- Favicons
	================================================== -->
<link rel="shortcut icon" href="<c:url value='/resources/images/favicon.html'/>">
<link rel="apple-touch-icon" href="<c:url value='/resources/images/apple-touch-icon.html'/>">
<link rel="apple-touch-icon" sizes="72x72"
	href="<c:url value='/resources/images/apple-touch-icon-72x72.html'/>">
<link rel="apple-touch-icon" sizes="114x114"
	href="<c:url value='/resources/images/apple-touch-icon-114x114.html'/>">
</head>
<body>

	<div id="wrapper">
		<tiles:insertAttribute name="header" />
		<div class="container">

			<div class="row">
				<tiles:insertAttribute name="content" />
			</div>
			<!--end row-->

		</div>
		<!--end conatiner-->
		<tiles:insertAttribute name="footer" />
	</div>
	<!--end wrapper-->

	<!-- JS
	================================================== -->
	<script src="<c:url value='/resources/js/jquery-1.9.1.min.js'/>"></script>
	<script src="<c:url value='/resources/js/jquery-ui-1.10.2.min.js'/>"></script>
	<!-- bootstrap -->
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
	<!-- jQuery.Cookie -->
	<script src="<c:url value='/resources/js/jquery.cookie.js'/>"></script>
	<!-- fancybox -->
	<script src="<c:url value='/resources/js/fancybox/jquery.fancybox.js'/>"></script>
	<!-- jquery.tweet -->
	<script src="<c:url value='/resources/js/jquery.tweet.js'/>"></script>
	<!-- custom function-->
	<script src="<c:url value='/resources/js/custom.js'/>"></script>
</body>
</html>