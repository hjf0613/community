<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<div class="row">
				<div class="col-md-12">
					<span style="font-size:18px;"><a href="">惠家E站</a></span>
					<span class="glyphicon glyphicon-chevron-right"></span> 
					<span style="font-size:17px;"><a href="">金融</a></span>
					<span class="glyphicon glyphicon-chevron-right"></span> 
					<span style="font-size:15px;"><a href="">${service.serviceName}</a></span>
					<span class="glyphicon glyphicon-chevron-right"></span> 
					<span style="font-size:14px;"><a href="">${league.leagueCompany}</a></span>
					
					
				</div>
			</div>
			<hr style=" height:2px;border:none;border-top:2px solid #222222;">
			<div class="row">
				<div class="col-md-4">
					<div class="book-image">
						<img src="<%=basePath%>assets/foreground/image/life.jpg" width="300px" height="430px" />
					</div>
					
				</div>
				<div class="col-md-6">
					<div class="book-detail">
						<p>服务名称：${service.serviceName}</p>
						<p>价格：￥${rinfo.rinfoPrice }</p>
						<p>发布时间：${rinfo.rinfoDate}</p>
						<p>服务简介：${rinfo.rinfoDesc}</p>
						<hr>
						<p>公司名称：${league.leagueCompany}</p>
						<p>电话：${league.leaguePhone}</p>
						<p>邮箱：${league.leagueEmail}</p>
						<p>所属分类：生活>${service.serviceName}</p>
						<hr>
						<div class="book-button">
							
							<button type="button" class="btn btn-warning" style="margin-right:13px;"> <span class="glyphicon glyphicon-book"></span> 购买</button>
							<button type="button" class="btn btn-info"><span class="glyphicon glyphicon-star-empty"></span> 收藏</button>
						</div>
						
				 	</div>
				</div>
				<div class="col-md-2">
					<div class="book-store">
						<p><a href="#">惠家E站</a></p>
						<hr>
						<p>安全等级 ：
							<span class="glyphicon glyphicon-star" style="margin-left:5px;"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
							<span class="glyphicon glyphicon-star"></span>
						</p>
						<hr>
						<p>联系我们 
							<p>
							<span class="glyphicon glyphicon-earphone" style="margin-left:5px;"></span> 0350-123456
							</p>
							<p>
								<span class="glyphicon glyphicon-envelope" style="margin-left:5px;"></span> 13080304993@163.com
							</p>
						</p>
						<hr>
						<p><span>爱生活、爱money</span></p>
						<hr>
						
					</div>
				</div>
			</div>
	
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