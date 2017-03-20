<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>智能温室控制系统</title>
    <jsp:include page="include/commonfile.jsp"/>

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
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel panel-blue panel-widget ">
                <div class="row no-padding">
                    <div class="col-sm-3 col-lg-5 widget-left">
                        <em class="glyphicon glyphicon-shopping-cart glyphicon-l"></em>
                    </div>
                    <div class="col-sm-9 col-lg-7 widget-right">
                        <div class="large">120</div>
                        <div class="text-muted">New Orders</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel panel-orange panel-widget">
                <div class="row no-padding">
                    <div class="col-sm-3 col-lg-5 widget-left">
                        <em class="glyphicon glyphicon-comment glyphicon-l"></em>
                    </div>
                    <div class="col-sm-9 col-lg-7 widget-right">
                        <div class="large">52</div>
                        <div class="text-muted">Comments</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-12 col-md-6 col-lg-3">
            <div class="panel panel-teal panel-widget">
                <div class="row no-padding">
                    <div class="col-sm-3 col-lg-5 widget-left">
                        <em class="glyphicon glyphicon-user glyphicon-l"></em>
                    </div>
                    <div class="col-sm-9 col-lg-7 widget-right">
                        <div class="large">24</div>
                        <div class="text-muted">New Users</div>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/.row-->

</div>	<!--/.main-->


<script>
    $('#calendar').datepicker({
    });

    !function ($) {
        $(document).on("click","ul.nav li.parent > a > span.icon", function(){
            $(this).find('em:first').toggleClass("glyphicon-minus");
        });
        $(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
    }(window.jQuery);

    $(window).on('resize', function () {
        if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
    })
    $(window).on('resize', function () {
        if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
    })
</script>
</body>

</html>

