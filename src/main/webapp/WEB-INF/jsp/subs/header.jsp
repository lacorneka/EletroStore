<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<!--begin header-->
<header>
	<div class="topHeader">
		<div class="container">
			<div class="pull-right">
				<div class="btn-group">
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						<i class="icon-shopping-cart"></i> (2) <span class="caret"></span>
					</button>
					<div class="dropdown-menu cart-content pull-right">
						<table class="table-cart">
							<tbody>
								<tr>
									<td class="cart-product-info"><a href="#"><img
											src="<c:url value='/resources/img/72x72.jpg'/>"
											alt="product image"></a>
										<div class="cart-product-desc">
											<p>
												<a class="invarseColor" href="#">Title1</a>
											</p>
											<ul class="unstyled">
												<li>Available: Yes</li>
												<li>Color: Black</li>
											</ul>
										</div></td>
									<td class="cart-product-setting">
										<p>
											<strong>1x-$500.00</strong>
										</p> <a href="#" class="btn btn-mini remove-pro"
										data-tip="tooltip" data-title="Delete" data-original-title=""><i
											class="icon-trash"></i></a>
									</td>
								</tr>
								<tr>
									<td class="cart-product-info"><a href="#"><img
											src="<c:url value='/resources/img/72x72.jpg'/>"
											alt="product image"></a>
										<div class="cart-product-desc">
											<p>
												<a class="invarseColor" href="#">Title</a>
											</p>
											<ul class="unstyled">
												<li>Available: Yes</li>
												<li>Color: Black</li>
											</ul>
										</div></td>
									<td class="cart-product-setting">
										<p>
											<strong>2x-$450.00</strong>
										</p> <a href="#" class="btn btn-mini remove-pro"
										data-tip="tooltip" data-title="Delete" data-original-title=""><i
											class="icon-trash"></i></a>
									</td>
								</tr>
							</tbody>
							<tfoot>
								<tr>
									<td class="cart-product-info"><a href="cart.do"
										class="btn btn-small">View cart</a> <a href="checkout.do"
										class="btn btn-small btn-primary">Checkout</a></td>
									<td>
										<h3>$1,598.30</h3>
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
				</div>
			</div>
			<!--end pull-right-->
			<div class="pull-right">
				<form method="get" action="http://egythemes.com/shoppest/page"
					class="siteSearch">
					<div class="input-append">
						<input type="text" class="span2" id="appendedInputButton"
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

				<li><a class="invarseColor" href="wishlist.do">Wishlist(4)</a></li>
				<li class="sep-vertical"></li>
				<li><a class="invarseColor" href="cart.do">Cart</a></li>
				<li class="sep-vertical"></li>
				<li><a class="invarseColor" href="checkout.do">Checkout</a></li>

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