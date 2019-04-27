layui.use(['layer', 'table', 'ax', 'laydate', 'admin','form'], function () {
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
            {field: 'commodity_id', hide: true, sort: true, title: 'id'},
            {field: 'category_name', sort: true, title: '分类名称'},
            {field: 'commodity_code', sort: true, title: '商品编码'},
            {field: 'commodity_name', sort: true, title: '商品名称'},
            {field: 'delete_flag', sort: true, title: '状态',templet: function (d) {
                if(d.delete_flag =='Y'){  return "<span>已作废</span>";  }else{ return "<span>正常</span>"; }
             } },
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
        }
    });


    /**
     * @param data 点击按钮时候的行数据
     */
    dataTable.onEdit = function (data) {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '编辑商品',
            area: ['800px', '440px'],
            content: Feng.ctxPath + '/commodity/edit?commodity_id=' + data.commodity_id,
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
            var ajax = new $ax(Feng.ctxPath + "/commodity/delete", function (data) {
                if(data.success){
                    table.reload(dataTable.tableId);
                    Feng.success("作废成功!");
                }else{
                    Feng.error("作废失败!" + data.message + "!");
                }
            }, function (data) {
                debugger;
                Feng.error("作废失败!" + data.responseJSON.message + "!");
            });
            ajax.set("ids", data.commodity_id);
            ajax.start();
        };
        Feng.confirm("是否作废【" + data.commodity_name + "】商品?", operation);
    };


    /**
     * 点击查询按钮
     */
    dataTable.search = function () {
        var queryData = {};
        queryData['commodity_name'] = $("#commodity_name").val();
        queryData['commodity_code'] = $("#commodity_code").val();
        queryData['category_id'] = $("#category_id").val();
        table.reload(dataTable.tableId, {where: queryData});
    };

    /**
     * 弹出添加
     */
    dataTable.openAdd = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加商品',
            area: ['800px', '440px'],
            content: Feng.ctxPath + '/commodity/add',
            end: function () {
                admin.getTempData('formOk') && table.reload(dataTable.tableId);
            }
        });
    };

    // 删除日志
    dataTable.deleteBatch = function () {
        var checkRows = table.checkStatus(dataTable.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要作废的数据");
            return;
        }
        var ids = new Array();
        for (var i = 0; i < checkRows.data.length; i++) {
            ids.push(checkRows.data[i]["commodity_id"]);
        }

        Feng.confirm("是否作废选中的商品?", function () {
            var ajax = new $ax(Feng.ctxPath + "/commodity/delete", function (data) {
                Feng.success("作废商品成功!");
                dataTable.search();
            }, function (data) {
                Feng.error("作废商品失败!");
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
        url: Feng.ctxPath + '/commodity/listdata',
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

    initSelect("商品分类","category_id", undefined, 0,"",Feng.ctxPath +"/commodity_category/select");
});
