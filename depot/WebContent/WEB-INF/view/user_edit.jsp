<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<div class="app-title">
	<div>
		<h1>
			<i class="fa fa-edit"></i>修改用户
		</h1>
	</div>
	<ul class="app-breadcrumb breadcrumb">
		<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
		<li class="breadcrumb-item">用户管理</li>
		<li class="breadcrumb-item"><a href="#">修改用户</a></li>
	</ul>
</div>

<div class="row">
	<div class="col-md-6">
		<div class="tile">
			<h3 class="tile-title">修改用户</h3>
			<div class="tile-body">
				<form class="form-horizontal" id="updateForm">
					<!-- 用户id -->
					<input type="hidden" id="userid" name="userid"
						value="${user.userid}" />
					<div class="form-group row">
						<label class="control-label col-md-3">用户名</label>
						<div class="col-md-8">
							<input class="form-control" type="text" id="username"
								placeholder="请输入用户名" name="username" value="${user.username}"
								onblur="checkUsername(this.value)">
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3">密码</label>
						<div class="col-md-8">
							<input class="form-control" type="password" placeholder="请输入密码"
								name="password" value="${user.password}" required>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3" for="roleselect">角色</label>
						<div class="col-md-8">
							<select class="form-control" id="roleselect" name="role.roleid">
								<c:forEach items="${roles}" var="role">
									<option value="${role.roleid}"
										<c:if test="${role.roleid eq user.role.roleid}">selected</c:if>>${role.rolename}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-md-3" for="deptselect">部门</label>
						<div class="col-md-8">
							<select class="form-control" id="deptlect" name="dept.deptid">
								<c:forEach items="${depts}" var="dept">
									<option value="${dept.deptid}"
										<c:if test="${dept.deptid eq user.dept.deptid}">selected</c:if>>${dept.deptname}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</form>
			</div>
			<div class="tile-footer">
				<div class="row">
					<div class="col-md-8 col-md-offset-3">
						<a
							onclick="action('${basePath}/user/updateUser','post','updateForm')">
							<button class="btn btn-primary" type="button">
								<i class="fa fa-fw fa-lg fa-check-circle"></i>修改
							</button>&nbsp;&nbsp;&nbsp;
						</a> <a class="btn btn-secondary" href="${basePath}/user/index"><i
							class="fa fa-fw fa-lg fa-times-circle"></i>返回</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function checkUsername(username) {
		//获取userid
		var userid = $("#userid").val();
		$.ajax({
			url : "${basePath}/user/checkUsername",
			type : "post",
			data : {
				"userid" : userid,
				"username" : username
			},
			dataType : "text",
			success : function(data) {
				if (data == "isExist") {
					//用户名已存在
					$("#username").val("");
					$("#username").attr("placeholder", "用户名已存在！");
				}
			}
		});
	}
</script>