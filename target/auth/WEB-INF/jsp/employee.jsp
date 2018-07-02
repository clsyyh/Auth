<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>人事管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<table border="1">
    <tr>
        <td>姓名</td>
        <td>性别</td>
        <td>部门</td>
        <td>职位</td>
        <td>编号</td>
        <td>电话</td>
        <td>手机</td>
        <td>住址</td>
        <td>邮箱</td>
        <td>照片</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.pager.dataList}" var="employee">
        <tr>
            <td>${employee.name}</td>
            <!--???如何转化  JSTL标签if-->
            <td>
                <c:if test="${employee.sex==1}">男</c:if>
                <c:if test="${employee.sex==0}">女</c:if>
            </td>
            <td>${employee.dept.name}</td>
            <td>${employee.job.name}</td>
            <td><c:out value="${employee.cardId}"></c:out> </td>
            <td>${employee.tel}</td>
            <td>${employee.phone}</td>
            <td>${employee.address}</td>
            <td>${employee.email}</td>
            <td><a href="/getImage?id=${employee.id}"><img src="/getImage?id=${employee.id}" width="40px" height="30px"></a></td>
            <td align="center">
                <a href="/updateEmployee?id=${employee.id}">
                    <img src="../images/update.gif"/></a>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<!--
不能一行显示
<div>
    <div float="left"><a href="/selectEmployeeByPage?pageNum=1">首页</a></div>
    <div float="left"><a href="/selectEmployeeByPage?pageNum="+${requestScope.pager.currentPage}-1>上一页</a></div>
    <div float="left"><a href="/selectEmployeeByPage?pageNum="+${requestScope.pager.currentPage}+1>下一页</a></div>
    <div float="left"><a href="/selectEmployeeByPage?pageNuM="+${requestScope.pager.totalPage}-1>尾页</a></div>
</div>
-->
<!--
参数传值错误
<span><a href="/selectEmployeeByPage?pageNum=1">首页</a></span>&nbsp;&nbsp;&nbsp;
<span><a href="/selectEmployeeByPage?pageNum="+${requestScope.pager.currentPage-1}>上一页</a></span>&nbsp;&nbsp;&nbsp;
<span><a href="/selectEmployeeByPage?pageNum="+${requestScope.pager.currentPage+1}>下一页</a></span>&nbsp;&nbsp;&nbsp;
<span><a href="/selectEmployeeByPage?pageNum="+${requestScope.pager.totalPage-1}>尾页</a></span>&nbsp;&nbsp;&nbsp;
-->
<span>共<c:out value="${requestScope.pager.totalRecord}"/>条记录</span>
&nbsp;&nbsp;
<span>共<c:out value="${requestScope.pager.totalPage}"/>页</span>
&nbsp;&nbsp;
<span>当前第<c:out value="${requestScope.pager.currentPage}"/>页</span>
&nbsp;&nbsp;
<span><a href="/selectEmployeeByPage?pageNum=1">首页</a></span>&nbsp;&nbsp;&nbsp;
<span><a href="/selectEmployeeByPage?pageNum=${requestScope.pager.currentPage-1}">上一页</a></span>&nbsp;&nbsp;&nbsp;
<span><a href="/selectEmployeeByPage?pageNum=<c:out value="${requestScope.pager.currentPage+1}"/>">下一页</a></span>&nbsp;&nbsp;&nbsp;
<span><a href="/selectEmployeeByPage?pageNum=<c:out value="${requestScope.pager.totalPage}"/>">尾页</a></span>&nbsp;&nbsp;&nbsp;
</body>
</html>