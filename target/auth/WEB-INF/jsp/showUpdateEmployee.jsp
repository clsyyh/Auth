<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@page language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>修改员工信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="../js/jquery.js"></script>
    <script type="text/javascript" src="../js/jquery.ui.js"></script>
    <script type="text/javascript" src="../js/employee.js"></script>
    <link type="text/css" rel="stylesheet" href="../css/smoothness/jquery.ui.css"/>
</head>
<body>
<h3><strong><b>修改员工信息</b></strong></h3>
<form action="/updateEmployee1" method="post" enctype="multipart/form-data">
    <!--set标签设置了value属性之后不能再有body??????-->
    <c:forEach items="${requestScope.target}" var="employee">
        <input type="hidden" value="${employee.id}" name="id">
        <table>
            <tr>
                <td><label>部门</label></td>
                <td>
                    <select name="deptId">
                        <c:forEach var="dept" items="${requestScope.depts}">
                            <!--option选项中必须使用out标签-->
                            <option value="${dept.id}"><c:out value="${dept.name}"/> </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>职位</label></td>
                <td>
                    <select name="jobId">
                        <c:forEach items="${requestScope.jobs}" var="job">
                            <option value="${job.id}"><c:out value="${job.name}"/></option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>编号</label></td>
                <td><input type="text" name="cardId" value="${employee.cardId}"/> </td>
            </tr>
            <tr>
                <td><label>姓名</label></td>
                <td><input type="text" name="name" value="${employee.name}"/> </td>
            </tr>
            <tr>
                <td><label>性别</label></td>
                <td><input type="radio" name="sex" value="1"/>男
                    <input type="radio" name="sex" value="0"/>女
                </td>
            </tr>
            <tr>
                <td><label>生日</label></td>
                <td><input type="text" name="birthday" id="birthday"/> </td>
            </tr>
            <tr>
                <td><label>电话</label></td>
                <td><input type="text" name="tel" value="${employee.tel}"/> </td>
            </tr>
            <tr>
                <td><label>手机</label></td>
                <td><input type="text" name="phone" value="${employee.phone}"/> </td>
            </tr>
            <tr>
                <td><label>QQ</label></td>
                <td><input type="text" name="qqNum" value="${employee.qqNum}"/> </td>
            </tr>
            <tr>
                <td><label>邮箱</label></td>
                <td><input type="text" name="email" value="${employee.email}"/> </td>
            </tr>
            <tr>
                <td><label>邮编</label></td>
                <td><input type="text" name="postCode" value="${employee.postCode}"/> </td>
            </tr>
            <tr>
                <td><label>民族</label></td>
                <td><input type="text" name="race" value="${employee.race}"/> </td>
            </tr>
            <tr>
                <td><label>教育</label></td>
                <td><input type="text" name="education" value="${employee.education}"/> </td>
            </tr>
            <tr>
                <td><label>Party</label></td>
                <td><input type="text" name="party" value="${employee.party}"/> </td>
            </tr>
            <tr>
                <td><label>特长</label></td>
                <td><input type="text" name="speciality" value="${employee.speciality}"/> </td>
            </tr>
            <tr>
                <td><label>爱好</label></td>
                <td><input type="text" name="hoby" value="${employee.hoby}"/> </td>
            </tr>
            <tr>
                <td><label>备注</label></td>
                <td><input type="text" name="remark" value="${employee.remark}"/> </td>
            </tr>
            <tr>
                <td><label>照片</label></td>
                <td><input type="file" name="zpFile"/> </td>
            </tr>
            <tr>
                <td><input type="submit" value="修改"/></td>
                <td><input type="reset" value="重置"/></td>
            </tr>
        </table>
    </c:forEach>
</form>
</body>