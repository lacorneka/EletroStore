<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
		function DoSubmit(i, id) {
			document.getElementById(id).value = i;
 			document.search.submit();					
		}
</script>

<form name="search" method="get" action="search.do" class="form-inline">
	<div class="row">
		<div class="span12">
			<c:if test="${empty requestScope.listproduct}">
				<div class="alert alert-error">
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					<h4>Oh, We're So Sorry</h4>
					There is no product that matches the search criteria.
				</div>
				<!--end alert-->
			</c:if>
			<div class="search">
				<div class="titleHeader clearfix">
					<h3>Search</h3>
				</div>

				<div class="well well-small">


					<input name="searchname" value="${param.searchname }" type="text"
						class="span8" placeholder="Type Search Term..." /> &nbsp;&nbsp;
					<button type="submit" class="btn btn-primary">
						<i class="icon-search"></i>
					</button>
					&nbsp;&nbsp; <label class="checkbox" checked> <input
						type="checkbox" value="1" name="indescription"> Search in
						product descriptions
					</label> <br /> <br />
					<!-- Search by category -->
					<select name="catalogid" class="span3">
						<option value="">--All Category--</option>
						<c:forEach var="category" items="${requestScope.listcategory}">
							<option
								<c:if test="${category.catalogid eq param.catalogid}">selected='selected'</c:if>
								value="${category.catalogid}">${category.catalogname}</option>
						</c:forEach>
					</select>

					<!-- Search by brand -->
					<select name="brandid" class="span3">
						<option value="">--All Brand--</option>
						<c:forEach var="brand" items="${requestScope.listbrand}">
							<option
								<c:if test="${brand.brandid eq param.brandid}">selected='selected'</c:if>
								value="${brand.brandid }">${brand.brandname}</option>
						</c:forEach>
					</select>
					<!-- Search by condition -->
					<select name="conditionid" class="span3">
						<option value="">--All Quality--</option>
						<c:forEach var="condition" items="${requestScope.listcondition}">
							<option
								<c:if test="${condition.conditionid eq param.conditionid}">selected='selected'</c:if>
								value="${condition.conditionid }">${condition.conditionname}</option>
						</c:forEach>
					</select> <select name="nstar" class="span3">
						<option value="">--All Rating--</option>
						<c:forEach var="i" begin="1" end="4">
							<option
								<c:if test="${i eq param.nstar}">selected='selected'</c:if>
								value="${i}">Over ${i} star(s)</option>
						</c:forEach>
					</select> &nbsp;&nbsp; <label class="pricefrom"> Price from </label>&nbsp;&nbsp;
					<input name="pricefrom" value="${param.pricefrom }" type="number"
						class="span4" placeholder="100" />&nbsp;&nbsp; <label
						class="pricefrom"> To </label>&nbsp;&nbsp; <input name="priceto"
						value="${param.priceto }" type="number" class="span4"
						placeholder="500" />

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
			<!--end row-->

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
		<!--end span12-->
	</div>
	<!--end row-->
</form>
<!--end form-->
