<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- Basic Page Needs
  ================================================== -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<title><tiles:insertAttribute name="title" /></title>
	<!--=== CSS ===-->

	<!-- Bootstrap -->
	<link href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />

	<!-- Theme -->
	<link href="<c:url value='/resources/assets/css/main.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/resources/assets/css/plugins.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/resources/assets/css/responsive.css'/>" rel="stylesheet" type="text/css" />
	<link href="<c:url value='/resources/assets/css/icons.css'/>" rel="stylesheet" type="text/css" />

	<link rel="stylesheet" href="<c:url value='/resources/assets/css/fontawesome/font-awesome.min.css'/>">

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>

	<!--=== JavaScript ===-->

	<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.9.1.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js'/>"></script>

	<script type="text/javascript" src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/assets/js/libs/lodash.compat.min.js'/>"></script>

	<!-- General -->
	<script type="text/javascript" src="<c:url value='/resources/assets/js/libs/breakpoints.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/plugins/respond/respond.min.js'/>"></script> <!-- Polyfill for min/max-width CSS3 Media Queries (only for IE8) -->
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.cookie.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/plugins/slimscroll/jquery.slimscroll.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/plugins/slimscroll/jquery.slimscroll.horizontal.min.js'/>"></script>

	<!-- Noty -->
	<!--
	<script type="text/javascript" src="<c:url value='/resources/plugins/noty/jquery.noty.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/plugins/noty/layouts/top.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/plugins/noty/themes/default.js'/>"></script>
	-->

	<!-- DataTables -->
	<script type="text/javascript" src="plugins/datatables/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="plugins/datatables/tabletools/TableTools.min.js"></script> <!-- optional -->
	<script type="text/javascript" src="plugins/datatables/colvis/ColVis.min.js"></script> <!-- optional -->
	<script type="text/javascript" src="plugins/datatables/DT_bootstrap.js"></script>

	<!-- Forms -->
	<script type="text/javascript" src="<c:url value='/resources/plugins/uniform/jquery.uniform.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/plugins/select2/select2.min.js'/>"></script>

	<!-- App -->
	<script type="text/javascript" src="<c:url value='/resources/assets/js/app.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/assets/js/plugins.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/assets/js/plugins.form-components.js'/>"></script>

	<script>
	$(document).ready(function(){
		"use strict";

		App.init(); // Init layout and core plugins
		Plugins.init(); // Init all plugins
		FormComponents.init(); // Init all form-specific plugins
	});
	</script>

</head>
<body>
	<!-- Header -->
	<header class="header navbar navbar-fixed-top" >
		<!-- Top Navigation Bar -->
		<div class="container">
			<!-- Logo -->
			<a class="navbar-brand" href="">
				<strong>ELETRO</strong>STORE
			</a>
			<!-- /logo -->
			<!-- Sidebar Toggler -->
			<a href="#" class="toggle-sidebar bs-tooltip" data-placement="bottom"
				data-original-title="Toggle navigation"> <i class="icon-reorder"></i>
			</a>
			<!-- /Sidebar Toggler -->
			<!-- Top Left Menu -->
			<ul class="nav navbar-nav navbar-left hidden-xs hidden-sm">
				<li><a href="welcome.do"> Home Page </a></li>
			</ul>
			<!-- /Top Left Menu -->
			<!-- Top Right Menu -->
			<ul class="nav navbar-nav navbar-right">
				<!-- User Login Dropdown -->
				<li class="dropdown user"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="icon-male"></i> <span
						class="username">#username</span> <i class="icon-caret-down small"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a href="account.do"><i class="icon-user"></i> My
								Profile</a></li>
						<li class="divider"></li>
						<li><a
							href="javascript:document.getElementById('logoutForm').submit()"><i
								class="icon-key"></i> Log Out</a></li>
					</ul></li>
				<!-- /user login dropdown -->
			</ul>
			<!-- /Top Right Menu -->
		</div>
		<!-- /top navigation bar -->
	</header>
	<!-- /.header -->
	
	<div id="container">
		<div id="sidebar" class="sidebar-fixed">
			<div id="sidebar-content">
				<!--=== Navigation ===-->
				<ul id="nav">
					<li>
						<a href="#"> <i
							class="icon-dashboard"></i> Dashboard
					</a>
					</li>
					<li class="current">
						<a href="#"> <i
							class="icon-table"></i> Provider Management
					</a>
					</li>
					<li>
						<a href="#"> <i
							class="icon-table"></i> Category Management
					</a>
					</li>
					<li>
						<a href="#"> <i
							class="icon-table"></i> Product Management
					</a>
					</li>

					<li>
						<a href="#"><i class="icon-table"></i>
							Order Management
					</a>
					</li>

					<li>
						<a href="#"> <i class="icon-table"></i>
							User Management
					</a>
					</li>

				</ul>
			</div>
			<div id="divider" class="resizeable"></div>
		</div>
		<!-- /Sidebar -->
		<div id="content">
			<div class="container">
				<tiles:insertAttribute name="content" />
			</div>
		</div>
	</div>
</body>
</html>