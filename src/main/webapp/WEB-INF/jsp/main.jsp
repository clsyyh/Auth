<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <title>主页面</title>
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.ui.js"></script>
    <script type="text/javascript" src="../js/main.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/smoothness/jquery.ui.css"/>
    <link type="text/css" rel="stylesheet" href="../css/main.css"/>
</head>
<body>
    <%
        /*
        把Map转换成2个List
        List<String> names=new ArrayList<String>();
        List<String> urls=new ArrayList<String>();
        Map<String,Object> funs=(HashMap<String,Object>)session.getAttribute("funs");
        for(Map.Entry<String,Object> entry:funs.entrySet()){
        String name=entry.getKey().toString();
        String url=entry.getValue().toString();
        names.add(name);
        urls.add(url);
        }
        request.setAttribute("names",names);
        request.setAttribute("urls",urls);

        <c:forEach var="url" items="${requestScope.urls}" varStatus="stat">
        <tr>
            <td><a href="${url}"/> 权限</td>
        </tr>
    </c:forEach>
        */
    %>
    <div id="header">
        <div class="header_main">
            <h1>LOGO</h1>
            <div class="header_commuity">
                <a href="###">公司简介</a>
            </div>
            <div class="header_dog">
                <a href="###">规章制度</a></div>
            <div class="header_user">
                <a href="###">个人中心</a></div>
            <div class="header_member">
                <a href="###">登录</a>|<a href="###">注册</a>
            </div>
        </div>
    </div>
<table>
    <!--如何把权限名称和url对应？？？-->
    <!--倒序|乱序遍历map？？？-->
    <c:forEach items="${sessionScope.funs}" var="entry">
        <tr>
            <td>
                <a href="${entry.value}">${entry.key}</a>
            </td>
        <tr>
    </c:forEach>
</table>
</body>