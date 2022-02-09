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
<title>修改user界面</title>
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
				<legend align="center">修改头像</legend>

				<form action="client/editportrait" method="post" class="student-form"  enctype="multipart/form-data">
					
					<div>
						<label for="portrait-pic">上传头像：</label> <input type="file" name="portrait-pic" id="portrait-pic" autocomplete="off">
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