<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../../layout/header.jsp"%>
<style>
.erorr {
	color: red;
}
</style>
<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">Create Orders</h3>
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
			<form:form method="post" action="insert" modelAttribute="o">
				<form:input path="role" type="hidden" value="1" />
				<div class="form-group">
					<label for="">Product Name :</label>
					<form:select path="productId.id" cssClass="form-control">
						<form:options items="${p}" itemLabel="name" itemValue="id" />
					</form:select>
					<br>
					<form:errors cssClass="erorr" path="productId" />
					<input type="hidden" name ="date">
				</div>
				<div class="form-group">
					<label for="">Quantity :</label>
					<form:input path="quantity" cssClass="form-control" />
					<br>
					<form:errors cssClass="erorr" path="quantity" />
				</div>
				<button type="submit" class="btn btn-primary">Add NEW</button>
			</form:form>
		</div>
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>