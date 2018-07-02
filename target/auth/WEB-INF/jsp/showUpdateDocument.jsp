<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>修改文档</title>
</head>
<body>
<h3><b><strong>修改文档</strong></b></h3>
<form action="updateDocument" method="post">
    <c:set var="document" value="${requestScope.target}">
    <input type="hidden" name="flag" value="2"/>
    <input type="hidden" name="id" value="${document.id}"/>
    <table>
        <tr>
            <td><label>文档题目：</label></td>
            <td><input type="text" name="title" value="${document.title}"> </td>
        </tr>
        <tr>
            <td><label>文档描述：</label></td>
            <td><input type="text" name="remark" value="${document.remark}"> </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="修改"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
    </c:set>
</form>
</body>