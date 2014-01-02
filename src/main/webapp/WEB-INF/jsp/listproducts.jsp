<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form method="get" action="listproduct.do" class="siteSearch">
	<div class="row">
		<aside class="span3">
			<div class="categories">
				<div class="titleHeader clearfix">
					<h3>Categories</h3>
				</div>
				<!--end titleHeader-->
				<ul class="unstyled">
					<c:forEach var="category" items="${requestScope.listcategory}">
						<li><a class="invarseColor"
							href="listproduct.do?catalogid=${category.catalogid}"
							type="submit">${category.catalogname}</a></li>
					</c:forEach>
				</ul>
			</div>
			<!--end categories-->

		</aside>
		<!--end aside-->


		<div class="span9">

			<div class="productFilter clearfix">

				<div class="sortBy inline pull-left">
					Sort By <select name="sortby">
						<option value="-1">Name (A-Z)</option>
						<option value="0">Name (Z-A)</option>
						<option value="1">Price (Low-Hight)</option>
						<option value="2">Price (Height-Low)</option>
					</select>
				</div>

				<div class="showItem inline pull-left">
					Show <select name="productonpage">
						<option value="2">2</option>
						<option value="4">4</option>
						<option value="6">6</option>
						<option value="8">8</option>
						<option value="10">10</option>
					</select>
				</div>
				<!--end sortBy-->
				<c:if test="${requestScope.productcatalog.catalogid != null}">
					<input type="hidden" name="catalogid"
						value="${requestScope.productcatalog.catalogid}" />
				</c:if>
				<div class="compareItem inline pull-left">
					<button class="btn" type="submit">Show Products</button>
				</div>
				<!--end compareItem-->

			</div>
			<!--end productFilter-->


			<div class="row">
				<ul class="listProductItems clearfix">
					<c:forEach var="product" items="${requestScope.listproduct}">
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
											<a href="#" class="invarseColor"> ${product.productname}
											</a>
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
									<div class="thumbDesc"></div>

									<div class="thumbButtons">
										<a class="btn btn-primary btn-small"
											href="cart.do?productid=${product.productid }"> <i
											class="icon-shopping-cart"></i> Add To Cart
										</a> <a class="btn btn-small"
											href="wishlist.do?productid=${product.productid }"> <i
											class="icon-heart"></i> Add To Wishlist
										</a> <a class="btn btn-small"
											href="compare.do?productid=${product.productid }"> <i
											class="icon-refresh"></i> Add To Compare
										</a>
									</div>
									<!--end thumbButtons-->
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>

			<c:set var="pagecount" value="${requestScope.pagecount}" />

			<div class="pagination pagination-right">
				<ul>
					<c:forEach var="i" begin="1" end="${pagecount}">
						<li <c:if test="${page == i}"> class="active" </c:if>><a
							class="invarseColor"
							<c:choose>
							 <c:when test="${requestScope.productcatalog.catalogid != null}">
							 href="listproduct.do?catalogid=${requestScope.productcatalog.catalogid}&page=${i}&productonpage=${productonpage}&sortby=${sortby}"
							 </c:when>
							  <c:otherwise>
							  href="listproduct.do?page=${i}&productonpage=${productonpage}&sortby=${sortby}"
      							</c:otherwise>
							
							</c:choose>>${i}</a></li>
					</c:forEach>
				</ul>
			</div>
			<!--end pagination-->

		</div>
		<!--end span9-->

	</div>
	<!--end row-->
</form>