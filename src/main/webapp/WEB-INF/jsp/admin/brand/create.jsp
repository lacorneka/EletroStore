<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<h2>Create</h2>

<%-- <form:form method="POST" modelAttribute="brand" action="/admin/brand/add.do"
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

	<div class="control-label">Image:				
			<span class="text-error">*</span>
	</div>
	<div class="controls">
		<input name="imageFile" type="file" />
	</div>
	<input type="submit" value="Add" />
</form:form>
 --%>
 
 <form:form method="post" action="brand/add.do"  modelAttribute="brand" enctype="multipart/form-data">
 
    <p>Select files to upload. Press Add button to add more file inputs.</p>
	<c:if test="${not empty error}">
		<div class="text-error">${params.error}</div>
	</c:if>

	<table id="fileTable">
        <tr>
            <td><input name="imageFile" type="file" /></td>
        </tr>

    </table>
    <br/><input type="submit" value="Upload" />
</form:form>

<div>
	<a href="brand.do">Back to list</a>
</div>