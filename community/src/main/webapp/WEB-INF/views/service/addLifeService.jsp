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

		<title>添加生活服务</title>
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
				添加生活服务
			</h1>
		</div>

		<ul class="breadcrumb">
			<li>
				<a href="index.html">服务管理</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				添加生活服务
			</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/addLifeService">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" value="保存 ">
						<a href="/lifeServiceList" class="btn">取消</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">
							<input type="hidden" name="servicePid" value="1" >
							<label>
								服务名称：
							</label>
							<input type="text" name="serviceName" >
							
							<label>
								服务状态：
							</label>
							<select name="serviceState">
								<option value="1">
									正常
								</option>
								<option value="0">
									锁定
								</option>
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
