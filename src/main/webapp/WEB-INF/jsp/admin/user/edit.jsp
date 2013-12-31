<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<sec:authorize url="/admin"></sec:authorize>
<h2>Edit</h2>

<form:form method="POST" modelAttribute="user" action="editinguser.do"
	class="form-horizontal">
	<h4>Edit Brand</h4>
	<hr />
	<c:if test="${not empty requestScope.error}">
		<div style="color: red;">${requestScope.error}</div>
		<br />
	</c:if>
	<input type="hidden" id="memberid" name="memberid"
		value="${user.memberid }" />
	<input type="hidden" id="email" name="email" value="${user.email }" />
	<input type="hidden" id="password" name="password"
		value="${user.password }" />

	<!-- firstname -->
	<div class="form-group">
		<label for="firstname" class="control-label col-md-2">First
			Name: </label>
		<div class="col-md-10">
			<input type="text" id="firstname" name="firstname"
				value="${user.firstname}" />
		</div>
	</div>

	<!-- lastname -->
	<div class="form-group">
		<label for="lastname" class="control-label col-md-2">Last
			Name: </label>
		<div class="col-md-10">
			<input type="text" id="lastname" name="lastname"
				value="${user.lastname}" />
		</div>
	</div>

	<!-- phonenumber -->
	<div class="form-group">
		<label for="phonenumber" class="control-label col-md-2">Phone
			Number: </label>
		<div class="col-md-10">
			<input type="text" id="phonenumber" name="phonenumber"
				value="${user.phonenumber}" />
		</div>
	</div>

	<!-- zipcode -->
	<div class="form-group">
		<label for="zipcode" class="control-label col-md-2">Zipcode: </label>
		<div class="col-md-10">
			<input type="text" id="zipcode" name="zipcode"
				value="${user.zipcode}" />
		</div>
	</div>

	<!-- enable -->
	<div class="form-group">
		<label for="enable" class="control-label col-md-2">Enable: </label>
		<div class="col-md-10">
			<form:checkbox path="enable" value="${user.enable}" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<input type="submit" value="Save" class="btn btn-default" />
		</div>
	</div>
</form:form>

<form:form method="POST" action="editinguser.do" class="form-horizontal">
	<h4>Add Role</h4>
	<hr />
	<!-- Role -->
	<input type="hidden" id="memberid" name="memberid"
		value="${user.memberid }" />
	<div class="form-group">
		<label for="role" class="control-label col-md-2">Role: </label>
		<div class="col-md-10">
			<input type="text" id="role" name="role" value="ROLE_USER" />
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
	<a href="${pageContext.request.contextPath}/admin/user.do">Back to
		list</a>
</div>