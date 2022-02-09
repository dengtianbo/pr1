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
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="css/style.css" />
<link href="assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="font/css/font-awesome.min.css" />

<script src="js/jquery-1.9.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="assets/layer/layer.js" type="text/javascript"></script>
<script src="assets/laydate/laydate.js" type="text/javascript"></script>
<script src="assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="js/lrtk.js" type="text/javascript"></script>
<title>订单详细</title>
</head>

<body>
	<div class="margin clearfix">
		<div class="Order_Details_style">
			<div class="Numbering">
				订单编号:<b>${uid }</b>
			</div>
		</div>
		<div class="detailed_style">
			<!--收件人信息-->
			<div class="Receiver_style">
				<div class="title_name">收件人信息</div>
				<div class="Info_style clearfix">
					<div class="col-xs-3">
						<label class="label_name" for="form-field-2"> 收件人姓名： </label>
						<div class="o_content">${order.user.username }</div>
					</div>
					<div class="col-xs-3">
						<label class="label_name" for="form-field-2"> 收件人电话： </label>
						<div class="o_content">${order.user.phone }</div>
					</div>
					<div class="col-xs-3">
						<label class="label_name" for="form-field-2"> 收件地邮编： </label>
						<div class="o_content">${order.user.email }</div>
					</div>
					<div class="col-xs-3">
						<label class="label_name" for="form-field-2"> 收件地址： </label>
						<div class="o_content">${order.user.address }</div>
					</div>
				</div>
			</div>
			<!--订单信息-->
			<div class="product_style">
				<div class="title_name">产品信息</div>
				<div class="Info_style clearfix">
				
				<c:forEach items="${list }" var="orderDetails">
						<div class="product_info clearfix" style="display: inline-block;margin-right: 50px">
							<a  class="img_link" style="display: block;"><img src="${orderDetails.goods.picture }" style=" width: 100px; height: 100px" /></a> <span>
							<a  class="name_link"><b>${orderDetails.goods.name }</b></a> 
							<b>${orderDetails.goods.ms }</b>
							<p>规格：500g/斤</p>
							<p>数量：<b>${orderDetails.number }</b></p>
							<p>
								价格：<b class="price"><i>￥</i>${orderDetails.goods.price }</b>
							</p>
							
						</span>
					</div>
				
				
				</c:forEach>
				
			
				</div>
			</div>
			<!--总价-->
			<div class="Total_style">
				<div class="Info_style clearfix">
					<div class="col-xs-3">
						<label class="label_name" for="form-field-2"> 支付方式： </label>
						<div class="o_content">在线支付</div>
					</div>
					<div class="col-xs-3">
						<label class="label_name" for="form-field-2"> 支付状态： </label>
						<c:choose>
							<c:when test="${order.order_status ==1 }">
								<div>未付款</div>
							</c:when>
							<c:when test="${order.order_status == 2  }">
								<div>未发货</div>
							</c:when>
							<c:when test="${order.order_status == 3}">
								
								<div>已发货</div>
							</c:when>

						</c:choose>
					</div>
					<div class="col-xs-3">
						<label class="label_name" for="form-field-2"> 订单生成日期： </label>
						<div class="o_content">${order.time }</div>
					</div>
					
					
				</div>
				<div class="Total_m_style">
					<span class="Total_price">总价：<b>${order.price }</b>元
					</span>
				</div>
			</div>


		</div>
	</div>
</body>
</html>