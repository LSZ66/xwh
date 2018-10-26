<%--
  Created by IntelliJ IDEA.
  User: lsz09
  Date: 2018/1/28
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
<form action="/mail" method="get">
    <div style="width: 500px">
        <fieldset>
            <legend>任务申请</legend>
            活动名称：<input type="text" name="name" required/><br/>
            申请人：<input type="text" name="from"/><br>
            申请部门:
            <input type="checkbox" name="dept" value="摄影部"/>摄影部
            <input type="checkbox" name="dept" value="新闻部"/>新闻部
            <input type="checkbox" name="dept" value="网络部"/>网络部<br/>
            活动时间：<input type="datetime-local" name="time"/><br/>
            联系方式：<input type="text" name="phone"><br/>
            *(测试用)提示信息邮箱：<input type="email" name="mail"><br/>
            <button type="submit">提交</button>
        </fieldset>
    </div>
</form>
</body>
</html>
