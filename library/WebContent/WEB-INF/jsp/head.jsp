<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<nav
	style="position: fixed; z-index: 999; width: 100%; background-color: #25c6fc"
	class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header" style="margin-left: 8%; margin-right: 1%">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath}/user/index"
				style="font-family: 华文行楷; font-size: 250%; color: white">图书管理系统</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-left">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" style="color: white"> 图书管理 <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/book/bookList">全部图书</a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/book/addBook">增加图书</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" style="color: white"> 读者管理 <b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/reader/readerList">全部读者</a></li>
						<li class="divider"></li>
						<li><a
							href="${pageContext.request.contextPath}/reader/addReader">增加读者</a></li>
					</ul></li>
				<li><a
					href="${pageContext.request.contextPath}/user/updatePwd?aid=${user.aid}"
					style="color: white"> 密码修改 </a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#" style="color: white">${user.aname}, 已登录</a></li>
				<li><a href="${pageContext.request.contextPath}/user/logout"
					style="color: white">退出</a></li>
			</ul>
		</div>
	</div>
</nav>
