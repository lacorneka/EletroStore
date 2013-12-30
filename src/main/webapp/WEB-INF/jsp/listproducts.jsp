<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="row">
	<aside class="span3">
		<div class="categories">
			<div class="titleHeader clearfix">
				<h3>Categories</h3>
			</div>
			<!--end titleHeader-->
			<ul class="unstyled">
				<li><a class="invarseColor active" href="#">Women (16)</a></li>
				<li><a class="invarseColor" href="#">Men (6)</a></li>
				<li><a class="invarseColor" href="#">Children (8)</a></li>
				<li><a class="invarseColor" href="#">FootWear (3)</a></li>
				<li><a class="invarseColor" href="#">Accesspries (56)</a></li>
			</ul>
		</div>
		<!--end categories-->

		<div class="product-quality">
			<div class="titleHeader clearfix">
				<h3>Shop By Quality</h3>
			</div>
			<!--end titleHeader-->
			<ul class="unstyled pro-filter-list">
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> New Products (7450)
				</a></li>
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> Used Products (110)
				</a></li>
			</ul>
		</div>
		<!--end product-quality-->


		<div class="pro-range-slider">
			<div class="titleHeader clearfix">
				<h3>Shop By Price</h3>
			</div>
			<!--end titleHeader-->

			<ul class="unstyled pro-filter-list">
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> Less than $70.00 (150)
				</a></li>
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> From $70.00 To $170.00 (310)
				</a></li>
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> From $170.00 To $270.00 (1410)
				</a></li>
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> From $270.00 To $370.00 (30)
				</a></li>
			</ul>

			<div class="price-range">
				<p class="clearfix">
					<label>-- Range Your Price:</label> <input type="text" id="amount">
				</p>
				<div id="slider-range"></div>
			</div>
		</div>
		<!--end pro-range-slider-->


		<div class="product-brands">
			<div class="titleHeader clearfix">
				<h3>Shop By Brands</h3>
			</div>
			<!--end titleHeader-->
			<ul class="unstyled pro-filter-list">
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> Apple Products (7450)
				</a></li>
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> Dell Products (240)
				</a></li>
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> HP Products (870)
				</a></li>
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> Microsoft Products (09)
				</a></li>
			</ul>
		</div>
		<!--end product-brands-->

	</aside>
	<!--end aside-->


	<div class="span9">

		<div class="productFilter clearfix">

			<div class="sortBy inline pull-left">
				Sort By <select name="sortItem">
					<option value="Default">Default</option>
					<option value="">Name (A-A)</option>
					<option value="">Name (Z-A)</option>
					<option value="">Price (Low-Hight)</option>
					<option value="">Price (Height-Low)</option>
				</select>
			</div>

			<div class="showItem inline pull-left">
				Show <select name="showItem">
					<option value="2">2</option>
					<option value="4">4</option>
					<option value="6">6</option>
					<option value="8">8</option>
					<option value="10">10</option>
				</select>
			</div>
			<!--end sortBy-->

			<div class="compareItem inline pull-left">
				<button class="btn">Product Compare (4)</button>
			</div>
			<!--end compareItem-->

		</div>
		<!--end productFilter-->


		<div class="row">
			<ul class="listProductItems clearfix">
				<c:forEach var="product" items="${requestScope.listproductscart }">
					<li class="clearfix">
						<div class="span3">
							<div class="thumbnail">
								<a href="#"><img
									src="<c:url value='/resources/img/product/${product.image1}'/>"
									alt=""></a>
							</div>
						</div>
						<div class="span6">
							<div class="thumbSetting">
								<div class="thumbTitle">
									<h3>
										<a href="#" class="invarseColor"> ${product.productname} </a>
									</h3>
								</div>
								<div class="thumbPriceRate clearfix">
									<span>${product.price} $</span>
									<ul class="rating">
										<li><i class="star-on"></i></li>
										<li><i class="star-on"></i></li>
										<li><i class="star-on"></i></li>
										<li><i class="star-on"></i></li>
										<li><i class="star-off"></i></li>
									</ul>
									<strong><a href="#">18 Reviews</a></strong>
								</div>
								<div class="thumbDesc">
									
								</div>

								<div class="thumbButtons">
									<a class="btn btn-primary btn-small" href="cart.do?productid=${product.productid }">
										<i class="icon-shopping-cart"></i> Add To Cart
									</a>
									<a class="btn btn-small" href="wishlist.do?productid=${product.productid }">
										<i class="icon-heart"></i> Add To Wishlist
									</a>

									<a class="btn btn-small" href="compare.do?productid=${product.productid }">
										<i class="icon-refresh"></i> Add To Compare
									</a>
								</div>
								<!--end thumbButtons-->
							</div>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>


		<div class="pagination pagination-right">
			<span class="pull-left">Showing 1 of 2 pages:</span>
			<ul>
				<li><a class="invarseColor" href="#">Prev</a></li>
				<li class="active"><a class="invarseColor" href="#">1</a></li>
				<li><a class="invarseColor" href="#">2</a></li>
				<li><a class="invarseColor" href="#">2</a></li>
				<li><a class="invarseColor" href="#">Next</a></li>
			</ul>
		</div>
		<!--end pagination-->

	</div>
	<!--end span9-->

</div>
<!--end row-->