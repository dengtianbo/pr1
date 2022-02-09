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
        <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="css/style2.css"/>       
        <link href="assets/css/codemirror.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/ace.min.css" />
         <link rel="stylesheet" href="css/user_list.css" />
        <link rel="stylesheet" href="assets/css/font-awesome.min.css" />
		
			<script src="assets/js/jquery.min.js"></script>
		
		<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		<script src="assets/js/bootstrap.min.js"></script>
		<script src="assets/js/typeahead-bs2.min.js"></script>
		<!-- page specific plugin scripts -->
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
        <script type="text/javascript" src="js/H-ui.js"></script> 
        <script type="text/javascript" src="js/H-ui.admin.js"></script> 
        <script src="assets/layer/layer.js" type="text/javascript" ></script>
        <script src="assets/laydate/laydate.js" type="text/javascript"></script>
        <script src="js/user_list.js" type="text/javascript"></script>
<title>用户列表</title>
<script type="text/javascript">
    var ctx="${ctx}"
	var pageNo = "${p.pageNum}";//当前页
	var pages = "${p.pages}";//总页数
	var pageSize = "${p.pageSize}";//页面大小
	var error = "${error}";//页面错误信息
</script>


</head>

<body>
<div class="page-content clearfix">
		<div class="search-form">
			<form action="admin/userlist" method="post">
				 <div class="search_style">
				     <ul class="search_content clearfix">
				     <li><label class="l_f">用户编号</label><input name="id" type="text"  class="text_add" placeholder="输入查询id"  style=" width:200px"/></li>
				     <li><label class="l_f">用户名称</label><input name="username" type="text"  class="text_add" placeholder="输入查询姓名"  style=" width:200px"/></li>
				     <li><label class="l_f">用户昵称</label><input name="nickname" type="text"  class="text_add" placeholder="输入查询用户昵称"  style=" width:200px"/></li>
				      
				      <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
				     </ul>
				 </div>
				
			
				<!-- 页码 -->
				<input type="hidden" name="pageNo" />
				<!-- 页面大小 -->
				<input type="hidden" name="pageSize" value="${p.pageSize}" />
			</form>
		</div>
    <div id="Member_Ratings">
      <div class="d_Confirm_Order_style">
    <!-- <div class="search_style">
     
      <ul class="search_content clearfix">
       <li><label class="l_f">会员名称</label><input name="" type="text"  class="text_add" placeholder="输入会员名称、电话、邮箱"  style=" width:400px"/></li>
       <li><label class="l_f">添加时间</label><input class="inline laydate-icon" id="start" style=" margin-left:10px;"></li>
       <li style="width:90px;"><button type="button" class="btn_search"><i class="icon-search"></i>查询</button></li>
      </ul>
    </div> -->
     <!---->
     <div class="border clearfix">
       <span class="l_f">
        <a href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加用户</a>
        <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a>
       </span>
       <span class="r_f">共：<b>${count }</b>条记录</span>
     </div>
     <!---->
     <div class="table_menu_list">
       <table class="table table-striped table-bordered table-hover" id="sample-table">
		<thead>
		 <tr>
				<th width="25"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
				<th width="80">ID</th>
				<th width="100">用户名</th>
				<th width="80">昵称</th>
				<th width="120">手机</th>
				<th width="150">邮箱</th>
				<th width="">默认地址</th>
                <th width="100">vip</th>
				<th width="70">状态</th>                
				<th width="250">操作</th>
			</tr>
		</thead>
	<tbody>
	
	<c:forEach  items="${users}" var="user" >
	<tr>
          <td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
          <td class="idd">${user.id }</td>
          <td><u style="cursor:pointer" class="text-primary" >${user.username }</u></td>
          <td>${user.nickname }</td>
          <td>${user.phone }</td>
          <td>${user.email }</td>
          <td class="text-l">${user.address }</td>
          <td>
          <c:choose>
          <c:when test="${user.id }== 1">是</c:when>
          <c:otherwise>否</c:otherwise>
          </c:choose>
          </td>
          
          <td class="td-status"><span class="label label-success radius">已启用</span></td>
          <td class="td-manage">
          <a onClick="member_stop(this,'10001')"  href="javascript:;" title="停用"  class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a> 
          <a title="编辑" href="javascript:;"  class="btn btn-xs btn-info" ><i class="icon-edit bigger-120"></i></a> 
          <a title="删除" href="javascript:;"   class="btn btn-xs btn-warning" ><i class="icon-trash  bigger-120"></i></a>
          </td>
		</tr>
	
	</c:forEach>
	
	
      </tbody>
	</table>
		<!--分页区  -->
			<div class="paginate">
				<span class="first"><a>首页</a></span>
				<span class="prev"><a>上一页</a></span>
				<ul>
					<c:forEach begin="${p.navigateFirstPage }" end="${p.navigateLastPage }" var="pi">
						<c:choose>
						<c:when test="${pi == pageNum }">
							<li ><a class="qq" href="javascript:void(0)">${pi }</a></li>
						</c:when>
						<c:otherwise>
							<li><a  href="javascript:void(0)">${pi }</a></li>
						</c:otherwise>
						</c:choose>
					</c:forEach>
					
				</ul>
				<input type="text" id="bt" value="${p.pageNum }"/><span class="go">前往</span>
				<span class="next"><a>下一页</a></span>
				<span class="last"><a>尾页</a></span>
				<select>
					<option value="2">2</option>
					<option value="5">5</option>
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="50">50</option>
					<option value="100">100</option>
				</select>
				
			</div>
	
   </div>
  </div>
 </div>
</div>
<!--添加用户图层-->
<div class="add_menber" id="add_menber_style" style="display:none">
  
    <ul class=" page-content">
     <li><label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label><span class="add_name"><input value="" name="用户名" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">真实姓名：</label><span class="add_name"><input name="真实姓名" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label><span class="add_name">
     <label><input name="form-field-radio" type="radio" checked="checked" class="ace"><span class="lbl">男</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio" type="radio" class="ace"><span class="lbl">女</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio" type="radio" class="ace"><span class="lbl">保密</span></label>
     </span>
     <div class="prompt r_f"></div>
     </li>
     <li><label class="label_name">固定电话：</label><span class="add_name"><input name="固定电话" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">移动电话：</label><span class="add_name"><input name="移动电话" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">电子邮箱：</label><span class="add_name"><input name="电子邮箱" type="text"  class="text_add"/></span><div class="prompt r_f"></div></li>
     <li class="adderss"><label class="label_name">家庭住址：</label><span class="add_name"><input name="家庭住址" type="text"  class="text_add" style=" width:350px"/></span><div class="prompt r_f"></div></li>
     <li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span class="add_name">
     <label><input name="form-field-radio1" type="radio" checked="checked" class="ace"><span class="lbl">开启</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio1"type="radio" class="ace"><span class="lbl">关闭</span></label></span><div class="prompt r_f"></div></li>
    </ul>
 </div>
</body>
</html>
