<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form name="listproduct" method="get" action="listproduct.do"
	class="siteSearch">
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
					Sort By <select name="sortby" onchange="submit();">
						<option value="-1"
							<c:if test="${-1 eq sortby}">selected='selected'</c:if>>Default</option>
						<option value="0"
							<c:if test="${0 eq sortby}">selected='selected'</c:if>>Name
							(A-Z)</option>
						<option value="1"
							<c:if test="${1 eq sortby}">selected='selected'</c:if>>Name
							(Z-A)</option>
						<option value="2"
							<c:if test="${2 eq sortby}">selected='selected'</c:if>>Price
							(Low-Hight)</option>
						<option value="3"
							<c:if test="${3 eq sortby}">selected='selected'</c:if>>Price
							(Hight-Low)</option>
						<option value="4"
							<c:if test="${4 eq sortby}">selected='selected'</c:if>>Rating
							(Low-Hight)</option>
						<option value="5"
							<c:if test="${5 eq sortby}">selected='selected'</c:if>>Rating
							(Hight-Low)</option>
					</select>
				</div>

				<div class="showItem inline pull-left">
					Show <select name="productonpage" onchange="submit();">
						<c:forEach var="i" begin="1" end="25" step="2">
							<option
								<c:if  test="${i * 2 == productonpage}" >
                                    selected='selected'
                                </c:if>
								value='${i*2}'>${i*2}</option>
						</c:forEach>

						<option
							<c:if  test="${-1 == productonpage}" >
                                selected='selected'
                            </c:if>
							value='-1'>All</option>
					</select>
				</div>
				<!--end sortBy-->

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

			<input name="page" type="hidden" value="1" />
			<script>
				function DoSubmit(i) {
					document.listproduct.page.value = i;
					document.listproduct.submit();					
				}
			</script>
			<div class="pagination pagination-right">
				<span class="pull-left">Showing 1 of 2 pages:</span>
				<ul>
					<c:forEach var="i" begin="1" end="${requestScope.pagecount}">
						<li <c:if test="${i eq page}">class="active"</c:if>><a
							class="invarseColor" href="#" onclick="DoSubmit(${i})"> ${i} </a></li>
					</c:forEach>
				</ul>
			</div>
			<!--end pagination-->

		</div>
		<!--end span9-->

	</div>
	<!--end row-->
</form>