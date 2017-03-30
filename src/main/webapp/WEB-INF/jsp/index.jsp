<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h1 class="page-header">首页</h1>
        </div>
    </div><!--/.row-->




    <div class="row">
        <div class="col-lg-12">
            <div class="panel-primary">
                <div class="panel-heading">发送指令</div>
                <div class="panel-body">
                    <button id="invocations" type="button" onclick="invocation()" class="btn green">发送指令</button>
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
    function invocation() {
        var dataSend = {
            "eventDate" : "2018-12-10T13:11:45.122-0500",
            "updateState" : "false",
            "initiator" : "REST",
            "initiatorId" : "admin",
            "target" : "Assignment",
            "commandToken" : "50060363-4152-410b-81a1-d8a1d8d1c972",
            "parameterValues" : {
                "message" : "111"
            }
        };
        $.ajax({
            type: "POST",
            contentType: "application/json;charset=utf-8",
            url: "http://localhost:8080/sitewhere/api/assignments/b8430c7c-5690-4fc7-ba13-644b66fbbe03/invocations",
            data:JSON.stringify(dataSend),
            dataType: "json",
            beforeSend: function(request){
                request.setRequestHeader("Content-Type","application/json");
                request.setRequestHeader("X-SiteWhere-Tenant","sitewhere1234567890");
                request.setRequestHeader("Authorization","Basic YWRtaW46cGFzc3dvcmQ=");
            },
            success: function (result) {
            },
            error: function () {
                alert("error")
            }
        });
    }
</script>
</body>

</html>

