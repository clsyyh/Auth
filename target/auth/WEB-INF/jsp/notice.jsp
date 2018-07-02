<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>人事管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.ui.js"></script>
    <script type="text/javascript" src="../js/notice.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/smoothness/jquery.ui.css"/>
</head>
<body>
<div>
    <p>
        <input type="button" value="删除" id="delete"/>
    </p>
</div>
<table border="1">
    <tr>
        <td><input type="checkbox" name="checkAll"></td>
        <td>公告名称</td>
        <td>公告内容</td>
        <td>创建时间</td>
        <td>公告人</td>
        <td align="center">操作</td>
        <td align="center">预览</td>
    </tr>
    <c:forEach var="notice" items="${requestScope.notices}" varStatus="stat">
        <tr id="data_${stat.index}">
            <td><input type="checkbox" id="box_${stat.index}" value="${notice.id}"/></td>
            <td id="${notice.id}" width="100" height="120">${notice.title}</td>
            <td id="c_${notice.id}">${notice.content}</td>
            <td><f:formatDate value="${notice.createDate}"
                              type="date" dateStyle="long"/></td>
            <td>${notice.user.loginname}</td>
            <td align="center" width="40px">
                <a href="updateNotice?flag=1&id=${notice.id}">
                    <img src="../images/update.gif" /></a>
            </td>
            <td align="center" width="40px">
                <a href="/prevNotice?id=${notice.id}">
                    <img src="../images/prev.gif"/>
                </a>
            </td>
        </tr>
        <!--
        错误写法
        <tr>
            <div id="box" >
                <h1 align="center"><strong><b>${notice.title}</b></strong></h1>
                <p>${notice.content}</p>
            </div>
        </tr>
        -->
    </c:forEach>
</table>
<!--
div中无法获取当前公告内容
<div id="box">
    <h1 align="center"><strong><b></b></strong></h1>
    <p></p>
</div>
-->
</body>