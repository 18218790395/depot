<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<!-- Main CSS-->
<link rel="stylesheet" type="text/css" href="${basePath}/css/main.css">
<!-- Font-icon css-->
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>登录-欢迎访问仓储管理系统</title>
<style type="text/css">
div.login-box.flipped {
	height: 390px;
}
</style>
</head>
<body>
	<section class="material-half-bg">
		<div class="cover"></div>
	</section>
	<section class="login-content">
		<div class="logo">
			<h1>仓储管理系统</h1>
		</div>
		<div class="login-box">
			<form class="login-form"
				action="${pageContext.request.contextPath}/user/toLogin"
				method="post">
				<h3 class="login-head">
					<i class="fa fa-lg fa-fw fa-user"></i>登 录
				</h3>
				<div class="form-group">
					<label class="control-label">用户名</label> <input
						class="form-control" name="username" type="text"
						placeholder="${msg eq null? '请输入用户名':msg}" autofocus required>
				</div>
				<div class="form-group">
					<label class="control-label">密码</label> <input class="form-control"
						name="password" type="password" placeholder="请输入密码" required>
				</div>
				<div class="form-group">
					<div class="utility">
						<div class="animated-checkbox"></div>
						<p class="semibold-text mb-2">
							<a href="#" data-toggle="flip">去注册</a>
						</p>
					</div>
				</div>
				<div class="form-group btn-container">
					<button class="btn btn-primary btn-block">
						<i class="fa fa-sign-in fa-lg fa-fw"></i>登 录
					</button>
				</div>
			</form>
			<form class="forget-form"
				action="${pageContext.request.contextPath}/user/register">
				<h3 class="login-head">
					<i class="fa fa-lg fa-fw fa-user-o"></i>注 册
				</h3>
				<div class="form-group">
					<label class="control-label">用户名</label> <input
						class="form-control" id="username" name="username" type="text"
						placeholder="请输入用户名" required onblur="checkUsername(this.value)">
				</div>
				<div class="form-group">
					<label class="control-label">密码</label> <input class="form-control"
						name="password" type="password" placeholder="请输入密码" required>
				</div>
				<div class="form-group">
					<div class="utility">
						<div class="animated-checkbox"></div>
						<p class="semibold-text mb-2">
							<a href="#" data-toggle="flip">去登录</a>
						</p>
					</div>
				</div>
				<div class="form-group btn-container">
					<button class="btn btn-primary btn-block">
						<i class="fa fa-user-circle-o fa-lg fa-fw"></i>注 册
					</button>
				</div>
			</form>
		</div>
	</section>
	<!-- Essential javascripts for application to work-->
	<script src="${basePath}/js/jquery-3.3.1.min.js"></script>
	<script src="${basePath}/js/jquery.validate.min.js"></script>
	<script src="${basePath}/js/popper.min.js"></script>
	<script src="${basePath}/js/bootstrap.min.js"></script>
	<script src="${basePath}/js/main.js"></script>
	<!-- The javascript plugin to display page loading on top-->
	<script src="${basePath}/js/plugins/pace.min.js"></script>
	<script type="text/javascript">
		// Login Page Flipbox control
		$('.login-content [data-toggle="flip"]').click(function() {
			$('.login-box').toggleClass('flipped');
			return false;
		});

		function checkUsername(username) {
			$.ajax({
				url : "${basePath}/user/checkUsername",
				type : "post",
				data : {
					"username" : username
				},
				dataType : "text",
				success : function(data) {
					if (data == "isExist") {
						//用户名已存在
						$("#username").val("");
						$("#username").attr("placeholder", "用户名已存在！");
					}
				}
			});
		}
	</script>
</body>
</html>