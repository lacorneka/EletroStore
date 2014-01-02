<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">

	<div class="span12">

		<div class="alert alert-error">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<h4>Oh, We're So Sorry</h4>
			There is no product that matches the search criteria.
		</div>
		<!--end alert-->

		<div class="search">
			<div class="titleHeader clearfix">
				<h3>Search</h3>
			</div>

			<div class="well well-small">
				<form method="get" action="http://egythemes.com/shoppest/page"
					class="form-inline">
					<input name="" type="text" class="span3"
						placeholder="Type Search Term..."> &nbsp;&nbsp; <select
						name="" class="span3">
						<option>--Select Category--</option>
						<option value="1">Put Category1</option>
					</select> &nbsp;&nbsp; <label class="checkbox"> <input
						type="checkbox"> Search in subcategories
					</label> &nbsp;&nbsp; <label class="checkbox"> <input
						type="checkbox"> Search in product descriptions
					</label> &nbsp;&nbsp;
					<button type="submit" class="btn btn-primary">
						<i class="icon-search"></i>
					</button>
				</form>
				<!--end form-->
			</div>
			<!--end well-->

		</div>
		<!--end search-->
	</div>
	<!--end span3-->


	<div class="span12">

		<div class="titleHeader clearfix">
			<h3>Search Result</h3>
		</div>
		<!--end titleHeader-->

		<div class="productFilter clearfix">

			<div class="sortBy inline pull-left">
				Sort By <select name="">
					<option value="-1">Name (A-Z)</option>
					<option value="0">Name (Z-A)</option>
					<option value="1">Price (Low-Hight)</option>
					<option value="2">Price (Height-Low)</option>
				</select>
			</div>

			<div class="showItem inline pull-left">
				Show <select name="">
					<option value="2">2</option>
					<option value="4">4</option>
					<option value="6">6</option>
					<option value="8">8</option>
					<option value="100">10</option>
				</select>
			</div>
			<!--end sortBy-->

			<div class="compareItem inline pull-left">
				<button class="btn">Product Compare</button>
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

			<ul class="hProductItems clearfix">
				<li class="span3 clearfix">
					<div class="thumbnail">
						<a href="#"><img src="img/212x192.jpg" alt=""></a>
					</div>
					<div class="thumbSetting">
						<div class="thumbTitle">
							<h3>
								<a href="#" class="invarseColor">Prodcut Title Here</a>
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
							<span>$150.00</span>
						</div>

						<div class="thumbButtons">
							<button class="btn btn-primary btn-small btn-block">
								ADD TO CART</button>
						</div>
					</div>
				</li>

			</ul>
		</div>
		<!--end row-->

		<div class="pagination pagination-right">
			<ul>
				<li class="active"><a class="invarseColor" href="#">1</a></li>
				<li><a class="invarseColor" href="#">2</a></li>
			</ul>
		</div>
		<!--end pagination-->

	</div>
	<!--end span12-->

</div>
<!--end row-->