<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="shortcut icon" type="image/x-icon" href="<%=basePath%>assets/foreground/image/title.ico">
    <title>惠家E站</title>

    <link href="<%=basePath%>assets/foreground/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=basePath%>assets/foreground/js/jquery.min.js"></script>
    <script src="<%=basePath%>assets/foreground/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/foreground/css/oneService.css">
	

  
  </head>
  <body>

		<div class="head">
			<nav class="navbar  navbar-inverse" role="navigation">
			  <div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
				  <a class="navbar-brand" href="#">您好，欢迎来到惠家E站</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav">
					<li><a href="/toIndex">首页</a></li>
				  </ul>
				  <form class="navbar-form navbar-left" role="search">
					<div class="form-group">
					  <input type="text" class="form-control" style="width:300px;" placeholder="服务名称">
					</div>
					<button type="submit" class="btn btn-info">搜索</button>
				  </form>
				  <ul class="nav navbar-nav navbar-right">
					
					<c:if test="${user == null}">
						<li><a href="/userLogin">登录</a></li>
					</c:if>
					<c:if test="${user != null }">
						<li>${user.userName}</li>
					</c:if>
					<li><a href="/userRegist">注册</a></li>
					<li><a href="#"> <span class="glyphicon glyphicon-tower"></span>  加盟商</a></li>
					<li><a href="#">我的订单</a></li>
					
				  </ul>
				</div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
		</div>
		<div class="body">
			<h4>请进行个人信息实名认证：</h4>
			<form:form action="/authentication" method="post" modelAttribute="user">
				<form:input path="userId" value="${user.userId}" type="hidden"/>
				<form:input path="roleId" value="3" type="hidden"/>
				<form:input path="userState" type="hidden" value="${user.userState}"/>
				<form:input path="userPassword" type="hidden" value="${user.userPassword}"/>
				<form:input path="userAccount" value="0" type="hidden"/>
				<label>
				用户名：
				</label><br>
				<form:input path="userName" value="${user.userName}"/><br>
				<label>
				注册手机号：
				</label><br>
				<form:input path="userPhone" value="${user.userPhone}"/><br>
				<label>
				邮箱：
				</label><br>
				<form:input path="userEmail" value="${user.userEmail}"/><br>
				<label>
				真实姓名：
				</label><br>
				<form:input path="userRealname"/>
				<form:errors path="userRealname" /><br>
				<label>
				身份证号：
				</label><br>
				<form:input path="userCard"/>
				<form:errors path="userCard" /><br>
				<label>
				出生日期：
				</label><br>
				<form:input path="userBirth" type="date"/>
				<form:errors path="userBirth" /><br>
				<label>
				家庭住址：
				</label><br>
				<form:input path="userAddress"/><br>
				<input type="submit" value="提交" />
			</form:form>
					
		
		</div>
		<div class="foot">
			<div class="row">	
				<div class="foot-intruction" >
					<table  class="table no-border">
						<tr>
						<th style="border: 0px;"><a href="#">购物指南</a></th>
						<th style="border: 0px;"><a href="#">支付方式</a></th>
						<th style="border: 0px;"><a href="#">配送方式</a></th>
						<th style="border: 0px;"><a href="#">退换货</a></th>
						<th style="border: 0px;"><a href="#">商家服务</a></th>
						</tr>
						<tr>
						<td style="border: 0px;"><a href="#">购物流程</a></td>
						<td style="border: 0px;"><a href="#">货到付款</a></td>
						<td style="border: 0px;"><a href="#">订单配送查询</a></td>
						<td style="border: 0px;"><a href="#">配送范围</a></td>
						<td style="border: 0px;"><a href="#">退换货政策</a></td>
						<td style="border: 0px;"><a href="#">商家中心</a></td>
						</tr>
						<tr>
						<td style="border: 0px;"><a href="#">发票制度</a></td>
						<td style="border: 0px;"><a href="#">网上支付</a></td>
						<td style="border: 0px;"><a href="#">订单状态说明</a></td>
						<td style="border: 0px;"><a href="#">当日/次日达</a></td>
						<td style="border: 0px;"><a href="#">自主申请退换货</a></td>
						<td style="border: 0px;"><a href="#">运营服务</a></td>
						</tr>
						<tr>
						<td style="border: 0px;"><a href="#">账户管理</a></td>
						<td style="border: 0px;"><a href="#">礼品卡支付</a></td>
						<td style="border: 0px;"><a href="#">自动取消订单</a></td>
						<td style="border: 0px;"><a href="#">订单自提</a></td>
						<td style="border: 0px;"><a href="#">退换货进度查询</a></td>
						<td style="border: 0px;"><a href="#">加入唯品会</a></td>
						</tr>
						<tr>
						<td style="border: 0px;"><a href="#">会员优惠</a></td>
						<td style="border: 0px;"><a href="#">银行转账</a></td>
						<td style="border: 0px;"><a href="#">自主修改订单</a></td>
						<td style="border: 0px;"><a href="#">验货与签收</a></td>
						<td style="border: 0px;"><a href="#">退款方式和时间</a></td>
						<td style="border: 0px;"><a href="#">客服电话</a></td>
						</tr>
					</table>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="foot-bottom">
						<a href="#">公司简介</a>
						<span>|</span>
						<a href="#">Investor Relations</a>
						<span>|</span>
						<a href="#">诚聘英才</a>
						<span>|</span>
						<a href="#">网站联盟</a>
						<span>|</span>
						<a href="#">惠家招商</a>
						<span>|</span>
						<a href="#">机构销售</a>
						<span>|</span>
						<a href="#">手机惠家</a>
						<span>|</span>
						<a href="#">官方log</a>
						<span>|</span>
						<a href="#">热词搜索</a>
						
					</div>
				</div>
			</div>
			
		</div>
		</div>
   
  </body>
</html>