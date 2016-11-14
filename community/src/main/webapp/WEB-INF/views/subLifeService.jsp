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
	<link rel="shortcut icon" type="image/x-icon" href="foreground/image/title.ico">
    <title>惠家E站</title>
    
		

    <link href="<%=basePath%>assets/foreground/css/bootstrap.min.css" rel="stylesheet">
	<script src="<%=basePath%>assets/foreground/js/jquery.min.js"></script>
    <script src="<%=basePath%>assets/foreground/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>assets/foreground/css/subService.css">
	

  
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
						<li><a href="#">${user.userName}</a></li>
					</c:if>
					<li><a href="/userRegist">注册</a></li>
					<li><a href="/leagueLogin"> <span class="glyphicon glyphicon-tower"></span>  加盟商</a></li>
					<li><a href="#">我的订单</a></li>
					
				  </ul>
				</div><!-- /.navbar-collapse -->
			  </div><!-- /.container-fluid -->
			</nav>
		</div>
		<div class="body">
			<div class="row">
				<div class="col-md-2 booktype">
					<div class="h3">
						<h3>生活</h3>
					</div>
					
					<ul class="list-group booktypelist">
					<c:forEach items="${listLifeService}" var="item">
						
					  <li class="list-group-item"><a href="/listOneLifeService/${item.serviceId}">${item.serviceName}</a></li>
					</c:forEach>
					  
					</ul>
				</div>
				<div class="col-md-10 book">
					<h3>${service.serviceName }</h3>
					<hr style=" height:2px;border:none;border-top:2px solid #222222;">
					<c:forEach items="${rinfoList}" var="rinfo">
							<div class="one-book">
								<div class="row">
									<div class="col-md-3 book-image">
										<img src="<%=basePath%>assets/foreground/image/life.jpg" alt="..." width="90px" height="110px"/>
									</div>
									<div class="col-md-9 book-content" style="padding-top:5px;">
										<p><a href="#" >【${rinfo.league.leagueCompany}】</a></p>
										
										<p><a href="#">简介：${rinfo.rinfoDesc}</a></p>
										<div class="row" style="padding-top:15px;">
											<div class="col-md-5" >
												
												<p style="color:red ;margin-top:7px;font-size:15px;">发布日期：${rinfo.rinfoDate}</p>
											</div>
											<div class="col-md-7">
												
												<span style="margin-right:13px;">价格：￥${rinfo.rinfoPrice}</span>
												<button type="button" class="btn btn-success" style="margin-right:13px;"> <span class="glyphicon glyphicon-eye-open"></span><a href="/oneLifeRinfo/${rinfo.rinfoId}/${rinfo.service.serviceId}/${rinfo.league.leagueId}">查看详情</a> </button>
												
											</div>
										</div>	
									</div>
								</div>
							</div>
							
					 </c:forEach>
							<div class="pagination pagination-right" style="margin-left:720px;">  
						        <font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第  
						            ${page.pageNow} 页</font> <a href="/initLife?pageNow=1">首页</a>  
						        <c:choose>  
						            <c:when test="${page.pageNow - 1 > 0}">  
						                <a href="/initLife?pageNow=${page.pageNow - 1}">上一页</a>  
						            </c:when>  
						            <c:when test="${page.pageNow - 1 <= 0}">  
						                <a href="/initLife?pageNow=1">上一页</a>  
						            </c:when>  
						        </c:choose>  
						        <c:choose>  
						            <c:when test="${page.totalPageCount==0}">  
						                <a href="/initLife?pageNow=${page.pageNow}">下一页</a>  
						            </c:when>  
						            <c:when test="${page.pageNow + 1 < page.totalPageCount}">  
						                <a href="/initLife?pageNow=${page.pageNow + 1}">下一页</a>  
						            </c:when>  
						            <c:when test="${page.pageNow + 1 >= page.totalPageCount}">  
						                <a href="/initLife?pageNow=${page.totalPageCount}">下一页</a>  
						            </c:when>  
						        </c:choose>  
						        <c:choose>  
						            <c:when test="${page.totalPageCount==0}">  
						                <a href="/initLife?pageNow=${page.pageNow}">尾页</a>  
						            </c:when>  
						            <c:otherwise>  
						                <a href="/initLife?pageNow=${page.totalPageCount}">尾页</a>  
						            </c:otherwise>  
						        </c:choose>  
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
						<th style="border: 0px;"><a href="#">订单服务</a></th>
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