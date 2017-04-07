<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>智能温室控制系统</title>
    <jsp:include page="include/commonfile.jsp"/>
    <script src="${ctx}/static/js/auto_control_param/checkForm.js"></script>

</head>

<body>
<jsp:include page="include/header.jsp"/>

<jsp:include page="include/sidebar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">自控参数管理</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">自控参数管理</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-10">
            <div class="panel-primary">
                <div class="panel-heading">新增自控参数</div>
                <div class="panel-body">
                    <form id="form" role="form" action="${ctx}/autoControlParam/addParam" method="post">
                        <div class="form-group">
                            <label for="paramName">自控参数名称：</label>
                            <input name="paramName" id="paramName" type="text" onBlur="checkParamName(this)" class="form-control">
                            <span id="paramNameNotice"></span>
                        </div>
                        <div class="form-group">
                            <label for="temperatureMin">温度下限：</label>
                            <input name="temperatureMin" id="temperatureMin" type="text" onBlur="checkTemperatureMin(this)" class="form-control">
                            <span id="temperatureMinNotice"></span>
                        </div>
                        <div class="form-group">
                            <label for="temperatureMax">温度上限：</label>
                            <input name="temperatureMax" id="temperatureMax" type="text" onBlur="checkTemperatureMax(this)" class="form-control">
                            <span id="temperatureMaxNotice"></span>
                        </div>
                        <div class="form-group">
                            <label for="humidityMin">湿度下限：</label>
                            <input name="humidityMin" id="humidityMin" type="text" onBlur="checkHumidityMin(this)" class="form-control">
                            <span id="humidityMinNotice"></span>
                        </div>
                        <div class="form-group">
                            <label for="humidityMax">湿度上限：</label>
                            <input name="humidityMax" id="humidityMax" type="text" onBlur="checkHumidityMax(this)" class="form-control">
                            <span id="humidityMaxNotice"></span>
                        </div>
                        <div class="form-group">
                            <label for="lightIntensityMin">光照强度下限：</label>
                            <input name="lightIntensityMin" id="lightIntensityMin" type="text" onBlur="checkLightIntensityMin(this)" class="form-control">
                            <span id="lightIntensityMinNotice"></span>
                        </div>
                        <div class="form-group">
                            <label for="lightIntensityMax">光照强度上限：</label>
                            <input name="lightIntensityMax" id="lightIntensityMax" type="text" onBlur="checkLightIntensityMax(this)" class="form-control">
                            <span id="lightIntensityMaxNotice"></span>
                        </div>
                        <div class="form-group">
                            <label for="soilMoistureMin">土壤湿度下限：</label>
                            <input name="soilMoistureMin" id="soilMoistureMin" type="text" onBlur="checkSoilMoistureMin(this)" class="form-control">
                            <span id="soilMoistureMinNotice"></span>
                        </div>
                        <div class="form-group">
                            <label for="soilMoistureMax">土壤湿度上限：</label>
                            <input name="soilMoistureMax" id="soilMoistureMax" type="text" onBlur="checkSoilMoistureMax(this)" class="form-control">
                            <span id="soilMoistureMaxNotice"></span>
                        </div>

                        <div class="control-group">
                            <button class="btn btn-primary"
                                    id="submit"
                                    style="margin-left: 150px;"
                                    type="submit"
                                    disabled
                            >
                                新增
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div><!--/.col-->
    </div>
</div>	<!--/.main-->
</body>

</html>

