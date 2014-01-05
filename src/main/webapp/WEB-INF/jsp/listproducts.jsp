<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form name="listproduct" method="get" action="listproduct.do"
	class="siteSearch">
	<script>
		function DoSubmit(i, id) {
			document.getElementById(id).value = i;
 			document.listproduct.submit();					
		}
	</script>

	<div class="row">
		<aside class="span3">
			<div class="categories">
				<div class="titleHeader clearfix">
					<h3>Filter</h3>
				</div>
				<!--end titleHeader-->
				<ul class="unstyled">
					<li><a class="invarseColor" href="listproduct.do"
						type="submit">Reset All</a></li>
				</ul>
			</div>
			<div class="categories">
				<div class="titleHeader clearfix">
					<h3>Categories</h3>
				</div>
				<!--end titleHeader-->
				<input type="hidden" id="catalogid" name="catalogid"
					value="${param.catalogid}" />
				<ul class="unstyled">
					<li><a class="invarseColor" href="#"
						onclick="DoSubmit( '', 'catalogid')" type="submit">All
							Categories</a></li>
					<c:forEach var="category" items="${requestScope.listcategory}">
						<li><a class="invarseColor" href="#"
							onclick="DoSubmit( ${category.catalogid}, 'catalogid')"
							type="submit">${category.catalogname}</a></li>
					</c:forEach>
				</ul>
			</div>
			<!--end categories-->

			<%-- 			<input type="hidden" id="searchname" name="searchname"
				value="${param.searchname}" />
 --%>
			<div class="product-quality">
				<div class="titleHeader clearfix">
					<h3>Search By Product Name</h3>
				</div>
				<input type="text" name="searchname" id="searchname"
					value="${param.searchname}" placeholder="Search" />
				<div class="pull-right">
					<input type="submit" value="Go" />
				</div>
				<!--end titleHeader-->
			</div>

			<input type="hidden" id="conditionid" name="conditionid"
				value="${param.conditionid}" />
			<div class="product-quality">
				<div class="titleHeader clearfix">
					<h3>Shop By Quality</h3>
				</div>
				<!--end titleHeader-->

				<ul class="unstyled pro-filter-list">
					<li><a class="invarseColor" href="#"
						onclick="DoSubmit( '', 'conditionid')" type="submit"><i
							class="icon-caret-right"></i>All</a></li>
					<c:forEach var="condition" items="${requestScope.listcondition}">
						<li><a class="invarseColor" href="#"
							onclick="DoSubmit( ${condition.conditionid}, 'conditionid')"><i
								class="icon-caret-right"></i>${condition.conditionname}</a></li>
					</c:forEach>
				</ul>
			</div>
			<!--end product-quality-->

			<input type="hidden" id="pricefilter" name="pricefilter"
				value="${param.pricefilter}" />

			<div class="pro-range-slider">
				<div class="titleHeader clearfix">
					<h3>Shop By Price</h3>
				</div>
				<!--end titleHeader-->

				<ul class="unstyled pro-filter-list">
					<li><a class="invarseColor" href="#"
						onclick="DoSubmit( ' p.price>=0', 'pricefilter')"> <i
							class="icon-caret-right"></i> All Price
					</a></li>
					<li><a class="invarseColor" href="#"
						onclick="DoSubmit( ' p.price<=100', 'pricefilter')"> <i
							class="icon-caret-right"></i> Less than $100.00
					</a></li>
					<li><a class="invarseColor" href="#"
						onclick="DoSubmit( ' p.price>=100 and p.price<=300', 'pricefilter')">
							<i class="icon-caret-right"></i> From $100.00 To $300.00
					</a></li>
					<li><a class="invarseColor" href="#"
						onclick="DoSubmit( ' p.price>=300 and p.price<=500', 'pricefilter')">
							<i class="icon-caret-right"></i> From $300.00 To $500.00
					</a></li>
					<li><a class="invarseColor" href="#"
						onclick="DoSubmit( ' p.price>=500', 'pricefilter')"> <i
							class="icon-caret-right"></i> More Than $500.00
					</a></li>
				</ul>

			</div>
			<!--end pro-range-slider-->

			<input type="hidden" id="nstar" name="nstar" value="${param.nstar}" />

			<div class="pro-range-slider">
				<div class="titleHeader clearfix">
					<h3>Shop By Rating</h3>
				</div>
				<!--end titleHeader-->

				<ul class="unstyled pro-filter-list">
					<li><a class="invarseColor" href="#"
						onclick="DoSubmit( '', 'nstar')" type="submit"><i
							class="icon-caret-right"></i>All</a></li>
					<c:forEach var="i" begin="1" end="5">
						<li><a class="invarseColor" href="#"
							onclick="DoSubmit( ${i}, 'nstar')"><i
								class="icon-caret-right"></i>Over ${i} star(s)</a></li>
					</c:forEach>
				</ul>

			</div>
			<!--end pro-range-slider-->

			<input type="hidden" id="brandid" name="brandid"
				value="${param.brandid}" />
			<div class="product-brands">
				<div class="titleHeader clearfix">
					<h3>Shop By Brands</h3>
				</div>
				<!--end titleHeader-->
				<ul class="unstyled pro-filter-list">
					<li><a class="invarseColor" href="#"
						onclick="DoSubmit( '', 'brandid')"><i class="icon-caret-right"></i>All
							Brand</a></li>
					<c:forEach var="brand" items="${requestScope.listbrand}">
						<li><a class="invarseColor" href="#"
							onclick="DoSubmit( ${brand.brandid}, 'brandid')"><i
								class="icon-caret-right"></i>${brand.brandname}</a></li>
					</c:forEach>
				</ul>
			</div>
			<!--end product-brands-->
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
					<a class="btn" href="compare.do">Show Compare</a>
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
									<a href="product.do?productid=${product.productid }"><img
										src="<c:url value='/resources/img/product/${product.image1}'/>"
										alt=""></a>
								</div>
							</div>
							<div class="span6">
								<div class="thumbSetting">
									<div class="thumbTitle">
										<h3>
											<a href="product.do?productid=${product.productid }"
												class="invarseColor"> ${product.productname} </a>
										</h3>
									</div>

									<div class="thumbPriceRate clearfix">
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

										<c:set var="rating" value="${product.rating}" />

										<ul class="rating">
											<fmt:formatNumber maxFractionDigits="0" groupingUsed="false"
												value="${rating}" var="intrating" />
											<c:forEach var="son" begin="1" end="${intrating}">
												<li><i class="star-on"></i></li>
											</c:forEach>
											<c:forEach var="sof" begin="1" end="${5-intrating}">
												<li><i class="star-off"></i></li>
											</c:forEach>
										</ul>
										<!-- <strong>18 Reviews</strong> -->
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

			<input id="page" name="page" type="hidden" value="1" />
			<div class="pagination pagination-right">
				<span class="pull-left">Showing 1 of
					${requestScope.pagecount} pages:</span>
				<ul>
					<c:forEach var="i" begin="1" end="${requestScope.pagecount}">
						<li <c:if test="${i eq page}">class="active"</c:if>><a
							class="invarseColor" href="#" onclick="DoSubmit(${i},'page')">
								${i} </a></li>
					</c:forEach>
				</ul>
			</div>
			<!--end pagination-->

		</div>
		<!--end span9-->

	</div>
	<!--end row-->
</form>