<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<!-- book是由Controller传过来的，内容是执行sql语句后得到的结果 -->
<title>《${book.bname}》</title>
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

	<div class="col-xs-6 col-md-offset-3">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">《 ${book.bname}》</h3>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<tbody>
						<tr>
							<th width="15%">图书名</th>
							<td>${book.bname}</td>
						</tr>
						<tr>
							<th>作者</th>
							<td>${book.author}</td>
						</tr>
						<tr>
							<th>出版社</th>
							<td>${book.publish}</td>
						</tr>
						<tr>
							<th>价格</th>
							<td>${book.price}</td>
						</tr>
						<tr>
							<th>数量</th>
							<td>${book.num}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
