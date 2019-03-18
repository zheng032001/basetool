/**
 * 页面初始化
 */
$(document).ready(function(){
    layui.config({
        dir:"/static/plugins/layuiadmin/",
        debug:true
    }).extend({
        index:"/static/plugins/layuiadmin/lib/index",
        view:"/static/plugins/layuiadmin/lib/view",
        admin:"/static/plugins/layuiadmin/lib/admin"
    }).use(["view","admin","index"]);
    // layer.msg("这是一个弹框消息",{
    //     btn:["好嘞","弄啥嘞"]
    // });
}) ;