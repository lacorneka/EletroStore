<%@ include file="/WEB-INF/includes/taglibs.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:set var="wishlists" scope="session" value="${sessionScope.wishlists}" />

<div class="row">

	<div class="span12">
		<table class="table">
			<thead>
				<tr>
					<th><span>Image</span></th>
					<th class="desc"><span>Descraption</span></th>
					<th><span>Day add</span></th>
					<th><span>Unit Price</span></th>
					<th><span>Action</span></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${wishlists.size() > 0}">
					<c:forEach var="i" begin="0" end="${wishlists.size()-1}">
						<c:set var="pr" value="${wishlists[i].product}" />
						<tr>
							<td><a href="#"><img
									src="<c:url value='/resources/img/product/${pr.image1}'/>"
									alt=""></a></td>
							<td class="desc">
								<h4>
									<a href="#" class="invarseColor"> ${pr.productname} </a>
								</h4>
								<ul class="rating clearfix">
									<li><i class="star-on"></i></li>
									<li><i class="star-on"></i></li>
									<li><i class="star-on"></i></li>
									<li><i class="star-off"></i></li>
									<li><i class="star-off"></i></li>
								</ul>
							</td>
							<td>
								<h2>${wishlists[i].dateadd}</h2>
							</td>
							<td>
								<h2>${pr.price}</h2>
							</td>
							<td><a class="btn btn-small btn-primary"
								href="cart.do?productid=${pr.productid}" data-title="+To Cart"
								data-placement="top" data-tip="tooltip"> <i
									class="icon-shopping-cart"></i>
							</a> <a class="btn btn-small" data-title="Remove"
								href="deleteProductWishlist.do?productid=${pr.productid}"
								data-placement="top" data-tip="tooltip"> <i
									class="icon-trash"></i>
							</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
	<!--end span12-->

</div>
<!--end row-->