<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" pageEncoding="utf-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改部门</title>
</head>
<body>
<h3><b><strong>修改部门</strong></b></h3>
<form action="/updateDept" method="post">
        <c:forEach var="dept" items="${requestScope.target}">
        <input type="hidden" name="flag" value="2"/>
        <input type="hidden" name="id" value="${dept.id}"/>
        <table>
            <tr>
                <td><label>部门名称</label></td>
                <td><input type="text" name="name" value="${dept.name}"/></td>
            </tr>
            <tr>
                <td><label>详细信息</label></td>
                <td><input type="text" name="remark" value="${dept.remark}"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="修改"/>
                </td>
                <td>
                    <input type="reset" value="取消"/>
                </td>
            </tr>
        </table>
        </c:forEach>
</form>
</body>