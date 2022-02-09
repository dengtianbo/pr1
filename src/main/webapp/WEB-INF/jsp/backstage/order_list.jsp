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
<link rel="stylesheet" href="css/style2.css" />
<link rel="stylesheet" href="css/user_list.css" />
<link href="assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/ace.min.css" />
<link rel="stylesheet" href="font/css/font-awesome.min.css" />



<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/order_list.js" type="text/javascript"></script>
<script type="text/javascript">
    var ctx="${ctx}"
	var pageNo = "${p.pageNum}";//当前页
	var pages = "${p.pages}";//总页数
	var pageSize = "${p.pageSize}";//页面大小
	var error = "${error}";//页面错误信息
</script>
<script src="js/jquery-1.9.1.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script src="assets/js/typeahead-bs2.min.js"></script>
<script src="assets/js/jquery.dataTables.min.js"></script>
<script src="assets/js/jquery.dataTables.bootstrap.js"></script>
<script src="assets/layer/layer.js" type="text/javascript"></script>
<script src="assets/laydate/laydate.js" type="text/javascript"></script>
<script src="assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="js/lrtk.js" type="text/javascript"></script>
<title>订单管理</title>
</head>

<body>
	<div class="margin clearfix">
		<div class="cover_style" id="cover_style">
			
			<!--内容-->
			<div class="centent_style" id="centent_style">
				<div id="covar_list" class="order_list">
					<div id="scrollsidebar" class="left_Treeview">
						<div class="show_btn" id="rightArrow">
							<span></span>
						</div>
						<div class="widget-box side_content">
							<div class="side_title">
								<a title="隐藏" class="close_btn"><span></span></a>
							</div>
							<div class="side_list">
								<div class="widget-header header-color-green2">
									<h4 class="lighter smaller">订单类型分类</h4>
								</div>
								<div class="widget-body">
									<ul class="b_P_Sort_list">
										<li><i class="orange  fa fa-reorder"></i><a href="#">全部订单(235)</a></li>
										<li><i class="fa fa-sticky-note pink "></i> <a href="#">食品类(235)</a></li>
										<li><i class="fa fa-sticky-note pink "></i> <a href="#">数码配件(2215)</a>
										</li>
										<li><i class="fa fa-sticky-note pink "></i> <a href="#">手机(3456)</a></li>
										<li><i class="fa fa-sticky-note pink "></i> <a href="#">电脑(4332)</a></li>
										<li><i class="fa fa-sticky-note pink "></i> <a href="#">厨房用品(1332)</a></li>
										<li><i class="fa fa-sticky-note grey "></i> <a href="#">电子产品(4543)</a></li>
										<li><i class="fa fa-sticky-note red  "></i> <a href="#">红钻会员(343)</a></li>
										<li><i class="fa fa-sticky-note blue "></i> <a href="#">家用电器(2343)</a></li>
										<li><i class="fa fa-sticky-note grey "></i> <a href="#">卫浴</a></li>
									</ul>

								</div>
							</div>
						</div>
					</div>
					<!--左侧样式-->
					<div class="list_right_style">
					
						<div class="search-form">	
							<!-- 分页和条件查询 -->
						<form action="admin/order_list" method="post" >
							<div class="search_style">
								<ul class="search_content clearfix">
									<li><label class="l_f">订单编号</label><input name="uid"
										type="text" class="text_add" value="${uid }" placeholder="订单订单编号"
										style="width: 250px"></li>
									
									<li style="width: 90px;"><button type="submit"
											class="btn_search">
											<i class="fa fa-search"></i>查询
										</button></li>
								</ul>
							</div>
							
							<!-- 页码 -->
							<input type="hidden" name="pageNo" />
							<!-- 页面大小 -->
							<input type="hidden" name="pageSize" value="${p.pageSize}" />
							
						</form>
						</div>




						<!--订单列表展示-->
						<table class="table table-striped table-bordered table-hover"
							id="sample-table">
							<thead>
								<tr>
									<th width="25px"><label><input type="checkbox"
											class="ace"><span class="lbl"></span></label></th>
									<th width="120px">订单编号</th>
									<th width="200px">购买用户名</th>
									<th width="100px">总价(￥)</th>

									<th width="150px">订单时间</th>

									<th width="150px">状态</th>
									<th width="250px">操作</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach items="${list }" var="order">
									<tr>
										<td><label><input type="checkbox" class="ace"><span
												class="lbl"></span></label></td>
										<td class="Order_uid">${order.uid }</td>
										<td>${order.user.username }</td>
										<td>${order.price }</td>
										<td>${order.time }</td>


										<c:choose>
											<c:when test="${order.order_status ==1 }">
												<td>未付款</td>
											</c:when>
											<c:when test="${order.order_status == 2  }">
												<td>未发货</td>
											</c:when>
											<c:when test="${order.order_status == 3}">
												<td>已发货</td>
											</c:when>

										</c:choose>

										<td><a href="admin/consignment" title="发货"
											class="btn btn-xs btn-success"><i
												class="fa fa-cubes bigger-120"></i></a> <a title="订单详细"
											href="admin/order_detailed?uid=${order.uid }"
											class="btn btn-xs btn-info order_detailed"><i
												class="fa fa-list bigger-120"></i></a> <a title="删除"
											href="admin/order_delete?uid=${order.uid }" onclick="Order_form_del(this,'1')"
											class="btn btn-xs btn-warning"><i
												class="fa fa-trash  bigger-120"></i></a></td>
									</tr>


								</c:forEach>


							</tbody>
						</table>

						<!--分页区  -->
						<div class="paginate">
							<span class="first"><a>首页</a></span> 
							<span class="prev"><a>上一页</a></span>
							<ul>
								<c:forEach begin="${p.navigateFirstPage }"
									end="${p.navigateLastPage }" var="pi">
									<c:choose>
										<c:when test="${pi == pageNum }">
											<li><a class="qq" href="javascript:void(0)">${pi }</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="javascript:void(0)">${pi }</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>

							</ul>
							<input type="text" id="bt" value="${p.pageNum }" /><span
								class="go">前往</span> <span class="next"><a>下一页</a></span> <span
								class="last"><a>尾页</a></span> <select>
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
	</div>
	<!--发货-->
	<div id="Delivery_stop" style="display: none">
		<div class="">
			<div class="content_style">
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-field-1">快递公司 </label>
					<div class="col-sm-9">
						<select class="form-control" id="form-field-select-1">
							<option value="">--选择快递--</option>
							<option value="1">天天快递</option>
							<option value="2">圆通快递</option>
							<option value="3">中通快递</option>
							<option value="4">顺丰快递</option>
							<option value="5">申通快递</option>
							<option value="6">邮政EMS</option>
							<option value="7">邮政小包</option>
							<option value="8">韵达快递</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-field-1"> 快递号 </label>
					<div class="col-sm-9">
						<input type="text" id="form-field-1" placeholder="快递号"
							class="col-xs-10 col-sm-5" style="margin-left: 0px;">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label no-padding-right"
						for="form-field-1">货到付款 </label>
					<div class="col-sm-9">
						<label><input name="checkbox" type="checkbox" class="ace"
							id="checkbox"><span class="lbl"></span></label>
					</div>
				</div>
			</div>
		</div>
	</div>




	<script>
 $(function() { 
	$("#cover_style").fix({
		float : 'top',
		minStatue : false,
		skin : 'green',	
		durationTime :false,
		window_height:30,//设置浏览器与div的高度值差
		spacingw:0,//
		spacingh:0,//
		close_btn:'.yingchan_btn',
		show_btn:'.xianshi_btn',
		side_list:'.hide_style',
		widgetbox:'.top_style',
		close_btn_width:60,	
		da_height:'#centent_style,.left_Treeview,.list_right_style',	
		side_title:'.b_n_btn',		
		content:null,
		left_css:'.left_Treeview,.list_right_style'
		
		
	});
});
//左侧显示隐藏
$(function() { 
	$("#covar_list").fix({
		float : 'left',
		minStatue : false,
		skin:false,	
		//durationTime :false,
		spacingw:50,//设置隐藏时的距离
	    spacingh:270,//设置显示时间距
		stylewidth:'220',
		close_btn:'.close_btn',
		show_btn:'.show_btn',
		side_list:'.side_list',
		content:'.side_content',
		widgetbox:'.widget-box',
		da_height:null,
		table_menu:'.list_right_style'
	});
});
//时间选择
 laydate({
    elem: '#start',
    event: 'focus' 
});
/*订单-删除*/
function Order_form_del(obj,id){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
	});
}
/**发货**/
function Delivery_stop(obj,id){
	layer.open({
        type: 1,
        title: '发货',
		maxmin: true, 
		shadeClose:false,
        area : ['500px' , ''],
        content:$('#Delivery_stop'),
		btn:['确定','取消'],
		yes: function(index, layero){		
		if($('#form-field-1').val()==""){
			layer.alert('快递号不能为空！',{
               title: '提示框',				
			  icon:0,		
			  }) 
			
			}else{			
			 layer.confirm('提交成功！',function(index){
		$(obj).parents("tr").find(".td-manage").prepend('<a style=" display:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="已发货"><i class="fa fa-cubes bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已发货</span>');
		$(obj).remove();
		layer.msg('已发货!',{icon: 6,time:1000});
			});  
			layer.close(index);    		  
		  }
		
		}
	})
};
//面包屑返回值
var index = parent.layer.getFrameIndex(window.name);
parent.layer.iframeAuto(index);
$('.Order_form,.order_detailed').on('click', function(){
	var cname = $(this).attr("title");
	var chref = $(this).attr("href");
	var cnames = parent.$('.Current_page').html();
	var herf = parent.$("#iframe").attr("src");
    parent.$('#parentIframe').html(cname);
    parent.$('#iframe').attr("src",chref).ready();;
	parent.$('#parentIframe').css("display","inline-block");
	parent.$('.Current_page').attr({"name":herf,"href":"javascript:void(0)"}).css({"color":"#4c8fbd","cursor":"pointer"});
	//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
    parent.layer.close(index);
	
});

//初始化宽度、高度  
  var heights=$(".top_style").outerHeight()+47; 
 $(".centent_style").height($(window).height()-heights); 
 $(".page_right_style").width($(window).width()-220);
 $(".left_Treeview,.list_right_style").height($(window).height()-heights-2); 
 $(".list_right_style").width($(window).width()-250);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".centent_style").height($(window).height()-heights); 
	 $(".page_right_style").width($(window).width()-220);
	 $(".left_Treeview,.list_right_style").height($(window).height()-heights-2);  
	 $(".list_right_style").width($(window).width()-250);
	}) 
//比例
var oldie = /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase());
			$('.easy-pie-chart.percentage').each(function(){
				$(this).easyPieChart({
					barColor: $(this).data('color'),
					trackColor: '#EEEEEE',
					scaleColor: false,
					lineCap: 'butt',
					lineWidth: 10,
					animate: oldie ? false : 1000,
					size:103
				}).css('color', $(this).data('color'));
			});
		
			$('[data-rel=tooltip]').tooltip();
			$('[data-rel=popover]').popover({html:true});
</script>
	<script>
//订单列表
jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable( {
		"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,1,2,3,4,5,6,7,8,9]}// 制定列不参与排序
		] } );
				
				
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
			
			
			
			});
</script>
</body>
</html>