<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../../layout/header.jsp"%>
<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title"></h3>
			<form action="searchCategores" method="get" class="form-inline"
				role="form">
				<div class="form-group">
					<input oninput="searchByName(this)" id="content" type="text"
						name="key" class="form-control" placeholder="">
				</div>
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-search" aria-hidden="true"></i>
				</button>
				<a href="${pageContext.request.contextPath}/ordersImport/initInsert"
					class="btn btn-success btn-sm">Create Orders Import</a>
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
						<th>Id</th>
						<th>Product Name</th>
						<th>Quantity</th>
						<th>Total Amount</th>
						<th>Create Date</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data}" var="o">
						<tr>
							<td>${o.id }</td>
							<td>${o.productId.name }</td>
							<td>${o.quantity }</td>
							<td><fmt:formatNumber value="${o.totalAmount }" /></td>
							<td><fmt:formatDate value="${o.date}" pattern="dd/MM/yyyy" /></td>
							<td><a
								href="${pageContext.request.contextPath}/ordersImport/delete?id=${o.id}"
								class="btn btn-danger btn-sm"
								onclick="return confirm('Bạn có muốn xóa không ?')">Delete</a> <a
								data-toggle="modal"
								href="${pageContext.request.contextPath}/ordersImport/detail?id=${o.id}"
								class="btn btn-success btn-sm" data-toggle="modal"
								data-target="#staticBackdrop">Detail</a></td>
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
							href="${pageContext.request.contextPath}/ordersImport/data?page=${i}">${i}</a></li>
					</c:forEach>
				</ul>
			</nav>
		</div>
		<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<div class="modal fade" id="staticBackdrop" data-backdrop="static"
	data-keyboard="false" tabindex="-1"
	aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body ">
				<div class="text-right">
					<i class="fa fa-close close" data-dismiss="modal"></i>
				</div>

				<div class="px-4 py-5">

					<h5 class="text-uppercase">WAREHOUSE VIET NAM</h5>



					<h4 class="mt-5 theme-color mb-5">Thanks for your order</h4>

					<span class="theme-color">Payment Summary</span>
					<div class="mb-3">
						<hr class="new1">
					</div>

					<div class="d-flex justify-content-between">
						<span class="font-weight-bold">Date :</span> <span
							class="text-muted">${o.date}</span>
					</div>

					<div class="d-flex justify-content-between">
						<small>Shipping</small> <small>$175.00</small>
					</div>


					<div class="d-flex justify-content-between">
						<small>Tax</small> <small>$200.00</small>
					</div>

					<div class="d-flex justify-content-between mt-3">
						<span class="font-weight-bold">Total Amount</span> <span
							class="font-weight-bold theme-color">$2125.00</span>
					</div>



					<div class="text-center mt-5">


						<button class="btn btn-primary">Track your order</button>



					</div>

				</div>


			</div>
		</div>
	</div>
</div>
<%@ include file="../../layout/footer.jsp"%>