<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="row">

	<div class="span12">
		<table class="table">
			<thead>
				<tr>
					<th><span>Image</span></th>
					<th class="desc"><span>Descraption</span></th>
					<th><span>Model</span></th>
					<th><span>Stock</span></th>
					<th><span>Unit Price</span></th>
					<th><span>Action</span></th>
				</tr>
			</thead>
			<tbody>

				<tr>
					<td><a href="#"><img src="img/72x72.jpg" alt=""></a></td>
					<td class="desc">
						<h4>
							<a href="#" class="invarseColor"> Foliomania the designer </a>
						</h4>
						<ul class="rating clearfix">
							<li><i class="star-on"></i></li>
							<li><i class="star-on"></i></li>
							<li><i class="star-on"></i></li>
							<li><i class="star-off"></i></li>
							<li><i class="star-off"></i></li>
						</ul>
						<ul class="unstyled">
							<li>No. CtAw9458</li>
						</ul>
					</td>
					<td>Some Model name here.</td>
					<td><i style="color: #468847; font-size: 18px;"
						class="icon-sign-blank"></i></td>
					<td>
						<h2>$150.00</h2>
					</td>
					<td>
						<button class="btn btn-small btn-primary" data-title="+To Cart"
							data-placement="top" data-tip="tooltip">
							<i class="icon-shopping-cart"></i>
						</button>
						<button class="btn btn-small" data-title="Remove"
							data-placement="top" data-tip="tooltip">
							<i class="icon-trash"></i>
						</button>
					</td>
				</tr>

			</tbody>
		</table>
	</div>
	<!--end span12-->

</div>
<!--end row-->