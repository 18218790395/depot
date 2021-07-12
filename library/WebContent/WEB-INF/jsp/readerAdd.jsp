<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>添加读者</title>
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
<body background="${basePath}/img/school.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">

	<div id="header"></div>

	<div class="col-xs-6 col-md-offset-3"
		style="padding-top: 100px; position: relative">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">添加读者</h3>
			</div>
			<div class="panel-body">
				<form action="${basePath}/reader/readerAdd" method="post"
					id="readeredit">
					<div class="input-group" style="padding-top: 20px;">
						<span class="input-group-addon">姓名</span> <input type="text"
							class="form-control" name="rname" id="rname">
					</div>
					<div class="input-group" style="padding-top: 20px;">
						<span class="input-group-addon">性别</span> <input type="text"
							class="form-control" name="gender" id="gender">
					</div>
					<div class="input-group" style="padding-top: 20px;">
						<span class="input-group-addon">地址</span> <input type="text"
							class="form-control" name="address" id="address">
					</div>
					<div class="input-group" style="padding-top: 20px;">
						<span class="input-group-addon">电话</span> <input type="text"
							class="form-control" name="phone" id="phone">
					</div>
					<input style="align-items: center" type="submit" value="添加"
						class="btn btn-success btn-sm" class="text-left">
					<script>
						function mySubmit(flag) {
							return flag;
						}
						$("#readeredit").submit(
								function() {
									if ($("#password").val() == ''
											|| $("#rname").val() == ''
											|| $("#gender").val() == ''
											|| $("#address").val() == ''
											|| $("#phone").val() == '') {
										alert("请填入完整读者信息！");
										return mySubmit(false);
									}
								})
					</script>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
