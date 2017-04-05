<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>CMSDemo|页面管理</title>
    <jsp:include page="include/commonfile.jsp"/>
    <%--开始引入bootstrap-table--%>
    <link href="${ctx}/static/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <script src="${ctx}/static/plugins/bootstrap-table/bootstrap-table.js"></script>
    <script src="${ctx}/static/plugins/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <%--结束引入bootstrap-table--%>
    <%--开始引入layer--%>
    <script src="${ctx}/static/plugins/layer/layer.js"></script>
    <%--结束引入layer--%>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<jsp:include page="include/sidebar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">页面管理</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">权限管理</li>
        </ol>
    </div><!--/.row-->
    <br>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-primary">
                <div class="panel-heading"></div>
                <div class="panel-body">
                    <table  id="pageTable" data-toggle="table" >
                        <thead>
                        <tr>
                            <%--data-field的值为pojo类的属性值，不是数据库字段--%>
                            <th data-field="username" >用户名</th>
                            <th data-field="roleName">权限名</th>
                            <th data-field="action" data-formatter="actionFormatter" data-events="actionEvents">操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>

            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function initTable() {
        //先销毁表格
        $('#pageTable').bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        $('#pageTable').bootstrapTable({
            method: "get",  //使用post请求到服务器获取数据
            url: "/permission/list", //获取数据源的URL
            striped: true,  //表格显示条纹
            pagination: true, //启动分页
            pageSize: 10,  //每页显示的记录数
            pageNumber:1, //当前第几页
            pageList: [5, 10, 15, 20, 25],  //记录数可选列表
            search: false,  //是否启用查询
            showColumns: true,  //显示下拉框勾选要显示的列
            showRefresh: true,  //显示刷新按钮
            sidePagination: "server", //表示服务端请求
            //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
            //设置为limit可以获取limit, offset, search, sort, order

            queryParamsType : "undefined",
            queryParams: function queryParams(params) {   //设置查询参数
                var param = {
                        pageNumber: params.pageNumber,
                        pageSize: params.pageSize
                };
                console.log( params.pageSize);
                return param;
            },
        });
    }

    $(document).ready(function () {
        //调用函数，初始化表格
        initTable();

        //当点击查询按钮的时候执行
        $("#search").bind("click", initTable);
    });
    function actionFormatter(value, row, index) {
        return [
            '<button class="edit" >编辑</button>'
        ].join('');
    }

    window.actionEvents = {
        'click .edit': function (e, value, row, index) {
            //获取当前行对象
            var obj = jQuery.parseJSON(JSON.stringify(row));
//            window.location.href = '/permission/toEdit?username='+obj.username;
//            layer.open({
//                type: 1,
//                closeBtn: false,
//                shift: 2,
//                shadeClose: true,
//                content: $("#box1")
//            });
            layer.open({
                type: 2,
                title: false,
                area: ['420px','400px'],
                maxmin: false,
                closeBtn: 1,
                content: '/permission/toEdit?username='+obj.username
            });
        }
    };
</script>

<script type="text/javascript">
    function get_roles() {
        $.ajax({
            type: "get",
            url: "/permission/listRoleNames", //获取json数据
            dataType: "json",
            success: function(data) {
                var d = eval("(" + data + ")");
                for(var i = 0; i < d.length; i++) {
                    var id = d[i].id;
                    var roleName = d[i].roleName;
                    var opt = "<option value='" + id + "'>" + roleName + "</option>";
                    $("#roleNames").append(opt);
                }
            },
            error: function() {
                alert("系统异常，请稍后再试！")
            }
        });
    }
    $(document).ready(function() {
        get_roles();
    });
</script>
</body>
</html>
