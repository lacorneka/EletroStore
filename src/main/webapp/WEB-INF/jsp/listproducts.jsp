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
				<li><a class="invarseColor" href="#">Outlet (12)</a></li>
				<li><a class="invarseColor" href="#">Community (0)</a></li>
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
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> From $370.00 To $470.00 (0)
				</a></li>
				<li><a class="invarseColor" href="#"> <i
						class="icon-caret-right"></i> More Than $500.00 (07)
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


		<div class="product-colors">
			<div class="titleHeader clearfix">
				<h3>Shop By Price</h3>
			</div>
			<!--end titleHeader-->

			<ul class="unstyled pro-filter-color">
				<li><a href="#" class="invarseColor"> <span
						class="label-color"
						style="width: 10px; height: 10px; background-color: red; display: inline-block;"></span>&nbsp;&nbsp;
						Filter By Red color
				</a></li>
				<li><a href="#" class="invarseColor"> <span
						class="label-color"
						style="width: 10px; height: 10px; background-color: green; display: inline-block;"></span>&nbsp;&nbsp;
						Filter By Green color
				</a></li>
				<li><a href="#" class="invarseColor"> <span
						class="label-color"
						style="width: 10px; height: 10px; background-color: brown; display: inline-block;"></span>&nbsp;&nbsp;
						Filter By Brown color
				</a></li>
				<li><a href="#" class="invarseColor"> <span
						class="label-color"
						style="width: 10px; height: 10px; background-color: yellow; display: inline-block;"></span>&nbsp;&nbsp;
						Filter By Yellow color
				</a></li>
				<li><a href="#" class="invarseColor"> <span
						class="label-color"
						style="width: 10px; height: 10px; background-color: blue; display: inline-block;"></span>&nbsp;&nbsp;
						Filter By Blue color
				</a></li>
			</ul>
		</div>
		<!--end product-color-->


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
					<option value="">Highest Rating</option>
					<option value="">Lowest Rating</option>
					<option value="">Model (A-Z)</option>
					<option value="">Model (Z-A)</option>
				</select>
			</div>

			<div class="showItem inline pull-left">
				Show <select name="showItem">
					<option value="15">15</option>
					<option value="25">25</option>
					<option value="50">50</option>
					<option value="75">75</option>
					<option value="100">100</option>
				</select>
			</div>
			<!--end sortBy-->

			<div class="compareItem inline pull-left">
				<button class="btn">Product Compare (4)</button>
			</div>
			<!--end compareItem-->

			<div class="displaytBy inline pull-right">
				Display
				<div class="btn-group">
					<button class="btn btn-primary active">
						<i class="icon-th"></i>
					</button>
					<button class="btn">
						<i class="icon-list"></i>
					</button>
				</div>
			</div>
			<!--end displaytBy-->

		</div>
		<!--end productFilter-->


		<div class="row">
			<ul class="listProductItems clearfix">
				<li class="clearfix">
					<div class="span3">
						<div class="thumbnail">
							<a href="#"><img src="img/212x192.jpg" alt=""></a>
						</div>
					</div>
					<div class="span6">
						<div class="thumbSetting">
							<div class="thumbTitle">
								<h3>
									<a href="#" class="invarseColor"> Foliomania the designer
										portfolio brochure </a> <span class="label label-info">Sales</span>
								</h3>
							</div>
							<div class="thumbPriceRate clearfix">
								<span><span class="strike-through">$177.00</span>$150.00</span>
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
								<p>
									Nam auctor nibh quis ipsum placerat sagittis ut at dolor. Class
									aptent taciti sociosqu ad litora torquent per conubia nostra [
									<a href="#" data-title="Read More" data-tip="tooltip"
										data-placement="top">...</a> ]
								</p>
							</div>

							<div class="thumbButtons">
								<button class="btn btn-primary btn-small">
									<i class="icon-shopping-cart"></i> Add To Cart
								</button>
								<button class="btn btn-small">
									<i class="icon-heart"></i> Add To Wishlist
								</button>

								<button class="btn btn-small">
									<i class="icon-refresh"></i> Add To Compare
								</button>
							</div>
							<!--end thumbButtons-->
						</div>
					</div>
				</li>
				<li class="clearfix">
					<div class="span3">
						<div class="thumbnail">
							<a href="#"><img src="img/212x192.jpg" alt=""></a>
						</div>
					</div>
					<div class="span6">
						<div class="thumbSetting">
							<div class="thumbTitle">
								<h3>
									<a href="#" class="invarseColor"> Foliomania the designer
										portfolio brochure </a>
								</h3>
							</div>
							<div class="thumbPriceRate clearfix">
								<span><span class="strike-through">$177.00</span>$150.00</span>
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
								<p>
									Nam auctor nibh quis ipsum placerat sagittis ut at dolor. Class
									aptent taciti sociosqu ad litora torquent per conubia nostra [
									<a href="#" data-title="Read More" data-tip="tooltip"
										data-placement="top">...</a> ]
								</p>
							</div>

							<div class="thumbButtons">
								<button class="btn btn-primary btn-small">
									<i class="icon-shopping-cart"></i> Add To Cart
								</button>
								<button class="btn btn-small">
									<i class="icon-heart"></i> Add To Wishlist
								</button>

								<button class="btn btn-small">
									<i class="icon-refresh"></i> Add To Compare
								</button>
							</div>
							<!--end thumbButtons-->
						</div>
					</div>
				</li>
				<li class="clearfix">
					<div class="span3">
						<div class="thumbnail">
							<a href="#"><img src="img/212x192.jpg" alt=""></a>
						</div>
					</div>
					<div class="span6">
						<div class="thumbSetting">
							<div class="thumbTitle">
								<h3>
									<a href="#" class="invarseColor"> Foliomania the designer
										portfolio brochure </a>
								</h3>
							</div>
							<div class="thumbPriceRate clearfix">
								<span>$150.00</span>
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
								<p>
									Nam auctor nibh quis ipsum placerat sagittis ut at dolor. Class
									aptent taciti sociosqu ad litora torquent per conubia nostra [
									<a href="#" data-title="Read More" data-tip="tooltip"
										data-placement="top">...</a> ]
								</p>
							</div>

							<div class="thumbButtons">
								<button class="btn btn-primary btn-small">
									<i class="icon-shopping-cart"></i> Add To Cart
								</button>
								<button class="btn btn-small">
									<i class="icon-heart"></i> Add To Wishlist
								</button>

								<button class="btn btn-small">
									<i class="icon-refresh"></i> Add To Compare
								</button>
							</div>
							<!--end thumbButtons-->
						</div>
					</div>
				</li>
				<li class="clearfix">
					<div class="span3">
						<div class="thumbnail">
							<a href="#"><img src="img/212x192.jpg" alt=""></a>
						</div>
					</div>
					<div class="span6">
						<div class="thumbSetting">
							<div class="thumbTitle">
								<h3>
									<a href="#" class="invarseColor"> Foliomania the designer
										portfolio brochure </a> <span class="label label-info">Sales</span>
								</h3>
							</div>
							<div class="thumbPriceRate clearfix">
								<span>$150.00</span>
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
								<p>
									Nam auctor nibh quis ipsum placerat sagittis ut at dolor. Class
									aptent taciti sociosqu ad litora torquent per conubia nostra [
									<a href="#" data-title="Read More" data-tip="tooltip"
										data-placement="top">...</a> ]
								</p>
							</div>

							<div class="thumbButtons">
								<button class="btn btn-primary btn-small">
									<i class="icon-shopping-cart"></i> Add To Cart
								</button>
								<button class="btn btn-small">
									<i class="icon-heart"></i> Add To Wishlist
								</button>

								<button class="btn btn-small">
									<i class="icon-refresh"></i> Add To Compare
								</button>
							</div>
							<!--end thumbButtons-->
						</div>
					</div>
				</li>
				<li class="clearfix">
					<div class="span3">
						<div class="thumbnail">
							<a href="#"><img src="img/212x192.jpg" alt=""></a>
						</div>
					</div>
					<div class="span6">
						<div class="thumbSetting">
							<div class="thumbTitle">
								<h3>
									<a href="#" class="invarseColor"> Foliomania the designer
										portfolio brochure </a>
								</h3>
							</div>
							<div class="thumbPriceRate clearfix">
								<span>$150.00</span>
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
								<p>
									Nam auctor nibh quis ipsum placerat sagittis ut at dolor. Class
									aptent taciti sociosqu ad litora torquent per conubia nostra [
									<a href="#" data-title="Read More" data-tip="tooltip"
										data-placement="top">...</a> ]
								</p>
							</div>

							<div class="thumbButtons">
								<button class="btn btn-primary btn-small">
									<i class="icon-shopping-cart"></i> Add To Cart
								</button>
								<button class="btn btn-small">
									<i class="icon-heart"></i> Add To Wishlist
								</button>

								<button class="btn btn-small">
									<i class="icon-refresh"></i> Add To Compare
								</button>
							</div>
							<!--end thumbButtons-->
						</div>
					</div>
				</li>
				<li class="clearfix">
					<div class="span3">
						<div class="thumbnail">
							<a href="#"><img src="img/212x192.jpg" alt=""></a>
						</div>
					</div>
					<div class="span6">
						<div class="thumbSetting">
							<div class="thumbTitle">
								<h3>
									<a href="#" class="invarseColor"> Foliomania the designer
										portfolio brochure </a> <span class="label label-success">Offer</span>
								</h3>
							</div>
							<div class="thumbPriceRate clearfix">
								<span>$150.00</span>
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
								<p>
									Nam auctor nibh quis ipsum placerat sagittis ut at dolor. Class
									aptent taciti sociosqu ad litora torquent per conubia nostra [
									<a href="#" data-title="Read More" data-tip="tooltip"
										data-placement="top">...</a> ]
								</p>
							</div>

							<div class="thumbButtons">
								<button class="btn btn-primary btn-small">
									<i class="icon-shopping-cart"></i> Add To Cart
								</button>
								<button class="btn btn-small">
									<i class="icon-heart"></i> Add To Wishlist
								</button>

								<button class="btn btn-small">
									<i class="icon-refresh"></i> Add To Compare
								</button>
							</div>
							<!--end thumbButtons-->
						</div>
					</div>
				</li>
			</ul>
		</div>


		<div class="pagination pagination-right">
			<span class="pull-left">Showing 9 of 20 pages:</span>
			<ul>
				<li><a class="invarseColor" href="#">Prev</a></li>
				<li class="active"><a class="invarseColor" href="#">1</a></li>
				<li><a class="invarseColor" href="#">2</a></li>
				<li><a class="invarseColor" href="#">2</a></li>
				<li><a class="invarseColor" href="#">3</a></li>
				<li><a class="invarseColor" href="#">Next</a></li>
			</ul>
		</div>
		<!--end pagination-->

	</div>
	<!--end span9-->

</div>
<!--end row-->