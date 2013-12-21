<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="span4">
	<div class="titleHeader clearfix">
		<h3>New Customer</h3>
	</div>
	<!--end titleHeader-->

	<div class="new-customer">
		<p>By creating an account you will be able to shop faster, be up
			to date on an order's status, and keep track of the orders you have
			previously made.</p>
		<a href="register.html" class="btn">Create Account</a>
	</div>
</div>
<!--end span4-->


<div class="span5">
	<div class="titleHeader clearfix">
		<h3>Returning Customer</h3>
	</div>
	<!--end titleHeader-->

	<form action="j_spring_security_check" method="post" id="loginForm">

		<div class="controls">
			<label for="j_username">Your E-Mail: <span class="text-error">*</span></label>
			<input class="text" type="text" name="j_username" id="j_username"
				value="" placeholder="example@example.com" />
		</div>
		<div class="controls">
			<label for="j_password">Your Password: <span class="text-error">*</span></label>
			<input class="text" type="password" id="j_password" name="j_password"
			 id="j_password" value="" placeholder="**************"> 
		</div>

		<div class="controls">
			<label class="checkbox" > <input name='_spring_security_remember_me' type="checkbox">
				Remember Me
			</label>
			<button type="submit" class="btn btn-primary">Login</button>
		</div>
	</form>
	<!--end form-->
</div>
<!--end span5-->

<div id="forget-pass" class="modal hide fade" tabindex="-1"
	data-backdrop="static" >
	<div class="modal-body">
		<form method="post" action="#"
			class="form-inline">
			<input type="text" name="" class="span4"
				placeholder="Put your E-Mail...">

			<button type="submit" class="btn btn-primary">Receive My
				Password</button>

			<button type="button" class="btn btn-small" data-dismiss="modal"
				>Cancel</button>
		</form>
		<!--end form-->
	</div>
	<!--end modal-body-->
</div>
<!--end modal-->


<div class="span3">
	<div class="titleHeader clearfix">
		<h3>Account</h3>
	</div>
	<!--end titleHeader-->
	<ul class="unstyled my-account">
		<li><a class="invarseColor" href="#"><i
				class="icon-caret-right"></i> Login or Register</a></li>
		<li><a class="invarseColor" href="#"><i
				class="icon-caret-right"></i> Forget my Password</a></li>
		<li><a class="invarseColor" href="#"><i
				class="icon-caret-right"></i> My Account</a></li>
		<li><a class="invarseColor" href="#"><i
				class="icon-caret-right"></i> My wishlist</a></li>
		<li><a class="invarseColor" href="#"><i
				class="icon-caret-right"></i> Order History</a></li>


		<li></li>
		<li></li>
	</ul>
</div>
<!--end span3-->