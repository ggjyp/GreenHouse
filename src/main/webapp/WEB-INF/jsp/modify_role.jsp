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
    <div class="row">
        <div class="col-lg-6">
            <div class="panel-primary">
                <div class="panel-heading">修改权限</div>
                <div class="panel-body">
                    <form id="form" role="form" action="${ctx}/permission/modifyRole" method="post">
                        <div class="form-group">
                            <label>用户名</label>
                            ${user.username}
                            <input type="hidden" name="username" value="${user.username}">
                        </div>

                        <div class="form-group">
                            <label for="roleId">权限名</label>
                            <select class="form-control" id="roleId">
                                <option value ="-1">请选择</option>
                                <option value ="2">管理员</option>
                                <option value="1">普通用户</option>
                                <option value="3">游客</option>
                            </select>
                        </div>
                        <button class="btn btn-primary">提交修改</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
<script>
    $(document).ready(function(){
        $('#form').bind('submit', function(){
            var username= $('#username').val();
            var roleId= $('#roleId').val();
            $(this).ajaxSubmit({
                type: 'post', // 提交方式 get/post         url: 'your url', // 需要提交的 url
                dataType : "json",
                data: {
                'username': username, 'roleId': roleId
            },
            success: function(data) { // data 保存提交后返回的数据，一般为 json 数据
                layer.msg("修改成功");
            }
            //$(this).resetForm(); // 提交后重置表单
        });
            return false; // 阻止表单自动提交事件
        });
    });
</script>
</body>

</html>

