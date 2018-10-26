<!--
Created by IntelliJ IDEA.
User: LSZ
Date: 2018/3/9
Time: 20:22
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">导航栏</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.jsp" style="font-family: 'Microsoft YaHei UI';">宣委会后台管理系统</a>
    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" href="${pageContext.request.contextPath}/admin/s?action=logout">
                <i class="fa fa-sign-out fa-fw"></i>
            </a>
        </li>
    </ul>

    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li>
                    <a href="index.jsp"><i class="fa fa-home fa-fw"></i> 信息总览</a>
                </li>
                <li>
                    <a href="apply.jsp"><i class="fa fa-tasks fa-fw"></i> 申请管理</a>
                </li>
                <li>
                    <a href="dept.jsp"><i class="fa fa-group fa-fw"></i> 部门管理</a>
                </li>
                <li>
                    <a href="member.jsp"><i class="fa fa-phone fa-fw"></i> 名单管理</a>
                </li>
                <li>
                    <a href="news.jsp"><i class="fa fa-newspaper-o fa-fw"></i> 新闻管理</a>
                </li>
                <li>
                    <a href="photo.jsp"><i class="fa fa-photo fa-fw"></i> 照片管理</a>
                </li>
            </ul>
        </div>
    </div>
</nav>