/**
 * 页面初始化
 */
$(document).ready(function(){

}) ;

/**
 * 执行登录
 */
function doLogin(){
    var userId = $("#userId").val();
    var password = $("#password").val();
    if(userId.length==0){
        layer.msg("请输入用户名");
        return;
    }
    if(password.length==0){
        layer.msg("请输入密码");
        return;
    }
    var mask = layer.load(0, {shade: false});
    $.ajax({
        url:"/checkLogin",
        data:{userId:userId,password:password},
        method:"post",
        success:function(res){
            if(res.code!=200){
                layer.msg(res.msg, {icon: 5});
            }else {
                window.location.href="/homePage";
            }
        },
        complete:function(){
            layer.close(mask);
        }
    })
}