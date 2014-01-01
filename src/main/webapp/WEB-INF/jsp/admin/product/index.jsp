<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<h2>All Products</h2>
<p>
	<a href="addproduct.do">Add new product</a>
</p>
<div class="widget box">
	<div class="widget-header">
		<h4>
			<i class="icon-reorder"></i> Table Product
		</h4>
		<div class="toolbar no-padding">
			<div class="btn-group">
				<span class="btn btn-xs widget-collapse"><i
					class="icon-angle-down"></i></span>
			</div>
		</div>
	</div>

	<div class="widget-content" style="display: block;">
		<table
			class="table table-hover table-striped table-bordered table-highlight-head">
			<tr>
				<th>Name</th>
				<th>Model</th>
				<th>Brand</th>
				<th>Category</th>
				<th>Condition</th>
				<th>Price</th>
				<!-- <th>Deal price</th>
				<th>Tax</th>
				<th>Quantity</th>
				<th>Rating</th>-->
				<th>Description</th>
				<th>Image</th>
				<th>Views</th>
				<th>No.Buyers</th>
				<th></th>
			</tr>
			<c:forEach var="p" items="${requestScope.products}">
				<tr>
					<td>${p.productname}</td>
					<td>${p.model}</td>
					<td>${p.brand.brandname}</td>
					<td>${p.productcatalog.catalogname}</td>
					<td>${p.conditions.conditionname}</td>
					<td>${p.price}</td>
					<%-- <td>${p.dealprice}</td>
					<td>${p.tax}</td>
					<td>${p.warranty}</td>
					<td>${p.rating}</td> --%>
					<td>${p.description}</td>
					<td><img style="max-height: 150px; max-width: 150px;"
						src="<c:url value='/resources/img/product/${p.image1}'/>"
						alt="${b.productname}"></td>
					<td>${p.productviews}</td>
					<td>${p.totalbuyer}</td>

					<td><a href="editproduct.do?editID=${p.productid}">Edit</a> <a
						href="productdetail.do?detailID=${p.productid}">Detail</a> <a
						href="deleteproduct.do?deleteID=${p.productid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>