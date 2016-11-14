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

		<title>加盟商认证</title>
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
				加盟商认证
			</h1>
		</div>

		<ul class="breadcrumb">
			<li>
				<a href="index.html">加盟商管理</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				加盟商认证
			</li>
		</ul>

		<div class="container-fluid">
			<div class="row-fluid">
				<form method="post" action="/audit">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" value="保存 ">
						<a href="/leagueList" class="btn">取消</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">
							<input type="hidden" name="leagueId" value="${league.leagueId}" >
							<input type="hidden" name="roleId" value="${league.roleId}" >
							<input type="hidden" name="leaguePassword" value="${league.leaguePassword}" >
							<label>
								账号：
							</label>
							<input type="text" name="leagueName" value="${league.leagueName}" readonly="readonly">
							<label>
								公司名：
							</label>
							<input type="text" name="leagueCompany" value="${league.leagueCompany}" readonly="readonly">
							<label>
								手机：
							</label>
							<input type="text" name="leaguePhone" value="${league.leaguePhone}" readonly="readonly">
							<label>
								邮箱：
							</label>
							<input type="text" name="leagueEmail" value="${league.leagueEmail}" readonly="readonly">
							<label>
								加盟商状态：
							</label>
							<select name="leagueState">
								<c:choose>
									<c:when test="${league.leagueState==\"1\"}">
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
