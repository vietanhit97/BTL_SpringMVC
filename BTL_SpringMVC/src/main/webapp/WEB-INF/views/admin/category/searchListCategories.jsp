<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../layout/header.jsp"%>
<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title"></h3>
			<form action="searchCategores" method="post" class="form-inline"
				role="form">
				<div class="form-group">
					<input oninput="searchByName(this)" id="content" type="text"
						name="key" class="form-control" placeholder="">
				</div>
				<button type="submit" class="btn btn-primary">
					<i class="fa fa-search" aria-hidden="true"></i>
				</button>
				<a href="${pageContext.request.contextPath}/category/initInsert"
					class="btn btn-success btn-sm">ADD NEW CATEGORY</a>
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
						<th>Category Name</th>
						<th>Status</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data}" var="c">
						<tr>
							<td>${c.id }</td>
							<td>${c.name }</td>
							<td><c:choose>
									<c:when test="${c.status==true}">
										<span class="label label-success">Show</span>
									</c:when>
									<c:otherwise>
										<span class="label label-danger">Hidden</span>
									</c:otherwise>
								</c:choose></td>
							<td><a
								href="${pageContext.request.contextPath}/category/delete?id=${c.id}"
								class="btn btn-danger btn-sm"
								onclick="return confirm('Bạn có muốn xóa không ?')">Delete</a> <a
								href="${pageContext.request.contextPath}/category/preUpdate?id=${c.id}"
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
							href="${pageContext.request.contextPath}/category/searchCategores?key=${key}?page=${i}">${i}</a></li>
					</c:forEach>
				</ul>
			</nav>
		</div>
		<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>