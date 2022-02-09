<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 获取应用上下文路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<!-- 整个页面的所有路径都是基于此相对路径 -->
<base href="${ctx }/">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="author" content="order by dede58.com" />
		<link type="text/css" rel="stylesheet" href="css/style.css" />
		
		<script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
		<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>

		<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript" src="js/menu.js"></script>

		<script type="text/javascript" src="js/select.js"></script>

		<script type="text/javascript" src="js/lrscroll.js"></script>

		<script type="text/javascript" src="js/iban.js"></script>
		<script type="text/javascript" src="js/fban.js"></script>
		<script type="text/javascript" src="js/f_ban.js"></script>
		<script type="text/javascript" src="js/mban.js"></script>
		<script type="text/javascript" src="js/bban.js"></script>
		<script type="text/javascript" src="js/hban.js"></script>
		<script type="text/javascript" src="js/tban.js"></script>
  <script type="text/javascript"  src="assets/layer/layer.js"></script>
	<script type="text/javascript"  src="assets/laydate/laydate.js"></script>
    
		<script type="text/javascript" src="js/lrscroll_1.js"></script>
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

		<title>尤洪</title>
	</head>
	<body>
		<!--Begin Header Begin-->
		<div class="soubg">
			<div class="sou">
				<span class="fr">
					<span class="fl">你好，请<a href="user/login">登录</a>&nbsp; <a href="user/regist"
							style="color:#ff4e00;">免费注册</a>&nbsp; </span>
					<span class="fl">|&nbsp;关注我们：</span>
					<span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
					<span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png"
							 align="absmiddle" /></a></span>
				</span>
			</div>
		</div>
		<!--End Header End-->
		<!--Begin Login Begin-->
		<div class="log_bg">
			<div class="top">
				<div class="logo"><a href="client/index"><img src="images/logo.png" /></a></div>
			</div>
			<div class="login">
				<div class="log_img"><img src="images/l_img.png" width="611" height="425" /></div>
				<div class="log_c">
					<form action="user/login" method="post">
						<table border="0" style="width:370px; font-size:14px; margin-top:30px;" cellspacing="0"
							cellpadding="0">
							<tr height="50" valign="top">
								<td width="55">&nbsp;</td>
								<td>
									<span class="fl" style="font-size:24px;">登录</span>
									<span class="fr">还没有商城账号，<a href="user/regist"
											style="color:#ff4e00;">立即注册</a></span>
								</td>
							</tr>
							<tr height="70">
								<td>用户名</td>
								<td><input type="text" value="" class="l_user" name="username" /></td>
							</tr>
							<tr height="70">
								<td>密&nbsp; &nbsp; 码</td>
								<td><input type="password" value="" class="l_pwd" name="password" /></td>
							</tr>
							
							<tr height="70">
								<td>验证码</td>
								<td><input type="text" value="" class="" name="captcha" style="height: 30px " />
									<img id="captcha"  src="captcha" style="width: 100px; height: 40px ; border-top: 20px">
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td style="font-size:12px; padding-top:20px;">
									<span style="font-family:'宋体';" class="fl">
										<label class="r_rad"><input type="checkbox" /></label><label
											class="r_txt">请保存我这次的登录信息</label>
									</span>
									<span class="fr"><a href="#" style="color:#ff4e00;">忘记密码</a></span>
								</td>
							</tr>
							<tr height="60">
								<td>&nbsp;</td>
								<td><input type="submit" value="登录" class="log_btn" /></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
		<!--End Login End-->
		<!--Begin Footer Begin-->
		<div class="btmbg">
			<div class="btm">
				备案/许可证编号：蜀ICP备XXX号-1XXX Copyright © 2015-2018 尤洪商城网 All Rights Reserved. <br />
				<img src="images/b_1.gif" width="98" height="33" /><img src="images/b_2.gif" width="98"
					height="33" /><img src="images/b_3.gif" width="98" height="33" /><img src="images/b_4.gif"
					width="98" height="33" /><img src="images/b_5.gif" width="98" height="33" /><img
					src="images/b_6.gif" width="98" height="33" />
			</div>
		</div>
	</body>
	
<script type="text/javascript">
	var img = document.querySelector("#captcha");
	img.addEventListener("click", function() {
		img.src = ctx + "/captcha?id" + new Date().getTime();
	});
</script>
</html>