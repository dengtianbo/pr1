<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 获取应用上下文路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<!-- 整个页面的所有路径都是基于此相对路径 -->
<base href="${ctx }/">
<head>

<title>添加goods界面</title>
<link rel="stylesheet" type="text/css" href="css/user_add.css"/>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"  src="assets/layer/layer.js"></script>
<script type="text/javascript" src="assets/laydate/laydate.js"></script>
<script type="text/javascript"  src="js/user_add.js"></script>
<script type="text/javascript">
    var ctx="${ctx}";
	var error = "${error}";//页面错误信息
	
</script>


</head>
	<body>
		<div class="container">
			<fieldset>
				<legend align="center">添加商品</legend>

				<form action="admin/goods_add" method="post" class="student-form" enctype="multipart/form-data">
					<div>
						<label for="stuId">商品名：</label> <input type="text" name="name" id="name" placeholder="请输入商品名"
							value="${goods.name }">
					</div>
					
					<div>
						<label for="price">价格：</label> <input type="text" name="price" id="price" placeholder="请输入价格"
							value="${goods.price }">
					</div>
					<div>
						<label for="pdid">商品详情id:</label> <input type="text" name="pdid" id="pdid" placeholder="请输入商品详情ID"
							value="${goods.pdid }">
					</div>
					
					<div>
						<label for="classid">类别id：</label> <input type="text" name="classid" id="classid" placeholder="请输入类别id"
						 value="${goods.classid }" >
					</div>
					<div>
						<label for="heat">热度：</label> <input type="text" name="heat" id="heat" placeholder="请输入热度"
							value="${goods.heat }">
					</div>
					
					<div>
						<label for="ms">描述：</label> <input type="text" name="ms" id="ms" placeholder="请输入描述"
						 value="${goods.ms }" >
					</div>
					
					<div>
						<label for="picture-pic">主图片：</label> <input type="file" name="picture-pic" id="portrait-pic" autocomplete="off">
					</div>
					

					<div>
						<label></label>
						<button type="submit">提交</button>
						<button type="reset" class="re-btn">重置</button>
					</div>
				</form>
			</fieldset>
		</div>
	</body>
</html>