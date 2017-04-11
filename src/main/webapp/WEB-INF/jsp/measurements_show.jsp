<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>智能温室系统|数据显示</title>
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
            <h1 class="page-header">数据显示</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">数据显示</li>
        </ol>
    </div><!--/.row-->
    <br>
    <div class="row">
        <div class="col-lg-12">
            <table  id="measurementTable" data-toggle="table" >
                <thead>
                <tr>
                    <th data-field="temperature" >温度</th>
                    <th data-field="humidity">湿度</th>
                    <th data-field="eventDate">时间</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript">
    function initTable() {
        var measurementTable = $('#measurementTable');
        //先销毁表格
        measurementTable.bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        measurementTable.bootstrapTable({
            method: "get",  //使用post请求到服务器获取数据
            url: "/sitewhere/measurements", //获取数据源的URL
            striped: true,  //表格显示条纹
            pagination: true, //启动分页
            pageSize: 10,  //每页显示的记录数
            pageNumber:1, //当前第几页
            pageList: [5, 10, 15, 20, 25],  //记录数可选列表
            search: false,  //是否启用查询
            showColumns: true,  //显示下拉框勾选要显示的列
            showRefresh: true,  //显示刷新按钮
            sidePagination: "server", //表示服务端请求
            queryParamsType : "undefined",
            queryParams: function queryParams(params) {   //设置查询参数
                var param = {
                    page: params.pageNumber,
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
