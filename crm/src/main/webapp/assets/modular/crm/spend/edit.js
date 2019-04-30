
layui.use(['layer', 'form', 'admin',  'laydate', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;

    //获取信息
    var ajax = new $ax(Feng.ctxPath + "/spend/detail/" + Feng.getUrlParam("spend_id"));
    var result = ajax.start();

    debugger
    result.spend_date=result.spend_date.substr(0,10);
    form.val('editForm', result);
    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var regex=/^[0-9]+([.]{1}[0-9]{1,2})?$/;
        if(!regex.test(data.field.price)){
            Feng.error("支出金额格式错误,最多支持2为小数");
            return false;
        }
        var ajax = new $ax(Feng.ctxPath + "/spend/update", function (data) {
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

    // ==========================省市级联========================== //
    var initSelect = function (title,id, pid, levelType,selectval,url) {
        $("#" + id).find("option").remove();
        var ctobj=document.getElementById(id);
        ctobj.options.add(new Option("请选择"+title,"",true,true));
        if (url == undefined) {  url="/sys_city/listdata";  }
        $.post(url, {pid: pid, levelType: levelType},
            function (rs) {
                if (rs.data.length <= 0) { return; }
                for (var i = 0; i < rs.data.length; i++) {
                    if(selectval==rs.data[i].value){
                        ctobj.options.add(new Option(rs.data[i].name,rs.data[i].value,true,true)); //这个兼容IE与firefox
                    }else{
                        ctobj.options.add(new Option(rs.data[i].name,rs.data[i].value)); //这个兼容IE与firefox
                    }
                }
                form.render();
            });
    };
    //渲染时间选择框
    laydate.render({
        elem: '#spend_date'
    });
    initSelect("支出分类","spend_category_id", undefined,1, result.spend_category_id, Feng.ctxPath +"/spend_category/select");
    initSelect("经手员工","user_id", undefined,1, result.user_id, Feng.ctxPath +"/extuser/select");
});