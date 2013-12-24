<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Create</h2>

<form:form method="POST" modelAttribute="brand" action="/admin/brand/add.do"
	class="form-horizontal" enctype="multipart/form-data">
	<h4>Brand</h4>
	<hr/>

	<form:label path="name" cssClass="control-label">Name:				
			<span class="text-error">*</span>
	</form:label>
	<div class="controls">
		<form:input path="name" placeholder="Samsung" />
		<form:errors path="name" cssClass="error text-error"
			style="margin-left: 10px;" />
	</div>

	<form:label path="image" cssClass="control-label">Image:				
			<span class="text-error">*</span>
	</form:label>
	<div class="controls">
		<input name="imageFile" type="file" />
		<form:input path="image" placeholder="" />
		<form:errors path="image" cssClass="error text-error"
			style="margin-left: 10px;" />
	</div>
	<input type="submit" value="Add" />
</form:form>

<div>
	<a href="/admin/brand.do">Back to list</a>
</div>

@section Scripts { @Scripts.Render("~/bundles/jqueryval") }
