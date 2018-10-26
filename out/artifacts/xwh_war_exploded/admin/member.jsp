<%--
  Created by IntelliJ IDEA.
  User: LSZ
  Date: 2018/3/10
  Time: 12:00
--%>
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
                    <h1 class="page-header">名单管理</h1>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        通讯录
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <jsp:include page="../WEB-INF/contact.html"/>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        更新通讯录
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <form action="${pageContext.request.contextPath}/admin/upload" method="post"
                              enctype="multipart/form-data">
                            <input type="file" name="uploadFile" accept="text/html"/><br/>
                            <button class="btn btn-success" type="submit">上传</button>
                        </form>
                    </div>
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

