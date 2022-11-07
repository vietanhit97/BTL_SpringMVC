<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Log in</title>
<style type="text/css">
.err {
	color: red;
}
</style>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin_css/css/all.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin_css/css/icheck-bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin_css/css/adminlte.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/css/font-awesome.min.css">
<script nonce="58024ead-28f6-488a-9ede-b00b8a1d9774">(function(w,d){!function(a,e,t,r){a.zarazData=a.zarazData||{};a.zarazData.executed=[];a.zaraz={deferred:[],listeners:[]};a.zaraz.q=[];a.zaraz._f=function(e){return function(){var t=Array.prototype.slice.call(arguments);a.zaraz.q.push({m:e,a:t})}};for(const e of["track","set","ecommerce","debug"])a.zaraz[e]=a.zaraz._f(e);a.zaraz.init=()=>{var t=e.getElementsByTagName(r)[0],z=e.createElement(r),n=e.getElementsByTagName("title")[0];n&&(a.zarazData.t=e.getElementsByTagName("title")[0].text);a.zarazData.x=Math.random();a.zarazData.w=a.screen.width;a.zarazData.h=a.screen.height;a.zarazData.j=a.innerHeight;a.zarazData.e=a.innerWidth;a.zarazData.l=a.location.href;a.zarazData.r=e.referrer;a.zarazData.k=a.screen.colorDepth;a.zarazData.n=e.characterSet;a.zarazData.o=(new Date).getTimezoneOffset();a.zarazData.q=[];for(;a.zaraz.q.length;){const e=a.zaraz.q.shift();a.zarazData.q.push(e)}z.defer=!0;for(const e of[localStorage,sessionStorage])Object.keys(e||{}).filter((a=>a.startsWith("_zaraz_"))).forEach((t=>{try{a.zarazData["z_"+t.slice(7)]=JSON.parse(e.getItem(t))}catch{a.zarazData["z_"+t.slice(7)]=e.getItem(t)}}));z.referrerPolicy="origin";z.src="/cdn-cgi/zaraz/s.js?z="+btoa(encodeURIComponent(JSON.stringify(a.zarazData)));t.parentNode.insertBefore(z,t)};["complete","interactive"].includes(e.readyState)?zaraz.init():a.addEventListener("DOMContentLoaded",zaraz.init)}(w,d,0,"script");})(window,document);</script>
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="../../index2.html"><b>Admin</b>LTE</a>
		</div>
		<div class="card">
			<div class="card-body login-card-body">
				<p class="login-box-msg">Sign in to start your session</p>

				<form:form action="" method="post" modelAttribute="a">
					<div class="input-group mb-3">
						<form:input path="name" cssClass="form-control" title="User Name" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fa fa-user-circle-o"></span>
							</div>
						</div>
					</div>
					<form:errors path="name" cssClass="err" />
					<div class="input-group mb-3">
						<form:input type="password" path="password" cssClass="form-control"
							title="Password" />
						<div class="input-group-append">
							<div class="input-group-text">
								<span class="fa fa-unlock-alt"></span>
							</div>
						</div>
					</div>
					<form:errors path="password" cssClass="err" />
					<div class="row">
						<div class="col-4">
							<button type="submit" class="btn btn-primary btn-block">Sign
								In</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>


		<script
			src="${pageContext.request.contextPath}/admin_css/js/jquery.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/admin_css/js/bootstrap.bundle.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/admin_css/js/adminlte.min.js?v=3.2.0"></script>
</body>
</html>