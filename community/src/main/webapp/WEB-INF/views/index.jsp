<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="shortcut icon" type="image/x-icon" href="foreground/image/log.png">
    <title>惠家E站</title>

    <link href="assets/foreground/css/bootstrap.min.css" rel="stylesheet">
	<script src="assets/foreground/js/jquery.min.js"></script>
    <script src="assets/foreground/js/bootstrap.min.js"></script>
	
	<style type="text/css">
		.lifeService:hover{
			background-color:#FBE300;
			
		}
		.financeService:hover{
			background-color:#FBE300;
		}
	</style>

  
  </head>
  <body>
		<div class="head">
			<div class="row" style="margin-top:10px;">
				<div class="col-md-7">
					<div class="row head-left" style="padding-left:100px;">
						<div class="col-md-2 head-inner-img">
							<img src="assets/foreground/image/log.png" width="80px" height="80px">
						</div>
						<div class="col-md-10 head-inner-font">
							<h1 style="color:#BC0505;">社区金融便民服务平台-恵家E站</h1>
						</div>
					</div>
				
				</div>
				<div class="col-md-5" style="padding-left:175px;">
					<div class="row">
						<div class="col-md-1" style="margin-top:9px;">
							<img src="assets/foreground/image/SF.png" width="50px" height="50px">
						</div>
						<div class="col-md-11" style="padding-left:32px;">
							<h4 style="color:#FE6602;font-weight:bold;">太原社区服务中心</h4>
							<p style="color:black;font-weight:bold;">24小时服务热线：0001-110110</p>
						</div>
					</div>
						
				
				</div>
			</div>
		</div>
		<div class="body" style="width:100%;height:535px;background-color:#ED6567;">
			<div class="row">
				<div class="col-md-6" >
					<p style="font-size:3em;font-weight:bold;color:#FBE300;text-align:center;margin-top:25px;margin-bottom:25px;">服务管理</p>
					<p style="font-size:1.5em;font-weight:bold;color:white;width:440px;margin-left:117px;">开展社区信息化的重要平台，建有社区管理和居民管理的网络信息，实现社区网络化、信息化
					、金融化，方便社区居民的生活，共建和谐社区、先进社区！</p>
					
					<div style="width:480px;height:135px;margin-top:80px;margin-left:100px;">
						<div class="lifeService" style="width:190px;height:80px;border:1px solid white;border-radius:1em;display:inline-block;margin-left:30px;">
							<a  href="/initLife" style="text-decoration:none; font-size:1.5em;font-weight:bold;color:white;display:inline-block;margin-left:53px;margin-top:22px;">生活服务</a>
						</div>
						<div class="financeService" style="width:190px;height:80px;border:1px solid white;border-radius:1em;display:inline-block;margin-left:20px;">
							<a  href="/initFinance" style="text-decoration:none; font-size:1.5em;font-weight:bold;color:white;display:inline-block;margin-left:53px;margin-top:22px;">金融服务</a>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<img src="assets/foreground/image/back.png">
				</div>
			</div>
		</div>
		

  </body>
</html>
