<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
    <ul class="nav menu">
        <li class="active"><a href="index.html"><span class="glyphicon glyphicon-dashboard"></span> 首页</a></li>
        <li><a href="${ctx}/permission"><span class="glyphicon glyphicon-th"></span> 权限管理</a></li>
        <li><a href="${ctx}/sitewhere"><span class="glyphicon glyphicon-th"></span> 数据显示</a></li>
        <li><a href="${ctx}/log"><span class="glyphicon glyphicon-stats"></span> 日志管理</a></li>
        <li><a href="tables.html"><span class="glyphicon glyphicon-list-alt"></span> 参数管理</a></li>
    </ul>
</div><!--/.sidebar-->