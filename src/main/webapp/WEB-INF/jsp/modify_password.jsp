<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>智能温室控制系统</title>
    <jsp:include page="include/commonfile.jsp"/>
    <script src="${ctx}/static/js/jquery.form.js"></script>

</head>

<body>
<jsp:include page="include/header.jsp"/>

<jsp:include page="include/sidebar.jsp"/>

<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="#"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">修改密码</li>
        </ol>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">修改密码</h1>
        </div>
    </div><!--/.row-->

    <div class="row">
        <div class="col-lg-10">
            <div class="panel-primary">
                <div class="panel-heading">用户信息</div>
                <div class="panel-body">
                    <form id="form" role="form" action="${ctx}/user/editPassword" method="post">
                        <input type="hidden" name="username" value="${user.username}">
                        <div class="form-group">
                            <label for="oldPwd">旧密码：</label>
                            <input id="oldPwd" type="password" class="form-control" placeholder="请输入旧密码">
                        </div>
                        <div class="form-group">
                            <label for="newPwd">新密码：</label>
                            <input id="newPwd" type="password" class="form-control" placeholder="请输入新密码">
                        </div>
                        <div class="form-group">
                            <label for="confirmPwd">确认密码：</label>
                            <input id="confirmPwd" type="password" class="form-control" placeholder="再次输入新密码">
                        </div>

                        <button class="btn btn-primary">提交修改</button>
                    </form>
                </div>
            </div>
        </div><!--/.col-->
    </div>
</div>	<!--/.main-->
<script>
    $(document).ready(function(){
        $('#form').bind('submit', function(){
            var username= $('#username').val();
            var oldPwd= document.getElementById("oldPwd").value;
            var newPwd= document.getElementById("newPwd").value;
            var confirmPwd= document.getElementById("confirmPwd").value;
            console.log(oldPwd);
            if (newPwd != confirmPwd){
                layer.msg("请确认新密码");
                return false;
            }

            $(this).ajaxSubmit({
                type: 'post',
                dataType : "json",
                data: {
                    'username':username, 'oldPwd':oldPwd, 'newPwd': newPwd
                },
                success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
                    if(data.result=="success"){
                        layer.msg("修改成功");
                    }
                    if(data.result=="failed"){
                        layer.msg("修改失败");
                    }
                    if(data.result=="error"){
                        layer.msg("旧密码错误");
                    }
                },
                error: function (data) {
                    layer.msg("系统错误");
                }

            });
            $(this).resetForm(); // 提交后重置表单
            return false; // 阻止表单自动提交事件
        });
    });
</script>
</body>

</html>

