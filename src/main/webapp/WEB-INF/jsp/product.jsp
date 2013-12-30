<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="product" value="${requestScope.product}" />

<div class="row">

	<div class="span12">

		<div class="row">
			<div class="product-details clearfix">
				<div class="span6">
					<div class="product-title">
						<h1>${product.productname }</h1>
					</div>
					<div class="product-img-thumb-floated">
						<a class="fancybox" href="img/650x700.jpg"><img
							src="<c:url value='/resources/img/product/${product.image1}'/>"
							alt="" style="width: 60px;"></a> <a class="fancybox" href=''><img
							src="<c:url value='/resources/img/product/${product.image2}'/>"
							alt="" style="width: 60px;"></a>
					</div>
					<!--product-img-thumb-->

					<div class="product-img-floated">
						<a class="fancybox" href="#"><img
							src="<c:url value='/resources/img/product/${product.image1}'/>"
							alt="" style="width: 370px;"></a>
					</div>
					<!--end product-img-->

				</div>
				<!--end span6-->

				<div class="span6">
					<div class="product-set">
						<div class="product-price">
							<span>${product.price }$</span>
						</div>
						<!--end product-price-->
						<div class="product-rate clearfix">
							<ul class="rating">
								<li><i class="star-on"></i></li>
								<li><i class="star-on"></i></li>
								<li><i class="star-on"></i></li>
								<li><i class="star-off"></i></li>
								<li><i class="star-off"></i></li>
							</ul>
							<span> 18 Review(s)&nbsp;&nbsp; </span>
						</div>
						<!--end product-inputs-->
						<div class="product-info">
							<dl class="dl-horizontal">
								<dt>Model:</dt>
								<dd>${product.model}</dd>

								<dt>Warranties:</dt>
								<dd>${product.warranty}Month</dd>

							</dl>
						</div>
						<!--end product-info-->
						<div class="product-inputs">
							<div class="input-append">

								<a href="cart.do?productid=${product.productid }"
									class="btn btn-primary"> <i class="icon-shopping-cart"></i>
									Add To Cart
								</a> <a href="wishlist.do?productid=${product.productid }"
									class="btn" data-tip="tooltip" data-title="+To Wishlist"> <i
									class="icon-heart"></i>
								</a>

								<button type="button" class="btn" data-tip="tooltip"
									data-title="+To Compare">
									<i class="icon-refresh"></i>
								</button>
							</div>

							<!--end form-->

						</div>
						<!--end product-inputs-->
					</div>
					<!--end product-set-->
				</div>
				<!--end span6-->

			</div>
			<!--end product-details-->
		</div>
		<!--end row-->


		<div class="product-tab">
			<ul class="nav nav-tabs">
				<li class="active"><a href="#descraption" data-toggle="tab">Descraption</a>
				</li>
				<li><a href="#specfications" data-toggle="tab">Specfications</a>
				</li>
				<li><a href="#return-info" data-toggle="tab">Features</a></li>
				<li><a href="#read-review" data-toggle="tab">Read Reviews</a></li>
				<li><a href="#make-review" data-toggle="tab">Make Review</a></li>
			</ul>

			<div class="tab-content">
				<div class="tab-pane active" id="descraption">
					${product.description }</div>
				<div class="tab-pane" id="specfications">
					${product.specifications }</div>
				<div class="tab-pane" id="return-info">${product.features}</div>

				<div class="tab-pane" id="read-review">

					<div class="single-review clearfix">
						<div class="review-header">
							<ul class="rating">
								<li><i class="star-on"></i></li>
								<li><i class="star-on"></i></li>
								<li><i class="star-off"></i></li>
								<li><i class="star-off"></i></li>
								<li><i class="star-off"></i></li>
							</ul>
							<h4>John Doe</h4>
							<small>26/11/2012</small>
						</div>
						<!--end review-header-->

						<div class="review-body">
							<p>Sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Ut enim ad minim veniam, quis nostrud exercitation.</p>
						</div>
						<!--end review-body-->
					</div>
					<!--end single-review-->

				</div>


				<div class="tab-pane" id="make-review">
					<form method="post" action="comment.do" class="form-horizontal">
						<div class="control-group">
							<label class="control-label" for="inputName">Your Name <span
								class="text-error">*</span></label>
							<div class="controls">
								<input type="text" name="name" class="span8" id="inputName"
									placeholder="John Doe...">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputReview">Your
								Review <span class="text-error">*</span>
							</label>
							<div class="controls">
								<textarea name="content" class="span8" id="inputReview"
									placeholder="Put your review here..."></textarea>
							</div>
						</div>
						<div class="control-group">
							<label class="control-label">Your Rate <span
								class="text-error">*</span></label>
							<div class="controls">
								<label class="radio inline">From Bad</label> <label
									class="radio inline"> <input type="radio" name="rate"
									value="option1">
								</label> <label class="radio inline"> <input type="radio"
									name="rate" value="option2">
								</label> <label class="radio inline"> <input type="radio"
									name="rate" value="option3">
								</label> <label class="radio inline"> <input type="radio"
									name="rate" value="option4">
								</label> <label class="radio inline"> <input type="radio"
									name="rate" value="option5">
								</label> <label class="radio inline">To Good</label>
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<button type="submit" class="btn btn-primary" name="submit">Add
									Review</button>
							</div>
						</div>
					</form>
					<!--end form-->
				</div>
			</div>
			<!--end tab-content-->
		</div>
		<!--end product-tab-->
		<div class="related-product">
			<div class="titleHeader clearfix">
				<h3>Accessories Product</h3>
			</div>
			<!--end titleHeader-->

			<div class="row">
				<ul class="hProductItems clearfix">
					<c:forEach var="product"
						items="${requestScope.listproductaccessories }">
						<li class="span3 clearfix">
							<div class="thumbnail">
								<a href="#"><img src="img/212x192.jpg" alt=""></a>
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
								<div class="product-desc"></div>
								<div class="thumbPrice">
									<span>${product.price} $</span>
								</div>

								<div class="thumbButtons">
									<a class="btn btn-primary btn-small btn-block"
										href="cart.do?productid=${product.productid }"> ADD TO
										CART</a>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!--end row-->
		</div>
		<!--end related-product-->
	</div>
	<!--end span12-->

</div>
<!--end row-->