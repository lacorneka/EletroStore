<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="listproductscart" scope="session"
	value="${sessionScope.listproductscart}" />
<c:set var="sumprice" value="0" />
<c:choose>
	<c:when test="${listproductscart.size() > 0}">
		<div class="row">

			<div class="span12">
				<table class="table">
					<thead>
						<tr>
							<th><span>Image</span></th>
							<th class="desc"><span>Descraption</span></th>
							<th><span>Quantity</span></th>
							<th><span>Unit Price</span></th>
							<th><span>Sub Price</span></th>
							<th><span>Action</span></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="product" items="${listproductscart}">
							<c:set var="sumprice"
								value="${sumprice + product.price*product.quantityforsell}" />
							<tr>
								<td><a href="#"><img
										src="<c:url value='/resources/img/product/${product.image1}'/>"
										alt=""></a></td>
								<td class="desc">
									<h4>
										<a href="product.do?productid=${product.productid}"
											class="invarseColor"> ${product.productname} </a>
									</h4>
									<ul class="rating clearfix">
										<li><i class="star-on"></i></li>
										<li><i class="star-on"></i></li>
										<li><i class="star-on"></i></li>
										<li><i class="star-off"></i></li>
										<li><i class="star-off"></i></li>
									</ul>
								</td>
								<td class="quantity">
									<div class="input-prepend input-append">
										<input type="text" name="" value="${product.quantityforsell}">
									</div>
								</td>
								<td class="sub-price">
									<h2>${product.price}$</h2>
								</td>
								<td class="total-price">
									<h2>
										<fmt:formatNumber type="number" groupingUsed="false"
											value="${product.quantityforsell*product.price}" />
										$
									</h2>
								</td>
								<td><a class="btn btn-small btn-success" data-title="Edit"
									data-placement="top" data-tip="tooltip"> <i
										class="icon-pencil"></i>
								</a> <a class="btn btn-small btn-danger" data-title="Remove"
									data-placement="top" data-tip="tooltip"> <i
										class="icon-trash"></i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<!--end span12-->


			<div class="span7">
				<div id="cart-tab"></div>
				<!--end cart-tab-->
			</div>
			<!--end span7-->


			<div class="span5">
				<div class="cart-receipt">
					<table class="table table-receipt">
						<tr>
							<td class="alignRight"><h2>Total</h2></td>
							<td class="alignLeft"><h2>
									<fmt:formatNumber type="number" groupingUsed="false"
										value="${sumprice}" />
									$
								</h2></td>
						</tr>
						<tr>
							<td class="alignRight"><a class="btn" href="welcome.do">Continue
									Shoping</a></td>
							<td class="alignLeft"><a class="btn btn-primary"
								href="checkout.do">Checkout</a></td>
						</tr>
					</table>
				</div>
			</div>
			<!--end span5-->


		</div>
		<!--end row-->
	</c:when>

	<c:otherwise>
		<table width="100%" border="1" cellspacing="0" cellpadding="5">
			<tr bgcolor="#666666">
				<td class="bgColorMain"><strong><font color="#FFFFFF">No
							product in Cart! Press <a style="color: red" href="Products.do">here</a>
							to continue shopping
					</font></strong></td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>