<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="http://www.jq22.com/jquery/bootstrap-3.3.4.css"
	rel="stylesheet">
	
<script src="js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>	
<script src="js/address.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
		var ctx="${ctx}";
		
		</script>

<script src="http://www.jq22.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://www.jq22.com/jquery/bootstrap-3.3.4.js"></script>
<script src="js/distpicker.data.js"></script>
<script src="js/distpicker.js"></script>
<script src="js/main.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script src="assets/layer/layer.js" type="text/javascript" ></script>
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>
<script type="text/javascript" src="js/select.js"></script>


<title>尤洪</title>
</head>
<body>
	<!--Begin Header Begin-->
	<div class="soubg">
		<div class="sou">
			
			<span class="fr"> <span class="fl">你好，请<a
					href="user/login">登录</a>&nbsp; <a href="user/regist"
					style="color: #ff4e00;">免费注册</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|
			</span> <span class="ss">
					<div class="ss_list">
						<a href="#">收藏夹</a>
						<div class="ss_list_bg">
							<div class="s_city_t"></div>
							<div class="ss_list_c">
								<ul>
									<li><a href="#">我的收藏夹</a></li>
									<li><a href="#">我的收藏夹</a></li>
								</ul>
							</div>
						</div>
					</div>

					<div class="ss_list">
							<a href="client/user_info">个人中心</a>
							
						</div>
			</span> <span class="fl">|&nbsp;关注我们：</span> <span class="s_sh"><a
					href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span> <span
				class="fr">|&nbsp;<a href="#">手机版&nbsp;<img
						src="images/s_tel.png" align="absmiddle" /></a></span>
			</span>
		</div>
	</div>
	<div class="m_top_bg">
		<div class="top">
			<div class="m_logo">
				<a href="client/index"><img src="images/logo.png" /></a>
			</div>
			<div class="m_search">
				<form>
					<input type="text" value="" class="m_ipt" /> <input type="submit"
						value="搜索" class="m_btn" />
				</form>
				<span class="fl"><a href="#">咖啡</a><a href="#">iphone 6S</a><a
					href="#">新鲜美食</a><a href="#">蛋糕</a><a href="#">日用品</a><a href="#">连衣裙</a></span>
			</div>
			<div class="i_car">
				<div class="car_t">
					购物车 [ <span>3</span> ]
				</div>
				<div class="car_bg">
					<!--Begin 购物车未登录 Begin-->
					<div class="un_login">
						还未登录！<a href="client/login" style="color: #ff4e00;">马上登录</a> 查看购物车！
					</div>
					<!--End 购物车未登录 End-->
					<!--Begin 购物车已登录 Begin-->
					<ul class="cars">
						<li>
							<div class="img">
								<a href="#"><img src="images/car1.jpg" width="58"
									height="58" /></a>
							</div>
							<div class="name">
								<a href="#">法颂浪漫梦境50ML 香水女士持久清新淡香 送2ML小样3只</a>
							</div>
							<div class="price">
								<font color="#ff4e00">￥399</font> X1
							</div>
						</li>
						<li>
							<div class="img">
								<a href="#"><img src="images/car2.jpg" width="58"
									height="58" /></a>
							</div>
							<div class="name">
								<a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a>
							</div>
							<div class="price">
								<font color="#ff4e00">￥399</font> X1
							</div>
						</li>
						<li>
							<div class="img">
								<a href="#"><img src="images/car2.jpg" width="58"
									height="58" /></a>
							</div>
							<div class="name">
								<a href="#">香奈儿（Chanel）邂逅活力淡香水50ml</a>
							</div>
							<div class="price">
								<font color="#ff4e00">￥399</font> X1
							</div>
						</li>
					</ul>
					<div class="price_sum">
						共计&nbsp; <font color="#ff4e00">￥</font><span>1058</span>
					</div>
					<div class="price_a">
						<a href="client/buycar">去购物车结算</a>
					</div>
					<!--End 购物车已登录 End-->
				</div>
			</div>
		</div>
	</div>
	<!--End Header End-->
	<div class="i_bg bg_color">
		<!--Begin 用户中心 Begin -->
		<div class="m_content">
			<div class="m_left">
				<div class="left_n">管理中心</div>
				<div class="left_m">
					<div class="left_m_t t_bg1">订单中心</div>
					<ul>
						<li><a href="client/order_list">我的订单</a></li>
						<li><a href="client/address_list" class="now">收货地址</a></li>
						<li><a href="#">缺货登记</a></li>
						<li><a href="#">跟踪订单</a></li>
					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg2">会员中心</div>
					<ul>
						<li><a href="client/user_info">用户信息</a></li>
						<li><a href="Member_Collect.html">我的收藏</a></li>
						<li><a href="Member_Msg.html">我的留言</a></li>
						<li><a href="Member_Links.html">推广链接</a></li>
						<li><a href="#">我的评论</a></li>
					</ul>
				</div>


			</div>
			<div class="m_right">
				<p></p>
				<div class="mem_tit">收货地址</div>
				<div class="address">
					<div class="a_close">
						<a href="#"><img src="images/a_close.png" /></a>
					</div>
					
					
					
					<table border="0" class="add_t" align="center"
						style="width: 98%; margin: 10px auto;" cellspacing="0"
						cellpadding="0">
						<tr>
							<td align="right" width="150"></td>
							<td style="font-size: 14px; color: #ff4e00;">${user.nickname }</td>
						</tr>
						<tr>
							<td align="right" width="150">收货人姓名：</td>
							<td>${user.username }</td>
						</tr>
						<tr>
							<td align="right">配送区域：</td>
							<td>${user.address }</td>
						</tr>
						
						<tr>
							<td align="right">手机：</td>
							<td>${user.phone }</td>
						</tr>

						<tr>
							<td align="right">电子邮箱：</td>
							<td>${user.email }</td>
						</tr>
					</table>

					<p align="right">
						<a style="color: #ff4e00;">默认</a>&nbsp; &nbsp; &nbsp;
						&nbsp; 
					</p>

					  <c:forEach items="${list }" var="addre">
						
						<table border="0" class="add_t" align="center"
						style="width: 98%; margin: 10px auto;" cellspacing="0"
						cellpadding="0">
						<tr>
							<td align="right" width="150">地址编号</td>
							<td style="font-size: 14px; color: #ff4e00;" class="addreid" >${addre.id }</td>
						</tr>
						<tr>
							<td align="right" width="150">收货人姓名：</td>
							<td>${addre.name }</td>
						</tr>
						<tr>
							<td align="right">配送区域：</td>
							<td  class="bb1">${addre.address }</td>
						</tr>
						<tr>
							<td align="right">详细地址：</td>
							<td class="bb2">${addre.details_address }</td>
						</tr>
						<tr>
							<td align="right">手机：</td>
							<td>${addre.phone }</td>
						</tr>

						<tr>
							<td align="right">电子邮箱：</td>
							<td>${addre.email }</td>
						</tr>
						<tr>
						<td></td>
						<td>
						
						<a class="menren" style="color: #ff4e00;float: right;">设为默认</a>&nbsp; &nbsp; &nbsp;
						&nbsp; 
						
						</td>
						
						</tr>
					</table>
						
					</c:forEach>
				</div>

				<div class="mem_tit">
					<a href="#"><img src="images/add_ad.gif" /></a>
				</div>
				<form method="post" action="client/address_add" class="address_form">
					<table border="0" class="add_tab" style="width: 930px;"
						cellspacing="0" cellpadding="0">
						
						<tr>
							<td width="135" align="right">配送地区</td>
							<td><div data-toggle="distpicker" class="addre"  >
								  <select data-province="---- 选择省 ----" class="addre1" ></select>
								  <select data-city="---- 选择市 ----" class="addre2"></select>
								  <select data-district="---- 选择区 ----" class="addre3"></select>
								</div>
								<input  name="address" type="hidden" class="address_tt" />
							</td>
							<td align="right">删除(修改)编号</td>
							<td style="font-family: '宋体';"><input type="text"
							name="id" class="add_ipt" placeholder="添加不问填"  id="id"/></td>
	
						</tr>
						<tr>
							<td align="right">收货人姓名</td>
							<td style="font-family: '宋体';"><input type="text" 
								class="add_ipt username" name="name" />（必填）</td>
							<td align="right">电子邮箱</td>
							<td style="font-family: '宋体';"><input type="text"
								 class="add_ipt email" name="email" /></td>
						</tr>
						<tr>
							<td align="right">详细地址</td>
							<td style="font-family: '宋体';"><input type="text"
								name="details_address" class="add_ipt details_address"   /></td>
							<td align="right">手机</td>
							<td style="font-family: '宋体';"><input type="text"
							name="phone" class="add_ipt phone" /></td>
						</tr>
					</table>
					<p align="right">
					
					<button type="submit" >确认添加</button>
						<a class="add_b detele_btn" >删除</a>&nbsp; &nbsp; 
						<a  class="add_b update_btn">确认修改</a>
					</p>
				</form>
				



			</div>
		</div>
		<!--End 用户中心 End-->
		<!--Begin Footer Begin -->
		<div class="b_btm_bg b_btm_c">
			<div class="b_btm">
				<table border="0"
					style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="72"><img src="images/b1.png" width="62"
							height="62" /></td>
						<td><h2>正品保障</h2>正品行货 放心购买</td>
					</tr>
				</table>
				<table border="0"
					style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="72"><img src="images/b2.png" width="62"
							height="62" /></td>
						<td><h2>满38包邮</h2>满38包邮 免运费</td>
					</tr>
				</table>
				<table border="0"
					style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="72"><img src="images/b3.png" width="62"
							height="62" /></td>
						<td><h2>天天低价</h2>天天低价 畅选无忧</td>
					</tr>
				</table>
				<table border="0"
					style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="72"><img src="images/b4.png" width="62"
							height="62" /></td>
						<td><h2>准时送达</h2>收货时间由你做主</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="b_nav">
			<dl>
				<dt>
					<a href="#">新手上路</a>
				</dt>
				<dd>
					<a href="#">售后流程</a>
				</dd>
				<dd>
					<a href="#">购物流程</a>
				</dd>
				<dd>
					<a href="#">订购方式</a>
				</dd>
				<dd>
					<a href="#">隐私声明</a>
				</dd>
				<dd>
					<a href="#">推荐分享说明</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<a href="#">配送与支付</a>
				</dt>
				<dd>
					<a href="#">货到付款区域</a>
				</dd>
				<dd>
					<a href="#">配送支付查询</a>
				</dd>
				<dd>
					<a href="#">支付方式说明</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<a href="#">会员中心</a>
				</dt>
				<dd>
					<a href="#">资金管理</a>
				</dd>
				<dd>
					<a href="#">我的收藏</a>
				</dd>
				<dd>
					<a href="#">我的订单</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<a href="#">服务保证</a>
				</dt>
				<dd>
					<a href="#">退换货原则</a>
				</dd>
				<dd>
					<a href="#">售后服务保证</a>
				</dd>
				<dd>
					<a href="#">产品质量保证</a>
				</dd>
			</dl>
			<dl>
				<dt>
					<a href="#">联系我们</a>
				</dt>
				<dd>
					<a href="#">网站故障报告</a>
				</dd>
				<dd>
					<a href="#">购物咨询</a>
				</dd>
				<dd>
					<a href="#">投诉与建议</a>
				</dd>
			</dl>
			<div class="b_tel_bg">
				<a href="#" class="b_sh1">新浪微博</a> <a href="#" class="b_sh2">腾讯微博</a>
				<p>
					服务热线：<br /> <span>400-123-4567</span>
				</p>
			</div>
			<div class="b_er">
				<div class="b_er_c">
					<img src="images/er.gif" width="118" height="118" />
				</div>
				<img src="images/ss.png" />
			</div>
		</div>
		<div class="btmbg">
			<div class="btm">
				备案/许可证编号：蜀ICP备XXX号-1XXX Copyright © 2015-2018 尤洪商城网 All Rights
				Reserved. <br /> <img src="images/b_1.gif" width="98" height="33" /><img
					src="images/b_2.gif" width="98" height="33" /><img
					src="images/b_3.gif" width="98" height="33" /><img
					src="images/b_4.gif" width="98" height="33" /><img
					src="images/b_5.gif" width="98" height="33" /><img
					src="images/b_6.gif" width="98" height="33" />
			</div>
		</div>
		<!--End Footer End -->
	</div>

</body>
</html>