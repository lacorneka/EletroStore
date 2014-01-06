<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<a href="account.do" class="btn btn-primary">Back</a>
<br/>
<c:set var="listorderdetails" value="${requestScope.listorderdetails}" />
<div class="row">

	<div class="span12">
		<table class="table">
			<thead>
				<tr>
					<th><span>Image</span></th>
					<th class="desc"><span>Description</span></th>
					<th><span>Quantity</span></th>
					<th><span>Unit Price</span></th>
					<th><span>Sub Price</span></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="detail" items="${listorderdetails}">
					<tr>
						<td><a href="#"><img
								src="<c:url value='/resources/img/product/${detail.product.image1}'/>"
								alt=""></a></td>
						<td class="desc">
							<h4>
								<a href="product.do?productid=${detail.product.productid}"
									class="invarseColor"> ${detail.product.productname} </a>
							</h4>
						</td>
						<td class="quantity">
							<div class="input-prepend input-append">
								<h2>
									${detail.quantity}</h2>
							</div>
						</td>
						<td class="sub-price">
							<h2>${detail.product.price}$</h2>
						</td>
						<td class="total-price">
							<h2>
								<fmt:formatNumber type="number" groupingUsed="false"
									value="${detail.quantity*detail.product.price}" />
								$
							</h2>
						</td>
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
							<fmt:formatNumber type="number" maxFractionDigits="2"
								groupingUsed="true" value="${listorderdetails[0].orders.totalmoney}" />
							$
						</h2></td>
				</tr>
			</table>
		</div>
	</div>
	<!--end span5-->


</div>
<!--end row-->
