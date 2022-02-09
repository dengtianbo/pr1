<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 获取应用上下文路径 -->
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html>
<!-- 整个页面的所有路径都是基于此相对路径 -->
<base href="${ctx }/">
<title>添加user界面</title>
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
				<legend align="center">添加用户</legend>

				<form action="admin/useradd" method="post" class="student-form">
					<div>
						<label for="stuId">用户名：</label> <input type="text" name="username" id="username" placeholder="请输入用户名"
							value="${user.username}">
					</div>
					<div>
						<label for="password">密码：</label> <input type="text" name="password" id="password" placeholder="请输入密码"
							value="${user.password}">
					</div>
					<div>
						<label for="nickname">昵称：</label> <input type="text" name="nickname" id="nickname" placeholder="请输入昵称"
							value="${user.nickname}">
					</div>
					<div>
						<label for="email">邮箱：</label> <input type="text" name="email" id="email" placeholder="请输入邮箱"
							value="${user.email}">
					</div>
					
					<div>
						<label for="phone">手机：</label> <input type="text" name="phone" id="phone" placeholder="请输入手机"
						 value="${e.phone}" >
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