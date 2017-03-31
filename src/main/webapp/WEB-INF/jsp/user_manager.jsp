<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>智能温室控制系统</title>
    <jsp:include page="include/commonfile.jsp"/>
    <script src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
    <script src="http://cdn.hcharts.cn/highcharts/modules/exporting.js"></script>
    <script src="${ctx}/static/js/greenhouse-chart.js"></script>

</head>

<body>
<jsp:include page="include/header.jsp"/>

<jsp:include page="include/sidebar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">首页</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">权限管理</h1>
        </div>
    </div><!--/.row-->




    <div class="row">
        <div class="col-lg-12">
            <h2>控制温室</h2>
        </div>
        <div class="col-lg-12">
            <div class="panel-primary">
                <div class="panel-heading"></div>
                <div class="panel-body">
                    <button id="invocations" type="button" onclick="invocation()" class="btn green">发送指令</button>
                </div>
            </div>
        </div>
    </div>


</div>	<!--/.main-->

</body>

</html>

