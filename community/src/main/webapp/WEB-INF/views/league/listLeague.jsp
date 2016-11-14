<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

		<title>加盟商管理</title>
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
				加盟商管理
			</h1>
		</div>
		<ul class="breadcrumb">
			<li>
				<a href="admin_index.jsp">Home</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				加盟商列表
			</li>
		</ul>
		<div class="container-fluid">
			<div class="row-fluid">
				<form class="form-inline" method="post"
					action="/selectLeague">
					<input class="input-xlarge" placeholder="公司名..." name="leagueCompany"
						type="text" >
					<input class="btn icon-search" type="submit" value="查询" />
					<span style="color:red;margin-left: 10px;">${errors }</span>
				</form>

				<div class="well">
					<table class="table">
						<thead>
							<tr>
								<th>
									账号
								</th>
								<th>
									公司名
								</th>
								<th>
									手机号
								</th>
								<th>
									邮箱
								</th>
								<th>
									状态
								</th>
								<th style="width: 90px;">
									编辑
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${leagueList}" var="item">
								<tr>
									<td>
										${item.leagueName}
									</td>
									<td>
										${item.leagueCompany}
									</td>
									<td>
										${item.leaguePhone}
									</td>
									<td>
										${item.leagueEmail}
									</td>
									
									
									<td>
										<c:choose>
											<c:when test="${item.leagueState==\"1\"}">
												通过		
											</c:when>
											<c:otherwise>未通过</c:otherwise>
										</c:choose>
									</td>
									<td>
										<a href="/audit/${item.leagueName}">审核</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pagination pagination-right">  
				        <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第  
				            ${page.pageNow} 页</font> <a href="leagueList?pageNow=1">首页</a>  
				        <c:choose>  
				            <c:when test="${page.pageNow - 1 > 0}">  
				                <a href="leagueList?pageNow=${page.pageNow - 1}">上一页</a>  
				            </c:when>  
				            <c:when test="${page.pageNow - 1 <= 0}">  
				                <a href="leagueList?pageNow=1">上一页</a>  
				            </c:when>  
				        </c:choose>  
				        <c:choose>  
				            <c:when test="${page.totalPageCount==0}">  
				                <a href="leagueList?pageNow=${page.pageNow}">下一页</a>  
				            </c:when>  
				            <c:when test="${page.pageNow + 1 < page.totalPageCount}">  
				                <a href="leagueList?pageNow=${page.pageNow + 1}">下一页</a>  
				            </c:when>  
				            <c:when test="${page.pageNow + 1 >= page.totalPageCount}">  
				                <a href="leagueList?pageNow=${page.totalPageCount}">下一页</a>  
				            </c:when>  
				        </c:choose>  
				        <c:choose>  
				            <c:when test="${page.totalPageCount==0}">  
				                <a href="leagueList?pageNow=${page.pageNow}">尾页</a>  
				            </c:when>  
				            <c:otherwise>  
				                <a href="leagueList?pageNow=${page.totalPageCount}">尾页</a>  
				            </c:otherwise>  
				        </c:choose>  
				    </div>  
				</div>
			</div>
		</div>
	</body>
</html>
