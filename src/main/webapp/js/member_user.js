$(function(){
	console.log("1111111");
	//显示头像
	var url = $(".portrait-pic").data("portrait");
	
	$(".portrait-pic").attr("src",url);
	
	
	
		//鼠标滑过，显示头像
	
	$(".portrait-pic").hover(function() {
		console.log("1111");
		var pos = $(this).offset();
		console.log(pos);
		var lft = pos.left + $(this).width();
		console.log(lft);
		 url = $(this).data("portrait");//获取头像路径
		console.log(url);
		$("<div>").addClass("portrait").css({
			top: pos.top + "px",
			left: lft + "px",
			background: "#fff url(" + url + ") no-repeat center center/cover"
		}).appendTo(document.body);

	}, function() {
		$(".portrait").remove();
	});

});