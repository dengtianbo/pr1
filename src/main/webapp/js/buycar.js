$(function() {

	//全选
	$("#quan").click(function() {

		var $quan = $("#quan");
		var $bts = $(".bt");
		if (this.checked == false) {
			for (var i = 0; i < $bts.length; i++) {
				$bts[i].checked = false;
				price();
			}
		} else {
			for (var i = 0; i < $bts.length; i++) {
				$bts[i].checked = true;
				price();
			}
		}
	});

	//单选
	$(".bt").click(function() {
		price();

	});
	//数量变化计算总价
	$(".car_ipt").change(function() {
		price();

	});
	//点击+ - 计算价格
	$(".car_btn_1").click(function() {
		price();

	});
	$(".car_btn_2").click(function() {
		price();

	});

	//计算价格
	function price() {
		var p = 0;
		var $btn = $(".bt");
		var $pr = $(".pr");
		var $num = $(".car_ipt");
		for (var i = 0; i < $pr.length; i++) {
			console.log($pr[i].innerHTML);
			var s = +$pr[i].innerHTML;
			var number = +$num[i].value;
			console.log(number);


			if ($btn[i].checked == true) {
				p += s * number;
			}
		}
		$price = $("#price");
		$price[0].innerHTML = p;
	};

	//购物车批量删除
	$(".r_txt").click(function() {
		console.log("111");
		var ids = [];
		var checked = $(".table tr>td :checked").parent().parent().children(".tt");//类数组
		//console.log($(".table tr>td :checked").value);
		//选中的td的所有id
		checked.each(function() {
			ids.push($(this).text());
		});
		console.log(ids);
		//校验
		if (ids.length === 0) {
			layer.alert("请选中您要删除的记录");
		} else {
			layer.confirm("是否确认删除您选中的记录", function(index) {
				//index是对话框的句柄，唯一的标识一个对话框
				//使用jquery发送ajax请求
				$.ajax({
					url: ctx + "/client/buycar_delete",
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

	//购物车单击删除
	$(".delete_bt").click(function() {
		console.log("111");
		var ids = [];
		var checked = $(this).parent().parent().children(".tt");//类数组
		//console.log($(".table tr>td :checked").value);
		//选中的td的所有id
		checked.each(function() {
			ids.push($(this).text());
		});
		console.log(ids);
		//校验
		if (ids.length === 0) {
			layer.alert("请选中您要删除的记录");
		} else {
			layer.confirm("是否确认删除您选中的记录", function(index) {
				//index是对话框的句柄，唯一的标识一个对话框
				//使用jquery发送ajax请求
				$.ajax({
					url: ctx + "/client/buycar_delete",
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

	//购买
	$(".submit_indent").click(function() {
		var ids = [];
		var checked =  $(".table tr>td :checked").parent().parent().children(".tt");//类数组
		//console.log($(".table tr>td :checked").value);
		//选中的td的所有id
		checked.each(function() {
			ids.push($(this).text());
		});
		console.log(ids);
		
		//对应的数量
		var nums = [];
		var checked1 =  $(".table tr>td :checked").parent().parent().children(".numb").find(".car_ipt");//类数组
		//console.log($(".table tr>td :checked").value);
		//选中的td的所有id
		checked1.each(function() {
			nums.push($(this).val());
		});
		console.log(nums);
		
		
		
		var v = $("#price").text();
		console.log(v);
		if (v == 0) {
			layer.alert("请选中您要购买的商品");
		} else {
			$.ajax({
				url: ctx + "/client/indent",
				method: "post",
				data: {
					ids: ids,
					nums: nums
				},
				dataType: "json",
				traditional: true
				
			})


			location.href = ctx + "/client/indent?price="+v;
		}
	});





});