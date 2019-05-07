/**
 * 页面初始化
 */
$(document).ready(function(){
    layui.table.on("sort(test)",function(obj){
        layui.table.reload("test",{
            where:{field:obj.field,order:obj.type}
        });
    })
}) ;

/**
 * 查询
 */
var history_query_data = null;
function doQuery(){
    var data = {
        userId:$("#userId").val(),
        userName:$("#userName").val()
    };
    history_query_data = data;
    layui.table.reload("test",{
        url:'/getUserList',
        where : data
    });
}
