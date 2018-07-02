<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
    <title>人事管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/noticeByPage.js"></script>
</head>
<body>
<div>
    <form action="#" method="post">
        <input type="text" id="no_title"/>
        <input type="button" id="button" value="查询"/>
    </form>
</div>
<table border="1">
    <tr>
        <td>ID</td>
        <td>公告名称</td>
        <td>公告内容</td>
        <td>创建时间</td>
        <td>公告人</td>
    </tr>
    <tbody id="noticeData">

    </tbody>
</table>
<div id="emptyInfo">
    <br>
</div>
<div id="loading">
    <br>
</div>
</body>
</html>