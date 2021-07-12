<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>更改密码</title>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${basePath}/css/bootstrap.min.css">
<script src="${basePath}/js/jquery-3.2.1.js"></script>
<script src="${basePath}/js/bootstrap.min.js"></script>
<script>
	$(function() {
		$('#header').load('${basePath}/user/head');
	})
</script>
</head>
<body background="${basePath}/img/book2.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">

	<div id="header" style="padding-bottom: 100px"></div>

	<div class="col-xs-6 col-md-offset-3" style="position: relative;">
		<div class="panel panel-primary ">
			<div class="panel-heading">
				<h3 class="panel-title">密码修改</h3>
			</div>
			<div class="panel-body">
				<!--pwdEdit后的aid为对应方法的形参名-->
				<form method="post"
					action="${basePath}/user/pwdEdit?aid=${user.aid}"
					class="form-inline" id="repasswd">
					<div class="input-group">
						<input type="password" id="oldPasswd" class="form-control"
							value="${user.pwd}"> <input type="password"
							id="newPasswd" name="pwd" placeholder="输入新密码"
							class="form-control"> <input type="password"
							id="reNewPasswd" placeholder="再次输入新密码" class="form-control">
						<em id="tishi" style="color: red"></em> <br /> <span> <input
							type="submit" value="提交" class="btn btn-default">
						</span>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		$(document)
				.keyup(
						function() {
							if ($("#newPasswd").val() != $("#reNewPasswd")
									.val()
									&& $("#newPasswd").val() != ""
									&& $("#reNewPasswd").val() != ""
									&& $("#newPasswd").val().length == $(
											"#reNewPasswd").val().length) {
								$("#tishi").text("两次输入的新密码不同，请检查");
							} else {
								$("#tishi").text("");
							}
						})

		$("#repasswd")
				.submit(
						function() {
							if ($("#oldPasswd").val() == ''
									|| $("#newPasswd").val() == ''
									|| $("#reNewPasswd").val() == '') {
								$("#tishi").text("请填写完毕后提交");
								return false;
							} else if ($("#newPasswd").val() != $(
									"#reNewPasswd").val()) {
								$("#tishi").text("两次输入的新密码不同，请检查");
								return false;
							}
						})
	</script>
</body>
</html>
