<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<h2>All Orders</h2>
<p>
	<a href="addorder.do">Add new order</a>
</p>
<div class="widget box">
	<div class="widget-header">
		<h4>
			<i class="icon-reorder"></i> Table Order
		</h4>
		<div class="toolbar no-padding">
			<div class="btn-group">
				<span class="btn btn-xs widget-collapse"><i
					class="icon-angle-down"></i></span>
			</div>
		</div>
	</div>
	<div class="widget-content" style="display: block;">
		<script>
			function DoSubmit(i, id) {
				document.getElementById(id).value = i;
				document.listorder.submit();
			}
		</script>
		<form name="listorder" action="account.do" method="get">

			Filter By <select name="filterorder" onchange="submit()">
				<option value="-1"
					<c:if test="${-1 eq param.filterorder}"><c:out value="selected" /></c:if>>All</option>
				<option value="0"
					<c:if test="${0 eq param.filterorder}"><c:out value="selected" /></c:if>>This
					week</option>
				<option value="1"
					<c:if test="${1 eq param.filterorder}"><c:out value="selected" /></c:if>>This
					month</option>
				<option value="2"
					<c:if test="${2 eq param.filterorder}"><c:out value="selected" /></c:if>>This
					year</option>
			</select>
		</form>

		<table
			class="table table-hover table-striped table-bordered table-highlight-head">
			<tr>
				<th><span>Order ID</span></th>
				<th><span>User</span></th>
				<th><span>Order Status</span></th>
				<th><span>Total Money</span></th>
				<th><span>Day</span></th>
				<th><span>Action</span></th>
			</tr>
			<c:forEach var="order" items="${requestScope.listorders}">
				<tr>
					<td>${order.orderid}</td>
					<td>${order.user.email}</td>
					<td><form action="editorder.do">
							<input type="hidden" name="orderid" value="${order.orderid}"> <select
								name="orderstatusid" onchange="submit()">
								<c:forEach var="o" items="${requestScope.listorderstatus}">
									<option value="${o.orderstatusid}"
										<c:if test="${o.orderstatusid eq order.orderstatus.orderstatusid }"><c:out value="selected=selected"/></c:if>>${o.orderstatusname}</option>
								</c:forEach>
							</select>
						</form></td>
					<td>$${order.totalmoney}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy"
							value="${order.orderdate}" /></td>
					<td><a href="orderdetail.do?orderid=${order.orderid}">
							Detail </a> <a href="deleteorder.do?orderid=${order.orderid}">
							Delete </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>