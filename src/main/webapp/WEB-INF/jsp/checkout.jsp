<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="user" value="${requestScope.user}" />

<div class="row">

	<div class="span9">

		<div class="checkout-outer">
			<div class="checkout-header">
				<a href="#" class="invarseColor pull-right" data-tip="tooltip"
					data-placment="top" data-title="EDIT"
					style="margin-right: 12px; color: #333; font-size: 13px;"><i
					class="icon-pencil"></i></a>
				<h4>
					<i class="icon-caret-down"></i> Account and billing Details
				</h4>
			</div>
			<!--end checkout-header-->

			<div class="checkout-content">

				<hr>

				<form method="post" action="checkout.do"
					class="form-horizontal">

					<div class="control-group">
						<label class="control-label" for="inputFirstName">First
							Name: <span class="text-error">*</span>
						</label>
						<div class="controls">
							<input type="text" name="firstname" placeholder="John" value="${user.firstname}">
						</div>
					</div>
					<!--end control-group-->

					<div class="control-group">
						<label class="control-label" for="inputLastName">Last
							Name: <span class="text-error">*</span>
						</label>
						<div class="controls">
							<input type="text" name="lastname" placeholder="Doe" value="${user.lastname}">
						</div>
					</div>
					<!--end control-group-->

					<div class="control-group">
						<label class="control-label" for="inputCompany">Company:</label>
						<div class="controls">
							<input type="text" name="company" placeholder="Shopfine, INC">
						</div>
					</div>
					<!--end control-group-->

					<div class="control-group">
						<label class="control-label" for="inputFirstAdd">Address:
							<span class="text-error">*</span>
						</label>
						<div class="controls">
							<input type="text" name="address" placeholder="3st el-hakim">
						</div>
					</div>
					<!--end control-group-->

					<div class="control-group">
						<label class="control-label" for="inputCity">Phone Number: <span
							class="text-error">*</span></label>
						<div class="controls">
							<input type="text" name="phonenumber" placeholder="0987654321" value="${user.phonenumber}">
						</div>
					</div>
					<!--end control-group-->

					<div class="control-group">
						<label class="control-label" for="inputPostCode">TOTAL: <span
							class="text-error">*</span>
						</label>
						<div class="controls">
							<input type="text" name="total" placeholder="0$" value="${requestScope.sumprice} $">
						</div>
					</div>
					<!--end control-group-->

					<div class="control-group">
						<div class="controls">
							<button type="submit" class="btn btn-primary">Complete</button>
						</div>
					</div>
					<!--end control-group-->

				</form>
				<!--end form-->
			</div>
			<!--end checkout-content-->
		</div>
		<!--end checkout-outer-->

	</div>
	<!--end span9-->





</div>
<!--end row-->