<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<sec:authorize url="/admin"></sec:authorize>
<h2>Edit</h2>

<form:form method="POST" modelAttribute="advertisement"
	action="editingadvertisement.do"
	class="form-horizontal" enctype="multipart/form-data">
	<h4>Edit Advertisement</h4>
	<hr />
	<c:if test="${not empty requestScope.error}">
		<div style="color: red;">${requestScope.error}</div>
	</c:if>
	<input type="hidden" id="id" name="id" value="${param.editID}"/>
	<!-- name -->
	<div class="form-group">
		<form:label path="name" cssClass="control-label col-md-2">Name:				
				<span style="color: red;">*</span>
		</form:label>

		<div class="col-md-10">
			<form:input path="name" placeholder="Samsung" value="${advertisement.name}" />
			<form:errors path="name" style="color: red; margin-left: 10px;" />
		</div>
	</div>
	
	<!-- advertisement description -->
	<div class="form-group">
		<form:label path="description" cssClass="control-label col-md-2">Description:				
		</form:label>

		<div class="col-md-10">
			<form:input path="description" placeholder="Tv LCD Samsung 47 inch discount up to 80%" />
			<form:errors path="description" style="color: red; margin-left: 10px;" />
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
			<input type="submit" value="Save" class="btn btn-default" />
		</div>
	</div>
</form:form>

<br>
<div class="form-group">
	<a href="${pageContext.request.contextPath}/admin/advertisement.do">Back to
		list</a>
</div>