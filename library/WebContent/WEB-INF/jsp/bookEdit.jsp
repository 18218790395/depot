<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- book是由Controller传过来的，内容是执行sql语句后得到的结果 -->
<title>编辑《${book.bname}》</title>
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
				<h3 class="panel-title">编辑《 ${book.bname}》</h3>
			</div>
			<div class="panel-body">
				<!--bookEdit后的bid为对应方法的形参名-->
				<form action="${basePath}/book/bookEdit?bid=${book.bid}"
					method="post" id="addbook">
					<div class="input-group">
						<span class="input-group-addon">图书名</span> <input type="text"
							class="form-control" name="bname" id="bname"
							value="${book.bname}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">作者</span> <input type="text"
							class="form-control" name="author" id="author"
							value="${book.author}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">出版社</span> <input type="text"
							class="form-control" name="publish" id="publish"
							value="${book.publish}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">价格</span> <input type="text"
							class="form-control" name="price" id="price"
							value="${book.price}">
					</div>
					<div class="input-group">
						<span class="input-group-addon">数量</span> <input type="text"
							class="form-control" name="num" id="num" value="${book.num}">
					</div>
					<input type="submit" value="确定" class="btn btn-success btn-sm"
						class="text-left">
					<script>
					<!--判断的属性是id 不是name-->
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
		</div>
	</div>
</body>
</html>
