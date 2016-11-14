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

		<title>编辑已发布服务</title>
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
				编辑生活服务
			</h1>
		</div>

		<ul class="breadcrumb">
			<li>
				<a href="index.html">服务管理</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				编辑已发布服务
			</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/editRinfo">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" value="保存 ">
						<a href="/publishServiceList" class="btn">取消</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">
							<input type="hidden" name="rinfoId" value="${rinfo.rinfoId}" >
							<input type="hidden" name="serviceId" value="${rinfo.serviceId }" >
							<input type="hidden" name="leagueId" value="${rinfo.leagueId }" >
							<label>
								服务详情：
							</label>
							<textarea rows="10" cols="80" name="rinfoDesc" >${rinfo.rinfoDesc}</textarea>
							
							<label>
								服务日期：
							</label>
							<input type="text" name="rinfoDate" value="${rinfo.rinfoDate}" />
							<label>
								服务价格：
							</label>
							<input type="text" name="rinfoPrice" value="${rinfo.rinfoPrice}" />
							
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
