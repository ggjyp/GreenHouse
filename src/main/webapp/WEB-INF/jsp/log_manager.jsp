<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>智能温室系统|日志管理</title>
    <jsp:include page="include/commonfile.jsp"/>
    <%--开始引入bootstrap-table--%>
    <link href="${ctx}/static/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <script src="${ctx}/static/plugins/bootstrap-table/bootstrap-table.js"></script>
    <script src="${ctx}/static/plugins/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <%--结束引入bootstrap-table--%>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<jsp:include page="include/sidebar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">日志管理</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">日志管理</li>
        </ol>
    </div><!--/.row-->
    <br>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-primary">
                <div class="panel-heading"></div>
                <div class="panel-body">
                    <table  id="logTable" data-toggle="table" >
                        <thead>
                        <tr>
                            <%--data-field的值为pojo类的属性值，不是数据库字段--%>
                            <th data-field="id" >日志编号</th>
                            <th data-field="operateFrom">操作者</th>
                            <th data-field="operateTo">操作对象</th>
                            <th data-field="date">操作时间</th>
                            <th data-field="behavior">操作</th>
                            <%--<th data-field="state">状态</th>--%>
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
        var logTable = $('#logTable');
        //先销毁表格
        logTable.bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        logTable.bootstrapTable({
            method: "get",  //使用post请求到服务器获取数据
            url: "/log/list", //获取数据源的URL
            striped: true,  //表格显示条纹
            pagination: true, //启动分页
            pageSize: 10,  //每页显示的记录数
            pageNumber:1, //当前第几页
            pageList: [5, 10, 15, 20, 25],  //记录数可选列表
            search: false,  //是否启用查询
            showColumns: false,  //显示下拉框勾选要显示的列
            showRefresh: false,  //显示刷新按钮
            sidePagination: "server", //表示服务端请求
            queryParamsType : "undefined",
            queryParams: function queryParams(params) {   //设置查询参数
                var param = {
                    pageNumber: params.pageNumber,
                    pageSize: params.pageSize
                };
                console.log( params.pageSize);
                return param;
            }
        });
    }

    $(document).ready(function () {
        initTable();
    });
</script>
</body>
</html>
