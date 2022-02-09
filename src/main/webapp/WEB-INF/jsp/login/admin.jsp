<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 获取应用上下文路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<!-- 整个页面的所有路径都是基于此相对路径 -->
<base href="${ctx }/">
<head>
<meta charset="UTF-8">
<title>管理员登入界面</title>
		<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		
		<link rel="stylesheet" href="assets/css/ace.min.css" />
		<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
        <link rel="stylesheet" href="css/style2.css"/>
		  <script type="text/javascript"  src="assets/layer/layer.js"></script>
		<script type="text/javascript"  src="assets/laydate/laydate.js"></script>
    
		<script src="assets/js/ace-extra.min.js"></script>
		
		<script src="assets/js/html5shiv.js"></script>
		<script src="assets/js/respond.min.js"></script>
		
		<script src="js/jquery-1.9.1.min.js"></script>        

	<script type="text/javascript">
		var ctx = "${ctx}";
		var info = "${info}";
		</script>
	<script type="text/javascript">
			$(function(){
				if (info) {
				layer.alert(info);
				}
			});
		</script>

</head>
<body class="login-layout Reg_log_style">
	<div class="logintop">
		<span>欢迎后台管理界面平台</span>
		<ul>
			<li><a href="#">返回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<div class="loginbody">
		<div class="login-container">
			<div class="center"></div>
			<div class="space-6"></div>
			<div class="position-relative">
				<div id="login-box" class="login-box widget-box no-border visible">
					<div class="widget-body">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee green"></i>
								管理员登陆
							</h4>
							<div class="login_icon"><img src="images/login.png" /></div>

							<form class="" method="post" action="admin/login">
								<fieldset>
									<ul>
										<li class="frame_style form_error"><label class="user_icon"></label><input
												name="username" type="text" id="username"  placeholder="请输入用户名" /></li>
										<li class="frame_style form_error"><label
												class="password_icon"></label><input name="password" type="password"
												id="userpwd"  placeholder="请输入密码" /></li>
										<li class="frame_style form_error">
										<label class="Codes_icon"></label>
										
										<input  type="text"  id="Codes_text" name="captcha"  class="cap" />
											<div class="Codes_region">
											<img id="captcha"  src="captcha" style="width: 100px; height: 40px">
											</div>
										</li>
									</ul>
									<div class="space"></div>

									<div class="clearfix">
										<label class="inline">
											<input type="checkbox" class="ace">
											<span class="lbl">保存密码</span>
										</label>

										<button type="submit" class="width-35 pull-right btn btn-sm btn-primary"
											id="login_btn">
											<i class="icon-key"></i>
											登陆
										</button>
									</div>

									<div class="space-4"></div>
								</fieldset>
							</form>
							<div class="social-or-login center">
								<span class="bigger-110">通知</span>
							</div>
							<div class="social-login center">
								本网站系统不再对IE8以下浏览器支持，请见谅。
							</div>
						</div><!-- /widget-main -->
						<div class="toolbar clearfix">
						</div>
					</div><!-- /widget-body -->
				</div><!-- /login-box -->
			</div><!-- /position-relative -->
		</div>
	</div>
	<div class="loginbm">版权所有 2017 <a href="">深圳非常聚成软件系统有限公司</a> </div><strong></strong>
</body>

<script type="text/javascript">
	var img = document.querySelector("#captcha");
	img.addEventListener("click", function() {
		img.src = ctx + "/captcha?id" + new Date().getTime();
	});
</script>
</html>


