<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>图书管理系统注册页面</title>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${basePath}/css/bootstrap.min.css">
<script src="js/jquery-3.2.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/js.cookie.js"></script>
<style>
#login {
	height: 50%;
	width: 28%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 5%;
	display: block;
	position: center;
}

.form-group {
	margin-bottom: 0;
}

* {
	padding: 0;
	margin: 0;
}
</style>
</head>
<body background="${basePath}/img/lizhi.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">
	<h2
		style="text-align: center; color: white; font-family: '华文行楷'; font-size: 500%">图
		书 馆</h2>
	<div class="panel panel-default" id="login">
		<form class="login-form" action="${basePath}/user/checkAname"
			method="post">
			<div class="panel-heading" style="background-color: #fff">
				<h3 class="panel-title">请填写注册信息</h3>
			</div>
			<div class="panel-body">
				<div class="form-group">
					<!-- 此处的name要与实体类的属性名同步！ -->
					<!-- placeholder属性用来提示用户填写字段 -->
					<label>用户名</label> <input class="form-control" name="aname"
						type="text" placeholder="${repeatmsg eq null? '请输入用户名':repeatmsg}"
						autofocus required>
				</div>
				<div class="form-group">
					<!-- 此处的name要与实体类的属性名同步！ -->
					<label>密码</label> <input class="form-control" name="pwd"
						type="password" placeholder="请输入密码" required>
				</div>
				<p>
					<a href="${basePath}/user/toLogin">去登录</a>
				</p>
				<p style="text-align: right; color: red; position: absolute"></p>
				<br />
				<button id="loginButton" class="btn btn-primary  btn-block">注册
				</button>
			</div>
		</form>
	</div>
</body>
</html>
