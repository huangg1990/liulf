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
     * 初始化表格的列 客户
     */
    dataTable.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'customer_id', hide: true, sort: true, title: 'id'},
            {field: 'customer_name', sort: true, title: '客户姓名'},
            {field: 'province', sort: true, title: '省份'},
            {field: 'city', sort: true, title: '市'},
            {field: 'area', sort: true, title: '区/县'},
            {field: 'customer_phone', sort: true, title: '电话'},
            {field: 'customer_car_card', sort: true, title: '车牌号码'},
            {
                field: 'delete_flag', sort: true, title: '状态', templet: function (d) {
                    if (d.delete_flag == 'Y') {
                        return "<span>已删除</span>";
                    } else {
                        return "<span>正常</span>";
                    }
                }
            },
            {field: 'create_time', sort: true, title: '创建时间'},
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
        } else if (layEvent === 'add_cell') {
            dataTable.onAddCell(data);
        }
    });

    /**
     * @param data 点击按钮时候的行数据
     */
    dataTable.onAddCell = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '出货【'+data.customer_name+"】",
            area: ['1000px', '640px'],
            content: Feng.ctxPath + '/commodity_sell/view_add?customer_id='+data.customer_id+"&customer_name="+encodeURI(data.customer_name),
            end: function () {
                admin.getTempData('formOk') && table.reload(dataTable.tableId);
            }
        });
    };

    /**
     * @param data 点击按钮时候的行数据
     */
    dataTable.onEdit = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '编辑客户',
            area: ['800px', '640px'],
            content: Feng.ctxPath + '/customer/view_update?customer_id=' + data.customer_id,
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
            var ajax = new $ax(Feng.ctxPath + "/customer/delete", function (data) {
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
            ajax.set("ids", data.customer_id);
            ajax.start();
        };
        Feng.confirm("是否删除【" + data.customer_name + "】客户?", operation);
    };

    /**
     * 点击查询按钮
     */
    dataTable.search = function () {
        var queryData = {};
        queryData['customer_name'] = $("#customer_name").val();
        queryData['province'] = $("#province").val();
        queryData['city'] = $("#city").val();
        queryData['area'] = $("#area").val();
        queryData['customer_phone'] = $("#customer_phone").val();
        queryData['customer_car_card'] = $("#customer_car_card").val();
        table.reload(dataTable.tableId, {where: queryData});
    };

    /**
     * 弹出添加
     */
    dataTable.openAdd = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加客户',
            area: ['800px', '640px'],
            content: Feng.ctxPath + '/customer/view_add',
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
            ids.push(checkRows.data[i]["customer_id"]);
        }

        Feng.confirm("是否删除选中的客户?", function () {
            var ajax = new $ax(Feng.ctxPath + "/customer/delete", function (data) {
                Feng.success("删除客户成功!");
                dataTable.search();
            }, function (data) {
                Feng.error("删除客户失败!");
            });
            ajax.set("ids", ids.join(','));
            ajax.start();
        });
    };

    //渲染时间选择框
    laydate.render({
        elem: '#beginTime'
    });

    //渲染时间选择框
    laydate.render({
        elem: '#endTime'
    });

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + dataTable.tableId,
        url: Feng.ctxPath + '/customer/listdata',
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
    var initSelect = function (title, id, pid, levelType, selectval, url) {
        $("#" + id).find("option").remove();
        var ctobj = document.getElementById(id);
        ctobj.options.add(new Option("请选择" + title, "", true, true));
        if (url == undefined) {
            url = "/sys_city/listdata";
        }
        $.post(url, {pid: pid, levelType: levelType},
            function (rs) {
                if (rs.data.length <= 0) {
                    return;
                }
                for (var i = 0; i < rs.data.length; i++) {
                    if (selectval == rs.data[i].value) {
                        ctobj.options.add(new Option(rs.data[i].name, rs.data[i].value, true, true)); //这个兼容IE与firefox
                    } else {
                        ctobj.options.add(new Option(rs.data[i].name, rs.data[i].value)); //这个兼容IE与firefox
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
        initSelect("", "city", data.value, 2);
    });
    form.on('select(city)', function (data) {
        clear_select("area");
        initSelect("", "area", data.value, 3);
    });
    initSelect("省份", "province", 100000, 1,"340000");
    initSelect("市","city", "340000", 2,"");
    initSelect("性别", "gender", undefined, 0, "", Feng.ctxPath + "/extdict/list?pcode=SEX");
    // ==========================省市级联========================== //


});
