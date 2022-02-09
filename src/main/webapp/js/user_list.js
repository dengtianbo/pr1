$(function() {
	//有错误则显示
	if (error) {
		layer.alert(error);
	}
	/*//日期范围
	laydate.render({
		elem: "#birthdayRange",
		range: true
	});*/

	//页面大小下拉框赋值
	$(".paginate>select").val(pageSize);

	//分页条相关事件处理
	$(".paginate>span").click(function() {
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

	

	//ajax批量删除按钮操作
    $(".btn-danger").click(function() {
        var ids = [];
        var checked = $(".table tr>td :checked").parent().parent().next();//类数组
		//选中的td的所有id
        checked.each(function() {
            ids.push($(this).text());
        });
        //校验
        if (ids.length === 0) {
            layer.alert("请选中您要删除的记录");
        } else {
            layer.confirm("是否确认删除您选中的记录", function(index) {
                //index是对话框的句柄，唯一的标识一个对话框
                //使用jquery发送ajax请求
                $.ajax({
                    url: ctx + "/admin/userdelete",
                    method: "post",
                    data: {
                        ids: ids
                    },
                    dataType: "json",
                    traditional: true,
                    success: function(resp) {
                        //表示当请求成功之后的回调函数
                        if (resp.success) {
                            layer.msg("成功删除" + resp.rows + "条记录");
                            checked.parent().remove();
                        } else {
                            layer.alert(error || "删除失败");
                        }
                    }
                });
                //关闭对话框
                layer.close(index);
            });
        }
	});
	
	//ajax删除按钮操作
	 $(".btn-warning").click(function() {
        var ids = [];
        var ch = $(this).parent().parent().children(".idd");//类数组
		//选中的td的所有id
         ch.each(function() {
            ids.push($(this).text());
        });
		console.log(ch);
		console.log(ids);
        //校验
        if (ids.length === 0) {
            layer.alert("请选中您要删除的记录");
        } else {
            layer.confirm("是否确认删除您选中的记录", function(index) {
                //index是对话框的句柄，唯一的标识一个对话框
                //使用jquery发送ajax请求
                $.ajax({
                    url: ctx + "/admin/good_delete",
                    method: "post",
                    data: {
                        ids: ids
                    },
                    dataType: "json",
                    traditional: true,
                    success: function(resp) {
                        //表示当请求成功之后的回调函数
                        if (resp.success) {
                            layer.msg("成功删除" + resp.rows + "条记录");
                            ch.parent().remove();
                        } else {
                            layer.alert(error || "删除失败");
                        }
                    }
                });
                //关闭对话框
                layer.close(index);
            });
        }
	});
	
	
	//添加按钮
	$("#member_add").click(function() {
		location.href = ctx + "/admin/useradd";
	});
	
	
	
	//点击修改按钮
	$(".btn-info").click(function() {
		var ids = [];
		var checked = $(this).parent().parent().children(".idd");//类数组

		checked.each(function() {
			ids.push($(this).text());
		});

		//校验
		if (ids.length === 0) {
			layer.alert("请选中您要修改的记录");
		} else if (ids.length > 1) {
			layer.alert("您一次只能修改一条记录");
		} else {
			var id = ids.pop();
			location.href = ctx + "/admin/useredit?id=" + id;
		}
	});
	
	//搜索按钮
	$(".btn_search").click(function() {
		$(".search-form form").submit();
	});
	

	//鼠标滑过，显示头像
	$("#tbl tr>td:nth-child(2)").hover(function() {
		var pos = $(this).offset();
		var lft = pos.left + $(this).width();
		var url = $(this).data("portrait");//获取头像路径

		$("<div>").addClass("portrait").css({
			top: pos.top + "px",
			left: lft + "px",
			background: "#fff url(" + url + ") no-repeat center center/cover"
		}).appendTo(document.body);

	}, function() {
		$(".portrait").remove();
	});


});