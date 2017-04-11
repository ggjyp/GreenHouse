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
        <div class="col-lg-12">
            <h1 class="page-header">首页</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">首页</li>
        </ol>
    </div><!--/.row-->
    <div class="row">
        <div class="col-lg-12">
            <h2>控制温室</h2>
        </div>
        <div class="col-lg-6">
            <div class="panel-primary">
                <div class="panel-heading">LED灯</div>
                <div class="panel-body">
                    <input type="hidden" id="currentUser" value="${username}">
                    <button id="offLED" type="button" onclick="closeLED()" class="btn btn-primary">关灯</button>
                    <button id="onLED" type="button" onclick="openLED()" class="btn btn-primary">开灯</button>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <h2>温室状态</h2>
        </div>
        <div class="col-md-6">
            <div class="panel-primary">
                <div class="panel-heading">温度状态</div>
                <div class="panel-body">
                    <div id="temperatureContainer" style="min-width:400px;height:400px"></div>
                </div>
            </div>
        </div><!--/.col-->
        <div class="col-md-6">
            <div class="panel-primary">
                <div class="panel-heading">湿度状态</div>
                <div class="panel-body">
                    <div id="humidityContainer" style="min-width:400px;height:400px"></div>
                </div>
            </div>
        </div><!--/.col-->
    </div>


</div>	<!--/.main-->
<script type="text/javascript">
    temperatureChart();
    humidityChart();
    //每5秒刷新一次图表，实际应用中，适当延长时间，例如每分钟刷新一次图表
    window.setInterval(temperatureChart, 5000);
    window.setInterval(humidityChart, 5000);
</script>
<script type="text/javascript">
    function closeLED() {
        var message = {
            "type" : "switch",
            "state" : "close"
        }
        var dataSend = {
            "updateState" : "false",
            "initiator" : "REST",
            "initiatorId" : "admin",
            "target" : "Assignment",
            "commandToken" : "e8b9b58e-10ea-4b76-b18b-c57c4a4ebd69",
            "parameterValues" : {
                "message" : JSON.stringify(message)
            }
        };
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: "http://localhost:8080/sitewhere/api/assignments/83d43843-c4a7-403c-83ac-9dc0d1918aba/invocations",
            data:JSON.stringify(dataSend),
            dataType: "json",
            beforeSend: function(request){
                request.setRequestHeader("Content-Type","application/json");
                request.setRequestHeader("X-SiteWhere-Tenant","sitewhere1234567890");
                request.setRequestHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQ=");
            },
            success: function () {
                //数据库增加一条日志记录
                var log = {
                    "operateFrom":$("#currentUser").val(),
                    "operateTo":"LED",
                    "behavior":"close",
                    "state":"1"
                };
                $.ajax({
                    type: "POST",
                    url: "/log/addLog",
                    data: log,
                    dataType: "json",
                    success: function (date) {
                        if (date.result == "success") {
                            layer.msg("操作成功")
                        }
                        if (date.result == "failed") {
                            layer.msg("操作失败")
                        }
                    },
                    error: function () {
                        layer.msg("系统错误")
                    }
                });
            },
            error: function () {
                layer.msg("error")
            }
        });
    }
    function openLED() {
        var message = {
            "type" : "switch",
            "state" : "open"
        }
        var dataSend = {
            "updateState" : "false",
            "initiator" : "REST",
            "initiatorId" : "admin",
            "target" : "Assignment",
            "commandToken" : "e8b9b58e-10ea-4b76-b18b-c57c4a4ebd69",
            "parameterValues" : {
                "message" : JSON.stringify(message)
            }
        };
        //ajax调用SiteWhere接口
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: "http://localhost:8080/sitewhere/api/assignments/83d43843-c4a7-403c-83ac-9dc0d1918aba/invocations",
            data:JSON.stringify(dataSend),
            dataType: "json",
            beforeSend: function(request){
                request.setRequestHeader("Content-Type","application/json");
                request.setRequestHeader("X-SiteWhere-Tenant","sitewhere1234567890");
                request.setRequestHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQ=");
            },
            success: function () {
                //数据库增加一条日志记录
                var log = {
                    "operateFrom":$("#currentUser").val(),
                    "operateTo":"LED",
                    "behavior":"open",
                    "state":"1"
                };
                $.ajax({
                    type: "POST",
                    url: "/log/addLog",
                    data: log,
                    dataType: "json",
                    success: function (date) {
                        if (date.result == "success") {
                            layer.msg("操作成功")
                        }
                        if (date.result == "failed") {
                            layer.msg("操作失败")
                        }
                    },
                    error: function () {
                        layer.msg("系统错误")
                    }
                });
            },
            error: function () {
                layer.msg("error")
            }
        });
    }

</script>
</body>

</html>

