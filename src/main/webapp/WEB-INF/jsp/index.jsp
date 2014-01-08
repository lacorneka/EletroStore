<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:if test="${not empty requestScope.listad}">
	<div class="row">
		<div class="span8">
			<div id="slideShow" class="carousel slide">
				<!-- Carousel items -->
				<div class="carousel-inner">
					<div class="active item">
						<img style="max-height: 350px; max-width: 930px"
							src="<c:url value='/resources/img/banner/${requestScope.listad[0].adimage}'/>"
							alt="${requestScope.listad[0].adname}">
					</div>

					<c:forEach var="i" begin="1" end="${requestScope.listad.size()-1}">
						<div class="item">
							<img style="max-height: 350px; max-width: 930px"
								src="<c:url value='/resources/img/banner/${requestScope.listad[i].adimage}'/>"
								alt="${requestScope.listad[i].adname}">
						</div>
					</c:forEach>
				</div>
				<!--end carousel-inner-->

				<!-- Carousel nav -->
				<a class="carousel-control left" href="#slideShow" data-slide="prev">&lsaquo;</a>
				<a class="carousel-control right" href="#slideShow"
					data-slide="next">&rsaquo;</a>
			</div>
			<!--end carousel-->
		</div>
		<!--end span8-->
	</div>
	<!--end row-->
</c:if>
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
					<c:if test="${not empty requestScope.listproduct }">
						<c:forEach var="product" items="${requestScope.listproduct }">
							<li class="span3 clearfix">
								<div class="thumbnail">
									<a href="product.do?productid=${product.productid}"><img
										src="<c:url value='/resources/img/product/${product.image1}'/>"
										alt=""></a>
								</div>
								<div class="thumbSetting">
									<div class="thumbTitle">
										<h3>
											<a href="product.do?productid=${product.productid}"
												class="invarseColor">${product.productname}</a>
										</h3>
									</div>
									<c:set var="rating" value="${product.rating}" />
									<ul class="rating clearfix">
										<fmt:formatNumber maxFractionDigits="0" groupingUsed="false"
											value="${rating}" var="intrating" />
										<c:forEach var="son" begin="1" end="${intrating}">
											<li><i class="star-on"></i></li>
										</c:forEach>
										<c:forEach var="sof" begin="1" end="${5-intrating}">
											<li><i class="star-off"></i></li>
										</c:forEach>
									</ul>
									<div class="thumbPrice">
										<c:choose>
											<c:when test="${product.price > product.dealprice }">
												<span><span
													style="color: #c0c0c0; text-decoration: line-through;">$${product.price}</span>$${product.dealprice}</span>
											</c:when>

											<c:otherwise>
												<span>$${product.price}</span>
											</c:otherwise>
										</c:choose>
									</div>

									<div class="thumbButtons">
										<a href="cart.do?productid=${product.productid }"
											class="btn btn-primary btn-small btn-block"> ADD TO CART</a>
									</div>
								</div>
							</li>
						</c:forEach>
					</c:if>
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
				<div class="pagers"></div>
			</div>
			<!--end titleHeader-->
			<ul class="brandList clearfix">
				<li><a href="listproduct.do?brandid=8"><img
						src="<c:url value='/resources/img/brand/sony.gif'/>" alt="logo1"></a></li>
				<li><a href="listproduct.do?brandid=7"><img
						src="<c:url value='/resources/img/brand/samsung.gif'/>" alt="logo"></a></li>
				<li><a href="listproduct.do?brandid=4"><img
						src="<c:url value='/resources/img/brand/toshiba.gif'/>" alt="logo"></a></li>
				<li><a href="listproduct.do?brandid=5"><img
						src="<c:url value='/resources/img/brand/lg.gif'/>" alt="logo"></a></li>
			</ul>
		</div>
		<!--end brands-->
	</div>
	<!--end span12-->
</div>
<!--end row-->
