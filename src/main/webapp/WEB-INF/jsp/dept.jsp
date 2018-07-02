<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/dept.js"></script>
    <title>人事管理系统</title>
</head>
<body>
    <div>
    <p>
        <input type="button" value="删除" id="delete"/>
    </p>
    </div>
    <table>
        <tr>
            <td><input type="checkbox" name="checkAll" id="checkAll"></td>
            <td>部门名称</td>
            <td>详细信息</td>
            <td align="center">操作</td>
        </tr>
        <c:forEach var="dept" items="${requestScope.depts}" varStatus="stat">
            <tr id="data_${stat.index}">
                <td><input type="checkbox" id="box_${stat.index}" value="${dept.id}"/></td>
                <td>${dept.name}</td>
                <td>${dept.remark}</td>
                <td align="center" width="40px;">
                    <a href="/updateDept?flag=1&id=${dept.id}">
                    <img title="修改" src="../images/update.gif"/></a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>