<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<h2>All Advertisements</h2>
<p>
	<a href="addadvertisement.do">Add new advertisement</a>
</p>
<div class="widget box">
	<div class="widget-header">
		<h4>
			<i class="icon-reorder"></i> Table Advertisement
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
				<th>Description</th>
				<th>Image File</th>
				<th>Show Image</th>
				<th></th>
			</tr>
			<c:forEach var="c" items="${requestScope.advertisements}">
				<tr>
					<td>${c.adname}</td>
					<td>${c.addescription}</td>
					<td>${c.adimage}</td>
					<td><img style="max-height: 150px; max-width: 150px;"
						src="<c:url value='/resources/img/advertisement/${c.adimage}'/>"
						alt="${c.adimage}"></td>
					<td><a href="editadvertisement.do?editID=${c.adid}">Edit</a> <a
						href="deleteadvertisement.do?deleteID=${c.adid}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>