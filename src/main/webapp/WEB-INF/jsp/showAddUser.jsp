<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<h3><b><strong>添加用户</strong></b></h3>
<form action="addUser" method="post">
    <input type="hidden" name="flag" value="2">
    <table>
        <tr>
            <td><label>登录名:</label></td>
            <td><input type="text" name="loginname"/> </td>
        </tr>
        <tr>
            <td><label>密码:</label></td>
            <td><input type="text" name="password"/></td>
        </tr>
        <tr>
            <td><label>姓名:</label></td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td><label>状态:</label></td>
            <td><input type="text" name="status"/></td>
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
</body>
</html>