<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.xxyxwh.service.DeptService" %>
<%@ page import="cn.xxyxwh.model.Dept" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    DeptService service = new DeptService();
    List<Dept> depts = service.showAllApplyingDepts();
    request.setAttribute("depts", depts);
    int year = Calendar.getInstance().get(Calendar.YEAR);
    request.setAttribute("currentYear", year);
%>

<!--
  Created by IntelliJ IDEA.
  User: LSZ
  Date: 2018/3/13
  Time: 11:42
-->

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>宣传工作委员会</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/formviewm.css">
    <script src="${pageContext.request.contextPath}/static/script/jquery-3.3.1.min.js"></script>
</head>

<body class="wallpaper">
<div id="container" class="container" mobile="1">

    <div>
        <h1 id="logo" class="logo"><a style="background-image: none; background-size: initial; height: 250px;"><img
                src="${pageContext.request.contextPath}/static/img/apply.jpg" style="border:none;width:100%;"></a></h1>
    </div>
    <div class="ui-content">
        <form class="form" action="${pageContext.request.contextPath}/apply" method="post">
            <input type="hidden" name="action" value="add"/>
            <div class="info" id="formHeader">
                <h2>提交宣传申请</h2>
                <div class="right">v1.0.1 beta</div>
                <br/>
            </div>
            <ul class="fields">

                <li class="clearfix"><label class="desc">活动名称</label>
                    <div class="content">
                        <input type="text" maxlength="256" class="ui-input-text xl input fld" name="name" required/>
                    </div>
                </li>

                <li class="clearfix"><label class="desc">申请单位</label>
                    <div class="content">
                        <input type="text" maxlength="256" class="ui-input-text xl input fld" name="unit" required/>
                    </div>
                </li>

                <li class="clearfix"><label class="desc">联系方式</label>
                    <div class="content">
                        <input type="text" maxlength="256" class="ui-input-text xl input fld" name="contact" required/>
                    </div>
                </li>

                <li class="clearfix " typ="check"><label class="desc">申请部门</label>
                    <div class="content pretty-box">
                        <fieldset class="controlgroup">
                            <c:forEach items="${depts}" var="dept">
                                <label>
                                    <input class="fld" id="t${dept.id}" type="checkbox" name="depts" value="${dept.id}">
                                    <label for="t${dept.id}"> ${dept.name}</label>
                                </label>
                            </c:forEach>
                        </fieldset>
                    </div>
                </li>

                <li class="clearfix"><label class="desc">活动日期</label>
                    <div class="content oneline">
                        <input type="date" class="ui-input-text input val" name="exec" required/>
                    </div>
                </li>

                <li class="clearfix"><label class="desc">活动时间</label>
                    <div class="content oneline">
                        <input type="time" class="ui-input-text input val" name="exec" required/>
                    </div>
                </li>

                <li class="clearfix"><label class="desc">活动地点</label>
                    <div class="content">
                        <input type="text" maxlength="256" class="ui-input-text xl input fld" name="place" required/>
                    </div>
                </li>

                <li class="clearfix"><label class="desc">其他信息</label>
                    <div class="content">
                        <textarea placeholder="详细信息" class="ui-input-text s detail fld" name="description"></textarea>
                    </div>
                </li>

                <li class="pc-submit">
                    <button id="create" class="btn-submit" type="submit">提交申请</button>

                </li>
            </ul>
        </form>
        <div style="display:block !important;font-size:100% !important;" class="powerby">
            宣传工作委员会 &copy; 2006 - ${currentYear} 版权所有。
        </div>
    </div>
    <div id="status" class="mobile hide"></div>
</div>
</body>
</html>