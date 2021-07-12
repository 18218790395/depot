<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>全部读者</title>
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
<body background="${basePath}/img/u1.jpg"
	style="background-repeat: no-repeat; background-size: 100% 100%; background-attachment: fixed;">

	<div id="header"></div>

	<div class="panel panel-default"
		style="position: relative; top: 80px; width: 90%; margin-left: 5%">
		<div class="panel-heading">
			<h3 class="panel-title">全部读者</h3>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>读者id</th>
						<th>姓名</th>
						<th>性别</th>
						<th>地址</th>
						<th>电话</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${readers}" var="reader">
						<tr>
							<td><c:out value="${reader.rid}"></c:out></td>
							<td><c:out value="${reader.rname}"></c:out></td>
							<td><c:out value="${reader.gender}"></c:out></td>
							<td><c:out value="${reader.address}"></c:out></td>
							<td><c:out value="${reader.phone}"></c:out></td>
							<td><a
								href="${basePath}/reader/updateReader?rid=<c:out value="${reader.rid}"></c:out>"><button
										type="button" class="btn btn-info btn-xs">编辑</button></a></td>
							<td><a
								href="${basePath}/reader/deleteReader?rid=<c:out value="${reader.rid}"></c:out>"><button
										type="button" class="btn btn-danger btn-xs">删除</button></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
