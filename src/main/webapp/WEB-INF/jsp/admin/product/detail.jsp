<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<h2>Model ${p.model}</h2>
<p>
	<a href="addproduct.do">Product detail</a>
</p>
<div class="widget box">
	<div class="widget-header">
		<h4>
			<i class="icon-reorder"></i> Product
		</h4>
		<div class="toolbar no-padding">
			<div class="btn-group">
				<span class="btn btn-xs widget-collapse"><i
					class="icon-angle-down"></i></span>
			</div>
		</div>
	</div>

	<div class="widget-content" style="display: block;">
		<img style="max-height: 300px; max-width: 300px;"
			src="<c:url value='/resources/img/product/${p.image1}'/>"
			alt="${p.productname}" />

		<div class="form-group">
			<label class="control-label col-md-2">Name: </label>

			<div class="col-md-10">
				<p>${p.productname}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Model: </label>

			<div class="col-md-10">
				<p>${p.model}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Brand: </label>

			<div class="col-md-10">
				<p>${p.brand.brandname}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Category: </label>

			<div class="col-md-10">
				<p>${p.productcatalog.catalogname}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Condition: </label>

			<div class="col-md-10">
				<p>${p.condition.conditionname}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Price: </label>

			<div class="col-md-10">
				<p>${p.price}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Deal price: </label>

			<div class="col-md-10">
				<p>${p.dealprice}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Tax: </label>

			<div class="col-md-10">
				<p>${p.tax}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Quantity: </label>

			<div class="col-md-10">
				<p>${p.quantity}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Max quantity per Order:
			</label>

			<div class="col-md-10">
				<p>${p.quantityforsell}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Warranty: </label>

			<div class="col-md-10">
				<p>${p.warranty}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Rating: </label>

			<div class="col-md-10">
				<p>${p.rating}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Description: </label>

			<div class="col-md-10">
				<p>${p.description}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Specifications: </label>

			<div class="col-md-10">
				<p>${p.specifications}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Features: </label>

			<div class="col-md-10">
				<p>${p.features}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Image: </label>

			<div class="col-md-10">
				<p>${p.image2}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">Views: </label>

			<div class="col-md-10">
				<p>${p.productviews}</p>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-md-2">No.Buyers: </label>

			<div class="col-md-10">
				<p>${p.totalbuyer}</p>
			</div>
		</div>

		<a href="deleteproduct.do?deleteID=${p.productid}">Delete</a>
	</div>
	<div class="form-group">
		<a href="${pageContext.request.contextPath}/admin/product.do">Back
			to list</a>
	</div>
</div>