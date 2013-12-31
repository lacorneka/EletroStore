<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="POST" modelAttribute="customer"
	action="registering.do" class="form-horizontal">

	<div class="legend">&nbsp;&nbsp;&nbsp;&nbsp;Account Informations</div>
	<div class="control-group">
		<form:label path="email" cssClass="control-label">Email:				
			<span class="text-error">*</span>
		</form:label>
		<div class="controls">
			<form:input path="email" placeholder="example@example.com" />
			<form:errors path="email" cssClass="error text-error"
				style="margin-left: 10px;" />
		</div>
	</div>
	<!--end control-group-->

	<div class="control-group">
		<form:label path="password" cssClass="control-label">Password:				
			<span class="text-error">*</span>
		</form:label>
		<div class="controls">
			<form:password path="password" placeholder="**********" />
			<span><form:errors path="password" cssClass="error text-error" /></span>
		</div>
	</div>

	<!--end control-group-->
	<div class="control-group">
		<form:label path="retypepassword" cssClass="control-label">Retype Password:				
			<span class="text-error">*</span>
		</form:label>
		<div class="controls">
			<form:password path="retypepassword" placeholder="**********" />
			<span style="margin-left: 10px;"><form:errors
					path="retypepassword" cssClass="error text-error" /></span>
		</div>
	</div>
	<!--end control-group-->

	<div class="legend">&nbsp;&nbsp;&nbsp;&nbsp;Personal Informations</div>
	<div class="control-group">
		<div class="control-label">
			<form:label path="firstname" cssClass="control-label">First Name
				</form:label>

		</div>
		<div class="controls">
			<form:input path="firstname" placeholder="Johny" />
			<span style="margin-left: 10px;"><form:errors path="firstname"
					cssClass="error text-error" /></span>
		</div>
	</div>
	<!--end control-group-->

	<div class="control-group">
		<form:label path="lastname" cssClass="control-label">Last Name:				
			</form:label>
		<div class="controls">
			<form:input path="lastname" placeholder="Depp" />
			<span style="margin-left: 10px;"><form:errors path="lastname"
					cssClass="error text-error" /></span>
		</div>
	</div>
	<!--end control-group-->

	<div class="control-group">
		<form:label path="phonenumber" cssClass="control-label">Phone Number:				
			<span class="text-error">*</span>
		</form:label>
		<div class="controls">
			<form:input path="phonenumber" placeholder="(08)-7654-321" />
			<span style="margin-left: 10px;"><form:errors
					path="phonenumber" cssClass="error text-error" /></span>
		</div>
	</div>
	<!--end control-group-->

	<div class="control-group">
		<form:label path="address" cssClass="control-label">Address:				
			<span class="text-error">*</span>
		</form:label>
		<div class="controls">
			<form:input path="address"
				placeholder="227 Nguyen Van Cu, Ward 5, HCMC" />
			<span style="margin-left: 10px;"><form:errors path="address"
					cssClass="error text-error" /></span>
		</div>
	</div>
	<!--end control-group-->

	<div class="control-group">
		<div class="controls">		
			I've read and agreed on <a href="#">Terms &amp; Conditions</a>
			<br/>
			 <input type="submit" class="btn btn-primary"
				value="Register">
		</div>
	</div>

</form:form>
