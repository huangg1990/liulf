
layui.use(['layer', 'form', 'admin',  'laydate', 'ax'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;

    // 表单提交事件
    form.on('submit(btnSubmit)', function (data) {
        var regex=/^[0-9]+([.]{1}[0-9]{1,2})?$/;
        if(!regex.test(data.field.unit_price)){
            Feng.error("单价格式错误,最多支持2位小数");
            return false;
        }
        regex=/^[1-9]\d*$/;
        if(!regex.test(data.field.amount)|| data.field.amount<=0 || data.field.amount>=99999){
            Feng.error("数量格式错误,只支持正整数。区间1-99999");
            return false;
        }
        var ajax = new $ax(Feng.ctxPath + "/commodity_stock/add", function (data) {
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
    var clear_select = function (id) {
        $("#" + id).find("option").remove();
        form.render();
    };

    //渲染时间选择框
    laydate.render({
        elem: '#deal_date'
    });

    form.on('select(province)', function (data) {
        clear_select("city");
        clear_select("area");
        clear_select("manufacturer_id");
        clear_select("manufacturer_sales_id");
        initSelect("城市", "city", data.value, 2);
    });
    form.on('select(city)', function (data) {
        clear_select("area");
        clear_select("manufacturer_id");
        clear_select("manufacturer_sales_id");
        initSelect("县/区", "area", data.value, 3);
    });
    form.on('select(area)', function (data) {
        clear_select("manufacturer_id");
        clear_select("manufacturer_sales_id");
        initSelect("厂商", "manufacturer_id", data.value, 4, undefined, Feng.ctxPath + "/manufacturer/select");
    });

    form.on('select(manufacturer_id)', function (data) {
        clear_select("manufacturer_sales_id");
        initSelect("厂商业务员", "manufacturer_sales_id", data.value, 4, undefined, Feng.ctxPath + "/manufacturer_sales/select");
    });
    initSelect("商品分类", "category_id", undefined, 0, "", Feng.ctxPath + "/commodity_category/select");
    form.on('select(category_id)', function (data) {
        clear_select("commodity_id");
        initSelect("商品名称", "commodity_id", data.value, 0, "", Feng.ctxPath + "/commodity/select");
    });
    initSelect("省份", "province", 100000, 1,"340000");
    initSelect("市","city", "340000", 2,"");
    initSelect("经手员工", "user_id", undefined, 1, undefined, Feng.ctxPath + "/extuser/select");

    initSelect("支付状态", "payment_status", undefined, 1, undefined, Feng.ctxPath + "/extdict/list?pcode=payment_status");
    initSelect("进/出货", "stock_category", undefined, 1, undefined, Feng.ctxPath + "/extdict/list?pcode=stock_category");

    $("#province").trigger("change");
});