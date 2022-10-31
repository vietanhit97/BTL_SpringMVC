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
			<h3 class="box-title">ADD NEW PRODUCT</h3>
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
			<form:form method="post" action="insert" modelAttribute="p"
				enctype="multipart/form-data">
				<div class="row">
					<div class="col-xs-7 col-sm-7 col-md-7 col-lg-7">
						<div class="form-group">
							<label for="">Product Name :</label>
							<form:input path="name" cssClass="form-control" /><br>
							<form:errors cssClass="erorr" path="name"/>
						</div>
						<div class="form-group">
							<label for="">Image :</label> <input type="file"
								class="form-control" name="upload" id="upload"
								placeholder="Ảnh sản phẩm "> <img src="" id="show_image"
								alt="" style="width: 300px">
						</div>
						<div class="form-group">
							<label for="">Status:</label>
							<form:errors cssClass="erorr" path="status"/>
							<div class="radio">
								<label><form:radiobutton path="status" value="true" />
									Show </label>
							</div>
							<div class="radio">
								<label><form:radiobutton path="status" value="false" />
									Hidden </label>
							</div>
						</div>
						<button type="submit" class="btn btn-primary">Add NEW</button>
					</div>
					<div class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
						<div class="form-group">
							<label for="">Category :</label>
							<form:select path="categoryId.id" cssClass="form-control">
								<form:options items="${c}" itemLabel="name" itemValue="id" />
							</form:select><br>
							<form:errors cssClass="erorr" path="categoryId"/>
						</div>
						<div class="form-group">
							<label for="">Price:</label>
							<form:input path="price" cssClass="form-control" /><br>
							<form:errors cssClass="erorr" path="price"/>
						</div>
						<div class="form-group">
							<label for="">Quantity :</label>
							<form:input path="quantity" cssClass="form-control" /><br>
							<form:errors cssClass="erorr" path="quantity"/>
						</div>

					</div>
				</div>
			</form:form>
		</div>
	</div>
	<!-- /.box -->
</section>
<%@ include file="../../layout/footer.jsp"%>