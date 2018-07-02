<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/login" method="post">
    <table>
        <tr>
            <td><label>登录名：</label></td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td><label>密&nbsp&nbsp&nbsp码：</label></td>
            <td><input type="text" name="pwd"/></td>
        </tr>
    </table>
    <div>
        <input type="radio" name="roleId" value="1"/>employee
        <input type="radio" name="roleId" value="8"/>header
        <input type="radio" name="roleId" value="5"/>admin
        <div>
            <input type="submit" value="登录">
        </div>
    </div>
</form>
</body>
</html>