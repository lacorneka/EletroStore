<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html>
<!--<![endif]-->
<head>
<script>
function refreshPage () {
    var page_y = $( document ).scrollTop();
    window.location.href = window.location.href + '?page_y=' + page_y;
}
window.onload = function () {
    setTimeout(refreshPage, 35000);
    if ( window.location.href.indexOf('page_y') != -1 ) {
        var match = window.location.href.split('?')[1].split("&")[0].split("=");
        $('html, body').scrollTop( match[1] );
    }
};
</script>
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
<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js"></script>
		<link rel="stylesheet" href="<c:url value='/resources/css/font-awesome-ie7.css'/>">
	<![endif]-->
<!-- Favicons
	================================================== -->
<link rel="shortcut icon"
	href="<c:url value='/resources/images/favicon.html'/>">
<link rel="apple-touch-icon"
	href="<c:url value='/resources/images/apple-touch-icon.html'/>">
<link rel="apple-touch-icon" sizes="72x72"
	href="<c:url value='/resources/images/apple-touch-icon-72x72.html'/>">
<link rel="apple-touch-icon" sizes="114x114"
	href="<c:url value='/resources/images/apple-touch-icon-114x114.html'/>">
<meta property="fb:app_id" content="231352093694196">
<script src="http://connect.facebook.net/en_US/all.js#xfbml=1"></script>
</head>
<body>


	<!-- AddThis Smart Layers BEGIN -->
	<!-- Go to http://www.addthis.com/get/smart-layers to customize -->
	<script type="text/javascript"
		src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-52c6a3601739107c"></script>
	<script type="text/javascript">
		addthis.layers({
			'theme' : 'gray',
			'share' : {
				'position' : 'left',
				'numPreferredServices' : 5
			},
			'whatsnext' : {},
			'recommended' : {}
		});
	</script>
	<!-- AddThis Smart Layers END -->

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
	<script
		src="<c:url value='/resources/js/fancybox/jquery.fancybox.js'/>"></script>
	<!-- jquery.tweet -->
	<script src="<c:url value='/resources/js/jquery.tweet.js'/>"></script>
	<!-- custom function-->
	<script src="<c:url value='/resources/js/custom.js'/>"></script>
</body>
</html>