$(function(){
	$("#sub_btn").click(function(){
		var price=$("#price").text();
		console.log(price);
		var ids=[];
		var checked = $(".idd");//类数组
		//选中的td的所有id
		checked.each(function() {
			ids.push($(this).text());
		});
		console.log(ids);
		layer.confirm("是否确认支付", function(index){
			
		
		location.href = ctx + "/client/order_add?price="+price;
		//关闭对话框
		layer.close(index);	
		});
		
	});
	
	
});