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

		<title>编辑金融服务</title>
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
				编辑金融服务
			</h1>
		</div>

		<ul class="breadcrumb">
			<li>
				<a href="index.html">服务管理</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				编辑金融服务
			</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/editFinanceService">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" value="保存 ">
						<a href="/financeServiceList" class="btn">取消</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">
							<input type="hidden" name="serviceId" value="${services.serviceId}" >
							<input type="hidden" name="servicePid" value="2" >
							<label>
								服务名称：
							</label>
							<input type="text" name="serviceName" value="${services.serviceName}">
							
							<label>
								服务状态：
							</label>
							<select name="serviceState">
								<c:choose>
									<c:when test="${services.serviceState==\"1\"}">
									<option value="1" selected="selected">正常</option>
									<option value="0">锁定</option>		
									</c:when>
									<c:otherwise>
									<option value="1">正常</option>
									<option value="0" selected="selected">锁定</option>	
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
