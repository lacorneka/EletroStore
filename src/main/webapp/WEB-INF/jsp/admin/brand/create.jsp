<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<sec:authorize url="/admin"></sec:authorize>
<h2>Create</h2>

<form:form method="POST" modelAttribute="brand"
	action="addingbrand.do"
	class="form-horizontal" enctype="multipart/form-data">
	<h4>Brand</h4>
	<hr />
	<c:if test="${not empty error}">
		<div style="color: red;">${requestScope.error}</div>
	</c:if>

	<!-- Brand name -->
	<div class="form-group">
		<form:label path="name" cssClass="control-label col-md-2">Name:				
				<span style="color: red;">*</span>
		</form:label>

		<div class="col-md-10">
			<form:input path="name" placeholder="Samsung" />
			<form:errors path="name" style="color: red; margin-left: 10px;" />

		</div>
	</div>

	<!-- input Image -->
	<div class="form-group">
		<label class="control-label col-md-2">Image: <span
			style="color: red;">*</span>
		</label>

		<div class="col-md-10">
			<input id="imageFile" name="imageFile" type="file" />
			<form:errors path="imageFile" style="color: red; margin-left: 10px;" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Add" class="btn btn-default" />
		</div>
	</div>
</form:form>

<br>
<div class="form-group">
	<a href="${pageContext.request.contextPath}/admin/brand.do">Back to
		list</a>
</div>