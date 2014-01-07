<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="wishlists" scope="session" value="${sessionScope.wishlists}" />
<c:set var="listproductscart" scope="session"
	value="${sessionScope.listproductscart}" />
<c:set var="cartsize" value="${listproductscart.size()}" />
<c:set var="wishlistsize" value="${wishlists.size()}" />

<c:if test="${empty listproductscart}">
	<c:set var="cartsize" value="0" />
</c:if>
<c:if test="${empty wishlists}">
	<c:set var="wishlistsize" value="0" />
</c:if>

<c:set var="sumprice">
	<fmt:formatNumber type="number" minFractionDigits="2"
		maxFractionDigits="2" value="0" />
</c:set>

<!--begin header-->
<header>
	<div class="topHeader">
		<div class="container">
			<div class="pull-right">
				<div class="btn-group">
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						<i class="icon-shopping-cart"></i> (${cartsize}) <span
							class="caret"></span>
					</button>
					<div class="dropdown-menu cart-content pull-right">
						<c:choose>
							<c:when test="${not empty listproductscart}">
								<table class="table-cart">
									<tbody>
										<c:forEach var="product" items="${listproductscart}">
											<c:set var="sumprice"
												value="${sumprice + product.price*product.quantityforsell}" />
											<tr>
												<td class="cart-product-info"><a href="#"><img
														style="max-width: 78px; max-height: 78px;"
														src="<c:url value='/resources/img/product/${product.image1}'/>"
														alt="${product.productname}"></a>
													<div class="cart-product-desc">
														<p>
															<c:set var="productname"
																value="${fn:substring(product.productname, 0, 20)}" />
															<a class="invarseColor" href="#">${productname}...</a>
														</p>
														<!-- <ul class="unstyled">
													<li>Available: Yes</li>
													<li>Color: Black</li>
												</ul> -->
													</div></td>
												<td width="20%" class="cart-product-setting">
													<p>
														<strong>${product.quantityforsell}x${product.price}</strong>
													</p> <a href="deleteproduct.do" class="btn btn-mini remove-pro"
													data-tip="tooltip" data-title="Delete"
													data-original-title=""><i class="icon-trash"></i></a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<td class="cart-product-info"><a href="cart.do"
												class="btn btn-small">View cart</a> <a href="checkout.do"
												class="btn btn-small btn-primary">Checkout</a></td>
											<td>
												<h3>
													$
													<fmt:formatNumber value="${sumprice}" maxFractionDigits="2" />
												</h3>
											</td>
										</tr>
									</tfoot>
								</table>
							</c:when>
							<c:otherwise>
								<h5 style="color: grey; text-align: center; margin: 3em;">Empty
									Cart</h5>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<!--end pull-right-->
			<div class="pull-right">
				<form method="get" action="listproduct.do" class="siteSearch">
					<div class="input-append">
						<input type="text" class="span2" name="searchname"
							placeholder="Start Typing...">
						<button class="btn" type="submit" name="">
							<i class="icon-search"></i>
						</button>
					</div>
				</form>
				<!--end form-->
			</div>
			<!--end pull-right-->
			<ul class="pull-right inline">
				<sec:authorize ifAnyGranted="ROLE_ANONYMOUS">
					<li><a class="invarseColor" href="login.do">Login</a></li>
					<li class="sep-vertical"></li>
					<li><a class="invarseColor" href="register.do">Register</a></li>
					<li class="sep-vertical"></li>
				</sec:authorize>
				<sec:authorize ifAnyGranted="ROLE_ADMIN">
					<li><a class="invarseColor" href="admin/welcome.do">Dashboard</a></li>
					<li class="sep-vertical"></li>
				</sec:authorize>

				<li><a class="invarseColor" href="wishlist.do">Wishlist(${wishlistsize})</a></li>
				<li class="sep-vertical"></li>
				<li><a class="invarseColor" href="cart.do">Cart(${cartsize})</a></li>

				<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
					<li class="sep-vertical"></li>
					<li><a class="invarseColor" href="account.do">My Account</a></li>
					<li class="sep-vertical"></li>
					<li><a class="invarseColor"
						href="<c:url value="j_spring_security_logout" />">Log out</a></li>
				</sec:authorize>

			</ul>
		</div>
		<!--end container-->
	</div>
	<!--end topHeader-->
	<div class="subHeader">
		<div class="container">
			<div class="navbar">
				<div class="siteLogo pull-left">
					<h1>
						<a href="welcome.do"><img
							src="<c:url value='/resources/img/logo.png'/>" alt="Eletro"></a>
					</h1>
				</div>

				<ul class="nav">
					<li class="active"><a href="#"><i class="icon-home"></i></a></li>

					<li><a href="#">TV &amp; Home Theater<i
							class="icon-caret-down"></i></a>
						<ul style="">
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> TVs
							</a></li>
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> Projectors &amp; Screens
							</a></li>
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> Blu-ray &amp; DVD Players
							</a></li>
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> Home Theater Systems
							</a></li>
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> Smart TVs &amp; Devices
							</a></li>
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> Digital TV Converters
							</a></li>
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> Connections
							</a></li>
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> TV Stands, Mounts &amp; Storage
							</a></li>
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> TV &amp; Home Theater Services
							</a></li>
							<li><a href="#"> <span>-</span><i
									class="icon-caret-right"></i> TV &amp; Home Theater Accessories
							</a></li>
						</ul></li>

				</ul>
				<!--end nav-->
			</div>
		</div>
		<!--end container-->
	</div>
	<!--end subHeader-->
</header>
<!-- end header -->