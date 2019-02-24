var TT = TAOTAO = {
	checkLogin : function(){
		var _ticket = $.cookie("TT_TOKEN");
		if(!_ticket){
			return ;
		}
		$.ajax({
            url: "http://localhost:8085/user/token/" + _ticket,
			dataType : "jsonp",
			type : "GET",
			success : function(data){
				if(data.status == 200){
					var username = data.data.username;
                    // var html = username + "，欢迎来到淘淘！<a onclick=\"location.reload()\"  href=\"http://localhost:8085/user/logout/"+"_ticket"+"&callback=/"+"\" class=\"link-logout\">[退出]</a>";
                    // var html = username + "，欢迎来到淘淘！<a onclick=\"location.reload()\"  target='_blank' href=\"http://localhost:8085/user/logout/"+"_ticket"+"&callback=/"+"\" class=\"link-logout\">[退出]</a>";
                    var html = username + "，欢迎来到淘淘！<a onclick='logout()'  target='_blank' href='javascript:void(0);' class='link-logout'>[退出]</a>";
					$("#loginbar").html(html);
				}
			}
		});
	}
};

function logout() {
    var _ticket = $.cookie("TT_TOKEN");
    $.ajax({
        url: "http://localhost:8085/user/logout/" + _ticket + "&callback=/",
        dataType: "jsonp",
        type: "GET",
        success: function (data) {
        }
    });
    location.reload();
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	TT.checkLogin();
});