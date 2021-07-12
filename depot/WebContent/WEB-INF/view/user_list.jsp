<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<div class="app-title">
	<div>
		<h1>
			<i class="fa fa-users"></i> 用户列表
		</h1>
	</div>
	<ul class="app-breadcrumb breadcrumb">
		<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
		<li class="breadcrumb-item"><a href="#">用户列表</a></li>
	</ul>
</div>

<div class="row">
	<div class="col-md-12">
		<div class="tile">
			<div class="tile-body">

				<form class="row" id="searchForm">
					<div class="form-group col-md-2">
						<label class="control-label">用户名</label> <input
							class="form-control" name="username" type="text"
							placeholder="请输入你的用户名" value="${searchdata.username}">
					</div>
					<div class="form-group col-md-4 align-self-end">
						<a
							onclick="action('${basePath}/user/listUsers','post','searchForm')">
							<button class="btn btn-primary" type="button">
								<i class="fa fa-fw fa-lg fa-search"></i>查询
							</button>
						</a>
						<c:if
							test="${loginuser.role.rolename eq '高级经理'  and loginuser.dept.deptname eq '信息部'}">
							<a
								onclick="action('${basePath}/user/toAddUser','post','searchForm')">
								<button class="btn btn-primary" type="button">添加</button>
							</a>
						</c:if>
					</div>
				</form>

				<table class="table table-bordered table-sm">
					<thead>
						<tr>
							<th>用户ID</th>
							<th>用户名</th>
							<th>角色名</th>
							<th>部门名</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pageInfo.list}" var="user">
							<tr>
								<td>${user.userid}</td>
								<td>${user.username}</td>
								<td>${user.role.rolename}</td>
								<td>${user.dept.deptname}</td>
								<td><c:if
										test="${(loginuser.role.rolename eq '高级经理'  and loginuser.dept.deptname eq '信息部') or (user.username eq loginuser.username)}">
										<a href="javascript:;"
											onclick="action('${basePath}/user/getUserById?userid=${user.userid}','get','')">
											<button class="btn btn-success btn-sm" type="button">修改</button>
										</a>
										<a href="javascript:;"
											onclick="action('${basePath}/user/deleteUserById?userid=${user.userid}','get','')">
											<button class="btn btn-danger btn-sm" type="button">删除</button>
										</a>
									</c:if></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<%@ include file="page.jsp"%>
			</div>
		</div>
	</div>
</div>

