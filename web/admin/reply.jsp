<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LSZ
  Date: 2018/3/10
  Time: 12:00
--%>
<%@ page import="cn.xxyxwh.model.Apply" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Apply apply = (Apply) request.getAttribute("apply");
    request.setAttribute("apply", apply);
%>
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
                    <h1 class="page-header">申请管理 / 查看详细信息 / ${apply.name}</h1>
                </div>
            </div>
        </div>

        <div class="center-block row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        详细信息
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-11">
                                <div class="form-group">
                                    <label>名称：</label>
                                    <p class="form-control-static">${apply.name}</p>
                                </div>

                                <div class="form-group">
                                    <label>主办方：</label>
                                    <p class="form-control-static">${apply.unit}</p>
                                </div>

                                <div class="form-group">
                                    <label>联系方式：</label>
                                    <p class="form-control-static">${apply.contact}</p>
                                </div>

                                <div class="form-group">
                                    <label>申请部门：</label>
                                    <p class="form-control-static">${apply.depts}</p>
                                </div>

                                <div class="form-group">
                                    <label>时间：</label>
                                    <p class="form-control-static">${apply.exec}</p>
                                </div>

                                <div class="form-group">
                                    <label>地点：</label>
                                    <p class="form-control-static">${apply.place}</p>
                                </div>

                                <div class="form-group">
                                    <label>提交时间：</label>
                                    <p class="form-control-static">${apply.time}</p>
                                </div>

                                <div class="form-group">
                                    <label>其他信息：</label>
                                    <textarea class="form-control" name="des" rows="4"
                                              disabled="disabled">${apply.description}</textarea>
                                </div>
                            </div>
                            <!-- /.col-lg-6 (nested) -->
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        回复
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-11">
                                <form role="form" action="${pageContext.request.contextPath}/admin/s" method="post">

                                    <input type="hidden" name="action" value="save">
                                    <input type="hidden" name="id" value="${apply.id}">


                                    <div class="form-group">
                                        <label>是否通过申请：</label>
                                        <label class="radio-inline">
                                            <c:if test="${apply.status == 0 ||apply.status == 1}">
                                                <input type="radio" name="status" value="1" checked/>通过
                                            </c:if>
                                            <c:if test="${ apply.status == 2}">
                                                <input type="radio" name="status" value="1"/>通过
                                            </c:if>
                                        </label>
                                        <label class="radio-inline">
                                            <c:if test="${apply.status == 2}">
                                                <input type="radio" name="status" value="2" checked/>不通过
                                            </c:if>
                                            <c:if test="${apply.status == 0 || apply.status == 1}">
                                                <input type="radio" name="status" value="2"/>不通过
                                            </c:if>
                                        </label>
                                    </div>

                                    <div class="form-group">
                                        <label>审核人</label>
                                        <input class="form-control" name="audit" required value="${apply.audit}"/>
                                    </div>

                                    <div class="form-group">
                                        <label>回复：</label>
                                        <textarea class="form-control" name="reply" rows="3"
                                                  placeholder="请输入回复信息...">${apply.reply}</textarea>
                                    </div>

                                    <button type="submit" class="btn btn-success">保存</button>&nbsp;&nbsp;
                                    <button type="reset" class="btn btn-default">清空</button>
                                </form>
                            </div>
                            <!-- /.col-lg-6 (nested) -->
                        </div>
                        <!-- /.row (nested) -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
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