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

	<!-- Sidebar Widget
	================================================== -->
	<div class="switcher">
		<h3>Site Switcher</h3>
		<a class="Widget-toggle-link">+</a>

		<div class="switcher-content clearfix">

			<div class="pattern-switch">
				<h4>BG Pattern</h4>
				<a style="background: url(<c:url value='/resources/img/backgrounds/bgnoise_lg.png'/>);">bgnoise_lg</a>
				<a style="background: url(<c:url value='/resources/img/backgrounds/bg.png'/>);">bg</a> <a
					style="background: url(<c:url value='/resources/img/backgrounds/foggy_birds.png'/>);">foggy_birds</a>
				<a style="background: url(<c:url value='/resources/img/backgrounds/gplaypattern.png'/>);">gplaypattern</a>
				<a style="background: url(<c:url value='/resources/img/backgrounds/grid_noise.png'/>);">grid_noise</a>
				<a style="background: url(<c:url value='/resources/img/backgrounds/lil_fiber.png'/>);">lil_fiber</a>
				<a style="background: url(<c:url value='/resources/img/backgrounds/scribble_light.png'/>);">scribble_light</a>
				<a style="background: url(<c:url value='/resources/img/backgrounds/tex2res5.png'/>);">tex2res5</a>
				<a style="background: url(<c:url value='/resources/img/backgrounds/white_plaster.png'/>);">white_plaster</a>
			</div>
			<!--end pattern-switch-->

		</div>
		<!--end switcher-content-->
	</div>
	<!-- End Sidebar Widget-->



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