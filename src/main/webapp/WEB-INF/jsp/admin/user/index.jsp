<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<h2>All Users</h2>
<div class="widget box">
	<div class="widget-header">
		<h4>
			<i class="icon-reorder"></i> Table User
		</h4>
		<div class="toolbar no-padding">
			<div class="btn-group">
				<span class="btn btn-xs widget-collapse"><i
					class="icon-angle-down"></i></span>
			</div>
		</div>
	</div>
	<c:if test="${not empty requestScope.error}">
		<div style="color: red;">${requestScope.error}</div>
	</c:if>
	<div class="widget-content" style="display: block;">
		<table
			class="table table-hover table-striped table-bordered table-highlight-head">
			<tr>
				<th>Email</th>
				<th>First name</th>
				<th>Last name</th>
				<th>Phone number</th>
				<th>Zipcode</th>
				<th>Roles</th>
				<th>Enable</th>
				<th></th>
			</tr>
			<c:forEach var="b" items="${requestScope.users}">
				<tr>
					<td>${b.email}</td>
					<td>${b.firstname}</td>
					<td>${b.lastname}</td>
					<td>${b.phonenumber}</td>
					<td>${b.zipcode}</td>
					<td><c:out value=" | " /> <c:forEach var="r"
							items="${b.userroleses}">
							<c:out value="${r.role}" />
							<c:out value=" | " />
						</c:forEach></td>
					<td><c:choose>
							<c:when test="${b.enable}">yes
							</c:when>
							<c:otherwise>no
							</c:otherwise>
						</c:choose></td>
					<td><a href="edituser.do?editID=${b.memberid}">Edit</a> <a
						href="deleteuser.do?deleteID=${b.memberid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>