
layui.use(['layer', 'form', 'admin', 'laydate', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/spend_category/add", function (data) {
            if(data.success){
                Feng.success("添加成功！");
                //传给上个页面，刷新table用
                admin.putTempData('formOk', true);
                //关掉对话框
                admin.closeThisDialog();
            }else{
                Feng.error("添加失败！" + data.responseJSON.message);
            }
        }, function (data) {
            Feng.error("添加失败！" + data.responseJSON.message)
        });
        ajax.set(data.field);
        ajax.start();
    });
});