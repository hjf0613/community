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

		<title>编辑系统功能</title>
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
				编辑系统功能
			</h1>
		</div>

		<ul class="breadcrumb">
			<li>
				<a href="index.html">系统功能管理</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				编辑系统功能
			</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/editFunction">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" value="保存 ">
						<a href="/listFunction" class="btn">取消</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">
							<label>
								父功能名称：
							</label>
							<input type="hidden" name="funId" value="${item.funId}" />
							<input type="hidden" name="funPid" value="${item.funPid}" />
							<input type="text" name="funPname" value="${item.funPname}"
								readonly="readonly">
							<label>
								功能名称：
							</label>
							<input type="text" name="funName" maxlength="10"
								value="${item.funName}">
							<label>
								功能地址：
							</label>
							<input type="text" name="funUrl" value="${item.funUrl}"
								maxlength="100">
							<label>
								功能状态：
							</label>
							<select name="funState">
								<c:choose>
									<c:when test="${item.funState==\"1\"}">
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
