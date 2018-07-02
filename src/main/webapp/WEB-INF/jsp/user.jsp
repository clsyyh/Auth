<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>人事管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/user.js"></script>
</head>
<body>
<div>
    <p>
        <input type="button" value="删除" id="delete"/>
    </p>
</div>
<table>
    <tr>
        <td><input type="checkbox" name="checkAll"></td>
        <td>登录名</td>
        <td>密码</td>
        <td>用户名</td>
        <td>状态</td>
        <td>创建时间</td>
        <td align="center">操作</td>
    </tr>
    <c:forEach items="${requestScope.users}" var="user" varStatus="stat">
        <tr id="data_${stat.index}">
        <td><input type="checkbox" id="box_${stat.index}" value="${user.id}" ></td>
        <td>${user.loginname }</td>
        <td>${user.password }</td>
        <td>${user.username }</td>
        <td>${user.status }</td>
        <td><f:formatDate value="${user.createDate}"
                          type="date" dateStyle="long"/></td>
        <td align="center" width="40px">
            <a href="updateUser?flag=1&id=${user.id}">
            <img src="../images/update.gif"/></a>
        </td>
        </tr>
    </c:forEach>
</table>
</body>