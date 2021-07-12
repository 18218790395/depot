<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>编辑读者信息《${reader.rid}》</title>
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

	<div id="header" style="padding-bottom: 80px"></div>

	<div class="col-xs-6 col-md-offset-3" style="position: relative;">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">编辑读者信息《 ${reader.rid}》</h3>
			</div>
			<div class="panel-body">
			<!--readerEdit后的rid为对应方法的形参名-->
				<form action="${basePath}/reader/readerEdit?rid=${reader.rid}"
					method="post" id="readeredit">
					<div class="input-group">
						<span class="input-group-addon">姓名</span> <input type="text"
							class="form-control" name="rname" id="rname"
							value="${reader.rname}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">性别</span> <input type="text"
							class="form-control" name="gender" id="gender"
							value="${reader.gender}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">地址</span> <input type="text"
							class="form-control" name="address" id="address"
							value="${reader.address}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">电话</span> <input type="text"
							class="form-control" name="phone" id="phone"
							value="${reader.phone}">
					</div>
					<input type="submit" value="确定" class="btn btn-success btn-sm"
						class="text-left">
					<script>
						$("#readeredit").submit(
								function() {
									if ($("#name").val() == ''
											|| $("#sex").val() == ''
											|| $("#address").val() == ''
											|| $("#phone").val() == '') {
										alert("请填入完整读者信息！");
										return false;
									}
								})
					</script>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
