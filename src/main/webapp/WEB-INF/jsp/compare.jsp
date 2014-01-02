<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="row">
	<div class="span12">

		<c:set var="products" scope="session"
			value="${sessionScope.listproductscompare }"></c:set>
		<c:set var="n" value="${products.size() }" />
		<c:choose>
			<c:when test="${n > 0}">
				<table class="table table-compare">
					<tr>
						<td class="aligned-color"><h3>Product</h3></td>
						<c:forEach var="i" begin="0" end="${ n-1}">
							<td><h4>
									<a href="#" class="invarseColor">${products[i].productname}</a>
								</h4></td>
						</c:forEach>
					</tr>
					<tr>
						<td class="aligned-color"><h3>Image</h3></td>
						<c:forEach var="i" begin="0" end="${ n-1}">
							<td><a href="#"><img
									style="max-height: 92px; max-width: 92px;"
									src="<c:url value='/resources/img/product/${products[i].image1}'/>"
									alt="thumb product"></a></td>
						</c:forEach>
					</tr>
					<tr>
						<td class="aligned-color"><h3>Price</h3></td>
						<c:forEach var="i" begin="0" end="${ n-1}">
							<td class="price"><c:choose>
									<c:when test="${products[i].price > products[i].dealprice }">
										<span class="strike-through">$${products[i].price}</span>
					$${products[i].dealprice}
							</c:when>

									<c:otherwise>
					$${products[i].price}
				</c:otherwise>
								</c:choose></td>
						</c:forEach>

					</tr>
					<tr>
						<td class="aligned-color"><h3>Brand</h3></td>
						<c:forEach var="i" begin="0" end="${ n-1}">
							<td>${products[i].brand.brandname}</td>
						</c:forEach>
					</tr>
					<tr>
						<td class="aligned-color"><h3>Rating</h3></td>
						<c:forEach var="i" begin="0" end="${ n-1}">
							<td><c:set var="rating" value="${products[i].rating}" />

								<ul class="rating">
									<fmt:formatNumber maxFractionDigits="0" groupingUsed="false"
										value="${rating}" var="intrating" />
									<c:forEach var="son" begin="1" end="${intrating}">
										<li><i class="star-on"></i></li>
									</c:forEach>
									<c:forEach var="sof" begin="1" end="${5-intrating}">
										<li><i class="star-off"></i></li>
									</c:forEach>
								</ul></td>
						</c:forEach>
					</tr>
					<tr>
						<td class="aligned-color"><h3>Warranty</h3></td>
						<c:forEach var="i" begin="0" end="${ n-1}">
							<td>${products[i].warranty}</td>
						</c:forEach>
					</tr>
					<tr>
						<td class="aligned-color"><h3>Description</h3></td>
						<c:forEach var="i" begin="0" end="${ n-1}">
							<td>${products[i].description}</td>
						</c:forEach>
					</tr>
					<tr>
						<td class="aligned-color"><h3>Specs</h3></td>
						<c:forEach var="i" begin="0" end="${ n-1}">
							<td>${products[i].specifications}</td>
						</c:forEach>
					</tr>
					<tr>
						<td class="aligned-color"><h3>Features</h3></td>
						<c:forEach var="i" begin="0" end="${ n-1}">
							<td>${products[i].features}</td>
						</c:forEach>
					</tr>
					<tr>
						<td class="aligned-color"></td>

						<c:forEach var="i" begin="0" end="${ n-1}">

							<td>
								<button class="btn btn-small btn-primary" data-tip="tooltip"
									data-title="+To Cart" data-placement="top">
									<i class="icon-shopping-cart"></i>
								</button>
								<button class="btn btn-small" data-tip="tooltip"
									data-title="+To Wishlist" data-placement="top">
									<i class="icon-heart"></i>
								</button>
								<button class="btn btn-small" data-tip="tooltip"
									data-title="Remove" data-placement="top">
									<i class="icon-trash"></i>
								</button>
							</td>
						</c:forEach>
					</tr>
				</table>
			</c:when>

			<c:otherwise>
				<table width="100%" border="1" cellspacing="0" cellpadding="5">
					<tr bgcolor="#666666">
						<td class="bgColorMain"><strong><font
								color="#FFFFFF">No product to Compare! Press <a
									style="color: red" href="listproduct.do">here</a> to continue
									shopping
							</font></strong></td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	<!--end span12-->
</div>
<!--end row-->