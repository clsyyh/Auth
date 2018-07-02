<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>人事管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/document.js"></script>
</head>
<body>
<div>
    <p>
        <input type="button" value="删除" id="delete"/>
    </p>
</div>
    <table>
        <tr>
            <td><input type="checkbox" name="checkAll" id="checkAll"/></td>
            <td>标题</td>
            <td>创建时间</td>
            <td>创建人</td>
            <td>描述</td>
            <td>操作</td>
            <td>下载</td>
        </tr>
    <c:forEach var="document" items="${requestScope.documents}" varStatus="stat">
        <tr id="data_${document.id}">
            <td><input type="checkbox" id="box_${document.id}" value="${document.id}"/> </td>
            <td>${document.title}</td>
            <td><f:formatDate value="${document.createDate}"
                              type="date" dateStyle="long"/></td>
            <td>${document.user.loginname}</td>
            <td>${document.remark}</td>
            <td align="center" width="40px">
                <a href="/updateDocument?flag=1&id=${document.id}">
                <img src="../images/update.gif" alt="修改">
            </a> </td>
            <td align="center" width="40px">
                <a href="#" id="down_${document.id}">
                    <img src="../images/downLoad.png" height="20px" width="20px" alt="下载">
                </a>
            </td>
        </tr>
    </c:forEach>
    </table>
</body>