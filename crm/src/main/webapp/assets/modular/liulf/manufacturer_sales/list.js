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

    dataTable.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'sales_id', hide: true, sort: true, title: 'id'},
            {field: 'sales_name', sort: true, title: '厂商业务员姓名'},
            {field: 'province', sort: true, title: '省份'},
            {field: 'city', sort: true, title: '市'},
            {field: 'area', sort: true, title: '区/县'},
            {field: 'manufacturer_name', sort: true, title: '所属厂商'},
            {field: 'sales_phone', sort: true, title: '厂商业务员电话'},
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
            title: '编辑厂商业务员',
            area: ['800px', '640px'],
            content: Feng.ctxPath + '/manufacturer_sales/view_update?sales_id=' + data.sales_id,
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
            var ajax = new $ax(Feng.ctxPath + "/manufacturer_sales/delete", function (data) {
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
            ajax.set("ids", data.sales_id);
            ajax.start();
        };
        Feng.confirm("是否删除【" + data.sales_name + "】厂商业务员?", operation);
    };

    /**
     * 点击查询按钮
     */
    dataTable.search = function () {
        var queryData = {};
        queryData['sales_name'] = $("#sales_name").val();
        queryData['province'] = $("#province").val();
        queryData['city'] = $("#city").val();
        queryData['area'] = $("#area").val();
        queryData['sales_phone'] = $("#sales_phone").val();
        table.reload(dataTable.tableId, {where: queryData});
    };

    /**
     * 弹出添加
     */
    dataTable.openAdd = function () {
        admin.putTempData('formOk', false);
        top.layui.admin.open({
            type: 2,
            title: '添加厂商业务员',
            area: ['800px', '640px'],
            content: Feng.ctxPath + '/manufacturer_sales/view_add',
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
            ids.push(checkRows.data[i]["sales_id"]);
        }

        Feng.confirm("是否删除选中的厂商业务员?", function () {
            var ajax = new $ax(Feng.ctxPath + "/manufacturer_sales/delete", function (data) {
                Feng.success("删除厂商业务员成功!");
                dataTable.search();
            }, function (data) {
                Feng.error("删除厂商业务员失败!");
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
        url: Feng.ctxPath + '/manufacturer_sales/listdata',
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

    var clear_select=function(id){
        $("#"+id).find("option").remove();
        form.render();
    };

    initSelect("省份","province", 100000, 1); //


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
    // ==========================省市级联========================== //
});
