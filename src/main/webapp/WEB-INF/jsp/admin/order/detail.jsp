<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<h2>Model ${p.model}</h2>
<p>Order detail</p>
<br />
<br />
<div class="widget box">
	<div class="widget-header">
		<h4>
			<i class="icon-reorder"></i> Order
		</h4>
		<div class="toolbar no-padding">
			<div class="btn-group">
				<span class="btn btn-xs widget-collapse"><i
					class="icon-angle-down"></i></span>
			</div>
			<br />
		</div>
		<br />
	</div>
	<br />
	<table 			class="table table-hover table-striped table-bordered table-highlight-head">
			<tr>
				<th><span>Image</span></th>
				<th class="desc"><span>Description</span></th>
				<th><span>Quantity</span></th>
				<th><span>Unit Price</span></th>
				<th><span>Sub Price</span></th>
			</tr>
			<c:forEach var="detail" items="${listorderdetails}">
				<tr>
					<td><a href="#"><img style="max-height: 92px; max-width: 92px;"
							src="<c:url value='/resources/img/product/${detail.product.image1}'/>"
							alt=""></a></td>
					<td class="desc">
							<a href="product.do?productid=${detail.product.productid}"
								class="invarseColor"> ${detail.product.productname} </a>
						
					</td>
					<td class="quantity">
						<div class="input-prepend input-append">
							${detail.quantity}
						</div>
					</td>
					<td class="sub-price">
						${detail.product.price}$
					</td>
					<td class="total-price">

							<fmt:formatNumber type="number" groupingUsed="false"
								value="${detail.quantity*detail.product.price}" />
							$

					</td>
				</tr>
			</c:forEach>
	</table>

</div>
<br />
<div class="form-group">
	<a href="${pageContext.request.contextPath}/admin/order.do">Back to
		list</a>
</div>
<br />
