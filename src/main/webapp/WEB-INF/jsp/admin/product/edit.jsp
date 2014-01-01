<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<sec:authorize url="/admin"></sec:authorize>
<h2>Edit</h2>

<form:form method="POST" modelAttribute="product"
	action="editingproduct.do" class="form-horizontal"
	enctype="multipart/form-data">
	<h4>Product</h4>
	<hr />
	<c:if test="${not empty error}">
		<div style="color: red;">${param.error}</div>
	</c:if>
	
	<input type="hidden" name="editID" value="${p.productid }" />

	<div class="form-group">
		<form:label path="productname" cssClass="control-label col-md-2">Product Name:				
				<span style="color: red;">*</span>
		</form:label>

		<div class="col-md-10">
			<form:input size="50" path="productname"
				placeholder="RCA - 40\" Class (40\" Diag.) - LED - 1080p - 60Hz - HDTV" value="${p.productname}" />
			<form:errors path="productname"
				style="color: red; margin-left: 10px;" />
		</div>
	</div>
	<div class="form-group">
		<form:label path="model" cssClass="control-label col-md-2">Model:
				<span style="color: red;">*</span>
		</form:label>

		<div class="col-md-10">
			<form:input path="model" placeholder="LED40C45RQ" value="${p.model}"/>
			<form:errors path="model" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-2">Brand: <span
			style="color: red;">*</span>
		</label>
		<div class="col-md-10">
			<select name="brandID">
				<c:forEach var="b" items="${brands}">
					<option value="${b.brandid}" <c:if test="${b.brandid eq p.brand.brandid }"><c:out value="selected=selected"/></c:if> >${b.brandname}</option>
				</c:forEach>
			</select>
			<form:errors path="brandID" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<label class="control-label col-md-2">Category: <span
			style="color: red;">*</span>
		</label>
		<div class="col-md-10">
			<select name="categoryID">
				<c:forEach var="c" items="${categories}">
					<option value="${c.catalogid}" <c:if test="${c.catalogid eq p.productcatalog.catalogid }"><c:out value="selected=selected"/></c:if> >${c.catalogname}</option>
				</c:forEach>
			</select>

			<form:errors path="categoryID" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<label for="conditionID" class="control-label col-md-2">Condition:
			<span style="color: red;">*</span>
		</label>

		<div class="col-md-10">
			<select name="conditionID" id="conditionID">
				<c:forEach var="c" items="${conditions}">
					<option value="${c.conditionid}" <c:if test="${c.conditionid eq p.conditions.conditionid }"><c:out value="selected=selected"/></c:if>>${c.conditionname}</option>
				</c:forEach>
			</select>
			<form:errors path="conditionID"
				style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<form:label path="price" cssClass="control-label col-md-2">Price:				
		</form:label>

		<div class="col-md-10">
			<form:input path="price" placeholder="299.99" value="${p.price }"/>
			<form:errors path="price" style="color: red; margin-left: 10px;" />
		</div>
	</div>
	<div class="form-group">
		<form:label path="dealprice" cssClass="control-label col-md-2">Deal price:				
		</form:label>

		<div class="col-md-10">
			<form:input path="dealprice" placeholder="259.99" value="${p.dealprice }" />
			<form:errors path="dealprice" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<form:label path="tax" cssClass="control-label col-md-2">Tax:				
		</form:label>

		<div class="col-md-10">
			<form:input path="tax" placeholder="0.1" value="${p.tax }" />
			<form:errors path="tax" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<form:label path="quantity" cssClass="control-label col-md-2">Quantity:				
		</form:label>

		<div class="col-md-10">
			<form:input path="quantity" placeholder="100" value="${p.quantity }" />
			<form:errors path="quantity" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<form:label path="quantityforsell" cssClass="control-label col-md-2">Max quantity per Order:				
		</form:label>

		<div class="col-md-10">
			<form:input path="quantityforsell" placeholder="5" value="${p.quantityforsell }"/>
			<form:errors path="quantityforsell"
				style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<!-- Warranty -->
	<div class="form-group">
		<form:label path="warranty" cssClass="control-label col-md-2">Warranty (year):				
		</form:label>

		<div class="col-md-10">
			<form:input path="warranty" placeholder="2" value="${p.warranty }"/>
			<form:errors path="warranty" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<form:label path="rating" cssClass="control-label col-md-2">Rating:				
				<span style="color: red;">*</span>
		</form:label>

		<div class="col-md-10">
			<form:input path="rating" placeholder="4" value="${p.rating }"/>
			<form:errors path="rating" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<!-- Description -->
	<div class="form-group">
		<form:label path="description" cssClass="control-label col-md-2">Description:				
		</form:label>

		<div class="col-md-10">
			<form:textarea path="description"
				placeholder="Watch your favorite programming on this RCA LED40C45RQ LED HDTV, which features 1080p resolution for crisp images and a 4000:1 dynamic contrast ratio for vibrant colors..." 
				value="${p.description }"/>
			<form:errors path="description"
				style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<!-- Specifications -->
	<div class="form-group">
		<form:label path="specifications" cssClass="control-label col-md-2">Specifications:				
		</form:label>

		<div class="col-md-10">
			<form:textarea path="specifications"
				placeholder="Width: 36-1/2\"Weight: 18.3\" without stand..." 
				value="${p.specifications }"/>
			<form:errors path="specifications"
				style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<!-- Features -->
	<div class="form-group">
		<form:label path="features" cssClass="control-label col-md-2">Features:				
		</form:label>

		<div class="col-md-10">
			<form:textarea path="features"
				placeholder="40\" screen measured diagonally from corner to corner..." 
				value="${p.features }"/>
			<form:errors path="features" style="color: red; margin-left: 10px;" />
		</div>
	</div>


	<!-- input Image -->
	<div class="form-group">
		<label class="control-label col-md-2">Image 1: <span
			style="color: red;">*</span>
		</label>

		<div class="col-md-10">
			<input id="image1" name="image1" type="file" />
			<form:errors path="image1" style="color: red; margin-left: 10px;" />
		</div>
	</div>
	<!-- input Image 2-->
	<div class="form-group">
		<label class="control-label col-md-2">Image 2: <span
			style="color: red;">*</span>
		</label>

		<div class="col-md-10">
			<input id="image2" name="image2" type="file" />
			<form:errors path="image2" style="color: red; margin-left: 10px;" />
		</div>
	</div>
 	<div class="form-group">
		<form:label path="productviews" cssClass="control-label col-md-2">Views:				
				<span style="color: red;">*</span>
		</form:label>

		<div class="col-md-10">
			<form:input path="productviews" placeholder="200" value="${p.productviews }"/>
			<form:errors path="productviews" style="color: red; margin-left: 10px;" />
		</div>
	</div>
	<div class="form-group">
		<form:label path="totalbuyer" cssClass="control-label col-md-2">No.Buyers:				
				<span style="color: red;">*</span>
		</form:label>

		<div class="col-md-10">
			<form:input path="totalbuyer" placeholder="10" 	value="${p.totalbuyer }"/>
			<form:errors path="totalbuyer" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Save" class="btn btn-default" />
		</div>
	</div>
</form:form>

<br>
<div class="form-group">
	<a href="${pageContext.request.contextPath}/admin/brand.do">Back to
		list</a>
</div>