<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LSZ
  Date: 2018/3/10
  Time: 12:00
--%>
<%@ page import="cn.xxyxwh.model.Apply" %>
<%@ page import="cn.xxyxwh.service.ApplyService" %>
<%@ page import="java.util.List" %>
<%
    ApplyService service = new ApplyService();
    long total = service.showTotalUnReply();
    request.setAttribute("unReply", total);
    Integer pageView = (Integer) application.getAttribute("pageView");
    request.setAttribute("pageView", pageView);
    List<Apply> applyList = service.showWeekTask();
    request.setAttribute("weekTask", applyList);
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8">
    <title>宣委会后台管理系统</title>
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="wrapper">
    <jsp:include page="nav.jsp"/>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">信息总览</h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6 col-md-6">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-tasks fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div>未处理申请</div>
                                <div class="huge">${unReply}</div>
                            </div>
                        </div>
                    </div>
                    <a href="apply.jsp">
                        <div class="panel-footer">
                            <span class="pull-left">详细信息</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-6 col-md-6">
                <div class="panel panel-yellow">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-television fa-5x"></i>
                            </div>
                            <div class="col-xs-9 text-right">
                                <div>页面访问量</div>
                                <div class="huge">${pageView}</div>
                            </div>
                        </div>
                    </div>
                    <a href="../">
                        <div class="panel-footer">
                            <span class="pull-left">查看详细</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        本周任务
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>活动名称</th>
                                <th>主办方</th>
                                <th>联系人</th>
                                <th>部门</th>
                                <th>活动时间</th>
                                <th>活动地点</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${weekTask}" var="task">
                                <tr>
                                    <td>${task.name}</td>
                                    <td>${task.unit}</td>
                                    <td>${task.contact}</td>
                                    <td>${task.depts}</td>
                                    <td>${task.exec}</td>
                                    <td>${task.place}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <div class="well">
                            <a class="btn btn-default btn-lg btn-block" href="apply.jsp">
                                查看所有任务</a>
                        </div>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>
    <!-- /#page-wrapper -->
</div>

<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/metisMenu/metisMenu.min.js"></script>
<script src="dist/js/sb-admin-2.js"></script>
</body>
</html>

