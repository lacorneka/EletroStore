<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<div class="row">

	<div class="span8">
		<div id="slideShow" class="carousel slide">
			<!-- Carousel items -->
			<div class="carousel-inner">
				<div class="active item">
					<img src="<c:url value='/resources/img/banner/banner1.jpg'/>"
						alt="slide1">
				</div>
				<div class="item">
					<img src="<c:url value='/resources/img/banner/banner2.jpg'/>"
						alt="slide1">
				</div>
				<div class="item">
					<img src="<c:url value='/resources/img/banner/banner3.jpg'/>"
						alt="slide1">
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
</div>
<!--end row-->

<div class="row">
	<div class="span12">
		<div id="latestItems">

			<div class="titleHeader clearfix">
				<h3>Typical Products</h3>
				<div class="pagers">
					<div class="btn-toolbar">
						<div class="btn-toolbar">
							<a href="listproduct.do" class="btn btn-mini">View All</a>
						</div>
					</div>
					<!--end btn-toolbar-->
				</div>
				<!--end pagers-->
			</div>
			<!--end titleHeader-->


			<div class="row">
				<ul class="hProductItems clearfix" id="cycleFeatured">

					<c:forEach var="product" items="${requestScope.listproduct }">
						<li class="span3 clearfix">
							<div class="thumbnail">
								<a href="product.do?productid=${product.productid}"><img
									src="<c:url value='/resources/img/product/${product.image1}'/>" alt=""></a>
							</div>
							<div class="thumbSetting">
								<div class="thumbTitle">
									<h3>
										<a href="#" class="invarseColor">${product.productname}</a>
									</h3>
								</div>
								<ul class="rating clearfix">
									<li><i class="star-on"></i></li>
									<li><i class="star-on"></i></li>
									<li><i class="star-on"></i></li>
									<li><i class="star-on"></i></li>
									<li><i class="star-off"></i></li>
								</ul>
								<div class="thumbPrice">
									<span>${product.price}$</span>
								</div>

								<div class="thumbButtons">
									<a href="Cart.do?productid=${product.productid }" class="btn btn-primary btn-small btn-block">
										ADD TO CART</a>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!--end row-->
		</div>
		<!--end featuredItems-->
	</div>
	<!--end span12-->
</div>
<!--end row-->


<div class="row">
	<div class="span12">
		<div class="brands">
			<div class="titleHeader clearfix">
				<h3>Brands</h3>
				<div class="pagers">
					<div class="btn-toolbar">
						<button class="btn btn-mini">View All</button>
					</div>
				</div>
			</div>
			<!--end titleHeader-->
			<ul class="brandList clearfix">
				<li><a href="#"><img
						src="<c:url value='/resources/img/brand/sony.gif'/>" alt="logo1"></a></li>
				<li><a href="#"><img
						src="<c:url value='/resources/img/brand/panasonic.gif'/>"
						alt="logo"></a></li>
				<li><a href="#"><img
						src="<c:url value='/resources/img/brand/toshiba.gif'/>" alt="logo"></a></li>
				<li><a href="#"><img
						src="<c:url value='/resources/img/brand/lg.gif'/>" alt="logo"></a></li>
			</ul>
		</div>
		<!--end brands-->
	</div>
	<!--end span12-->
</div>
<!--end row-->
