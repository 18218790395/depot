<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>图书信息添加</title>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${basePath}/css/bootstrap.min.css">
<script src="${basePath}/js/jquery-3.2.1.js"></script>
<script src="${basePath}/js/bootstrap.min.js"></script>
<style>
.form-group {
	margin-bottom: 0;
}
</style>
<script>
	$(function() {
		$('#header').load('${basePath}/user/head');
	})
</script>
</head>
<body background="${basePath}/img/sky.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">

	<div id="header"></div>

	<div
		style="position: relative; padding-top: 60px; width: 80%; margin-left: 10%">
		<form action="${basePath}/book/bookAdd" method="post" id="addbook">
			<div class="form-group">
				<label>图书名</label> <input type="text" class="form-control"
					name="bname" id="bname" placeholder="请输入图书名">
			</div>
			<div class="form-group">
				<label>作者</label> <input type="text" class="form-control"
					name="author" id="author" placeholder="请输入作者名">
			</div>
			<div class="form-group">
				<label>出版社</label> <input type="text" class="form-control"
					name="publish" id="publish" placeholder="请输入出版社">
			</div>
			<div class="form-group">
				<label>价格</label> <input type="text" class="form-control"
					name="price" id="price" placeholder="请输入价格">
			</div>
			<div class="form-group">
				<label>数量</label> <input type="text" class="form-control" name="num"
					id="num" placeholder="请输入图书数量">
			</div>
			<input type="submit" value="添加" class="btn btn-success btn-sm"
				class="text-left">
			<script>
				$("#addbook").submit(
						function() {
							if ($("#bname").val() == ''
									|| $("#author").val() == ''
									|| $("#publish").val() == ''
									|| $("#price").val() == ''
									|| $("#num").val() == '') {
								alert("请填入完整图书信息！");
								return false;
							}
						})
			</script>
		</form>
	</div>
</body>
</html>
