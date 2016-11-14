<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <title>惠家E站加盟商注册页面</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/foreground/assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/foreground/assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/foreground/assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/foreground/assets/css/style.css">

        
        <link rel="shortcut icon" type="image/x-icon" href="assets/foreground/image/title.ico">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/foreground/assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/foreground/assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/foreground/assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/foreground/assets/ico/apple-touch-icon-57-precomposed.png">

<script type="text/javascript">
	function checkleague(){
		
        var leaguename=$("#form-leaguename").val(); 
      
        $.ajax({
           url:"/queryByLeague",
           type:"post",
           data:{"leagueName":leaguename},
           dataType:"json",
           
          success:function(data){
               if (data==true ) {
                $("#leagueSpan").text("帐号已存在");
                $("#form-leaguename").val(' ');
            }else if(data==false && leaguename!=""){
                $("#leagueSpan").text("帐号可用");
            }
          }
        });
    }
	</script>
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
                        			<h3>Become our member</h3>
                            		<span> Please enter your message to regist:</span>
                            		<span id="leagueSpan" style="color:#934846;font-size:18px;"></span>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form:form action="/leagueRegist" method="post" class="login-form"  modelAttribute="league">
			                    	
			                    	<div class="form-group">
			                          <label class="sr-only" for="form-leaguename">账号</label>
			                          <form:input path="leagueName" placeholder="账号" class="form-leaguename form-control" id="form-leaguename" onblur="checkleague()"/>
			                          <form:errors path="leagueName" />
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">密码</label>
			                        	<form:input path="leaguePassword" type="password" placeholder="密码" class="form-password form-control" id="form-password"/>
			                        	<form:errors path="leaguePassword" />
			                        </div>
			                        <div class="form-group">
			                          <label class="sr-only" for="leagueCompany">公司名</label>
			                          <form:input path="leagueCompany" placeholder="公司名" class="form-leagueCompany form-control" id="form-leagueCompany" />
			                          <form:errors path="leagueCompany" />
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-email">邮箱</label>
			                        	<form:input path="leagueEmail" placeholder="邮箱..." class="form-email form-control" id="form-email"/>
			                        	<form:errors path="leagueEmail" />
			                        </div>
									<div class="form-group">
			                        	<label class="sr-only" for="form-phone">联系电话</label>
			                       		<form:input path="leaguePhone" placeholder="联系电话" class="form-phone form-control" id="form-phone"/>
			                       		<form:errors path="leaguePhone" />
			                        </div>
			                        <form:input path="leagueState" type="hidden" value="0"/>
			                        <form:button class="btn">注册</form:button>
			                    </form:form>
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