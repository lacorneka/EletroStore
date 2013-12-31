<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<h2>All Categories</h2>
<p>
	<a href="addcategory.do">Add new category</a>
</p>
<div class="widget box">
	<div class="widget-header">
		<h4>
			<i class="icon-reorder"></i> Table Category
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
				<th>Image File</th>
				<th>Show Image</th>
				<th></th>
			</tr>
			<c:forEach var="c" items="${requestScope.categories}">
				<tr>
					<td>${c.catalogname}</td>
					<td>${c.catalogimage}</td>
					<td><img style="max-height: 150px; max-width: 150px;"
						src="<c:url value='/resources/img/category/${c.catalogimage}'/>"
						alt="${c.catalogimage}"></td>
					<td><a href="editcategory.do?editID=${c.catalogid}">Edit</a> <a
						href="deletecategory.do?deleteID=${c.catalogid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>