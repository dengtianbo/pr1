$(function(){
	//跳转购物车
	$(".buy_in").click(function(){
		var id=$(".goods_id").val();
		console.log(id);
		var number =$(".n_ipt").val();
		console.log(number);
		
		$.ajax({
			 url: ctx + "/client/buycar_add",
            method: "post",
            data: {
                id: id,
				number:number
            },
            dataType: "json",
            traditional: true
			
		});
		
		//location.href=ctx+"/client/buycar_add?id="+id+"&&number="+number;
	});
	
});