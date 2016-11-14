<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

		<title>用户详细信息</title>
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
				用户详细信息
			</h1>
		</div>

		<ul class="breadcrumb">
			<li>
				<a href="index.html">客户管理</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				查看用户信息
			</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/editUser">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" value="保存 ">
						<a href="/userList1" class="btn">返回</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">
							
							<input type="hidden" name="userId" value="${user.userId}" />
							<input type="hidden" name="roleId" value="${user.roleId}" />
							
							<label>
								用户名：
							</label>
							<input type="text" name="userName" maxlength="10"
								value="${user.userName}" readonly="readonly">
							<label>
								密码：
							</label>
							<input type="text" name="userPassword" maxlength="10"
								value="${user.userPassword}" readonly="readonly">
							<label>
								手机号：
							</label>
							<input type="text" name="userPhone" maxlength="10"
								value="${user.userPhone}" readonly="readonly">
							<label>
								邮箱：
							</label>
							<input type="text" name="userEmail" maxlength="10"
								value="${user.userEmail}" readonly="readonly">
							<label>
								姓名：
							</label>
							<input type="text" name="userRealname" maxlength="10"
								value="${user.userRealname}" readonly="readonly">
							<label>
								身份证：
							</label>
							<input type="text" name="userCard" maxlength="10"
								value="${user.userCard}" readonly="readonly">
							<label>
								生日：
							</label>
							<input type="text" name="userBirth" maxlength="10"
								value="<fmt:formatDate value="${user.userBirth}" pattern="yyyy-MM-dd"/>" readonly="readonly">
							<label>
								地址：
							</label>
							<input type="text" name="userAddress" maxlength="10"
								value="${user.userAddress}" readonly="readonly">
							<label>
								余额：
							</label>
							<input type="text" name="userAccount" maxlength="10"
								value="${user.userAccount}" readonly="readonly">
							
							<label>
								功能状态：
							</label>
							<select name="userState">
								<c:choose>
									<c:when test="${user.userState==\"1\"}">
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
