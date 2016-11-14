<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>用户认证</title>
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>assets/jslib/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>assets/css/theme.css">
		<link rel="stylesheet"
			href="<%=basePath%>assets/jslib/font-awesome/css/font-awesome.css">
		<script src="<%=basePath%>assets/jslib/jquery-1.7.2.min.js"
			type="text/javascript"></script>
	</head>

	<body class="content1">
		<div class="header">
			<h1 class="page-title">
				用户认证
			</h1>
		</div>

		<ul class="breadcrumb">
			<li>
				<a href="index.html">用户管理</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				用户认证
			</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/auth">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" value="保存 ">
						<a href="/userList" class="btn">取消</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">
							<input type="hidden" name="userId" value="${user.userId}" >
							<label>
								用户名：
							</label>
							<input type="text" name="userName" value="${user.userName}" readonly="readonly">
							<label>
								用户手机：
							</label>
							<input type="text" name="userPhone" value="${user.userPhone}" readonly="readonly">
							<label>
								姓名：
							</label>
							<input type="text" name="userRealname" value="${user.userRealname}" readonly="readonly">
							<label>
								身份证：
							</label>
							<input type="text" name="userCard" value="${user.userCard}" readonly="readonly">
							<label>
								用户状态：
							</label>
							<select name="userState">
								<c:choose>
									<c:when test="${user.userState==\"1\"}">
									<option value="1" selected="selected">通过</option>
									<option value="0">否定</option>		
									</c:when>
									<c:otherwise>
									<option value="1">通过</option>
									<option value="0" selected="selected">否定</option>	
									</c:otherwise>
								</c:choose>
								
							</select>
							<div style="color: red">
								${msg}
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
