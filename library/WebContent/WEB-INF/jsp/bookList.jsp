<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>全部图书信息</title>
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
<body background="${basePath}/img/book1.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">

	<div id="header"></div>

	<div style="padding: 70px 550px 10px">
		<form method="post" action="${basePath}/book/searchBook"
			class="form-inline" id="searchform">
			<div class="input-group">
				<input type="text" placeholder="输入图书名" class="form-control"
					id="search" name="bname" class="form-control"> <span
					class="input-group-btn"> <input type="submit" value="搜索"
					class="btn btn-default">
				</span>
			</div>
		</form>
		<script>
			$("#searchform").submit(function() {
				var val = $("#search").val();
				if (val == '') {
					alert("请输入关键字");
					return false;
				}
			})
		</script>
	</div>
	<div class="panel panel-default" style="width: 90%; margin-left: 5%">
		<div class="panel-heading" style="background-color: #fff">
			<h3 class="panel-title">全部图书</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>图书名</th>
						<th>作者</th>
						<th>出版社</th>
						<th>价格</th>
						<th>剩余数量</th>
						<th>详情</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<!-- books是由Controller传过来的，内容是执行sql语句后得到的结果 -->
					<c:forEach items="${books}" var="book">
						<tr>
							<td><c:out value="${book.bname}"></c:out></td>
							<td><c:out value="${book.author}"></c:out></td>
							<td><c:out value="${book.publish}"></c:out></td>
							<td><c:out value="${book.price}"></c:out></td>
							<td><c:out value="${book.num}"></c:out></td>
							<!--detailBook后的bid为对应方法的形参名-->
							<td><a
								href="${basePath}/book/detailBook?bid=<c:out value="${book.bid}"></c:out>">
									<button type="button" class="btn btn-success btn-xs">详情</button>
							</a></td>
							<!--updateBook后的bid为对应方法的形参名-->
							<td><a
								href="${basePath}/book/updateBook?bid=<c:out value="${book.bid}"></c:out>"><button
										type="button" class="btn btn-info btn-xs">编辑</button></a></td>
							<td><a
								href="${basePath}/book/deleteBook?bid=<c:out value="${book.bid}"></c:out>"><button
										type="button" class="btn btn-danger btn-xs">删除</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
