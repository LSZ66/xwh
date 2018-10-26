<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<%--
  Created by IntelliJ IDEA.
  User: LSZ
  Date: 2018/3/10
  Time: 12:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="cn.xxyxwh.model.Apply" %>
<%@ page import="cn.xxyxwh.service.ApplyService" %>
<%@ page import="java.util.List" %>
<%
    ApplyService service = new ApplyService();
    List<Apply> applyList = service.showAllApply();
    request.setAttribute("applyList", applyList);
%>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="utf-8">
    <title>宣委会后台管理系统</title>
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
    <link href="vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
    <link href="vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
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
                    <h1 class="page-header">申请管理</h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">全部任务</div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <table width="100%" class="table table-striped table-bordered table-hover" id="applyTable">
                            <thead>
                            <tr>
                                <th>活动名称</th>
                                <th>主办方</th>
                                <th>联系人</th>
                                <th>申请部门</th>
                                <th>活动时间</th>
                                <th>活动地点</th>
                                <th>状态</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${applyList}" var="apply">
                                <tr>
                                    <td>${apply.name}</td>
                                    <td>${apply.unit}</td>
                                    <td>${apply.contact}</td>
                                    <td>${apply.depts}</td>
                                    <td>${apply.exec}</td>
                                    <td>${apply.place}</td>
                                    <td class="text-center">
                                        <c:if test="${apply.status == 0}">
                                            <label class="label label-warning">未审核</label>
                                        </c:if>
                                        <c:if test="${apply.status == 1}">
                                            <label class="label label-success">审核通过</label>
                                        </c:if>
                                        <c:if test="${apply.status == 2}">
                                            <label class="label label-default">审核不通过</label>
                                        </c:if>
                                    </td>
                                    <td class="text-center">
                                        <a class="btn btn-primary"
                                           href="${pageContext.request.contextPath}/admin/s?action=reply&applyID=${apply.id}">
                                            详细信息
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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
<script src="vendor/datatables/js/jquery.dataTables.min.js"></script>
<script src="vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
<script src="vendor/datatables-responsive/dataTables.responsive.js"></script>
<script src="dist/js/sb-admin-2.js"></script>
<script>
    $(document).ready(function () {
        $('#applyTable').DataTable({
            responsive: true,
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "order": [[4, 'desc']],
            "aoColumnDefs": [{"bSortable": false, "aTargets": [0, 2, 5, 7]}]
        });
    });
</script>
</body>
</html>

