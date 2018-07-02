<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>添加部门</title>
</head>
<body>
<h3><b><strong>添加部门</strong></b></h3>
<form action="/addDept" method="post">
    <input type="hidden" name="flag" value="2">
    <table>
        <tr>
            <td><label>部门名称</label></td>
            <td><input type="text" name="name"/> </td>
        </tr>
        <tr>
            <td><label>详细信息</label></td>
            <td><input type="text" name="remark"/> </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="添加"/>
            </td>
            <td>
                <input type="reset" value="取消"/>
            </td>
        </tr>
    </table>
</form>
