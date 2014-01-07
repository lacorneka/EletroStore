<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div>
	<div
		style="clear: both; display: block; text-align: center; margin: 80px;">
		<h1 style="font-size: 100px; color: #fb6f58; padding: 15px;">
			<strong>404</strong>
		</h1>
		<div style="padding: 20px;">
			<p style="font-size: 30px;">Whoops, our bad...</p>
			<div style="font-size: 20px">
				<p style="font-size: 20px; padding-top: 20px; padding-bottom: 10px;">
					<strong>The page you requested was not found, and we have
						a fine guess why. </strong>
				</p>
				<ul
					style="font-size: 14px; text-align: left; padding-left: 80px; margin-bottom: 50px">
					<li>If you typed the URL directly, please make sure the
						spelling is correct.</li>
					<li>If you clicked on a link to get here, the link is
						outdated.</li>
				</ul>

				<p>You might wanna browse our site instead:</p>
				<ul class="inline">
					<li><a onclick="window.history.back();">Back</a></li>
					<li><a href="${pageContext.request.contextPath}/welcome.do">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/login.do">Login</a></li>
					<li><a href="${pageContext.request.contextPath}/register.do">Register</a></li>
					<li><a
						href="${pageContext.request.contextPath}/listproduct.do">Products</a></li>
					<li><a href="${pageContext.request.contextPath}/search.do">Search</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
