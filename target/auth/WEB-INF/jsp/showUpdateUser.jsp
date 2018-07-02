<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
<h3><b><strong>修改用户</strong></b></h3>
<form action="updateUser" method="post">
    <c:set var="user" value="${requestScope.target}">
    <input type="hidden" name="flag" value="2"/>
    <input type="hidden" name="id" value="${user.id}"/>
    <table>
        <tr>
            <td><label>登录名:</label></td>
            <td><input type="text" name="loginname" value="${user.loginname}"/> </td>
        </tr>
        <tr>
            <td><label>密&nbsp&nbsp&nbsp码:</label></td>
            <td><input type="text" name="password" value="${user.password}"/></td>
        </tr>
        <tr>
            <td><label>姓&nbsp&nbsp&nbsp名:</label></td>
            <td><input type="text" name="username" value="${user.username}"/></td>
        </tr>
        <tr>
            <td><label>状&nbsp&nbsp&nbsp态:</label></td>
            <td><input type="text" name="status" value="${user.status}"/></td>
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
    </c:set>
</form>
</body>
</html>