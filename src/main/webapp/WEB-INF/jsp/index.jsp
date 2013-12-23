<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>


<div class="span8">
	<div id="slideShow" class="carousel slide">
		<!-- Carousel items -->
		<div class="carousel-inner">
			<div class="active item">
				<img src="<c:url value='/resources/img/614x300.jpg'/>" alt="slide1">
			</div>
			<div class="item">
				<img src="<c:url value='/resources/img/614x300.jpg'/>" alt="slide1">
			</div>
			<div class="item">
				<img src="<c:url value='/resources/img/614x300.jpg'/>" alt="slide1">
			</div>
		</div>
		<!--end carousel-inner-->

		<!-- Carousel nav -->
		<a class="carousel-control left" href="#slideShow" data-slide="prev">&lsaquo;</a>
		<a class="carousel-control right" href="#slideShow" data-slide="next">&rsaquo;</a>
	</div>
	<!--end carousel-->
</div>
<!--end span8-->


<div class="span4">

	<ul class="thumb-banner">
		<li>
			<div class="thumbnail">
				<a href="#"><img src="<c:url value='/resources/img/292x83.jpg'/>" alt="banner"></a>
			</div>
		</li>
		<li>
			<div class="thumbnail">
				<a href="#"><img src="<c:url value='/resources/img/292x83.jpg'/>" alt="banner"></a>
			</div>
		</li>
		<li>
			<div class="thumbnail">
				<a href="#"><img src="<c:url value='/resources/img/292x83.jpg'/>" alt="banner"></a>
			</div>
		</li>
	</ul>
	<!--end homeSpecial-->

</div>
<!--end span4-->