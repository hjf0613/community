<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>惠家E站登陆页面</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/foreground/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/foreground/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/foreground/assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/foreground/assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/foreground/image/title.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/foreground/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/foreground/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/foreground/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/foreground/assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>惠家E站</strong></h1>
                            
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Login to our home</h3>
                            		<span>Enter your phone and password to log on:</span>
                            	 	<span style="color:#934846;font-size:18px;">${error}</span>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="/userLogin" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">账号：</label>
			                        	<input type="text" name="userPhone" placeholder="手机号" class="form-username form-control" id="form-username">
			                        	
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">密码：</label>
			                        	<input type="password" name="userPassword" placeholder="密码" class="form-password form-control" id="form-password">
			                        	
			                        </div>
			                        <button type="submit" class="btn">登录</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 social-login">
  
                        	<div class="social-login-buttons">
	                        	<a class="btn btn-link-2" href="#">
	                        		 <i class="fa fa-question-circle fa-lg" aria-hidden="true"></i> 忘记密码
	                        	</a>
	                        	<a class="btn btn-link-2" href="/userRegist">
	                        		 <i class="fa fa-rebel" aria-hidden="true"></i> 用户注册
	                        	</a>
	                        	
                        	</div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
        <script src="assets/foreground/assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/foreground/assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/foreground/assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/foreground/assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>