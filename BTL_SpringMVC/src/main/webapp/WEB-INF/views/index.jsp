<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp"%>
<section class="content">
	<!-- Default box -->
	<div class="box">
		<div class="box-header with-border">
			<h3 class="box-title">Welcome To </h3>
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
			<div class="thumbnail">
				<img data-src="#" alt="">
				<div class="caption">
					<h4>Hello</h4>
					<h2>${user}</h2>
				</div>
			</div>
		</div>
		<!-- /.box-body -->
		<!-- /.box-footer-->
	</div>
	<!-- /.box -->
</section>
<%@ include file="layout/footer.jsp"%>