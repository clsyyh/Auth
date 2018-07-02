<%@page language="java" pageEncoding="utf-8" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>人事管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<c:set var="notice" value="${requestScope.notice}">
    <h1><strong><b>${notice.title}</b></strong></h1>
    <p>${notice.content}</p>
</c:set>
</body>