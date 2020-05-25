<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" pageEncoding="UTF-8" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>化工品备案查询</title>

    <meta name="keywords" content="化工品备案查询">
    <link href="css/my.css" rel="stylesheet" type="text/css"/>
    <style type="text/css">

    </style>
</head>


<body>

    <%--<div id="pageHeader">--%>
        <%--<div id="pageLogo" class="pageLogo">--%>
            <%--<img id="logo_img" src="images/my_logo_s.gif" alt="my_logo">--%>
        <%--</div>--%>
        <%--<div id="pageTitle">--%>
            <%--<h1>my AI Tool</h1>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--<div id="headerImage">--%>
        <%--<img src="images/pickup.jpg" title="My first AI platform ">--%>
    <%--</div>--%>


<form method="post" action="${pageContext.request.contextPath}/page" id="query">
    <div id="aaa" style="height: 300px;margin-top: 200px">
        <h3>您好！请输入需要验证的信息</h3>

        <input type="text" name="acc" value="" style="width: 174px;height: 30px;"/>
        <input type="button" value="查询" style="height: 35px;width:84px;font-size: 16px;"
           onclick="javascript:document.getElementById('query').submit();"/>
    </div>

</form>

<%--<div class="footer"><img class="mobile-icon" src="images/icp-logo.png">&nbsp;<a href="http://www.beian.miit.gov.cn/"
                                                                                target="_blank">京ICP备13024188号-8</a>
    | <img class="mobile-icon" src="images/polic-logo.png">&nbsp;
    <a href="" target="_blank">京公网安备 11030102010888号</a></div>--%>
</body>