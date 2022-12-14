<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../layout/header.jsp"%>

<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title"></h3>
			<form action="searchProducts" method="post" class="form-inline"
				role="form">
				<div class="form-group">
					<input oninput="searchByName(this)" id="content" type="text"
						name="key" class="form-control" placeholder="">
				</div>
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-search" aria-hidden="true"></i>
				</button>
				<a href="${pageContext.request.contextPath}/product/initInsert"
					class="btn btn-success btn-sm">ADD NEW PRODUCT</a>
			</form>
			<div class="box-tools pull-right">
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse" data-toggle="tooltip" title="Collapse">
					<i class="fa fa-minus"></i>
				</button>
				<button type="button" class="btn btn-box-tool" data-widget="remove"
					data-toggle="tooltip" title="Remove">
					<i class="fa fa-times"></i>
				</button>
			</div>
		</div>
		<div class="box-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Product Name</th>
						<th>Image</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Category Product</th>
						<th>Status</th>
						<th>
						 
						</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data}" var="p">
						<tr>
							<td>${p.id }</td>
							<td>${p.name }</td>
							<td><img src="<c:url value="/resources/images/${p.image }" />" width="60px"></td>
							<td><fmt:formatNumber value="${p.price }"/> VND</td>					
							<td>${p.quantity }</td>
							<td>${p.categoryId.name}</td>
							<td><c:choose>
									<c:when test="${p.status==true}">
										<span class="label label-success">Show</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">Hidden</span>
									</c:otherwise>
								</c:choose></td>
							<td><a
								href="${pageContext.request.contextPath}/product/delete?id=${p.id}"
								class="btn btn-danger btn-sm"
								onclick="return confirm('B???n c?? mu???n x??a kh??ng ?')">Delete</a> <a
								href="${pageContext.request.contextPath}/product/preUpdate?id=${p.id}"
								class="btn btn-success btn-sm">Update</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- /.box-body -->
		<div class="box-footer text-center">
			<nav aria-label="Page navigation ">
				<ul class="pagination">
					<c:forEach begin="1" end="${Math.ceil(count/4)}" var="i">
						<li class="page-item"><a class="page-link" id="${i}"
							href="${pageContext.request.contextPath}/product/searchProducts?page=${i}">${i}</a></li>
					</c:forEach>
				</ul>
			</nav>
		</div>
		<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>