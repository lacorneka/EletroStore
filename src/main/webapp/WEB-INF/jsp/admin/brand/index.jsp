<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<h2>All Brands</h2>
<p>
	<a href="addbrand.do">Add new brand</a>
</p>
<div class="widget box">
	<div class="widget-header">
		<h4>
			<i class="icon-reorder"></i> Table Brand
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
			<c:forEach var="b" items="${requestScope.brands}">
				<tr>
					<td>${b.brandname}</td>
					<td>${b.brandimage}</td>
					<td><img style="max-height: 150px; max-width: 150px;" src="<c:url value='/resources/img/brand/${b.brandimage}'/>" alt="${b.brandimage}"></td>
					<td><a href="editbrand.do?editID=${b.brandid}">Edit</a> <a href="deletebrand.do?deleteID=${b.brandid}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>