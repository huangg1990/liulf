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
            {field: 'spend_id', hide: true, sort: true, title: 'id'},
            {field: 'spend_category_name', sort: true, title: '分类名称'},
            {field: 'price', sort: true, title: '金额'},
            {field: 'spend_date', sort: true, title: '支出日期'},
            {field: 'user_name', sort: true, title: '经手人'},
            {field: 'delete_flag', sort: true, title: '状态',templet: function (d) {
                if(d.delete_flag =='Y'){  return "<span>已删除</span>";  }else{ return "<span>正常</span>"; }
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
            title: '编辑支出',
            area: ['800px', '640px'],
            content: Feng.ctxPath + '/spend/view_update?spend_id=' + data.spend_id,
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
            var ajax = new $ax(Feng.ctxPath + "/spend/delete", function (data) {
                if(data.success){
                    table.reload(dataTable.tableId);
                    Feng.success("删除成功!");
                }else{
                    Feng.error("删除失败!" + data.message + "!");
                }
            }, function (data) {
                debugger;
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("ids", data.spend_id);
            ajax.start();
        };
        Feng.confirm("删除不可恢复，是否删除该支出?", operation);
    };


    /**
     * 点击查询按钮
     */
    dataTable.search = function () {
        var queryData = {};
        queryData['spend_category_id'] = $("#spend_category_id").val();
        queryData['spend_date'] = $("#spend_date").val();
        queryData['user_id'] = $("#user_id").val();
        table.reload(dataTable.tableId, {where: queryData});
    };

    /**
     * 弹出添加
     */
    dataTable.openAdd = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加支出',
            area: ['800px', '640px'],
            content: Feng.ctxPath + '/spend/view_add',
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
            ids.push(checkRows.data[i]["spend_id"]);
        }

        Feng.confirm("是否删除选中的支出?", function () {
            var ajax = new $ax(Feng.ctxPath + "/spend/delete", function (data) {
                Feng.success("删除支出成功!");
                dataTable.search();
            }, function (data) {
                Feng.error("删除支出失败!");
            });
            ajax.set("ids", ids.join(','));
            ajax.start();
        });
    };

    //渲染时间选择框
    laydate.render({
        elem: '#spend_date'
    });

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + dataTable.tableId,
        url: Feng.ctxPath + '/spend/listdata',
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

    initSelect("支出分类","spend_category_id", undefined,1, undefined, Feng.ctxPath +"/spend_category/select");
    initSelect("经手员工","user_id", undefined,1, undefined, Feng.ctxPath +"/extuser/select");
});
