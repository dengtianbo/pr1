$(function(){
	
	//页面大小下拉框赋值
	$(".paginate>select").val(pageSize);

	//分页条相关事件处理
	$(".paginate>span").click(function() {
		console.log("111111111");
		var me = $(this);
		if (me.is(".first")) { //首页
			$(".search-form [name=pageNo]").val(1);
		} else if (me.is(".last")) { //尾页
			//总
			$(".search-form [name=pageNo]").val(parseInt(pages));
			console.log(pages);
		} else if (me.is(".prev")) { //上一页
			//当前页
			pageNo = parseInt(pageNo) - 1;
			if (isNaN(pageNo)||pageNo < 1) {
				pageNo = 1;
			}
			$(".search-form [name=pageNo]").val(pageNo);
		} else if (me.is(".next")) { //下一页
			//当前页
			pageNo = parseInt(pageNo) + 1;
			if (pageNo > pages) {
				pageNo = pages;
			}
			$(".search-form [name=pageNo]").val(pageNo);


		} else if (me.is(".go")) {//前往
			var n = parseInt($(".paginate>#bt").val());
			if (!(n >= 1 && n <= pages)) {
				n = 1;
			}
			$(".search-form [name=pageNo]").val(n);
		}

		//提交表单
		$(".search-form form").submit();
		
	});


	//点击页数
	$(".paginate>ul>li").click(function() {
		var me = $(this);
		var n = parseInt(me.text());
		$(".search-form [name=pageNo]").val(n);
		console.log("111111111");
		//提交表单
		$(".search-form form").submit();
	});

	//页面大小下拉框改变事件
	$(".paginate>select").change(function() {
		var ps = $(this).val();
		$(".search-form form>[name=pageSize]").val(ps);
		//提交表单
		$(".search-form form").submit();
	});
	
	
	//发货
	console.log("aaaa");
	$(".btn-success").click(function(){
			console.log("bbb");
		var uid=$(this).parent().parent().children(".Order_uid").text();
		console.log(uid);
		
		location.href=ctx+"/admin/consignment?uid="+uid;
	});
	
	//订单详情
	
	
	
});