<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

		<title>修改密码</title>
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>assets/jslib/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>assets/css/theme.css">
		<link rel="stylesheet"
			href="<%=basePath%>assets/jslib/font-awesome/css/font-awesome.css">
		<script src="<%=basePath%>assets/jslib/jquery-1.7.2.min.js"
			type="text/javascript"></script>
		<style type="text/css">
#line-chart {
	height: 300px;
	width: 800px;
	margin: 0px auto;
	margin-top: 1em;
}

.brand {
	font-family: georgia, serif;
}

.brand .first {
	color: #ccc;
	font-style: italic;
}

.brand .second {
	color: #fff;
	font-weight: bold;
}
</style>
		<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	</head>

	<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
	<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
	<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
	<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
	<!--[if (gt IE 9)|!(IE)]><!-->
	<body class="">
		<!--<![endif]-->
		<div class="navbar">
			<div class="navbar-inner">
				<ul class="nav pull-right">
				</ul>
				<a class="brand" href="admin_index.jsp"><span class="first">欢迎</span>
					<span class="second">修改密码</span>
				</a>
			</div>
		</div>

		<div class="row-fluid">
			<div class="dialog">
				<div class="block">
					<p class="block-heading">
						修改密码
					</p>
					<div class="block-body">
						<form method="post" action="/editPassword">
							<label>
								用户名：
							</label>
							<input type="text" name="adminName" class="span12" maxlength="20" value="${admin.adminName}" readonly="readonly">
							<label>
								新密码：
							</label>
							<input type="password" name="adminPassword" class="span12" maxlength="20">
							${msg }
							<input type="submit" class="btn btn-primary pull-right" value="确认" />
							<div class="clearfix"></div>
							
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
