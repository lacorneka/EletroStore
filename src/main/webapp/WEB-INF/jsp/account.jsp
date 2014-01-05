<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/includes/taglibs.jsp"%>

<c:set var="user" value="${requestScope.user}" />
<c:set var="listorders" value="${requestScope.listorders}" />

<div class="row">

	<div class="span12">
		<div class="account-list-outer">

			<div class="titleHeader clearfix">
				<h3>My Account</h3>
			</div>
			<!--end titleHeader-->

			<form id="customer" class="form-horizontal" action="changeaccount.do"
				method="POST">

				<c:if test="${not empty sessionScope.accounterror}">
					<div class="error text-error">
						Error: ${sessionScope.accounterror}
					</div>
				</c:if>

				<div class="legend">&nbsp;&nbsp;&nbsp;&nbsp;Account
					Informations</div>
				<div class="control-group">
					<label for="email" class="control-label">Email: <span
						class="text-error">*</span>
					</label>
					<div class="controls">
						<input id="email" name="email" type="text" disabled
							value="${user.email}" />
					</div>
				</div>
				<!--end control-group-->

				<div class="control-group">
					<label for="password" class="control-label">Old Password: <span
						class="text-error">*</span>
					</label>
					<div class="controls">
						<input id="password" name="password" type="password" value="" />
						<span></span>
					</div>
				</div>

				<!--end control-group-->
				<div class="control-group">
					<label for="newpassword" class="control-label">New
						Password: <span class="text-error">*</span>
					</label>
					<div class="controls">
						<input id="newpassword" name="newpassword" type="password"
							value="" /> <span style="margin-left: 10px;"></span>
					</div>
				</div>
				<!--end control-group-->

				<!--end control-group-->
				<div class="control-group">
					<label for="renewpassword" class="control-label">Renew
						Password: <span class="text-error">*</span>
					</label>
					<div class="controls">
						<input id="renewpassword" name="renewpassword" type="password"
							value="" /> <span style="margin-left: 10px;"></span>
					</div>
				</div>
				<!--end control-group-->

				<div class="legend">&nbsp;&nbsp;&nbsp;&nbsp;Personal
					Informations</div>
				<div class="control-group">
					<div class="control-label">
						<label for="firstname" class="control-label">First Name </label>
					</div>
					<div class="controls">
						<input id="firstname" name="firstname" placeholder="Johny"
							type="text" value="${user.firstname }" /> <span
							style="margin-left: 10px;"></span>
					</div>
				</div>
				<!--end control-group-->

				<div class="control-group">
					<label for="lastname" class="control-label">Last Name: </label>
					<div class="controls">
						<input id="lastname" name="lastname" placeholder="Depp"
							type="text" value="${user.lastname }" /> <span
							style="margin-left: 10px;"></span>
					</div>
				</div>
				<!--end control-group-->

				<div class="control-group">
					<label for="phonenumber" class="control-label">Phone
						Number: <span class="text-error">*</span>
					</label>
					<div class="controls">
						<input id="phonenumber" name="phonenumber" type="text"
							value="${user.phonenumber}" /> <span style="margin-left: 10px;"></span>
					</div>
				</div>
				<!--end control-group-->

				<div class="control-group">
					<div class="controls">
						<input type="submit" class="btn btn-primary" value="Change">
					</div>
				</div>

			</form>


			<div class="titleHeader clearfix">
				<h3>My Orders</h3>
			</div>
			<!--end titleHeader-->
			<br />

			<c:choose>
				<c:when test="${listorders.size() > 0}">
					<form name="listorder" action="account.do" method="get">
						<div class="sortBy inline pull-left">
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
						</div>
						<table class="table">
							<thead>
								<tr>
									<th><span>Order ID</span></th>
									<th><span>User</span></th>
									<th><span>Order Status</span></th>
									<th><span>Total Money</span></th>
									<th><span>Day</span></th>
									<th><span>Action</span></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="order" items="${listorders}">
									<tr>
										<td>${order.orderid}</td>
										<td>${user.email}</td>
										<td>${order.orderstatus.orderstatusname}</td>
										<td><h2>$${order.totalmoney}</h2></td>
										<td><fmt:formatDate pattern="dd-MM-yyyy"
												value="${order.orderdate}" /></td>
										<td>
											<a href="orderdetail.do?orderid=${order.orderid}" class="btn btn-small btn-success" data-title="Detail"
												data-placement="top" data-tip="tooltip">
												<i class="icon-pencil"></i>
											</a>
											<c:if test="${order.orderstatus.orderstatusid eq 1}">
											<a href="deleteorder.do?orderid=${order.orderid}"class="btn btn-small" data-title="Remove"
												data-placement="top" data-tip="tooltip">
												<i class="icon-trash"></i>
											</a>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
				</c:when>

				<c:otherwise>
					<table width="100%" border="1" cellspacing="0" cellpadding="5">
						<tr bgcolor="#666666">
							<td class="bgColorMain"><strong><font
									color="#FFFFFF">No have any Orders! Press <a
										style="color: red" href="listproduct.do">here</a> to continue
										shopping
								</font></strong></td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
		<!--end -->
	</div>
	<!--end span9-->
</div>
<!--end row-->