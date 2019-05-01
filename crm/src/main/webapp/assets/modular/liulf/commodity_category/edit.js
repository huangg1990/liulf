
layui.use(['layer', 'form', 'admin', 'laydate', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var layer = layui.layer;

    //获取信息
    var ajax = new $ax(Feng.ctxPath + "/commodity_category/detail/" + Feng.getUrlParam("category_id"));
    var result = ajax.start();

    debugger
    form.val('editForm', result);
    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/commodity_category/update", function (data) {
            if(data.success){
                Feng.success("操作成功！");
                //传给上个页面，刷新table用
                admin.putTempData('formOk', true);
                //关掉对话框
                admin.closeThisDialog();
            }else{
                Feng.error("操作失败！" + data.responseJSON.message);
            }
        }, function (data) {
            Feng.error("操作成功！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();
    });
});