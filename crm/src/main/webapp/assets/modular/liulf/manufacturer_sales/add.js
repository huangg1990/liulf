
layui.use(['layer', 'form', 'admin', 'laydate', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;

    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var ajax = new $ax(Feng.ctxPath + "/manufacturer_sales/add", function (data) {
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

        var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;//手机号码
        var isMob= /^0?1[3|4|5|8][0-9]\d{8}$/;// 座机格式
        if(!isPhone.test( data.field.sales_phone) && !isMob.test(data.field.sales_phone)){
            Feng.error(" 固定电话或手机 格式有误！");
            return false;
        }

        ajax.set(data.field);
        ajax.start();
    });

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

    var clear_select=function(id){
        $("#"+id).find("option").remove();
        form.render();
    };

    initSelect("省份", "province", 100000, 1,"340000");
    initSelect("市","city", "340000", 2,"");
    form.on('select(province)', function(data){
        clear_select("city");
        clear_select("area");
        clear_select("manufacturer_id");
        initSelect("城市","city",data.value,2);
    });
    form.on('select(city)', function(data){
        clear_select("area");
        clear_select("manufacturer_id");
        initSelect("县/区","area",data.value,3);
    });
    form.on('select(area)', function (data) {
        clear_select("manufacturer_id");
        initSelect("厂商","manufacturer_id", data.value,4, undefined, Feng.ctxPath +"/manufacturer/select");
    });

    $("#province").trigger("change");
});