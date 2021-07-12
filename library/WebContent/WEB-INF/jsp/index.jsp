<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>图书管理系统主页</title>
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

	<div id="header"></div>
</body>
</html>
