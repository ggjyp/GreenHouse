<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>智能温室系统|自控参数管理</title>
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
            <h1 class="page-header">自控参数管理</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <ol class="breadcrumb">
            <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">自控参数管理</li>
        </ol>
    </div><!--/.row-->
    <br>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-primary">
                <div class="panel-heading"></div>
                <div class="panel-body">
                    <p><button onclick="window.location.href='${ctx}/autoControlParam/toAdd'" class="btn btn-primary">新增自控参数</button></p>
                    <table  id="paramTable" data-toggle="table" >
                        <thead>
                        <tr>
                            <th data-field="paramName" >参数名</th>
                            <th data-field="temperatureMin">温度下限</th>
                            <th data-field="temperatureMax">温度上限</th>
                            <th data-field="humidityMin">湿度下限</th>
                            <th data-field="humidityMax">湿度上限</th>
                            <th data-field="lightIntensityMin">光照强度下限</th>
                            <th data-field="lightIntensityMax">光照强度上限</th>
                            <th data-field="soilMoistureMin">土壤湿度下限</th>
                            <th data-field="soilMoistureMax">土壤湿度上限</th>
                            <th data-field="modifyDate">修改时间</th>
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
        var paramTable = $('#paramTable');
        //先销毁表格
        paramTable.bootstrapTable('destroy');
        //初始化表格,动态从服务器加载数据
        paramTable.bootstrapTable({
            method: "get",  //使用post请求到服务器获取数据
            url: "/autoControlParam/list", //获取数据源的URL
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
    function actionFormatter(value, row, index) {
        return [
            '<button class="btn btn-success use" >启用</button>',
            '<button class="btn btn-success edit" >编辑</button>',
            '<button class="btn btn-success delete" >删除</button>'


        ].join('');
    }

    window.actionEvents = {
        'click .use': function (e, value, row, index) {
            //获取当前行对象
            var obj = jQuery.parseJSON(JSON.stringify(row));
            window.location.href = '/autoControlParam/toEdit?paramName='+obj.paramName;
        },
        'click .edit': function (e, value, row, index) {
            //获取当前行对象
            var obj = jQuery.parseJSON(JSON.stringify(row));
            window.location.href = '/autoControlParam/toEdit?paramName='+obj.paramName;
        },
        'click .delete': function (e, value, row, index) {
            //获取当前行对象
            var obj = jQuery.parseJSON(JSON.stringify(row));
            $.ajax({
                type: "POST",
                url: "/autoControlParam/deleteParam",
                data: {"paramName":obj.paramName},
                dataType: "json",
                success: function (date) {
                    if (date.result == "success") {
                        initTable();
                    }
                    if (date.result == "failed") {
                        layer.msg("删除失败");
                    }
                },
                error: function () {
                    layer.msg("系统错误")
                }
            });
        }
    };
</script>
</body>
</html>
