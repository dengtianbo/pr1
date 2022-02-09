$(function() {
	//地址
	$(".addre").change(function() {

		var a1 = $(".addre1").val();
		var a2 = $(".addre2").val();
		var a3=$(".addre3").val();
		console.log(a1);
		console.log(a2);
		console.log(a3);
		var a = a1 + a2 + a3;
		console.log(a);
		$(".address_tt").val(a);
		console.log($(".address_tt").val());
	});

	//修改
	$(".update_btn").click(function() {
		var addre = {};

		var id=$("#id").val();
		addre.id = id;
		console.log(id);
		var address = $(".address_tt").val();
		addre.address = address;
		console.log(address);
		var details_address = $(".details_address").val();
		addre.details_address = details_address;
		console.log(details_address);
		var name = $(".username").val();
		addre.name=name;
		console.log(name);
		var phone=$(".phone").val();
		addre.phone = phone;
		console.log(phone);
		var email = $(".email").val();
		addre.email = email;
		console.log(email);

		console.log(addre);

		

		$.ajax({
			url: ctx + "/client/address_update",
			method: "post",
			data: {
				addre: addre
			},
			dataType: "json",
			traditional: true,
			success: function(resp) {
				//表示当请求成功之后的回调函数
				if (resp.success) {
					layer.msg("成功修改" + resp.rows + "条记录");
					var ch=$(".addreid");
					for(var i=0;i<ch.length;i++){
						if(ch[i].val()==id){
							$(this).parent().parent().remove();
						}
						
					}
					
					
				} else {
					layer.alert( "修改失败");
				}
			}
		})



	});


	//删除
	$(".detele_btn").click(function() {
			var id=$("#id").val();
		location.href=ctx+"/client/address_detele?id="+id;
	});
	
	//设置默认地址
	$(".menren").click(function() {
	 var address=$(this).parent().parent().parent().children().children(".bb1");
		
		console.log(address.text());
		var details_address = $(this).parent().parent().parent().children().children(".bb2");
		console.log(details_address.text());
		var a=address.text()+details_address.text();
		console.log(a);
		location.href=ctx+"/client/user_address?address="+a;
	});
	
	
});