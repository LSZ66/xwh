<%--
  Created by IntelliJ IDEA.
  User: LSZ
  Date: 2018/3/9
  Time: 18:27
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>找不到页面</title>
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
    <img src="${pageContext.request.contextPath}/error/res/404.png" alt="404" class="icon" width="400" height="260">
    <h1>对不起,您要找的页面不存在</h1><br/>
    <h4>有可能您输入了错误的URL</h4>
    <div class="bottom-links">
        <a href="${pageContext.request.contextPath}/" class="btn btn-default">返回主页</a>
    </div>
</div>
</body>
</html>