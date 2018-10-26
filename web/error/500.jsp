<%--
  Created by IntelliJ IDEA.
  User: LSZ
  Date: 2018/3/9
  Time: 18:28
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>服务器错误</title>
    <link href="${pageContext.request.contextPath}/error/res/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/error/res/bootstrap.css" rel="stylesheet">
    <style type="text/css">
        body {
            background: #F5F5F5;
        }
    </style>
</head>
<body>
<div class="error-pages">
    <img src="${pageContext.request.contextPath}/error/res/500.png" alt="500" class="icon" width="400" height="260">
    <h1>服务器发生了错误</h1><br/>
    <h4>请稍后再试,如果问题一直存在,请联系网站管理员</h4>
    <div class="bottom-links">
        <a href="${pageContext.request.contextPath}/" class="btn btn-default">返回主页</a>
    </div>
</div>
</body>
</html>