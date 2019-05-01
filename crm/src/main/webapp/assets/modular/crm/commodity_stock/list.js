layui.use(['layer', 'table', 'ax', 'laydate', 'admin', 'form'], function () {
    var $ = layui.$;
    var $ax = layui.ax;
    var layer = layui.layer;
    var table = layui.table;
    var laydate = layui.laydate;
    var admin = layui.admin;
    var form = layui.form;


    var dataTable = {
        tableId: "dataTable"   //表格id
    };

    /**
     * 初始化表格的列
     */
    dataTable.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'stock_id', hide: true, sort: true, title: 'id'},
            {field: 'manufacturer_name', sort: true, title: '厂商名称'},
            {field: 'category_name', sort: true, title: '商品分类'},
            {field: 'commodity_name', sort: true, title: '商品名称'},
            {
                field: 'stock_category', sort: true, title: '进/退货', templet: function (d) {
                    if (d.stock_category == 'jinhuo') {
                        return "<span>进货</span>";
                    } else if (d.stock_category == 'tuihuo') {
                        return "<span>退货</span>";
                    }
                }
            },
            {field: 'unit_price', sort: true, title: '单价'},
            {field: 'amount', sort: true, title: '数量'},
            {
                field: 'amount', sort: true, title: '总价', templet: function (d) {

                    var total = parseInt(d.amount) * parseFloat(d.unit_price);
                    total=total.toFixed(2);
                    if(d.payment_status=="zuofei"){
                        if (d.stock_category == 'jinhuo') {
                            return "<span style='color: red'><s>-" + total + "</s></span>";
                        }else{
                            return "<span style='color: green'><s>" + total + "</s></span>";
                        }
                    }else{
                        if (d.stock_category == 'jinhuo') {
                            return "<span style='color: red'>-" + total + "</span>";
                        }else{
                            return "<span style='color: green'>" + total + "</span>";
                        }
                    }

                }
            },
            // {field: 'user_name', sort: true, title: '经手员工'},
            // {
            //     field: 'delete_flag', sort: true, title: '状态', templet: function (d) {
            //         if (d.delete_flag == 'Y') {
            //             return "<span>已删除</span>";
            //         } else {
            //             return "<span>正常</span>";
            //         }
            //     }
            // },
            {
                field: 'payment_status', sort: true, title: '支付状态', templet: function (d) {
                   switch (d.payment_status) {
                       case "yikaipiao" :return "已开票";// 3.
                       case "yizhifu" :return "已支付";
                       case "zuofei" :return "作废";
                   }
                   return "未知";
                }
            },
            // {field: 'create_time', sort: true, title: '创建时间'},
            {field: 'deal_date', sort: true, title: '交易日期', templet: function (d) {  return d.deal_date.substr(0,10);  }  },
            {align: 'center', toolbar: '#tableBar', title: '操作', minWidth: 200}
        ]];
    };

    // 绑定 表格上  每一行的按钮
    table.on('tool(' + dataTable.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        if (layEvent === 'edit') {
            dataTable.onEdit(data);
        } else if (layEvent === 'delete') {
            dataTable.onDelete(data);
        }
    });


    /**
     * @param data 点击按钮时候的行数据
     */
    dataTable.onEdit = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '编辑进/退货',
            area: ['1000px', '640px'],
            content: Feng.ctxPath + '/commodity_stock/view_update?stock_id=' + data.stock_id,
            end: function () {
                admin.getTempData('formOk') && table.reload(dataTable.tableId);
            }
        });
    };

    /**
     * 点击删除
     * @param data 点击按钮时候的行数据
     */
    dataTable.onDelete = function (data) {
        debugger;
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/commodity_stock/delete", function (data) {
                if (data.success) {
                    table.reload(dataTable.tableId);
                    Feng.success("删除成功!");
                } else {
                    Feng.error("删除失败!" + data.message + "!");
                }
            }, function (data) {
                debugger;
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("ids", data.stock_id);
            ajax.start();
        };
        Feng.confirm("删除不可恢复，是否删除该进/退货?", operation);
    };


    /**
     * 点击查询按钮
     */
    dataTable.search = function () {
        var queryData = {};
        queryData['category_id'] = $("#category_id").val();
        queryData['commodity_id'] = $("#commodity_id").val();

        queryData['user_id'] = $("#user_id").val();
        queryData['payment_status'] = $("#payment_status").val();
        queryData['stock_category'] = $("#stock_category").val();
        queryData['deal_date'] = $("#deal_date").val();

        queryData['manufacturer_id'] = $("#manufacturer_id").val();
        queryData['manufacturer_sales_id'] = $("#manufacturer_sales_id").val();

        table.reload(dataTable.tableId, {where: queryData});
    };

    /**
     * 弹出添加
     */
    dataTable.openAdd = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加进/退货',
            area: ['1000px', '640px'],
            content: Feng.ctxPath + '/commodity_stock/view_add',
            end: function () {
                admin.getTempData('formOk') && table.reload(dataTable.tableId);
            }
        });
    };

    // 删除日志
    dataTable.deleteBatch = function () {
        var checkRows = table.checkStatus(dataTable.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要删除的数据");
            return;
        }
        var ids = new Array();
        for (var i = 0; i < checkRows.data.length; i++) {
            ids.push(checkRows.data[i]["stock_id"]);
        }

        Feng.confirm("是否删除选中的进/退货?", function () {
            var ajax = new $ax(Feng.ctxPath + "/commodity_stock/delete", function (data) {
                Feng.success("删除进/退货成功!");
                dataTable.search();
            }, function (data) {
                Feng.error("删除进/退货失败!");
            });
            ajax.set("ids", ids.join(','));
            ajax.start();
        });
    };

    //渲染时间选择框
    laydate.render({
        elem: '#deal_date'
    });

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + dataTable.tableId,
        url: Feng.ctxPath + '/commodity_stock/listdata',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: dataTable.initColumn()
    });
    // 添加按钮点击事件
    $('#btnAdd').click(function () {
        dataTable.openAdd();
    });
    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        dataTable.search();
    });

    // 搜索按钮点击事件
    $('#btnDeleteBatch').click(function () {
        dataTable.deleteBatch();
    });

    $('#btnImportBatch').click(function () {
        dataTable.OpenimportData();
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


    initSelect("省份", "province", 100000, 1);

    initSelect("商品分类", "category_id", undefined, 0, "", Feng.ctxPath + "/commodity_category/select");
    form.on('select(category_id)', function (data) {
        clear_select("commodity_id");
        initSelect("商品名称", "commodity_id", data.value, 0, "", Feng.ctxPath + "/commodity/select");
    });

    // initSelect("经手员工", "user_id", undefined, 1, undefined, Feng.ctxPath + "/extuser/select");

    initSelect("支付状态", "payment_status", undefined, 1, undefined, Feng.ctxPath + "/extdict/list?pcode=payment_status");
    initSelect("进/出货", "stock_category", undefined, 1, undefined, Feng.ctxPath + "/extdict/list?pcode=stock_category");



});
